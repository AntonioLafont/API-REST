# API-REST - Práctica 3

## Carrito

| Método HTTP | Ruta                       | Cuerpo                | Descripción                                  | Respuestas posibles |
| ----------- | -------------------------- | --------------------- | -------------------------------------------- | ------------------- |
| POST        | `/api/carrito`             | Carrito (JSON)        | Crea un nuevo carrito                        | 201, 400            |
| GET         | `/api/carrito/{idCarrito}` | —                     | Obtiene un carrito por su identificador      | 200, 404            |
| PUT         | `/api/carrito/{idCarrito}` | Carrito (JSON)        | Actualiza un carrito existente               | 200, 404            |
| DELETE      | `/api/carrito/{idCarrito}` | —                     | Elimina un carrito                           | 204, 404            |

## Línea de Carrito

| Método HTTP | Ruta                                        | Cuerpo                   | Descripción                           | Respuestas posibles |
| ----------- | ------------------------------------------- | ------------------------ | ------------------------------------- | ------------------- |
| POST        | `/api/carrito/{idCarrito}/lineas`           | LineaCarrito (JSON)      | Agrega una línea al carrito           | 201, 400, 404       |
| DELETE      | `/api/carrito/{idCarrito}/lineas/{idLineaCarrito}` | —               | Elimina una línea del carrito        | 204, 404            |

## Modelos de Datos

### Carrito
```json
{
  "idCarrito": 1,
  "idUsuario": 100,
  "correo": "usuario@example.com",
  "totalPrecio": 150.50
}
```

### LineaCarrito
```json
{
  "idLineaCarrito": 1,
  "idArticulo": 5,
  "numeroUnidades": 3,
  "precioUnitario": 25.50,
  "costeLinea": 76.50
}
```