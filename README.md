# LABORATORIO 3 AREP - MODULARIZACIÓN CON VIRTUALIZACIÓN E INTRODUCCIÓN A DOCKER
En este laboratorio, construimos una pequeña y eficiente aplicación web utilizando Spark Java y Docker. Comenzamos creando un proyecto Java con Maven y las dependencias 
necesarias para Spark Java. Luego, definimos un punto final en la clase principal que devuelve una cadena cuando se accede a él. Creando un Dockerfile, construimos una 
imagen de Docker para la aplicación, la ejecutamos y exponemos el puerto en la máquina host. Demostramos la flexibilidad y escalabilidad de Docker creando varias instancias 
del contenedor mapeadas a puertos diferentes. Modificamos el proyecto para publicar servicios REST que realicen cálculos específicos y utilizamos Docker Compose para un 
servicio web y MongoDB. Esto simplifica la configuración y gestión de nuestra aplicación, mejorando su portabilidad y escalabilidad.
# Iniciando 
A continuación se indican una serie de instruciones para bajar y ejecutar el proyecto de manera exitosa:

Es **importante**❗tener instalado: 
- [MAVEN](https://maven.apache.org) : Manejo de las dependecias. 
- [GIT](https://git-scm.com) : Control de versiones.
- [JAVA](https://www.java.com/es/) : Lenguaje de programación (JDK 20). 

# Instalación ⬇️
Los siguiente comando le permitira clonar el repositorio de manera local:
~~~
git clone https://github.com/SantiagoMelo0104/AREP-LAB5.git
~~~


# Ejecución🪄
Para este ejemplo usaremos el IDE de Intelij:
+ Una vez clonado, abrimos el proyecto en en IDE y ubicamos la siguiente clase **SparkWebServer**.
  ![imagen](https://github.com/SantiagoMelo0104/AREP-LAB5/assets/123812833/74a6678d-426e-4735-9459-fa464a2198c1)

+ A continuación dirijase al navegador de su preferencia y vaya a la siguiente dirección
    ~~~
    http://localhost:4567/formulario.html
    ~~~
  ![imagen](https://github.com/SantiagoMelo0104/AREP-LAB5/assets/123812833/17c0f914-31bd-49be-88e1-19d81c8690bf)


Tambien por consola se puede y seria de la siguiente forma 
+ Entrar al directorio del proyecto con el siguiente comando:
  ~~~
  cd AREP-LAB5
  ~~~
+ Compilar el proyecto con el siguiente comando:
  ~~~
  mvn clean install
  ~~~
  ![imagen](https://github.com/SantiagoMelo0104/AREP-LAB5/assets/123812833/76d99986-240d-45a9-8e74-ea82018d5334)

+ Para ejecutar el proyecto con el siguiente comando:
  ~~~
  java -cp "target/classes;target/dependency/*" org.arep.SparkWebServer
  ~~~
  ![imagen](https://github.com/SantiagoMelo0104/AREP-LAB5/assets/123812833/df03cfcd-b70e-4edd-aa11-14c6da9f1516)

+ A continuación dirijase al navegador de su preferencia y vaya a la siguiente dirección
   ~~~
    http://localhost:4567/formulario.html
    ~~~
   ![imagen](https://github.com/SantiagoMelo0104/AREP-LAB5/assets/123812833/9b8db9c5-4068-4c91-994d-dcd7f19807c9)

  
  # Arquitectura 📄 
  En el lado del servidor, la aplicación utiliza la biblioteca Spark Java para proporcionar un servidor web ligero que puede manejar solicitudes HTTP y 
  devolver respuestas en forma de texto o HTML. La aplicación define varias rutas HTTP que pueden ser invocadas por el cliente web para realizar cálculos 
  matemáticos y comprobar si una palabra dada es un palíndromo.
  
  En el lado del cliente, la aplicación utiliza la API Fetch de JavaScript para realizar solicitudes HTTP a las rutas definidas en el servidor. Cuando se 
  realiza una solicitud, el servidor devuelve una respuesta en forma de texto que es mostrada al usuario en el navegador.
  
  La aplicación también implementa una arquitectura de microservicios al dividir la lógica de negocio en diferentes métodos que pueden ser invocados por las 
  rutas HTTP. Por ejemplo, el cálculo del seno y del coseno se implementan en diferentes métodos, lo que permite una mayor modularidad y reutilización del código.
  
  En resumen, la aplicación combina elementos de la arquitectura de servidor web y de la arquitectura de microservicios para proporcionar una interfaz web sencilla 
  y eficaz para realizar cálculos matemáticos y comprobar si una palabra dada es un palíndromo.
  # Pruebas 
  ![imagen](https://github.com/SantiagoMelo0104/AREP-LAB5/assets/123812833/492b6a7c-96f8-4535-a453-1c43e22971b4)
  ![imagen](https://github.com/SantiagoMelo0104/AREP-LAB5/assets/123812833/08b519c4-8b05-42a2-9522-f79422103fcb)


# Para correrlo en Docker
Se encuntra en un repositorio de Docker Hub que es: [darkxs/arep-lab5](https://hub.docker.com/repository/docker/darkxs/arep-lab5/general)

Para poder ejecutar el contenedor:
+ Abir doker:
  ![imagen](https://github.com/SantiagoMelo0104/AREP-LAB5/assets/123812833/a665f313-4699-4e26-a590-f2dcca1b4581)
+ En la consola colocar el siguiente comado:
  ~~~
  docker run -d -p 34000:46000 --name lab5 darkxs/arep-lab5:latest
  ~~~
  ![imagen](https://github.com/SantiagoMelo0104/AREP-LAB5/assets/123812833/f0f5bd5a-d574-4ac3-99e8-bb62fedeaec9)
+  Docker va a aparecer así:
  ![imagen](https://github.com/SantiagoMelo0104/AREP-LAB5/assets/123812833/32299d3a-85a3-42a4-a308-23ec3b9f9a13)
+ A continuación dirijase al navegador de su preferencia y vaya a la siguiente dirección
  ~~~
   http://localhost:34000/formulario.html
  ~~~
  ![imagen](https://github.com/SantiagoMelo0104/AREP-LAB5/assets/123812833/c66e6cab-2635-47ab-b511-cbf96b36e294)
  ![imagen](https://github.com/SantiagoMelo0104/AREP-LAB5/assets/123812833/2469a491-7166-4bf5-a1b6-719b9b04c5d9)

# Autor 
Santiago Naranjo Melo [SantiagoMelo0104](https://github.com/SantiagoMelo0104)
