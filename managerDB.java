import com.sun.jdi.ObjectReference;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class managerDB {


    public Connection connect_to_db() throws SQLException {

        Connection con = null;

        try {

            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javaMarket", "postgres", "admin123");

            if (!(con == null)) System.out.println("Conexion ok");

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
        return con;
    }

    public products buscar_producto(Integer id, Connection conn) {

        products prod = new products();

        try {
            String query = "Select * from products where id =  ? ";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                prod.setDescription(rs.getString(2));

                prod.setStock(rs.getInt(3));

                prod.setSalesprice(rs.getDouble(4));

            }
            else
                System.out.println("no encontramos nada");

        } catch (Exception e) {
            new SQLException(e);
        }
        return prod;
    }

    public ArrayList<products> ListaProductos(Connection conn) throws SQLException {

        ArrayList<products> Productos_lista = new ArrayList<products>();

        String query = "Select * from products";

        PreparedStatement ps = conn.prepareStatement(query);

        ResultSet datos = ps.executeQuery();

        while (datos.next()) {
            products prod1 = new products();
            prod1.setId(datos.getInt(1));
            prod1.setName(datos.getString(2));
            prod1.setDescription(datos.getString(3));
            prod1.setSalesprice(datos.getDouble(4));
            prod1.setStock(datos.getInt(5));
            Productos_lista.add(prod1);
        }

        return Productos_lista;
    }

    public boolean modificarProducto(Connection conn, String descripcion, int stock, Double precioNew,int id) throws SQLException {

        String query = "update products set description = ?, stock = ?,salesprice = ? where id = ?";

        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1,descripcion);
        ps.setInt(2,stock);
        ps.setDouble(3,precioNew);
        ps.setInt(4,id);

        return ps.execute();
    }


    public boolean eliminarProducto(Connection conn, int id) throws SQLException {

        String query = "Delete * from products where id = ?";

        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1,id);

        return ps.execute();
    }

    public boolean agregarProducto(Connection conn) throws SQLException {


        products prod = new products();

        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese id del Producto(arreglar en db): ");
        prod.setId(lector.nextInt());
        System.out.println("Ingrese descripcion del Producto: ");
        prod.setDescription(lector.next());
        System.out.println("Ingrese Stock: ");
        prod.setStock(lector.nextInt());
        System.out.println("Ingrese Precio: ");
        prod.setSalesprice(lector.nextDouble());

        String query = "INSERT INTO PRODUCTS (id,description,stock,salesprice) VALUES (?,?,?,?);";

        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1,prod.id);
        ps.setString(2, prod.description);
        ps.setInt(3,prod.stock);
        ps.setDouble(4,prod.salesprice);

        return ps.execute();
    }
}