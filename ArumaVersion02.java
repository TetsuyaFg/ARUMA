import javax.sql.XADataSource;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class ArumaVersion02 {
    static Scanner aruma = new Scanner(System.in);
    static double totalCompra = 0;
    static int cantidadProductos = 0;
    static String ubicacionTienda = "";

    //CORREO Y CONTRASEÑA ESTATICOS
    static final String CORREO_ESTATICO = "arumalosmassalados@gmail.com";
    static final String CONTRASENA_ESTATICA = "aruma123";

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
                    acceso = loginUsuario(aruma);
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
                // Reiniciar totales por cada sesion
                totalCompra = 0;
                cantidadProductos = 0;
                ubicacionTienda = "";

                boolean seguirComprando = true;
                while (seguirComprando) {
                    menu_productos();
                    System.out.println("Elija la categoria que desea (en numeros)");
                    int opcion = aruma.nextInt();
                    aruma.nextLine();

                    switch (opcion) {
                        case 1:
                            productosOjos();
                            break;
                        case 2:
                            SeccionLabios();
                            break;
                        case 3:
                            productosRostro();
                            break;
                        case 4:
                            productosUnas();
                            break;
                        default:
                            System.out.println("Opcion no valida");
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
                    // --- Pago con tarjeta ---
                    validaPagoTarjeta(aruma, totalCompra);
                    mostrarBoleta(totalCompra, cantidadProductos);
                } else {
                    // --- Pago sin tarjeta: recojo en tienda ---
                    mostrarBoleta(totalCompra, cantidadProductos);
                    elegirTiendaFisica(aruma);
                    mostrarBoletaConTienda(totalCompra, cantidadProductos, ubicacionTienda);
                }

                System.out.println("Gracias por su compra en ARUMA!");
            }
        }
    }

    //MENUS
    public static void MENUARUMA() {
        System.out.println("1. REGISTRARSE");
        System.out.println("2. INICIAR SESION");
        System.out.println("3. INGRESAR COMO INVITADO");
        System.out.println("4. SALIR");
    }

    public static void menu_productos() {
        System.out.println("---CATEGORIAS DE MAQUILLAJE---");
        System.out.println("1. Ojos");
        System.out.println("2. Labios");
        System.out.println("3. Rostro");
        System.out.println("4. Unas");
    }


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
        System.out.println("Ingrese su contrasena:");
        String contrasena = aruma.nextLine();
        System.out.println("----CONFIRMACION DE DATOS--------");
        System.out.println("Ingrese su correo nuevamente:");
        String correo_in = aruma.nextLine();
        System.out.println("Ingrese su contrasena nuevamente:");
        String contrasena_in = aruma.nextLine();
        if (correo.equals(correo_in) && contrasena.equals(contrasena_in)) {
            System.out.println("Registro exitoso! Bienvenido a ARUMA!");
        } else {
            System.out.println("Los datos no coinciden. Vuelva a intentar.");
        }
    }

    public static boolean loginUsuario(Scanner aruma) {
        System.out.println("-----INICIAR SESION------");
        String correo, pass;
        do {
            System.out.println("Ingrese su correo:");
            correo = aruma.nextLine();
            System.out.println("Ingrese su contrasena:");
            pass = aruma.nextLine();

            if (correo.equals(CORREO_ESTATICO) && pass.equals(CONTRASENA_ESTATICA)) {
                System.out.println("Bienvenido a ARUMA!");
                return true;
            } else {
                System.out.println("Correo o contrasena incorrectos. Acceso denegado.");
                System.out.println("Por favor inicie sesion nuevamente.");
            }
        } while (true);
    }

    // SECCIONES CON PRODUCTOS
    public static void productosOjos() {
        String[] nombres = {"Sheglam", "Petrizzio", "Catrice", "Clinique", "Essence",
                "Maybelline", "L.A Girl", "L.A Girl Pro", "L.A Girl Liquida", "L'oreal Paris"};
        double[] precios = {82.90, 29.90, 26.90, 145.00, 15.90, 48.90, 47.90, 150.50, 85.90, 68.90};

        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + ". " + nombres[i] + "  S/" + precios[i]);
        }
        System.out.println("Seleccione opcion:");
        int opcion = aruma.nextInt();
        aruma.nextLine();
        System.out.println("Ingrese cantidad:");
        int cantidad = aruma.nextInt();
        aruma.nextLine();
        totalCompra += precios[opcion - 1] * cantidad;
        cantidadProductos++;
    }

    public static void SeccionLabios() {
        String[] nombres = {"ESSENCE What A Tint", "ESSENCE Gloss Choco Bomb", "ESSENCE Gloss Extreme Shine",
                "CATRICE Plumping Lip Liner", "MAYBELLINE Lifter Gloss", "MAYBELLINE Labial Liquido Fearless",
                "ESSENCE Gloss Hydra Kiss", "MAYBELLINE Labial Liquido Peppy", "MAYBELLINE Vinyl Ink Cheeky",
                "BEAUTY CREATIONS Labial Balm"};
        double[] precios = {19.90, 7.90, 14.90, 12.90, 57.72, 59.90, 15.90, 59.90, 59.90, 34.90};

        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + ". " + nombres[i] + "  S/" + precios[i]);
        }
        System.out.println("Seleccione opcion:");
        int opcion = aruma.nextInt();
        aruma.nextLine();
        System.out.println("Ingrese cantidad:");
        int cantidad = aruma.nextInt();
        aruma.nextLine();
        totalCompra += precios[opcion - 1] * cantidad;
        cantidadProductos++;
    }

    public static void productosRostro() {
        String[] nombres = {"Base Fit Me Matte", "Spray Fijador Petrizzio", "Sellador L.A GIRL",
                "Base Pixi On-The-Glow", "Base Clinique", "Serum L'OREAL PARIS",
                "Base Polvo L'OREAL PARIS", "Base Pro-Matte L'OREAL PARIS",
                "Colorete CATRICE", "Base FREZYDERM"};
        double[] precios = {56.86, 44.90, 55.90, 79.90, 210.00, 101.92, 80.66, 79.82, 21.90, 144.00};

        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + ". " + nombres[i] + "  S/" + precios[i]);
        }
        System.out.println("Seleccione opcion:");
        int opcion = aruma.nextInt();
        aruma.nextLine();
        System.out.println("Ingrese cantidad:");
        int cantidad = aruma.nextInt();
        aruma.nextLine();
        totalCompra += precios[opcion - 1] * cantidad;
        cantidadProductos++;
    }

    public static void productosUnas() {
        String[] nombres = {"MASGLO (Base Ajo y Limon)", "VOGUE (Gel)", "MASGLO (Base clinical)",
                "MASGLO (Gel evolution brillo)", "MASGLO (Esmalte masglo Blanco)", "MASGLO (Esmalte linda)",
                "MASGLO (Esmalte bella)", "OPI (Brillo)", "Vogue (Ena-morada)", "CATRICE (Pearlfection)"};
        double[] precios = {16.70, 20.90, 19.90, 24.60, 16.70, 16.70, 16.70, 51.90, 17.90, 12.90};

        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + ". " + nombres[i] + "  S/" + precios[i]);
        }
        System.out.println("Seleccione opcion:");
        int opcion = aruma.nextInt();
        aruma.nextLine();
        System.out.println("Ingrese cantidad:");
        int cantidad = aruma.nextInt();
        aruma.nextLine();
        totalCompra += precios[opcion - 1] * cantidad;
        cantidadProductos++;
    }

    //TIENDA FISICA

    public static void elegirTiendaFisica(Scanner aruma) {
        System.out.println("========================================");
        System.out.println("   RECOJO EN TIENDA FISICA - ARUMA");
        System.out.println("========================================");
        System.out.println("Seleccione la tienda donde desea recoger su pedido:");
        System.out.println("1. Juliaca - Real Plaza");
        System.out.println("2. Puno    - Real Plaza");
        System.out.println("Ingrese el numero de la tienda:");

        int opcionTienda = 0;
        boolean tiendaValida = false;

        while (!tiendaValida) {
            opcionTienda = aruma.nextInt();
            aruma.nextLine();
            if (opcionTienda == 1) {
                ubicacionTienda = "Juliaca - Real Plaza";
                tiendaValida = true;
            } else if (opcionTienda == 2) {
                ubicacionTienda = "Puno - Real Plaza";
                tiendaValida = true;
            } else {
                System.out.println("Opcion invalida. Ingrese 1 o 2:");
            }
        }

        System.out.println("Ha seleccionado recoger en: " + ubicacionTienda);
    }

    //BOLETA ESTANDAR
    public static void mostrarBoleta(double total, int cantidadProductos) {
        double descuento;
        double totalfinal;
        System.out.println("======BOLETA DE COMPRA======");
        System.out.println("Cantidad de tipos de productos comprados: " + cantidadProductos);
        System.out.println("Total acumulado: S/" + total);

        if (total >= 100) {
            descuento = total * 0.10;
            totalfinal = total - descuento;
            System.out.println("Descuento Aplicado: 10%");
        } else if (total >= 50) {
            descuento = total * 0.05;
            totalfinal = total - descuento;
            System.out.println("Descuento aplicado: 5%");
        } else {
            descuento = 0;
            totalfinal = total;
            System.out.println("No se aplico descuento");
        }

        System.out.println("Monto de descuento: S/" + descuento);
        System.out.println("Total final a pagar: S/" + totalfinal);
        System.out.println("Metodo de pago: Tarjeta");
        System.out.println("===============================================");
    }

    //BOLETA CON TIENDA FISICA

    public static void mostrarBoletaConTienda(double total, int cantidadProductos, String tienda) {
        double descuento;
        double totalfinal;

        System.out.println("==========================================");
        System.out.println("        BOLETA DE COMPRA - ARUMA         ");
        System.out.println("==========================================");
        System.out.println("Cantidad de tipos de productos: " + cantidadProductos);
        System.out.println("Total acumulado: S/" + total);

        if (total >= 100) {
            descuento = total * 0.10;
            totalfinal = total - descuento;
            System.out.println("Descuento Aplicado: 10%");
        } else if (total >= 50) {
            descuento = total * 0.05;
            totalfinal = total - descuento;
            System.out.println("Descuento aplicado: 5%");
        } else {
            descuento = 0;
            totalfinal = total;
            System.out.println("No se aplico descuento");
        }

        System.out.println("Monto de descuento: S/" + descuento);
        System.out.println("Total final a pagar: S/" + totalfinal);
        System.out.println("------------------------------------------");
        System.out.println("Metodo de pago: Pago en tienda");
        System.out.println("------------------------------------------");
        System.out.println("  LUGAR DE RECOJO:");
        System.out.println("  Tienda ARUMA - " + tienda);
        System.out.println("------------------------------------------");
        System.out.println("  Presente esta boleta al momento de");
        System.out.println("  recoger su pedido en tienda.");
        System.out.println("==========================================");
    }

    //VALIDAR PAGO CON TARJETA
    public static void validaPagoTarjeta(Scanner escaner, double total) {
        String nroTarjeta, fechaVencimiento, cvv;
        boolean pAprovado = false;
        System.out.println("Monto total a pagar con tarjeta es: S/" + total);

        do {
            System.out.println("Ingrese los 16 digitos de la tarjeta:");
            nroTarjeta = escaner.nextLine();
            System.out.println("Ingrese la fecha de caducidad (MM/AA):");
            fechaVencimiento = escaner.nextLine();
            System.out.println("Ingrese el codigo de seguridad CVV:");
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

            if (tarjetaOk && fechaEstructuraOk && fechaNoVencida && cvvOk) {
                System.out.println("Autorizando fondos... transaccion exitosa");
                pAprovado = true;
            } else {
                System.out.println("Operacion denegada por la pasarela bancaria");
                if (!tarjetaOk) System.out.println("  - El numero de tarjeta debe tener exactamente 16 digitos");
                if (!fechaEstructuraOk) System.out.println("  - Formato de fecha incorrecto (use MM/AA)");
                if (fechaEstructuraOk && !fechaNoVencida) System.out.println("  - Tarjeta caducada");
                if (!cvvOk) System.out.println("  - El CVV debe tener 3 digitos");
                System.out.println("Intente nuevamente el pago electronico");
            }
        } while (!pAprovado);
    }
}
