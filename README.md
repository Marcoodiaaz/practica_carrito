
# Práctica 2: Servicio Web REST - Carrito de Compra

Este proyecto consiste en una API REST mínima desarrollada con **Spring Boot** que permite gestionar un recurso de "Carrito" en un entorno de e-commerce simplificado. El objetivo es implementar las operaciones fundamentales **CRUD** utilizando el estilo arquitectónico *request/response* sobre HTTP.

## Alcance Funcional

El recurso **Carrito** contiene las siguientes propiedades:

* `idCarrito`: Identificador único del carrito.
* `idArticulo`: Identificador del artículo asociado.
* `descripcion`: Texto descriptivo del artículo.
* `unidades`: Número de unidades.
* `precioFinal`: Importe final calculado/proporcionado.

## Descripción de Endpoints

A continuación se detallan los puntos de acceso de la API siguiendo la rúbrica de evaluación:

| Método | Ruta | Cuerpo (JSON) | Descripción | Posibles Respuestas |
| --- | --- | --- | --- | --- |
| **POST** | `/api/carrito` | Objeto Carrito completo | Crea un nuevo recurso carrito | `201 Created` |
| **GET** | `/api/carrito` | Vacío | Recupera la lista de todos los carritos | `200 OK` |
| **GET** | `/api/carrito/{id}` | Vacío | Obtiene los detalles de un carrito específico | `200 OK`, `404 Not Found` |
| **PUT** | `/api/carrito/{id}` | Objeto Carrito actualizado | Modifica los datos de un carrito existente | `200 OK`, `404 Not Found` |
| **DELETE** | `/api/carrito/{id}` | Vacío | Elimina un carrito del sistema | `204 No Content` |

## Tecnologías Utilizadas

* **Java 17+**
* **Spring Boot 3**
* **Maven**
* **Git/GitHub** para control de versiones.
