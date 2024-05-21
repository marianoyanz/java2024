import java.sql.*;

public class managerDB {

    public Connection connect_to_db() throws SQLException {

        Connection con = null;

        try{

            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javaMarket","postgres","admin123");

            if ( !(con == null) )  System.out.println("Conexion ok");

        }
        catch(SQLException e) {

            throw new RuntimeException(e);

        }
        return con;
    }

   public products buscar_producto(Integer id, Connection conn ) {

       products prod = new products();
       try {
           String query = "Select * from products where id =  ? " + id.toString();

           PreparedStatement ps = conn.prepareStatement(query);



           ResultSet rs = ps.executeQuery();
           if(rs.next()){
               prod.setId(rs.getInt(1));
               prod.setDescription(rs.getString(2));
               prod.setStock(rs.getInt(3));
               //prod.setSalesprice(rs.getDouble(3));


        }
        else{
            System.out.println("no encontramos nada");
        }

       }
       catch(Exception e) {
            new SQLException(e);
       }
    return  prod;
    }
}