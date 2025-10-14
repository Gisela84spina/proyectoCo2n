
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    ArrayList<Producto> productosDB =  obtenerProductos();
    int idSiguiente = productosDB.size() +1;
    int opcionUsuario;


      System.out.println("══════════════════════════════════════════════════════════════");
      System.out.println(" ");
      System.out.println("Desde la Revolución Industrial, las emisiones de CO₂ han aumentado");
      System.out.println("más de un 400%, intensificando el calentamiento global y generando");
      System.out.println("consecuencias visibles como huracanes, incendios y sequías extremas.");
      System.out.println(" ");
      System.out.println("Lo que quizás no sabías es que cerca del 78% del oxígeno que respiramos");
      System.out.println("proviene de las microplantas marinas — organismos que están en riesgo");
      System.out.println("porque la temperatura de los océanos no deja de aumentar.");
      System.out.println(" ");
      System.out.println("💡 En esta aplicación promovemos la compra de las plantas que mayor");
      System.out.println("capacidad de absorción de CO₂ tienen en tu zona. Cada usuario que");
      System.out.println("adquiere y mantiene su planta recibe puntos semanales, que puede");
      System.out.println("canjear por descuentos en supermercados locales. 🌱");
      System.out.println(" ");
      System.out.println("Así, quienes ya son conscientes del cambio climático se benefician,");
      System.out.println("y quienes aún no lo son, pueden transformarse en nuevos agentes de");
      System.out.println("cambio — quizás atraídos al principio por el sistema de puntos, pero");
      System.out.println("motivados luego por el impacto positivo que pueden generar. 💚");
      System.out.println(" ");
      System.out.println("══════════════════════════════════════════════════════════════");
      System.out.println("Desarrollado por Gisela Spina — Proyecto CO2nsciente 🌿");
      System.out.println("══════════════════════════════════════════════════════════════");
      System.out.println(" ");


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
        case 1 -> {
          crearProducto(idSiguiente, productosDB);
          idSiguiente += 1;
        }
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

  public static void crearProducto(int id, ArrayList<Producto> productos){
  Scanner entrada = new Scanner(System.in);
  System.out.println("Creando nuevo producto");
  System.out.print("Ingrese el nombre del producto nuevo: ");
  String nombre = entrada.nextLine();


  productos.add(new Producto(id, nombre)); //caambiarlo a static mas adelante
  //agregar mensaje d confirmacion d producto agregado
  pausa();
  }

  public static void listarProductos(ArrayList<Producto> productos) {
  System.out.println("Lista de productos:");

  if (productos == null || productos.isEmpty()) {
    System.out.println("No hay productos q mostrar...");
  }else{

    for (Producto producto : productos) {
      System.out.printf(" %2d.%s%n", producto.id, producto.nombre);
    }
  }
  System.out.println("----------------------------------");
  pausa();
}

  public static void buscarNombre(ArrayList<Producto> productos) {
  Scanner entrada = new Scanner(System.in);
  System.out.println("Ingrese el nombre del producto: ");
  String busqueda = entrada.nextLine();
  ArrayList<Producto> productosEncontrados = new ArrayList<>();

  for (Producto producto : productos){
    if(estaIncluido(producto.nombre, busqueda)) {
      productosEncontrados.add(producto);
    }
  }
  listarProductos(productosEncontrados);
  }


  public static void editarProducto(ArrayList<Producto> productos) {
    //el listado no tiene en si al producto si no q guarda la direccion
    //donde se encuentra ese producto
    Scanner entrada = new Scanner(System.in);
    //y aca tenms la direccion d memoria q nos permite modificar el obj original
    // q es 1 d los q esta en el listado
    Producto producto = obtenerProductoPorId(productos);
    //to do: validar q encontramos el producto
    String nombreOriginal = producto.nombre;
    System.out.println("Producto a editar: ");
    System.out.println(nombreOriginal);
    //to do: confirmar q el usuario eligio producto correcto a editar
    System.out.print("Ingrese el nuevo nombre: ");
    String nuevoNombre = entrada.nextLine();

    //actualizacion dl nombre
    producto.nombre = nuevoNombre;

    System.out.printf("El nombre del producto cambio de %s a %s", nombreOriginal, nuevoNombre);
  }


  public static void eliminarProducto(List<Producto> productos) {
    Scanner entrada = new Scanner(System.in);
    Producto producto = obtenerProductoPorId(productos);
    //to do: validar q encontramos el producto
    String nombreOriginal = producto.nombre;
    System.out.println("Ingrese el producto que desea eliminar: ");
    System.out.println(nombreOriginal);
    //to do: confirmar el producto a eliminar

    //borrando el producto
    productos.remove(producto);
    System.out.println("Borrado exitosamente!!");
  }

  //utilidades
  //busqueda x id, x ahora solo funciona con el indice, cambiar a futuro
  //preguntar al profe si es x el salto del numero
  public static Producto obtenerProductoPorId(List<Producto> productos) {
    Scanner entrada = new Scanner(System.in);
    // to do: validar datos
    System.out.println("Ingrese el id del producto: ");
    int idBusqueda = entrada.nextInt();

    for (Producto producto : productos){
      if (producto.id == idBusqueda) {
        return  producto;
      }
    }

    return null; // no se encontro el producto
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

public static  ArrayList<Producto> obtenerProductos() {
    ArrayList<Producto> productos = new ArrayList<>();

  productos.add(new Producto(1,"Combo Verde Urbano (3 plantas purificadoras)"));
  productos.add(new Producto(2,"Pack Semillas Futuro Sustentable"));
  productos.add(new Producto(3,"Mini Huerta de Aromáticas CO₂ Free"));
  productos.add(new Producto(4,"Kit Bonsái Respira Planeta"));
  productos.add(new Producto(5,"Fertilizante líquido orgánico 'Oxígeno Extra'"));
  productos.add(new Producto(6,"Maceta inteligente con sensor de humedad"));
  productos.add(new Producto(7,"Set 'Guardianes del Aire' (árboles nativos en miniatura)"));
  productos.add(new Producto(8,"Tierra negra enriquecida con biochar"));
  productos.add(new Producto(9,"Pack Plantitas de Oficina Anti-Estrés"));
  productos.add(new Producto(10,"Estación de germinación portátil 'EcoStart'"));
  productos.add(new Producto(11,"Combo Árboles Jóvenes Reforestación Express"));
  productos.add(new Producto(12,"Riego solar automático EcoDrop"));

  return productos;

}


}


