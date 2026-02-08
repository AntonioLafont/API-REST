# API-REST
práctica 2 PAT

| Método HTTP | Ruta                | Cuerpo (Request Body) | Descripción                                  | Respuestas posibles |
| ----------- | ------------------- | --------------------- | -------------------------------------------- | ------------------- |
| POST        | `/api/carrito`      | Carrito (JSON)        | Crea un nuevo carrito                        | 201, 409            |
| GET         | `/api/carrito/{id}` | —                     | Obtiene un carrito por su identificador      | 200, 404            |
| PUT         | `/api/carrito/{id}` | Carrito (JSON)        | Actualiza un carrito existente               | 200, 404            |
| DELETE      | `/api/carrito/{id}` | —                     | Elimina un carrito                           | 204, 404            |
