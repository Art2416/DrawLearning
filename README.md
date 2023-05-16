## Escuela Colombiana de Ingeniería

## Arquitectura de Software (ARSW)

## DrawLearning!!!

### Resumen:
En respuesta a la necesidad de contar con una herramienta versátil y dinámica que permita a las personas compartir contenido escrito o dibujado en tiempo real,
hemos desarrollado DrawLearning. Esta aplicación web divertida está diseñada para usuarios de todos los ámbitos, facilitando tanto el aprendizaje como el
entretenimiento al permitir la creación y visualización de contenido visual en tiempo real.

### Descripción:
En un mundo donde la virtualidad ha adquirido gran importancia debido a la pandemia, hemos identificado la falta de herramientas que permitan a las personas
mostrar y compartir contenido escrito o dibujado en tiempo real. Con DrawLearning, hemos fusionado diferentes opciones existentes, como las funcionalidades de
evaluación de conocimientos de aplicaciones como Kahoot y la interacción lúdica de juegos como Drawar.io. Nuestro objetivo es crear una aplicación web versátil y divertida
que se adapte a cualquier ámbito cotidiano, fomentando el uso de herramientas tecnológicas para el aprendizaje, el ocio y otras actividades.

## Software necesarias

- Java
- maven - Gestor de dependencias
- Spring-boot - Framework
- Git - Sistema de control de versiones

### Funcionalidades:
Las funcionalidades de DrawLearning se dividen según el rol del usuario:

#### Participante:
- Unirse a una partida.
- Dibujar en el lienzo.
- Cambiar el color del trazo.
- Ver preguntas del organizador.
- Ver pistas del organizador.

#### Organizador:
- Crear preguntas o texto para los participantes.
- Crear pistas para los participantes.
- Observar la pantalla de cualquier participante.
- Seleccionar un ganador de la sesión.

### Detalles de las funcionalidades:
1. Observar la pantalla de cualquier participante: Los organizadores pueden visualizar en tiempo real lo que cada participante está dibujando al unirse a la partida.
2. Crear preguntas o texto para los participantes: Los organizadores deben agregar preguntas relacionadas con los objetivos de la partida en el espacio correspondiente.
3. Crear pistas para los participantes: Los organizadores pueden agregar pistas adicionales para ayudar a los participantes, utilizando el botón correspondiente.
4. Crear una partida: Los usuarios con los permisos necesarios pueden crear partidas y permitir que otros participantes se unan.
5. Seleccionar un ganador de la sesión: Los organizadores pueden elegir a un ganador entre los participantes seleccionando la opción correspondiente.
6. Ver preguntas del organizador: Los participantes pueden ver las preguntas proporcionadas por los organizadores en el espacio correspondiente para comenzar a dibujar.
7. Ver pistas del organizador: Los participantes pueden ver pistas proporcionadas por los organizadores si son los primeros en presionar el botón "Obtener pista".
8. Dibujar en el lienzo: La aplicación proporciona un espacio donde los participantes pueden dibujar utilizando puntos.
9. Cambiar el color del trazo: Los participantes pueden seleccionar el color deseado para su trazo a través de un menú.
10. Unirse a una partida: Los usuarios pueden unirse a partidas si tienen los permisos necesarios.

### Esperados a tener en cuenta:

- Los usuarios tienen una conexión estable y rápida para evitar inconsistencias debido a la latencia.
- Los usuarios ya están registrados previamente en el directorio de ingreso del juego para determinar los permisos necesarios.
- Los servicios utilizados para la aplicación deben pertenecer a Microsoft Azure.
- La aplicación debe cumplir con los atributos de calidad especificados, incluyendo disponibilidad, seguridad mantenibilidad y testeabilidad.
- La arquitectura implementada debe permitir la escalabilidad horizontal.
- Se debe implementar un ciclo de integración continua.
- El código debe ser escaneado a través de SonarQube.

### Atributos de calidad:
* Disponibilidad:
  DrawLearning garantiza una alta disponibilidad al ser desplegado en Azure App Service, lo que permite su uso en diversas plataformas y dispositivos. Esto se logra mediante una infraestructura en la nube escalable y confiable.

* Mantenibilidad:
  Se garantiza la mantenibilidad de DrawLearning a través de la inspección continua del código estático mediante la herramienta SonarQube. Esta herramienta detecta errores y vulnerabilidades de seguridad, y se integra en el ciclo de integración continua.

* Seguridad:
  Autenticar actores y Autorizar actores: DrawLearning garantiza la autenticación de los usuarios mediante Azure Active Directory, lo que permite verificar si una persona está registrada antes de acceder a la aplicación y se asegura que los usuarios tengan los permisos necesarios para utilizar las funcionalidades de DrawLearning..

* Testeabilidad:
  DrawLearning tiene la capacidad de que el sistema sea probado de manera efectiva, lo cual implica que las funcionalidades y componentes puedan ser sometidos a pruebas unitarias. Una alta testeabilidad facilita la identificación de errores, la validación de funcionalidades y la verificación del cumplimiento de los requisitos.

### Herrmientas empleadas algunas con (Microsoft Azure):
- Azure App Service: Para el despliegue del proyecto, ya que es un servicio que hospeda aplicaciones web en el lenguaje deseado y permite una ejecución fácil y escalable en diversos entornos.
- Azure Active Directory: Como servicio de identidad que proporciona inicio de sesión único, autenticación multifactorial y acceso condicional.
- Se implementa una arquitectura de API-REST.
- Se utiliza el framework Spring con un patrón Modelo-Vista-Controlador (MVC) para la construcción de la aplicación.
- Se utiliza el módulo STOMP para el aprovechamiento y configuración de tópicos, permitiendo la interacción en tiempo real mediante una arquitectura de publicador-suscriptor.

### División de capas de Drawlearning:
- Aplicación: Desarrollada en Java utilizando Maven y el framework Spring Boot.
- Presentación: Utiliza HTML, CSS y JavaScript.

### Requerimientos:
* Tiempo real: El Organizador tiene la posibilidad de ver lo que están dibujando los participantes en tiempo real.
* Concurrencia: Se evidencia cuando se digitan las pistas o preguntas.
