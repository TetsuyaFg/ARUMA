import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class Practica03 {
    //scanner
    static Scanner aruma = new Scanner(System.in);
    //datos para los metodos
    static double totalCompra=0;
    static int cantidadProductos=0;
    static String ubicacionTienda="";
    // datos del cliente
    static String nombreCliente="";
    static String dniCliente="";
    //datos ultimos para mostrar en la boleta
    static double ultimoPrecio=0;
    static int ultimaCantidad=0;
    static String ultimoProducto="";
    //datos estatico de la cuenta ya creada
    static final String CORREO_ESTATICO="arumalosmassalados@gmail.com";
    static final String CONTRASENA_ESTATICA="aruma123";
    //datos cajera y caja
    static final String CAJERA="Cajera guapa de aruma";
    static final String NRO_CAJA="123";

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

                        boolean registroOk = registro_de_correo_contrasena(aruma);
                        if (registroOk) {
                            System.out.println("Ahora puede iniciar sesion con su cuenta.");

                        }
                    } else {
                        System.out.println("Acceso denegado");
                    }
                    break;
                case 2:
                    acceso = loginUsuario(aruma);
                    break;
                case 3:
                    System.out.println("Ingreso como invitado");
                    System.out.println("Ingrese su nombre completo:");
                    nombreCliente = aruma.nextLine();
                    System.out.println("Ingrese su DNI:");
                    dniCliente = aruma.nextLine();
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
                        case 1: productosOjos();    break;
                        case 2: SeccionLabios();    break;
                        case 3: productosRostro();  break;
                        case 4: productosUnas();    break;
                        default: System.out.println("Opcion no valida");
                    }

                    System.out.println("Desea comprar otro articulo? (SI/NO)");
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
                    mostrarBoleta(totalCompra, cantidadProductos);
                } else {
                    mostrarBoleta(totalCompra, cantidadProductos);
                    elegirTiendaFisica(aruma);
                    mostrarBoletaConTienda(totalCompra, cantidadProductos, ubicacionTienda);
                }

                System.out.println("Gracias por su compra en ARUMA!");
            }
        }
    }
public static void MENUARUMA(){
    System.out.println("1. REGISTRARSE");
    System.out.println("2. INICIAR SESION");
    System.out.println("3. INGRESAR COMO INVITADO");
    System.out.println("4. SALIR");
}
public static void menu_productos(){
    System.out.println("====SECCION MAQUILLAJE====");
    System.out.println("1. Ojos");
    System.out.println("2. Labios");
    System.out.println("3. Rostro");
    System.out.println("4. Unas");
}
public static boolean REGISTRO_NOMBRES (Scanner aruma){
    System.out.println("Ingrese sus nombres y apeliidos");
    nombreCliente=aruma.nextLine();
    System.out.println("Ingrese su DNI");
    dniCliente=aruma.nextLine();
    System.out.println("Ingrese su año de nacimiento");
    int fecha = aruma.nextInt();
    aruma.nextLine();
    int edad = 2026 - fecha ;
    if (edad >= 18 && edad < 97){
        System.out.println("Tienes "+edad+" años. Acceso concedido");
        return true;
    }
    else {
        System.out.println("Tienes menos de 18 años. Acceso denegado");
        return false;
    }

}
public static boolean registro_de_correo_contrasena(Scanner aruma){
    System.out.println("Ingrese su correo");
    String correo = aruma.nextLine();
    System.out.println("Ingrese su contrasena");
    String contrasena = aruma.nextLine();
    System.out.println("==INGRESE SUS DATOS NUEVAMENTE=== ");
    System.out.println("Ingrese su correo nuevamente ");
    String correo_in = aruma.nextLine();
    System.out.println("Ingrese su contrasena nuevamente ");
    String contrasena_in = aruma.nextLine();
    if (correo.equals(correo_in)&&contrasena.equals(contrasena_in)){
        System.out.println("Registro exitoso! Bienvenido a ARUMA");
        return true;
    }
    else {
        System.out.println("Los datos no coinciden. Intente de nuevo");
        return false;
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
                // Pedimos nombre y DNI para la boleta
                System.out.println("Ingrese su nombre completo:");
                nombreCliente = aruma.nextLine();
                System.out.println("Ingrese su DNI:");
                dniCliente = aruma.nextLine();
                return true;
            } else {
                System.out.println("Correo o contrasena incorrectos. Acceso denegado.");
                System.out.println("Por favor inicie sesion nuevamente.");
            }
        } while (true);
    }

//categorias
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
    ultimoProducto = nombres[opcion - 1];
    ultimaCantidad = cantidad;
    ultimoPrecio   = precios[opcion - 1];
}
    public static void SeccionLabios(){
    String [] nombres = {"ESSENCE What A Tint", "ESSENCE Gloss Choco Bomb", "ESSENCE Gloss Extreme Shine",
            "CATRICE Plumping Lip Liner", "MAYBELLINE Lifter Gloss", "MAYBELLINE Labial Liquido Fearless",
            "ESSENCE Gloss Hydra Kiss", "MAYBELLINE Labial Liquido Peppy", "MAYBELLINE Vinyl Ink Cheeky",
            "BEAUTY CREATIONS Labial Balm"};
    double [] precio = {19.90, 7.90, 14.90, 12.90, 57.72, 59.90, 15.90, 59.90, 59.90, 34.90};
    for(int i = 0 ; i < 10 ; i++){
        System.out.println((i+1)+". "+nombres+" S/"+precio);
    }
        System.out.println("Seleccione una opcion");
    int opcion = aruma.nextInt();
        System.out.println("Seleccione la cantidad");
        int cantidad = aruma.nextInt();
        totalCompra+=precio[opcion - 1]*cantidad;
        cantidadProductos++;
        ultimoProducto=nombres[opcion-1];
        ultimoPrecio=precio[opcion - 1];
        ultimaCantidad=cantidad;

    }


public static void productosRostro(){
    String[] nombres={"Base Fit Me Matte", "Spray Fijador Petrizzio", "Sellador L.A GIRL",
            "Base Pixi On-The-Glow", "Base Clinique", "Serum L'OREAL PARIS",
            "Base Polvo L'OREAL PARIS", "Base Pro-Matte L'OREAL PARIS",
            "Colorete CATRICE", "Base FREZYDERM"};
    double[] precios={56.86, 44.90, 55.90, 79.90, 210.00, 101.92, 80.66, 79.82, 21.90, 144.00};
    for(int i=0;i<10;i++){
        System.out.println((i+1)+". "+nombres[i]+" S/ "+precios[i]);
    }
    System.out.println("selecione la opcion");
    int opcion=aruma.nextInt();
    System.out.println("ingrese cantidad");
    int cantidad=aruma.nextInt();
    aruma.nextLine();
    totalCompra+=precios[opcion-1]*cantidad;
    cantidadProductos++;
    ultimoProducto=nombres[opcion-1];
    ultimaCantidad=cantidad;
    ultimoPrecio=precios[opcion-1];
}
public  static void productosUnas(){
    String[]nombres={"MASGLO (Base Ajo y Limon)", "VOGUE (Gel)", "MASGLO (Base clinical)",
            "MASGLO (Gel evolution brillo)", "MASGLO (Esmalte masglo Blanco)", "MASGLO (Esmalte linda)",
            "MASGLO (Esmalte bella)", "OPI (Brillo)", "Vogue (Ena-morada)", "CATRICE (Pearlfection)"};

    double[]precio={16.70, 20.90, 19.90, 24.60, 16.70, 16.70, 16.70, 51.90, 17.90, 12.90};
    for (int i=0;i<10;i++){
        System.out.println((i+1)+"."+nombres[i]+"S/"+precio[i]);
    }
    System.out.println("seleccione opcion");
    int opcion= aruma.nextInt();;
    System.out.println("ingrese cantidad");
    int cantidad=aruma.nextInt();
    aruma.nextLine();
    totalCompra=precio[opcion-1]*cantidad;
    cantidadProductos++;
    ultimoProducto=nombres[opcion-1];
    ultimaCantidad=cantidad;
    ultimoPrecio=precio[opcion-1];
}
    public static void elegirTiendaFisica(Scanner aruma) {
        System.out.println("========================================");
        System.out.println("   RECOJO EN TIENDA FISICA - ARUMA");
        System.out.println("========================================");
        System.out.println("Seleccione la tienda donde desea recoger su pedido:");
        System.out.println("1. Juliaca - Real Plaza  [TDA-JUL-138-RP]");
        System.out.println("2. Puno    - Real Plaza  [TDA-PUN-042-RP]");
        System.out.println("Ingrese el numero de la tienda:");

        boolean tiendaValida = false;
        while (!tiendaValida) {
            int opcionTienda = aruma.nextInt();
            aruma.nextLine();
            if (opcionTienda == 1) {
                ubicacionTienda = "Juliaca - Real Plaza  [TDA-JUL-138-RP]";
                tiendaValida = true;
            } else if (opcionTienda == 2) {
                ubicacionTienda = "Puno - Real Plaza  [TDA-PUN-042-RP]";
                tiendaValida = true;
            } else {
                System.out.println("Opcion invalida. Ingrese 1 o 2:");
            }
        }
        System.out.println("Ha seleccionado recoger en: " + ubicacionTienda);
    }

public static void validaPagoTarjeta(Scanner aruma,double total){
    String fechaVencimiento,nroTarjeta,cvv;
    boolean pAprovado=false;
    System.out.println("monto total a pagar con tarjeta es: "+total);
    do{
        System.out.println("ingrese los 16 dijitos de la tarjeta");
        nroTarjeta=aruma.nextLine();
        System.out.println("ingrese la fecha ade caducidad (MM/AA)");
        fechaVencimiento=aruma.nextLine();
        System.out.println("ingrese el codigo cvv");
        cvv=aruma.nextLine();

        boolean tarjetaOk=(nroTarjeta.length()==16);
        boolean cvvOk=(cvv.length()==3);
        boolean fechaestructuraOk=(fechaVencimiento.length()==5&&fechaVencimiento.contains("/"));
        boolean fechaNoVencida=false;
    if(fechaestructuraOk){
        try{
            DateTimeFormatter formateador = DateTimeFormatter.ofPattern("MM/yy");
            YearMonth fechaTarjeta = YearMonth.parse(fechaVencimiento, formateador);
            YearMonth fechaActual  = YearMonth.now();
            if (fechaTarjeta.isAfter(fechaActual) || fechaTarjeta.equals(fechaActual)) {
                fechaNoVencida = true;
            }
        }
        catch(DateTimeParseException e){
            fechaestructuraOk=false;
        }
    }
    if(tarjetaOk&&fechaestructuraOk&&fechaNoVencida&&cvvOk){
        System.out.println("Autorizando fondos... transaccion exitosa");
        pAprovado = true;
    }
    else {
        System.out.println("Operacion denegada por la pasarela bancaria");
        if (!tarjetaOk)   {
            System.out.println("  - El numero de tarjeta debe tener exactamente 16 digitos");
        }
        if (!fechaestructuraOk){
            System.out.println("  - Formato de fecha incorrecto (use MM/AA)");
        }
        if (fechaestructuraOk && !fechaNoVencida){
            System.out.println("  - Tarjeta caducada");
        }
        if (!cvvOk){
            System.out.println("  - El CVV debe tener 3 digitos");
        }
        System.out.println("Intente nuevamente el pago electronico");
    }
    }
    while(!pAprovado);
}
public static String totalEnLetras(double monto){
    int soles = (int) monto;
    int centavos = (int) Math.round((monto - soles) * 100);

    String[] u = {"", "UNO", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE",
            "DIEZ", "ONCE", "DOCE", "TRECE", "CATORCE", "QUINCE", "DIECISEIS",
            "DIECISIETE", "DIECIOCHO", "DIECINUEVE"};

    String[] d = {"", "", "VEINTE", "TREINTA", "CUARENTA", "CINCUENTA",
            "SESENTA", "SETENTA", "OCHENTA", "NOVENTA"};

    String[] c = {"", "CIENTO", "DOSCIENTOS", "TRESCIENTOS", "CUATROCIENTOS",
            "QUINIENTOS", "SEISCIENTOS", "SETECIENTOS", "OCHOCIENTOS", "NOVECIENTOS"};

    String texto = "";

    if (soles == 0) {
        texto = "CERO";
    } else if (soles < 20) {
        texto = u[soles];
    } else if (soles < 100) {
        int dec = soles / 10;
        int uni = soles % 10;
        texto = d[dec] + (uni > 0 ? " Y " + u[uni] : "");
    } else if (soles == 100) {
        texto = "CIEN";
    } else if (soles < 1000) {
        int cen = soles / 100;
        int resto = soles % 100;

        texto = c[cen];

        if (resto > 0) {
            if (resto < 20) {
                texto += " " + u[resto];
            } else {
                int dec = resto / 10;
                int uni = resto % 10;
                texto += " " + d[dec] + (uni > 0 ? " Y " + u[uni] : "");
            }
        }
    } else {
        texto = "MONTO MUY ALTO";
    }

    return texto + " Y " + String.format("%02d", centavos) + "/100 SOLES";
}
public static void mostrarBoleta(double total,int cantidadProductos){
    double descuento;
    double totalfinal;
    if (total>=100){
        descuento=total*0.10;
        totalfinal=total-descuento;

    } else if (total>=50) {
        descuento=total*0.05;
        totalfinal=total-descuento;

    }else{
        descuento=0;
        totalfinal=total;

    }
    //IGV
    double opGravadas=totalfinal/1.18;
    double igv=totalfinal-opGravadas;
    // fecha y hora actual
    LocalDateTime aruma=LocalDateTime.now();
    String fecha=aruma.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    String hora= aruma.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

    System.out.println("================================================");
    System.out.println("                    ARUMA                       ");
    System.out.println("             TIENDAS ARUMA S.A.C.               ");
    System.out.println("              RUC: 20600657888                  ");
    System.out.println("  AV. JAVIER PRADO ESTE NRO. 6210 INT. 1201     ");
    System.out.println("  URB. RIVERA DE MONTERRICO | LA MOLINA | LIMA  ");
    System.out.println("  JIRON TUMBES 571 LOCAL 138 DIST. DE JULIACA   ");
    System.out.println("       PROVINCIA SAN ROMAN, PUNO                ");
    System.out.println("------------------------------------------------");
    System.out.println("       BOLETA DE VENTA ELECTRONICA              ");
    System.out.println("             B123-00074907                      ");
    System.out.println("------------------------------------------------");
    System.out.println("Tda No.   : TDA-JUL-138-RP   Fecha: " + fecha);
    System.out.println("NoCaja    : " + NRO_CAJA + "              Hora : " + hora);
    System.out.println("Cajer@/o  : " + CAJERA);
    System.out.println("Cliente   : " + nombreCliente);
    System.out.println("DNI       : " + dniCliente);
    System.out.println("------------------------------------------------");
    System.out.println("SKU       CANT  PRECIO UNIT.  DSCTO     TOTAL  ");
    System.out.println("DESCRIPCION                                     ");
    System.out.println("------------------------------------------------");
    System.out.printf("%-10s  %3d    S/%-8.2f  0.00   S/%.2f%n",
            "1029178", ultimaCantidad, ultimoPrecio, ultimoPrecio * ultimaCantidad);
    System.out.println(ultimoProducto);
    System.out.println("------------------------------------------------");
    System.out.printf("  OP GRAVADAS                      S/%.2f%n", opGravadas);
    System.out.printf("  OP INAFECTAS                     S/0.00%n");
    System.out.printf("  TOTAL DCTO                       S/%.2f%n", descuento);
    System.out.printf("  IGV  18%%                         S/%.2f%n", igv);
    System.out.printf("  PERCEPCION: 0%%                   S/0.00%n");
    System.out.println("------------------------------------------------");
    System.out.printf("  TOTAL A PAGAR:                   S/%.2f%n", totalfinal);
    System.out.println("------------------------------------------------");
    System.out.printf("  PAGO    TARJETA                  S/%.2f%n", totalfinal);
    System.out.println("------------------------------------------------");
    System.out.println("Son: " + totalEnLetras(totalfinal));
    System.out.println("================================================");
}
public  static void mostrarBoletaConTienda(double total,int cantidadProductos,String tienda){
    double descuento;
    double totalfinal;
    if (total>=100) {
        descuento=total*0.10;
        totalfinal=total-descuento;

    } else if (total>=50) {
        descuento=total*0.05;
        totalfinal=total-descuento;

    }else {
        descuento=0;
        totalfinal=total;

    }
    //IGV
    double opGravadas=totalfinal/1.18;
    double igv=totalfinal-opGravadas;
    //tienda
    String codigoTienda;
    if (tienda.contains("juliaca")){
        codigoTienda="TDA-JUL-138-RP";


    }else {
        codigoTienda="TDA-PUN-042-RP";

    }
    //FECHA Y HORA ACTAL
    LocalDateTime aruma=LocalDateTime.now();
    String fecha=aruma.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    String hora=aruma.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

    System.out.println("================================================");
    System.out.println("                    ARUMA                       ");
    System.out.println("             TIENDAS ARUMA S.A.C.               ");
    System.out.println("              RUC: 20600657888                  ");
    System.out.println("  AV. JAVIER PRADO ESTE NRO. 6210 INT. 1201     ");
    System.out.println("  URB. RIVERA DE MONTERRICO | LA MOLINA | LIMA  ");
    System.out.println("  JIRON TUMBES 571 LOCAL 138 DIST. DE JULIACA   ");
    System.out.println("       PROVINCIA SAN ROMAN, PUNO                ");
    System.out.println("------------------------------------------------");
    System.out.println("       BOLETA DE VENTA ELECTRONICA              ");
    System.out.println("             B123-00074907                      ");
    System.out.println("------------------------------------------------");
    System.out.println("Tda No.   : " + codigoTienda + "   Fecha: " + fecha);
    System.out.println("NoCaja    : " + NRO_CAJA + "              Hora : " + hora);
    System.out.println("Cajer@/o  : " + CAJERA);
    System.out.println("Cliente   : " + nombreCliente);
    System.out.println("DNI       : " + dniCliente);
    System.out.println("------------------------------------------------");
    System.out.println("SKU       CANT  PRECIO UNIT.  DSCTO     TOTAL  ");
    System.out.println("DESCRIPCION                                     ");
    System.out.println("------------------------------------------------");
    System.out.printf("%-10s  %3d    S/%-8.2f  0.00   S/%.2f%n",
            "1029178", ultimaCantidad, ultimoPrecio, ultimoPrecio * ultimaCantidad);
    System.out.println(ultimoProducto);
    System.out.println("------------------------------------------------");
    System.out.printf("  OP GRAVADAS                      S/%.2f%n", opGravadas);
    System.out.printf("  OP INAFECTAS                     S/0.00%n");
    System.out.printf("  TOTAL DCTO                       S/%.2f%n", descuento);
    System.out.printf("  IGV  18%%                         S/%.2f%n", igv);
    System.out.printf("  PERCEPCION: 0%%                   S/0.00%n");
    System.out.println("------------------------------------------------");
    System.out.printf("  TOTAL A PAGAR:                   S/%.2f%n", totalfinal);
    System.out.println("------------------------------------------------");
    System.out.printf("  PAGO    CASH                     S/%.2f%n", totalfinal);
    System.out.println("------------------------------------------------");
    System.out.println("Son: " + totalEnLetras(totalfinal));
    System.out.println("------------------------------------------------");
    System.out.println("  LUGAR DE RECOJO : " + tienda);
    System.out.println("  Presente esta boleta al recoger su pedido.");
    System.out.println("================================================");

}
}


