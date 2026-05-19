
import java.util.Scanner;
public class SeccionLabiosAruma {
    static void main(String[] args) {
        Scanner aruma = new Scanner(System.in);
        int opcion;
        double total=0;
        int cantidaddeProductos=0;
        mostrarBienvenida();
        do {
            menuLabios();
            System.out.println("INGRESE UNA OPCION");
            opcion = aruma.nextInt();
            switch (opcion) {
                case 1:total = total + compraDelProducto(aruma,
                        "==ESSENCE== RUBOR ESSENCE WHAT A TINT! LIP & CHEEK TINT 01", 19.90);
                    cantidaddeProductos++;
                    break;
                case 2:
                    total=total+compraDelProducto(aruma,"==ESSENCE== Gloss Extreme Shine Volume Lipgloss 17",14.90);
                    cantidaddeProductos++;
                    break;
                case 3:
                    total=total+ compraDelProducto(aruma,"==MAYBELLINE== Labial Color Sensational Made For All 0.34 Fl Oz Tono Mauve For Me Maybelline",38.32);
                    cantidaddeProductos++;
                    break;
                case 4:
                    total=total +compraDelProducto(aruma,"==MAYBELLINE== Labial Líquido Maybelline Ny Vinyl Ink Lippy 10",59.90);
                    cantidaddeProductos++;
                    break;
                case 5:
                    total=total+compraDelProducto(aruma,"==MAYBELLINE== Brillo Labial Maybelline Ny Lifter Gloss Moon",14.90);
                    cantidaddeProductos++;
                    break;
                case 6:
                    total=total+compraDelProducto(aruma,"==MAYBELLINE== Labial Líquido Súper Stay Vinyl Ink Tono Fearless 4.2ml Maybelline",59.90);
                    cantidaddeProductos++;
                    break;
                case 7:
                    total=total+compraDelProducto(aruma,"==ESSENCE== Gloss Hydra Kiss Lip Tint 03 Essence",15.90);
                    cantidaddeProductos++;
                    break;
                case 8:
                    total=total+compraDelProducto(aruma,"==MAYBELLINE== Labial Líquido Súper Stay Vinyl Ink Tono Peppy 4.2ml Maybelline",59.90);
                    cantidaddeProductos++;
                    break;
                case 9:
                    total=total+compraDelProducto(aruma,"==MAYBELLINE== Labial Líquido Maybelline Ny Vinyl Ink Cheeky 34",59.90);
                    cantidaddeProductos++;
                    break;
                case 10:
                    total=total+compraDelProducto(aruma,"==BEAUTY CREATIONS== Labial Balm N Cute Cherry Beauty Creations",34.90);
                    break;
                case 11:
                    mostrarBoleta(total,cantidaddeProductos);
                    break;
                case 12:
                    System.out.println("Gracias por visitar esta seccion SOMOS =_ARUMA_=");
                    break;
                default:
                    System.out.println("Opcion incorrecta. Intente nuevamente.");
                    break;

            }
        }
        while (opcion != 12);

    }

    public static void mostrarBienvenida() {
        System.out.println("============================");
        System.out.println("____ARUMA - MAQUILLAJE____");
        System.out.println("_____CATEGORIA: LABIOS´ ");
        System.out.println("______SECCION: LABIAL");
        System.out.println("==============================");
    }

    public static void menuLabios() {
        System.out.println("---Productos Disponibles---");
        System.out.println("1.==ESSENCE== RUBOR ESSENCE WHAT A TINT! LIP & CHEEK TINT 01: S/19.90");
        System.out.println("2.==ESSENCE== Gloss Extreme Shine Volume Lipgloss 17: S/14.90");
        System.out.println("3.==MAYBELLINE== Labial Color Sensational Made For All 0.34 Fl Oz Tono Mauve For Me Maybelline : S/38.32");
        System.out.println("4.==MAYBELLINE== Labial Líquido Maybelline Ny Vinyl Ink Lippy 10: S/59.90");
        System.out.println("5.==MAYBELLINE== Brillo Labial Maybelline Ny Lifter Gloss Moon: S/14.90 ");
        System.out.println("6.==MAYBELLINE== Labial Líquido Súper Stay Vinyl Ink Tono Fearless 4.2ml Maybelline: S/59.90");
        System.out.println("7.==ESSENCE== Gloss Hydra Kiss Lip Tint 03 Essence: S/15.90");
        System.out.println("8.==MAYBELLINE== Labial Líquido Súper Stay Vinyl Ink Tono Peppy 4.2ml Maybelline: S/59.90");
        System.out.println("9.==MAYBELLINE== Labial Líquido Maybelline Ny Vinyl Ink Cheeky 34: S/59.90");
        System.out.println("10.==BEAUTY CREATIONS== Labial Balm N Cute Cherry Beauty Creations: S/34.90");
        System.out.println("11.-----Ver Boleta------");
        System.out.println("12. EXIT🫡");

    }
    public static double compraDelProducto(Scanner aruma, String nombreProducto, double precio){
        int cantidad;
        double subtotal;
        System.out.println("Producto Seleccionado: ");
        System.out.println(nombreProducto);
        System.out.println("Precio Unitario: S/ "+precio);
        System.out.print("Ingrese la cantidad que desea comprar");
        cantidad= aruma.nextInt();

        while(cantidad<= 0){
            System.out.println("La cantidad debe de ser mayor a cero.");
            System.out.print("Ingrese nuevamente la cantidad.");
            cantidad= aruma.nextInt();

        }
        subtotal = precio*cantidad;
        System.out.println("Sub total por este producto: S/"+subtotal);
        return subtotal;

        }
        public static void mostrarBoleta(double total, int cantidadPoductos){
        double descuento;
        double totalfinal;
            System.out.println("======BOLETA DE COMPRA=====");
            System.out.println("Cantidad de tipos de productos comprados: "+cantidadPoductos);
            System.out.println("Total acumulado: S/"+total);
            if (total >= 100){
                descuento = total * 0.10;
                totalfinal= total - descuento;

                System.out.println("Descuento Aplicado: 10%");
                System.out.println("Monto de descuento: S/"+descuento);
                System.out.println("Total final a pagar: S/"+totalfinal);

            }
            else if (total>=50){
                descuento = total * 0.05;
                totalfinal = total - descuento;
                System.out.println("Descuento aplicado: 5%");
                System.out.println("Monto de descuento: S/"+descuento);
                System.out.println("Total final a pagar: S/"+totalfinal);

            }
            else {
                descuento = 0;
                totalfinal= total;

                System.out.println("No se aplico descuento");
                System.out.println("Total final a pagar: S/"+totalfinal);
            }
            System.out.println("===============================================");
            }

    }
