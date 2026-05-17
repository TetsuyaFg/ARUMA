import java.util.Scanner;
public class Aruma {
    static Scanner aruma = new Scanner(System.in);

    public static void main(String[] arg) {
        int opcion = 0;
        while (opcion != 2) {
            mostrarProducto(0);
        }
    }

    public static void mostrarProducto(int opcion) {
        System.out.println("---uñas---");
        System.out.println("1. Esmaltes");
        System.out.println("2. Salir del programa");
        opcion = aruma.nextInt();
        switch (opcion) {
            case 1:
                productos(opcion, 0);
                break;
            case 2:
                System.out.println("Saliendo del programa...");
                System.exit(0);
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    public static void productos(int opcion, double precio) {
        System.out.println("1. MASGLO (Esmalte Base Ajo y Limón Fotalecedora) S/16.70");
        System.out.println("2. VOGUE  (Esmalte de Uñas Efecto Gel) S/20.90");
        System.out.println("3. MASGLO (Base clinical) S/19.90");
        System.out.println("4. MASGLO (Gel evolutionn brillo) S/24.60");
        System.out.println("5. MASGLO (Esmalte masglo) S/69.90");
        System.out.println("6. MASGLO (Esmalte linda) S/16.70");
        System.out.println("7. MASGLO (Esmalte bella) S/16.70");
        System.out.println("8. OPI    (Esmalte brillo) S/51.90");
        System.out.println("9. Vogue  (Esmalte ena-morada) S/17.90");
        System.out.println("10. CATRICE (Esmalte pearlfection S/12.90)");
        opcion = aruma.nextInt();
    }

    public static double precio_Producto(int opcion, int cantidad) {
        double precio_esmalte = 0;
        switch (opcion) {
            case 1:
                precio_esmalte = 16.70 * cantidad;
                break;
            case 2:
                precio_esmalte = 20.90 * cantidad;
                break;
            case 3:
                precio_esmalte = 19.90 * cantidad;
                break;
            case 4:
                precio_esmalte = 24.60 * cantidad;
                break;
            case 5:
                precio_esmalte = 69.90 * cantidad;
                break;
            case 6:
                precio_esmalte = 16.70 * cantidad;
                break;
            case 7:
                precio_esmalte = 16.70 * cantidad;
                break;
            case 8:
                precio_esmalte = 51.90 * cantidad;
                break;
            case 9:
                precio_esmalte = 17.90 * cantidad;
                break;
            case 10:
                precio_esmalte = 12.90 * cantidad;
                break;
            default:
                System.out.println("Opcion no valida");
        }
        return precio_esmalte;
    }
    public  static boolean deseaComprar(Scanner aruma){
        System.out.println("¿DESEA COMPR ALGO MAS?");
        System.out.println("SI/NO");
        String compar=aruma.nextLine();
        if (compar.equalsIgnoreCase("si")){
            System.out.println("que produscto desea comprar ");
            return true;
        }
        else{
            System.out.println("GRACIAS POR SU VICITA");
            return false;
        }
    }
}


