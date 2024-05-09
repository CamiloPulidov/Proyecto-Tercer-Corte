Integrantes :JUAN CAMILO PULIDO VARGAS

todo el proyecto se encuentra en la carpeta "human-resources"

Este Proyecto esta construido con una base de datos postgres con pgAdmin4, por lo tanto se adjunta el archivo “ScriptBaseDeDatos.pdf”, el cual contiene el script de creación de la base de datos y el script de inserción para los usuarios iniciales .

Una vez hecho todo lo anterior, abrimos postman, para utilizar la aplicación, es importante recordar que a la hora de usar los métodos para actualizar información o guardar un nuevo empleado ,se debe enviar un body :

http://localhost:4040/api/empleados/all
A esta solicitud http de tipo GET que sirve para traer todos los empleados, con toda su información, puede acceder cualquier persona sin credenciales ,esto con el fin de hacer más fácil el proceso de calificación y revisión de la api.

http://localhost:4040/api/empleados/save/{id}/con/{pass}
A esta solicitud http de tipo POST que sirve para actualizar y crear nuevos empleados, solo puede acceder un empleado de recursos humanos, donde “{id}” es el id del empleado de recurso humanos y “{pass}” es su contraseña, necesita un body que contenga el empleado nuevo o con la información actualizada.

http://localhost:4040/api/empleados/borrar/{borrar}/use/{id}/con/{pass}
A esta solicitud http de tipo DELETE que sirve para borrar un empleado por id, solo puede acceder un empleado de recursos humanos, donde “{id}” es el id del empleado de recurso humanos, “{pass}” es su contraseña y “{borrar}” el id del empleado que se quiere borrar.

http://localhost:4040/api/empleados/cambio-numero/{id}/con/{pass}
A esta solicitud http de tipo PUT que sirve para actualizar el número de celular, puede acceder cualquier empleado, donde “{id}” es el id del empleado y “{pass}” es su contraseña, necesita un body que contenga la nueva información a la que se quiere actualizar.

http://localhost:4040/api/empleados/cambio-correo/{id}/con/{pass}
A esta solicitud http de tipo PUT que sirve para actualizar el correo electrónico, puede acceder cualquier empleado, donde “{id}” es el id del empleado y “{pass}” es su contraseña, necesita un body que contenga la nueva información a la que se quiere actualizar.


http://localhost:4040/api/empleados/cambio-contraseña/{id}/con/{pass}
A esta solicitud http de tipo PUT que sirve para actualizar la contraseña, puede acceder cualquier empleado, donde “{id}” es el id del empleado y “{pass}” es su contraseña, necesita un body que contenga la nueva información a la que se quiere actualizar.

http://localhost:4040/api/empleados/cambio-direccion/{id}/con/{pass}
A esta solicitud http de tipo PUT que sirve para actualizar la dirrecion, puede acceder cualquier empleado, donde “{id}” es el id del empleado y “{pass}” es su contraseña, necesita un body que contenga la nueva información a la que se quiere actualizar.

Adicional a lo dicho anteriormente, se recuerda que siempre que la api se esté ejecutando y sean las 6:42 pm ,se enviara un correo a todos los empleados( el correo debe ser Gmail) ,donde se adjunte el pago de la nomina y un pdf informando esto .

Para usar todas las solicitudes como un empleado de recursos humanos ,adjunto las credenciales de este (que ya debió haber sido previamente creado en el script dado):
Id:”003”
Contraseña: “pass1”
