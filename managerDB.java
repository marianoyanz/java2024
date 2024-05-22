import java.sql.*;
import java.util.Scanner;

public class managerDB {

    public Connection connect_to_db() throws SQLException {

        Connection con = null;

        try{

            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javaMarket","postgres","Admin1243_");

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
           String query = "Select * from products where id =  ? ";

           PreparedStatement ps = conn.prepareStatement(query);

           ps.setInt(1,id);

           ResultSet rs = ps.executeQuery();

           if(rs.next()){
               prod.setName(rs.getString(1));
               prod.setId(rs.getInt(2));
               prod.setDescription(rs.getString(3));
               prod.setSalesprice(rs.getDouble(4));
               prod.setStock(rs.getInt(5));
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
    public boolean agregarProducto(Connection conn) throws SQLException {


        products prod = new products();
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese Nombre del Producto: ");
        prod.setName(lector.next());
        System.out.println("Ingrese Stock: ");
        prod.setStock(lector.nextInt());
        System.out.println("Ingrese Precio: ");
        prod.setSalesprice(lector.nextDouble());

        String query = "INSERT INTO PRODUCTS (name,id,description,price,stock,shippinincluded,id_autoincremento) VALUES (?,?,?,?,?,?,?) ";

        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1,"no asdasddadds");
        ps.setInt(2,23232);
        ps.setString(3,prod.description);
        ps.setDouble(4,prod.salesprice);
        ps.setInt(5,prod.stock);
        ps.setBoolean(6,true);
        ps.setInt(7,212121);

        return ps.execute();
    }
}