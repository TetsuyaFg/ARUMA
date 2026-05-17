import java.util.Scanner;
public class ARUMA {
    public static void main(String[] args) {
        Scanner aruma = new Scanner(System.in);
        int respuesta = 0;
        while (respuesta != 4) {
            System.out.println("-----BIENVFNIDO A ARUMA-----");
            System.out.println("--MENU--");
            MENUARUMA();
            System.out.println("elija como desea ingresar (en numeros)");
            respuesta = aruma.nextInt();
            aruma.nextLine();
            boolean acceso = false;
            switch (respuesta) {
                case 1:
                    System.out.println("ingrese los siguientes datos");
                    boolean nombre = REGISTRO_NOMBRES(aruma);
                    if (nombre) {
                        registro_de_correo_contrasena(aruma);
                        acceso = true;
                    } else {
                        System.out.println("acceso denegado");
                        respuesta = 0;
                    }
                    break;
                case 2:
                    iniciar_sesion(aruma);
                    acceso = true;
                    break;
                case 3:
                    System.out.println("bienvenido a ARUMA");
                    acceso = true;
                    break;
                case 4:
                    aruma.close();
                    break;
                default:
                    System.out.println("opcion no valida");
            }
            if (acceso) {
                System.out.println("bienvenido a ARUMA");
                menu_productos();
                System.out.println("elija la opcion que desee(en numeros)");
                int opcion = aruma.nextInt();
                aruma.nextLine();
                switch (opcion) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                            productos_rostro();
                            if(desea_comprar(aruma)) {
                                int opcion_selec = aruma.nextInt();
                                aruma.nextLine();
                                System.out.println("ingrese la cantidad a comprar");
                                int cantidad = aruma.nextInt();
                                double total_pagar = precios_productos(opcion_selec, cantidad);
                                System.out.println("el total a pagar es: " + total_pagar);
                            }
                            else{
                                acceso= false;
                            }
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("opcion no valida");
                }
            }
        }
    }

    public static void MENUARUMA() {
        System.out.println("-------------------------------------");
        System.out.println("1.REGISTRARSE");
        System.out.println("2.INICIAR SESION");
        System.out.println("3.INGRESAR COMO INVITADO");
        System.out.println("4.SALIR");
        System.out.println("-------------------------------------");
    }

    public static boolean REGISTRO_NOMBRES(Scanner aruma) {
        System.out.println("ingrese sus nombres y apellidos");
        String nombre_apellidos = aruma.nextLine();
        System.out.println("ingrese su dni");
        String dni = aruma.nextLine();
        System.out.println("ingrese su año de nacimiento");
        int fecha = aruma.nextInt();
        aruma.nextLine();
        int edad = 2026 - fecha;
        if (edad >= 18 && edad < 97) {
            System.out.println("tiene " + edad + " puede continuar");
            return true;
        } else {
            System.out.println("usted es menor de 18 años no puede ingresar");
            System.out.println("lo sentimos "+nombre_apellidos);
            return false;
        }
    }

    public static void registro_de_correo_contrasena(Scanner aruma) {
        System.out.println("ingrese su correo");
        String correo = aruma.nextLine();
        System.out.println("ingrese su contraseña");
        String contrasena = aruma.nextLine();
        System.out.println("----INICIO DE SESION--------");
        System.out.println("ingrese su correo");
        String correo_in = aruma.nextLine();
        System.out.println("ingrese su contraseña");
        String contrasena_in = aruma.nextLine();
        if (correo.equals(correo_in) && contrasena.equals(contrasena_in)) {
            System.out.println("bienvenido a ARUMA");
            System.out.println("escoja los productos que desee comprar");
        } else {
            System.out.println("contraseña o correo incorrecto");
            System.out.println("vulva a intentar");
        }
    }

    public static void iniciar_sesion(Scanner aruma) {
        System.out.println("----INICIO DE SESION--------");
        System.out.println("ingrese su correo");
        String correo_in = aruma.nextLine();
        System.out.println("ingrese su contraseña");
        String contrasena_in = aruma.nextLine();
    }

    public static void menu_productos() {
        System.out.println("tenemos maquillaje para:");
        System.out.println("1. ojos");
        System.out.println("2. labios");
        System.out.println("3. rostro");
        System.out.println("4. uñas");
    }

    public static void productos_rostro() {
        System.out.println("tenemos los siguentes productos:");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("1. MAYBELLINE");
        System.out.println("Base Fit Me Matte + Poreless 1.00 Fl Oz Tono 220 Natural Beige Maybelline");
        System.out.println("S/ 56.86");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("2. PETRIZZIO");
        System.out.println("Spray Fijador de Maquillaje 60 Ml Petrizzio");
        System.out.println("S/ 44.90");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("3. L.A GIRL");
        System.out.println("Sellador en Spray Pro Setting HD Matte Finish Larga Duración 30ml L.A");
        System.out.println("S/ 55.90");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("4. PIXI");
        System.out.println("Base En Barra Hidratante Con Color Pixi On-The-Glow Base Caramel 19Gr");
        System.out.println("S/ 79.90");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("5. CLINIQUE");
        System.out.println("Base Serum Even Better Clinical SPF 20 WN76 Toaste Clinique");
        System.out.println("S/ 210.00");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("6. L'OREAL PARIS");
        System.out.println("Serum con color Base True Match Tono Medium-Tan 5-6 30ml L'Oréal Paris");
        System.out.println("S/ 101.92");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("7. L'OREAL PARIS");
        System.out.println("Base En Polvo L'Oreal París Infallible 24H Fresh Wear 190 Beige Sand");
        System.out.println("S/ 80.66");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("8.L'OREAL PARIS");
        System.out.println("Base de Maquillaje Infallible Pro-Matte Tono Classic Tan 30 Ml L'Oréal Paris");
        System.out.println("S/ 79.82");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("9. CATRICE");
        System.out.println("Colorete Iluminador Líquido Up De Disney Pixar");
        System.out.println("S/ 21.90");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("10. FREZYDERM");
        System.out.println("Base Velvet Colors Light 30 ml Frezyderm Maquillaje");
        System.out.println("S/ 144.00");
        System.out.println("-----------------------------------------------------------------------------------");
    }
    public static double precios_productos(int opcion,int cantidad){
        double precio_rotro=0;
        switch (opcion){
            case 1:
                precio_rotro=56.86*cantidad;
                break;
            case 2:
                precio_rotro=44.90*cantidad;
                break;
            case 3:
                precio_rotro=55.90*cantidad;
                break;
            case 4:
                precio_rotro=79.90*cantidad;
                break;
            case 5:
                precio_rotro=210.00*cantidad;
                break;
            case 6:
                precio_rotro=101.92*cantidad;
                break;
            case 7:
                precio_rotro=80.66*cantidad;
                break;
            case 8:
                precio_rotro=79.82*cantidad;
                break;
            case 9:
                precio_rotro=21.90*cantidad;
                break;
            case 10:
                precio_rotro=144.00*cantidad;
                break;
            default:
                System.out.println("opcion no valida");
        }
        return precio_rotro;
    }
    public static boolean desea_comprar(Scanner aruma){
        System.out.println("desea comprar algun producto si/no");
        String comprar=aruma.nextLine();
        if(comprar.equalsIgnoreCase("si")){
            System.out.println("que producto desea comprar");
            return true;
        }
        else{
            System.out.println("gracias por visitarnos");
            return false;
        }
    }
}