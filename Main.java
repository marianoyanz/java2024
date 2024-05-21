import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        managerDB mDB = new managerDB();

        Connection conec = mDB.connect_to_db();

        int numero = 1;
        products p = mDB.buscar_producto(numero,conec);

        if(null == p)
            System.out.println("mal ahi cheeee");
        else
            System.out.println(p.getDescription());

    }

}
