# Alkemy-Challenge-Backend-Java

# Indicaciones :
1. Crear la base de datos con el nombre de : alkemyapi.
2. Correr la aplicacion para crear las clases con sus relaciones.
3. Crear los roles y el usuario admin con el siguiente script:


insert into rol values (1,'ROLE_ADMIN')
insert into rol values (2,'ROLE_USER')
insert into usuario values (1,'1@gmail.com','uno','$2a$10$pwHaffQwuUBLM/BvcSgOHuieZz96/pcCeMeuvlEPMIxCRfpuqBqye','Admin')


usuario admin = Admin
password= password

Ahora tenemos el usuario administrador , que tendrá acceso a todas las funcionalidades de la app

Luego si registramos usuarios desde la app se registraran con el rol de user, que tendrá acceso a peticiones de tipo GET.
