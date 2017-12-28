package WS;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "Usuario")
public class WsUsuario {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarUsuario")
    public String AgregarUsuario(@WebParam(name = "nombre") String nombre, @WebParam(name = "correo") String correo, @WebParam(name = "fecha_nac") String fecha_nac, @WebParam(name = "nick") String nick, @WebParam(name = "contrasena") String contrasena, @WebParam(name = "karma") String karma) {
        //TODO write your implementation code here:
        return null;
    }
}
