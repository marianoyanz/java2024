import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        managerDB mDB = new managerDB();

        Connection conec = mDB.connect_to_db();

        Scanner lector = new Scanner(System.in);

        mostrarMenu();
        System.out.println("Ingrese un numero (para salir ingrese 0): ");
        int numero = lector.nextInt();

        while (numero != 0) {
            switch (numero) {
                case 1:
                    if(!(mDB.agregarProducto(conec))) System.out.println("Hubo un error");
             /*   case 2:
                    mDB.modificarProducto();
                    break;
                case 3:
                    mDB.eliminarProducto();
                    break;*/
                case 4:
                    products p = mDB.buscar_producto(numero, conec);
                    if (null == p)
                        System.out.println("mal ahi cheeee");
                    else
                        System.out.println(p.getDescription());
                        System.out.println(p.getStock());
                case 0:
                    break;
            }
            System.out.println("Ingrese un numero: /para salir ingrese 0");
            numero = lector.nextInt();
        }
    }

    public static void mostrarMenu() {
        System.out.println("1)Buscar Producto");
        System.out.println("2)Agregar Producto");
        System.out.println("3)Modificar Producto");
        System.out.println("4)Eliminar Producto");
        System.out.println("5)Listar los productos");
        System.out.println("0)Salir");
    }

}
