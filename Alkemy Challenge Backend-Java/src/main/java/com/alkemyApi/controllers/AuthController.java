package com.alkemyApi.controllers;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemyApi.entities.Rol;
import com.alkemyApi.entities.Usuario;
import com.alkemyApi.models.LoginModel;
import com.alkemyApi.models.RegistroModel;
import com.alkemyApi.repositories.IRolRepository;
import com.alkemyApi.repositories.IUserRepository;
import com.alkemyApi.seguridad.JWTAuthResonseModel;
import com.alkemyApi.seguridad.JwtTokenProvider;
import com.alkemyApi.services.imp.EmailSenderService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private IUserRepository usuarioRepositorio;
	
	@Autowired
	private IRolRepository rolRepositorio;
	
	@Autowired
	private EmailSenderService emailSenderService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	
	
	
	@PostMapping("/login")
	public ResponseEntity<JWTAuthResonseModel> authenticateUser(@RequestBody LoginModel loginModel){
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginModel.getNombreDeUsuario(), loginModel.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		//obtenemos el token del jwtTokenProvider
		String token = jwtTokenProvider.generarToken(authentication);
		
		return ResponseEntity.ok(new JWTAuthResonseModel(token));
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registrarUsuario(@RequestBody RegistroModel registroModel){
		if(usuarioRepositorio.existsByUsername(registroModel.getUsername())) {
			return new ResponseEntity<>("Ese nombre de usuario ya existe",HttpStatus.BAD_REQUEST);
		}
		
		if(usuarioRepositorio.existsByEmail(registroModel.getEmail())) {
			return new ResponseEntity<>("Ese email de usuario ya existe",HttpStatus.BAD_REQUEST);
		}
		
		Usuario usuario = new Usuario();
		usuario.setNombre(registroModel.getNombre());
		usuario.setUsername(registroModel.getUsername());
		usuario.setEmail(registroModel.getEmail());
		usuario.setPassword(passwordEncoder.encode(registroModel.getPassword()));
		
		Rol roles = rolRepositorio.findByRol("ROLE_USER").get();
		usuario.setRoles(Collections.singleton(roles));
		
		usuarioRepositorio.save(usuario);
		emailSenderService.sendSimpleEmail(registroModel.getEmail(),"Bienvenido! Usted se ha registrado a la api de Alkemy","AlkemyApi");
		return new ResponseEntity<>("Usuario registrado exitosamente",HttpStatus.OK);
	}
	}