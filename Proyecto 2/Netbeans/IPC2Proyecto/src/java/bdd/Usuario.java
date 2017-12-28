package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {

    public boolean agregarUsuario(String nombre, String correo, String fecha_nac, String nick, String contrasena, String karma) throws SQLException {
        Connection dbConnection = null;
        //ES PARA DECLARAR SENTENCIAS SQL
        PreparedStatement preparedStatement = null;
        //SQL -- 
        try{
            String insertTableSQL = "INSERT INTO usuario(nombre, correo, fecha_nac, nick,contrasena, karma)" + "VALUES(?,?,?,?,?,?)";
            dbConnection = new conexion().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            /* ? */preparedStatement.setString(1, nombre);
            /* ? */preparedStatement.setString(2, correo);
            /* ? */preparedStatement.setString(3, fecha_nac); 
            /* ? */preparedStatement.setString(4, nick); 
            /* ? */preparedStatement.setString(5, contrasena); 
            /* ? */preparedStatement.setString(6, karma);
            // execute insert SQL stetement

            preparedStatement.executeUpdate();
            dbConnection.close();
            System.out.println("Si ingreso usuarios");
            return true;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    public int getUsuariosPorID (int id_usuario){
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        //ArrayList a[] = new ArrayList[2];
        String selectSQL = "SELECT * FROM USUARIO WHERE id_usuario=?";
        try {
            dbConnection = new conexion().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, id_usuario);
            ResultSet rs;
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println("ID: "+rs.getInt("id_usuario"));
                System.out.println("Nombre: "+ rs.getString("nombre"));
                System.out.println("Correo electrónico: "+rs.getString("correo"));
                System.out.println("Fecha de nacimiento: "+rs.getString("f_nac"));
                System.out.println("Nombre de usuario: "+rs.getString("nick"));
                System.out.println("Contraseña: "+rs.getString("contrasena"));
                System.out.println("Karma: "+rs.getString("karma"));
            }
            rs.close();
        } catch (SQLException se) {
        } catch (Exception e) {
        } finally {
            try {
                if (preparedStatement != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
                
            }
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return 0;
    }
    public static void main(String[] args) {
//        try {
//            (new Usuario()).agregarUsuario("U7", "prueba@gmail.com", "1/1/1", "prueba","123", "ninguno");
//            System.out.println("usuario agregado");
//        } catch (SQLException ex) {
//            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        (new Usuario()).getUsuariosPorID(2);
    }
}
                 