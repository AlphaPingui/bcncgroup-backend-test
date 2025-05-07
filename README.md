# Similar Products API

## Descripción

Este proyecto es una prueba técnica realizada para una posición de FullStack Developer. Expone un endpoint que devuelve productos similares a uno dado, integrándose con servicios mock.

> Esta prueba se ha realizado en Spring Boot

---

## Tecnologías utilizadas

- Java 21.0.6
- Spring Boot 3.4.5
- Gradle
- Spring Web
- Lombok
- Spring Boot Devtools
- JUnit 5

---

## Cómo ejecutar el proyecto

```bash
./gradlew bootRun
```

> El servicio estará disponible en: `http://localhost:5000`

---

## Estructura

`/product/{productId}/similar`: Devuelve detalles de productos similares al ID especificado.

---

## Calidad y estilo de código

Este proyecto implementa herramientas de análisis y formateo automático para mantener un código limpio, consistente y profesional.

## Spotless

Se utiliza para aplicar un formato automático al código Java siguiendo el estándar de Google.

Comandos útiles:
- `./gradlew spotlessApply`: Aplica el formato automáticamente.

- `./gradlew spotlessCheck`: Verifica si el código está correctamente formateado.

> Spotless asegura que el código tenga los imports ordenados, sin espacios innecesarios y con indentación uniforme.

## Checkstyle

Checkstyle se emplea para validar que el código cumple con ciertas reglas de estilo y convenciones.

Comandos útiles:
- `./gradlew checkstyleMain`: Analiza el código fuente principal (src/main/java).

- `./gradlew checkstyleTest`: Analiza las clases de test (src/test/java).

>Los archivos de configuración están ubicados en: config/checkstyle/checkstyle.xml

## Estándares
Formato: Google Java Style

Convenciones: Reglas básicas sobre nombres de variables, imports y estructura de métodos

---

## Dockerización

- Multi-stage build con Gradle y Temurin JRE 21

- Genera una imagen ligera optimizada para producción

- Expone el puerto 5000 como requiere la prueba técnica

### Cómo construir la imagen
docker build -t similar-products .

### Cómo ejecutar la app en Docker

docker run --name similar-products similar-products

> Este comando ejecuta la app sin mapear el puerto 5000 en el host para evitar conflictos (como me los ha estado dando a mi usando macOS)
___

## Flujo de trabajo con Git

Este proyecto sigue el modelo de ramas basado en Git Flow:

- `main`: contiene el código estable y listo para producción.
- `develop`: rama de integración donde se agrupan todas las funcionalidades antes de ser lanzadas.
- `feature/*`: ramas para el desarrollo de nuevas funcionalidades.
- `fix/*`: ramas para corregir errores puntuales.
- `release/*`: ramas para preparar versiones de producción.
- `hotfix/*`: ramas para arreglos urgentes en producción.

Cada nueva funcionalidad se desarrollará en su propia rama `feature/nombre-de-la-funcionalidad`, que posteriormente se integrará en `develop` mediante Pull Request.

## Estructura de commits

Este repositorio sigue el estándar de commits convencionales para mejorar la legibilidad y la trazabilidad:

- `feat`: nueva funcionalidad.
- `fix`: corrección de errores.
- `refactor`: mejora interna sin cambio funcional.
- `test`: añadir o mejorar tests.
- `docs`: actualización del README u otra documentación.
- `chore`: tareas de mantenimiento.

---

## Estructura de commits

Se han implementado test en tres capas:

- Cliente (`ProdudctClient`)
- Servicio (`SimilarProductService`)
- Controlador (`SimilarProductController`)

> Todos los tests se ejecutan con `./gradlew test`
---

## Licencia

Este proyecto está licenciado bajo la MIT License.