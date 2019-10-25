### MailerApp


#### Instrucciones de uso:

Para abrir el proyecto, puedes usar IDEA o importar el codigo en Netbeans.

#### Instrucciones para el archivo de correos
Para enviar correo masivamente, debes de generar una lista de direcciones (separadas por saltos de lineas (enters), extension .txt), 
y cargarla en el programa. Se mostrarán los correos en una tabla en la parte de abajo, junto con su estado

#### Instrucciones de conexión

Para poder usar la aplicación, debes de conectarte a un servidor SMTP con SSL y autenticación. 

Generalmente la dirección del servidor smtp suele ser smtp.&lt;domain&gt;.com , sin embargo, para utilizar un proveedor 
como outlook o gmail, debes de consultar la documentación del servicio.

El usuario suele ser directamente el correo electrónico de la cuenta, mientras que la contraseña dependiendo del servidor
puede ser una contraseña de aplicaciones inseguras (gmail) o simplemente la contraseña del correo electrónico


#### Instrucciones para redactar el correo

Los campos concernientes al correo se encuentran en la parte de la derecha.

El campo De: es necesario que se llene con la dirección de correo que deseas que aparezca como remitente. 
(Aunque si pones una dirección diferente al correo del que corresponden las credenciales utilizadas es más 
probable que tu correo se marque como spam)

Asunto: Se explica solo

Texto: Ahí puedes escribir un mensaje de texto plano.

Finalmente, luego de llenar todos los campos (el programa por ahora no verifica), puedes presionar el botón Enviar Masivos
y mientras se envían, saldrán mensajes en la consola y se actualizará la tabla indicando que se ha enviado correctamente


