# CONVERSOR DE MONEDAS API

## Descripción

Este proyecto es una aplicación Spring Boot que consume la API de ExchangeRate-API para obtener tasas de cambio de monedas. La aplicación permite a los usuarios convertir cantidades entre diferentes monedas y rastrear el historial de conversiones con marcas de tiempo.

### Implementación

El proyecto incluye las siguientes características y funcionalidades:

1. **Consumo de la API de ExchangeRate-API**: Utiliza `HttpClient` para realizar solicitudes HTTP y obtener tasas de cambio en formato JSON.
2. **Análisis de JSON con Gson**: Utiliza la biblioteca Gson para analizar y manejar los datos JSON recibidos de la API.
3. **Conversión de Monedas**: Permite a los usuarios convertir cantidades entre diferentes monedas utilizando las tasas obtenidas.
4. **Historial de Conversiones**: Rastrea y muestra el historial de conversiones realizadas, incluyendo la moneda de origen, la moneda de destino, la cantidad convertida y la fecha y hora de la conversión.
5. **Interfaz de Consola**: Proporciona una interfaz de usuario en la consola para interactuar con la aplicación.
6. **Soporte para Más Monedas**: Soporta una amplia gama de monedas para la conversión.
7. **Registros con Marca de Tiempo**: Utiliza `java.time` para crear registros de conversiones con marcas de tiempo.

## Objetivos

- Proporcionar una herramienta sencilla para convertir monedas utilizando tasas de cambio actualizadas.
- Permitir a los usuarios rastrear su historial de conversiones con detalles completos.
- Demostrar el uso de Spring Boot, HttpClient y Gson para interactuar con una API externa y manejar datos JSON.

## Logros

- Integración exitosa de la API de ExchangeRate-API para obtener tasas de cambio.
- Implementación de la conversión de monedas con soporte para múltiples monedas.
- Creación de un historial de conversiones con marcas de tiempo.
- Provisión de una interfaz de usuario en la consola para una fácil interacción.
- Validación y manejo de errores básicos para mejorar la experiencia del usuario.

## Uso

### Requisitos Previos

- Java 11 o superior
- Maven o Gradle
- IDE como IntelliJ IDEA, Eclipse o cualquier editor de texto
