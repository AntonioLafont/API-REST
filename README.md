# API-REST

| Método HTTP | Ruta                       | Cuerpo                | Descripción                                  | Respuestas posibles |
| ----------- | -------------------------- | --------------------- | -------------------------------------------- | ------------------- |
| POST        | `/api/carrito`             | Carrito (JSON)        | Crea un nuevo carrito                        | 201, 409            |
| GET         | `/api/carrito/{idCarrito}` | —                     | Obtiene un carrito por su identificador      | 200, 404            |
| PUT         | `/api/carrito/{idCarrito}` | Carrito (JSON)        | Actualiza un carrito existente               | 200, 404            |
| DELETE      | `/api/carrito/{idCarrito}` | —                     | Elimina un carrito                           | 204, 404            |
