import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ArumaVersion01 {
    static Scanner aruma = new Scanner(System.in);
    static double totalCompra = 0;
    static int cantidadProductos = 0;

    public static void main(String[] args) {
        int respuesta = 0;

        while (respuesta != 4) {
            System.out.println("-----BIENVENIDO A ARUMA-----");
            MENUARUMA();
            System.out.println("Elija como desea ingresar (en numeros)");
            respuesta = aruma.nextInt();
            aruma.nextLine();
            boolean acceso = false;

            switch (respuesta) {
                case 1:
                    if (REGISTRO_NOMBRES(aruma)) {
                        registro_de_correo_contrasena(aruma);
                        acceso = true;
                    } else {
                        System.out.println("Acceso denegado");
                        respuesta = 0;
                    }
                    break;
                case 2:
                    loginUsuario(aruma);
                    acceso = true;
                    break;
                case 3:
                    System.out.println("Ingreso como invitado");
                    acceso = true;
                    break;
                case 4:
                    System.out.println("Gracias por su visita");
                    aruma.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

            if (acceso) {
                boolean seguirComprando = true;
                while (seguirComprando) {
                    menu_productos();
                    System.out.println("Elija la categoria que desea (en numeros)");
                    int opcion = aruma.nextInt();
                    aruma.nextLine();

                    switch (opcion) {
                        case 1: productosOjos(); break;
                        case 2: SeccionLabios(); break;
                        case 3: productosRostro(); break;
                        case 4: productosUnas(); break;
                        default: System.out.println("Opcion no valida");
                    }

                    System.out.println("¿Desea comprar otro articulo? (SI/NO)");
                    String otroArticulo = aruma.nextLine();
                    if (otroArticulo.equalsIgnoreCase("NO")) {
                        seguirComprando = false;
                    }
                }

                System.out.println("Total a pagar: S/" + totalCompra);
                System.out.println("Desea pagar con tarjeta? (SI/NO)");
                String metodoPago = aruma.nextLine();
                if (metodoPago.equalsIgnoreCase("SI")) {
                    validaPagoTarjeta(aruma, totalCompra);
                }

                mostrarBoleta(totalCompra, cantidadProductos);
                System.out.println("Gracias por su compra en ARUMA!");
            }
        }
    }

    // MENUS
    public static void MENUARUMA() {
        System.out.println("1.REGISTRARSE");
        System.out.println("2.INICIAR SESION");
        System.out.println("3.INGRESAR COMO INVITADO");
        System.out.println("4.SALIR");
    }

    public static void menu_productos() {
        System.out.println("\n---CATEGORIAS DE MAQUILLAJE---");
        System.out.println("1. Ojos");
        System.out.println("2. Labios");
        System.out.println("3. Rostro");
        System.out.println("4. Uñas");
    }

    //REGISTRO E INICIO DE SESION
    public static boolean REGISTRO_NOMBRES(Scanner aruma) {
        System.out.println("Ingrese sus nombres y apellidos:");
        String nombre_apellidos = aruma.nextLine();
        System.out.println("Ingrese su DNI:");
        String dni = aruma.nextLine();
        System.out.println("Ingrese su año de nacimiento:");
        int fecha = aruma.nextInt();
        aruma.nextLine();
        int edad = 2026 - fecha;
        if (edad >= 18 && edad < 97) {
            System.out.println("Tiene " + edad + " años. Puede continuar");
            return true;
        } else {
            System.out.println("Usted es menor de 18 años. Acceso denegado.");
            return false;
        }
    }

    public static void registro_de_correo_contrasena(Scanner aruma) {
        System.out.println("Ingrese su correo:");
        String correo = aruma.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contrasena = aruma.nextLine();
        System.out.println("----INICIO DE SESION--------");
        System.out.println("Ingrese su correo:");
        String correo_in = aruma.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contrasena_in = aruma.nextLine();
        if (correo.equals(correo_in) && contrasena.equals(contrasena_in)) {
            System.out.println("Bienvenido a ARUMA!");
        } else {
            System.out.println("Correo o contraseña incorrecta. Vuelva a intentar.");
        }
    }

    public static void loginUsuario(Scanner aruma) {
        System.out.println("-----INICIAR SESION------");
        String correo, pass;
        do {
            System.out.println("Ingrese su correo:");
            correo = aruma.nextLine();
            System.out.println("Ingrese su contraseña:");
            pass = aruma.nextLine();
            boolean correoOk = correo.contains("@") && correo.endsWith(".com");
            boolean passOk = pass.length() >= 8 && (pass.contains("#") || pass.contains("@"));
            if (correoOk && passOk) {
                System.out.println("Bienvenido a ARUMA");
                break;
            } else {
                System.out.println("Datos incorrectos. Intente nuevamente.");
            }
        } while (true);
    }

    //SECCIONES CON PRODUCTOS
    public static void productosOjos() {
        String[] nombres = {"Sheglam","Petrizzio","Catrice","Clinique","Essence","Maybelline","L.A Girl","L.A Girl Pro","L.A Girl Liquida","L'oreal Paris"};
        double[] precios = {82.90,29.90,26.90,145.00,15.90,48.90,47.90,150.50,85.90,68.90};

        for(int i=0;i<10;i++){
            System.out.println((i+1)+". "+nombres[i]+" S/"+precios[i]);
        }
        System.out.println("Seleccione opcion:");
        int opcion = aruma.nextInt();
        aruma.nextLine();
        System.out.println("Ingrese cantidad:");
        int cantidad = aruma.nextInt();
        aruma.nextLine();
        totalCompra += precios[opcion-1]*cantidad;
        cantidadProductos++;
    }

    public static void SeccionLabios() {
        String[] nombres = {"ESSENCE What A Tint","ESSENCE Gloss Choco Bomb","ESSENCE Gloss Extreme Shine","CATRICE Plumping Lip Liner","MAYBELLINE Lifter Gloss","MAYBELLINE Labial Líquido Fearless","ESSENCE Gloss Hydra Kiss","MAYBELLINE Labial Líquido Peppy","MAYBELLINE Vinyl Ink Cheeky","BEAUTY CREATIONS Labial Balm"};
        double[] precios = {19.90,7.90,14.90,12.90,57.72,59.90,15.90,59.90,59.90,34.90};

        for(int i=0;i<10;i++){
            System.out.println((i+1)+". "+nombres[i]+" S/"+precios[i]);
        }
        System.out.println("Seleccione opcion:");
        int opcion = aruma.nextInt();
        aruma.nextLine();
        System.out.println("Ingrese cantidad:");
        int cantidad = aruma.nextInt();
        aruma.nextLine();
        totalCompra += precios[opcion-1]*cantidad;
        cantidadProductos++;
    }

    public static void productosRostro() {
        String[] nombres = {"Base Fit Me Matte","Spray Fijador Petrizzio","Sellador L.A GIRL","Base Pixi On-The-Glow","Base Clinique","Serum L'OREAL PARIS","Base Polvo L'OREAL PARIS","Base Pro-Matte L'OREAL PARIS","Colorete CATRICE","Base FREZYDERM"};
        double[] precios = {56.86,44.90,55.90,79.90,210.00,101.92,80.66,79.82,21.90,144.00};

        for(int i=0;i<10;i++){
            System.out.println((i+1)+". "+nombres[i]+" S/"+precios[i]);
        }
        System.out.println("Seleccione opcion:");
        int opcion = aruma.nextInt();
        aruma.nextLine();
        System.out.println("Ingrese cantidad:");
        int cantidad = aruma.nextInt();
        aruma.nextLine();
        totalCompra += precios[opcion-1]*cantidad;
        cantidadProductos++;
    }

    public static void productosUnas() {
        String[] nombres = {"MASGLO Base Ajo y Limón","VOGUE Gel","MASGLO Base clinical","MASGLO Gel evolutionn brillo","MASGLO esmalte masglo","MASGLO esmalte linda","MASGLO esmalte bella","OPI Brillo","Vogue Ena-morada","CATRICE Pearlfection"};
        double[] precios = {16.70,20.90,19.90,24.60,69.90,16.70,16.70,51.90,17.90,12.90};

        for(int i=0;i<10;i++){
            System.out.println((i+1)+". "+nombres[i]+" S/"+precios[i]);
        }
        System.out.println("Seleccione opcion:");
        int opcion = aruma.nextInt();
        aruma.nextLine();
        System.out.println("Ingrese cantidad:");
        int cantidad = aruma.nextInt();
        aruma.nextLine();
        totalCompra += precios[opcion-1]*cantidad;
        cantidadProductos++;
    }

    //BOLETA
    public static void mostrarBoleta(double total, int cantidadProductos){
        double descuento;
        double totalfinal;
        System.out.println("======BOLETA DE COMPRA======");
        System.out.println("Cantidad de tipos de productos comprados: "+cantidadProductos);
        System.out.println("Total acumulado: S/"+total);
        if (total >= 100){
            descuento = total * 0.10;
            totalfinal= total - descuento;
            System.out.println("Descuento Aplicado: 10%");
        } else if (total>=50){
            descuento = total * 0.05;
            totalfinal = total - descuento;
            System.out.println("Descuento aplicado: 5%");
        } else {
            descuento = 0;
            totalfinal= total;
            System.out.println("No se aplico descuento");
        }
        System.out.println("Monto de descuento: S/"+descuento);
        System.out.println("Total final a pagar: S/"+totalfinal);
        System.out.println("===============================================");
    }

    //VALIDAR PAGO
    public static void validaPagoTarjeta(Scanner escaner, double total) {
        String nroTarjeta, fechaVencimiento, cvv;
        boolean pAprovado = false;
        System.out.println("Monto total a pagar con tarjeta es: S/" + total);
        do {
            System.out.println("Ingrese los 16 digitos de la tarjeta");
            nroTarjeta = escaner.nextLine();
            System.out.println("Ingrese la fecha de caducidad (MM/AA) ");
            fechaVencimiento = escaner.nextLine();
            System.out.println("Ingrese el código de seguridad CVV");
            cvv = escaner.nextLine();

            boolean tarjetaOk = (nroTarjeta.length() == 16);
            boolean cvvOk = (cvv.length() == 3);
            boolean fechaEstructuraOk = (fechaVencimiento.length() == 5 && fechaVencimiento.contains("/"));
            boolean fechaNoVencida = false;
            if (fechaEstructuraOk) {
                try {
                    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("MM/yy");
                    YearMonth fechaTarjeta = YearMonth.parse(fechaVencimiento, formateador);
                    YearMonth fechaActual = YearMonth.now();
                    if (fechaTarjeta.isAfter(fechaActual) || fechaTarjeta.equals(fechaActual)) {
                        fechaNoVencida = true;
                    }
                } catch (DateTimeParseException e) {
                    fechaEstructuraOk = false;
                }
            }
            if (tarjetaOk && fechaEstructuraOk && fechaNoVencida) {
                System.out.println("Autorizando fondos... transaccion exitosa");
                pAprovado = true;
            } else {
                System.out.println("Operacion denegada por la pasarela bancaria");
                if (!tarjetaOk) System.out.println("El número de tarjeta debe contener exactamente 16 dígitos");
                if (!fechaEstructuraOk) System.out.println("Formato de fecha incorrecto");
                if (fechaEstructuraOk && !fechaNoVencida) System.out.println("Tarjeta caducada");
                if (!cvvOk) System.out.println("El CVV debe contener 3 dígitos");
            }
            System.out.println("Intente nuevamente el pago electrónico");
        } while (!pAprovado);
    }
}