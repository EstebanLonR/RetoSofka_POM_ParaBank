ParaBankAutomatizad🤖

RetoPOM-Parabak hecho por Juan Esteban Londoño Ruiz. 
Este proyecto esta realizado bajo el modelo POO(Programacion Orientada a Objetos) y bajo el Lenguaje de programacion Java bajo el gestor de dependencias Gradle🐘

Pre Requisitos 📋

Se debe de tener en el equipo a ejecutar Java version 11, update 191 o superior and JDK (Variables de entorno Configuradas). Eclipse IDE, IntelliJ IDEA, o NetBeans (version 2019 o superior)

Para clonar este repositorio localmente este es el comando el cual se debera ejecutar: git clone https://github.com/EstebanLonR/RetoSofka_POM_ParaBank.git Importar el proyecto a los IDE Eclipse,IntelliJ o NetBeans.

En la carpeta de Documentos de pruebas estaran publicados tanto en formato PDF como HTML el plan de pruebas construido para la verificacion de las funcionalidades del aplicativo WEB.
Igualmente en este siguiente Link tambien se encontrara publicado el mismo:
https://fuzzy-gruyere-5cb.notion.site/Plan-De-Pruebas-Automatizadas-ParaBank-42f2d09c2c444219abf6e89e54572f9a

Variables y Funciones: Lower Camel Case. Ejemplo: nomenclaturaEjemplo. Class names: PascalCase or Upper Camel Case. Ejemplo: NomenclaturaEjemplo. Versionamiento 🔀 Git es usado para el control de Version.

La estructura completa del projecto es la siguiente :

SourcesPackage/

Package main/model: contiene toda la estructura de los datos que seran necesarios para utilizar en la prueba

Package main/util: contiene todas las utilidades que seran necesarias para implementar en la automatizacion

Package main/page: contiene todas los localizadores de el aplicativo y los metodos a ejecutar

Package test/runner: es la clase desde donde seran ejecutadas las automatizaciones.

Package test/stepdefinition: contiene los pasos necesarios con las que el runner podra correr la automatizacion.

Directory resources/features: se encuentran las historias de usuario y los escenarios propuestos para probar en lenguaje Gherkin

Directory resources/drivers: se encuentran los drivers de navegador necesarios en los que realizaremos las pruebas
