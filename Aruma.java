import java.util.Scanner;
public class Aruma {
    static Scanner aruma = new Scanner(System.in);
    static double totalCompra = 0;
    public static void main(String[] arg){
        int opcion = 0;
        while(opcion != 2){
            mostrarProducto(0);
        }
    }
    public static void mostrarProducto(int opcion){
        System.out.println("\n---OJOS---");
        System.out.println("1. Sombras");
        System.out.println("2. Salir del programa");

        opcion = aruma.nextInt();

        switch (opcion){
            case 1:
                productos(0,0);
                break;
            case 2:
                System.out.println("Saliendo del programa...");
                System.exit(0);
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }
    public static void productos(int opcion, double precio){
        int cantidad;
        String nombre = "";

        System.out.println("---PRODUCTOS---");
        System.out.println("1. Sheglam S/82.90");
        System.out.println("2. Petrizzio S/29.90");
        System.out.println("3. Catrice S/26.90");
        System.out.println("4. Clinique S/145.00");
        System.out.println("5. Essence S/15.90");
        System.out.println("6. Maybelline S/48.90");
        System.out.println("7. L.A Girl S/47.90");
        System.out.println("8. L.A Girl Pro S/150.50");
        System.out.println("9. L.A Girl Liquida S/85.90");
        System.out.println("10. L'oreal Paris S/68.90");

        opcion = aruma.nextInt();

        switch (opcion){
            case 1:
                precio = 82.90;
                nombre = "Sheglam";
                break;

            case 2:
                precio = 29.90;
                nombre = "Petrizzio";
                break;

            case 3:
                precio = 26.90;
                nombre = "Catrice";
                break;

            case 4:
                precio = 145.00;
                nombre = "Clinique";
                break;

            case 5:
                precio = 15.90;
                nombre = "Essence";
                break;

            case 6:
                precio = 48.90;
                nombre = "Maybelline";
                break;

            case 7:
                precio = 47.90;
                nombre = "L.A Girl";
                break;

            case 8:
                precio = 150.50;
                nombre = "L.A Girl Pro";
                break;

            case 9:
                precio = 85.90;
                nombre = "L.A Girl Liquida";
                break;

            case 10:
                precio = 68.90;
                nombre = "L'oreal Paris";
                break;
            default:
                System.out.println("Opcion no valida");
                return;
        }
        System.out.println("¿Cuantos va llevar?");
        cantidad = aruma.nextInt();
        double subtotal = precio * cantidad;
        totalCompra = totalCompra + subtotal;

//boleta simple para conectar el resto.

        System.out.println("---BOLETA---");
        System.out.println("Producto: " + nombre);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio unitario: S/" + precio);
        System.out.println("Subtotal: S/" + subtotal);
        System.out.println("Total acumulado: S/" + totalCompra);

        seguirComprando();
    }
    public static void seguirComprando(){
        String opcion;
        System.out.println("¿va llevar algo mas?");
        System.out.println("SI / NO");
        opcion = aruma.next();

        if(opcion.equalsIgnoreCase("SI")){
            productos(0,0);
        }else{
            System.out.println("Gracias por su compra");
            System.out.println("Total final: S/" + totalCompra);
        }
    }
}