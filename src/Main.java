import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    ArrayList<String> productosDB =  obtenerProductos();
    int opcionUsuario;
    System.out.println("\n***************************************************************************");
    System.out.println("\n🌍 Bienvenid@ a \uD83C\uDF31 CO2nsciente \uD83C\uDF31 -- soluciones simples para problemas globales --");
    System.out.println("🌿 Absorción de CO₂ = recompensas reales. 😉 Con nosotros ganás x2.");
    System.out.println("\n***************************************************************************");


    System.out.print("\nIngrese su provincia:\n ");
    String provincia = entrada.nextLine().trim().toLowerCase();
    System.out.println("\n***************************************************************************");

    switch (provincia) {
      case "buenos aires":
        System.out.println("🌳 Arboles: Jacaranda, Ceibo ");
        System.out.println("\uD83C\uDF33 Plantas de interior: Potus, Lengua De Suegra");
        break;

      case "cordoba":
        System.out.println("🌳 Arboles: Algarrobo, Espinillo");
        System.out.println("\uD83C\uDF33 Plantas de interior: Ficus, Helecho De Boston");
        break;

      case "mendoza":
        System.out.println("🌳 Arboles: Alamo, Olivo ");
        System.out.println("\uD83C\uDF33 Plantas de interior: Aloe Vera, Palma Areca ");
        break;
      default:
        System.out.println("Provincia no encrontrada. Mostrando opciones generales para la zona de Argentina. ");
        System.out.println("Arboles: Sauce, Lapacho.");
        System.out.println("Plantas de interiores: Cinta, Dracena. ");


    }
    System.out.println("\n***************************************************************************");


    label:
    while (true){
      System.out.println("""
      \nIngrese el numero equivalente a la opcion:\n
      0- Finaliza el programa
      1- Crea un producto
      2- Listar Productos
      3- Busqueda por nombre
      4- Editar nombre producto
      5- Borrar producto
      """);
      opcionUsuario = entrada.nextInt();

      switch (opcionUsuario) {
        case 1 -> crearProducto(productosDB);
        case 2 -> listarProductos(productosDB);
        case 3 -> buscarNombre(productosDB);
        case 4 -> editarProducto(productosDB);
        case 5 -> eliminarProducto(productosDB);
        case 0 -> {
          System.out.println("\uD83C\uDF33\uD83C\uDF2C Gracias por su compromiso con el planeta");

          break label;
        }
      default -> System.out.println("Opcion incorrecta, intentelo de nuevo");

     }
   }
  }

  public static void crearProducto(ArrayList<String> productos){
  Scanner entrada = new Scanner(System.in);
  System.out.println("Creando nuevo producto");
  System.out.print("Ingrese el nombre del producto nuevo: ");
  String nombre = entrada.nextLine();

  productos.add(nombre);
  //agregar mesaje d confirmacion d producto agregado
  pausa();
  }

  public static void listarProductos(ArrayList<String> productos) {
  System.out.println("Lista de productos:");

  if (productos == null || productos.isEmpty()) {
    System.out.println("No hay productos q mostrar...");
  }else{
    int contador = 1;
    for (String producto : productos) {
      System.out.printf(" %2d.%s%n", contador++, producto);
    }
  }
  System.out.println("----------------------------------");
  pausa();
}

  public static void buscarNombre(ArrayList<String> productos) {
  Scanner entrada = new Scanner(System.in);
  System.out.println("Ingrese el nombre del producto: ");
  String busqueda = entrada.nextLine();
  ArrayList<String> productosEncontrados = new ArrayList<>();

  for (String producto : productos){
    if(estaIncluido(producto, busqueda)) {
      productosEncontrados.add(producto);
    }
  }
  listarProductos(productosEncontrados);
  }
public static boolean estaIncluido(String nombreCompleto, String nombreParcial) {
    String nombreCompletoFormateado = formatoBusqueda(nombreCompleto);
    return nombreCompletoFormateado.contains(formatoBusqueda(nombreParcial));
}

public static  String formatoBusqueda(String texto) {
    return texto.trim().toLowerCase();
}

public static void pausa() {
    Scanner entrada = new Scanner(System.in);
    System.out.println("ENTER para continuar...");
    entrada.nextLine();
    for (int i = 0; i < 20; ++i) {
      System.out.println();
      //limpiar mejor la pantalla
    }
}

public static  ArrayList<String> obtenerProductos() {
    ArrayList<String> productos = new ArrayList<>();

  productos.add("Combo Verde Urbano (3 plantas purificadoras)");
  productos.add("Pack Semillas Futuro Sustentable");
  productos.add("Mini Huerta de Aromáticas CO₂ Free");
  productos.add("Kit Bonsái Respira Planeta");
  productos.add("Fertilizante líquido orgánico 'Oxígeno Extra'");
  productos.add("Maceta inteligente con sensor de humedad");
  productos.add("Set 'Guardianes del Aire' (árboles nativos en miniatura)");
  productos.add("Tierra negra enriquecida con biochar");
  productos.add("Pack Plantitas de Oficina Anti-Estrés");
  productos.add("Estación de germinación portátil 'EcoStart'");
  productos.add("Combo Árboles Jóvenes Reforestación Express");
  productos.add("Riego solar automático EcoDrop");

  return productos;

}

  public static void editarProducto(ArrayList<String> productos) {
    Scanner entrada = new Scanner(System.in);
    listarProductos(productos); // Mostramos la lista actual para elegir cuál editar

    if (productos.isEmpty()) {
      System.out.println("No hay productos para editar...");
      pausa();
      return;
    }

    System.out.print("Ingrese el número del producto que desea editar: ");
    int indice = entrada.nextInt();
    entrada.nextLine(); // limpiar buffer

    if (indice < 1 || indice > productos.size()) {
      System.out.println("Número inválido. Intente nuevamente.");
      pausa();
      return;
    }

    System.out.print("Ingrese el nuevo nombre para el producto: ");
    String nuevoNombre = entrada.nextLine();

    String productoAntiguo = productos.get(indice - 1);
    productos.set(indice - 1, nuevoNombre);

    System.out.println("✅ Producto editado con éxito:");
    System.out.println("🔄 " + productoAntiguo + " ➜ " + nuevoNombre);
    pausa();
  }


  public static void eliminarProducto(ArrayList<String> productos) {
    Scanner entrada = new Scanner(System.in);
    listarProductos(productos);

    System.out.print("Ingrese el número del producto que desea eliminar: ");
    int indice = entrada.nextInt();

    if (indice > 0 && indice <= productos.size()) {
      String eliminado = productos.remove(indice - 1);
      System.out.println("🗑️ Producto eliminado: " + eliminado);
    } else {
      System.out.println("❌ Número inválido. Intente nuevamente.");
    }

    pausa();
  }


}


