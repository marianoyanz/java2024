import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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

                    if(mDB.agregarProducto(conec)) System.out.println("Hubo un error");

                    else System.out.println("Producto cargado con exito");

                case 2:
                    ArrayList<products> productos = new ArrayList<products>();

                    productos = mDB.ListaProductos(conec);

                    if(!(productos.isEmpty())) {
                        System.out.println("lISTADO PRODUCTOS: ");

                        for (int i = 0; i < productos.size(); i++)

                            System.out.println( i + ")" + productos.get(i).toString());

                    }

                    else System.out.println("No hay productos cargados");

                    break;
                case 3:
                    System.out.println("Ingrese el id del producto a eliminar: ");

                    int id = lector.nextInt();

                    if(mDB.eliminarProducto(conec,id)) System.out.println("Producto eliminado con exito.");

                    break;
                case 4:
                    System.out.println("Ingrese el id del producto a buscar: ");
                    int idprod = lector.nextInt();

                    products p = mDB.buscar_producto(idprod, conec);

                    if (null == p)

                        System.out.println("mal ahi cheeee");

                    else{
                        System.out.println("Algunos datos...");

                        System.out.println(p.getDescription());
                        System.out.println(p.getStock());
                    }
                    break;
                case 5:
                    products prod = null;

                    System.out.println("Ingrese el id del producto a modificar: ");

                    int idMod = lector.nextInt();

                    prod = mDB.buscar_producto(idMod,conec);

                    System.out.println(prod.toString());

                    System.out.println("Ingrese la nueva descripcion: ");
                    String des = lector.next();

                    System.out.println("Ingrese el recuento de stock: ");
                    int stock = lector.nextInt();

                    System.out.println("Ingrese el precio del producto: ");
                    Double precio = lector.nextDouble();

                    if(mDB.modificarProducto(conec,des,stock,precio,idMod)) System.out.println("Producto modificado con exito.");

                    else System.out.println("aLgo paso compaaaa");
                    break;
                case 0:

                    break;
            }
            mostrarMenu();
            System.out.println("Ingrese un numero: /para salir ingrese 0");

            numero = lector.nextInt();
        }
    }


    public static void mostrarMenu() {
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("1)Agregar Producto");
        System.out.println("2)Listar Productos");
        System.out.println("3)Eliminar Producto");
        System.out.println("4)Buscar Producto");
        System.out.println("5)Modificar Producto");
        System.out.println("0)Salir");

        System.out.println("---------------------------------------------------------------------------");
    }

}
