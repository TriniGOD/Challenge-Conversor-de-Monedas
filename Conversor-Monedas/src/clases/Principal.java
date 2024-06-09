package clases;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        String usuario;
        int opc;
        double montoConversion;
        Conversion conversion;
        Consulta consulta = new Consulta();
        Scanner entrada = new Scanner(System.in);
        ArchivoConversiones archivo = new ArchivoConversiones();
        do{
            System.out.println("Escribe tu nombre: ");
            usuario = String.valueOf(entrada.nextLine());
        }while ("".equals(usuario));
        archivo.crearArchivo(usuario);
        System.out.println(usuario+", se genero un archivo .txt en el que podras consultar tu historial de consultas sobre conversiones");
            do{
                opc = 0;
                System.out.println("Daniel Alejandro Trinidad Casillas presenta... \n");
                System.out.println("-------------CONVERSOR DE MONEDAS-------------D \n");
                System.out.println("-----Menu principal----- \n");
                System.out.println("1. Consultar el formato para las comparaciones. ");
                System.out.println("2. Convertir monedas. (opcion libre). \n");
                System.out.println("Conversiones fijas... \n");
                System.out.println("3. Dolar a peso mexicano. ");
                System.out.println("4. Euro a peso mexicano. ");
                System.out.println("5. Real brasileno a yen. ");
                System.out.println("6. Libra esterlina a rupia india. ");
                System.out.println("7. Salir. ");
                System.out.println("----------------------------------------------");
                System.out.println("Selecciona la opcion que desees: ");
                    try{
                        opc = Integer.parseInt(entrada.nextLine());
                    } catch (NumberFormatException e){
                        System.out.println("Error en la seleccion de la opcion.");
                    }
                    switch (opc){
                        case 1:
                            System.out.println("Este es el formato para las consultas de conversion de monedas: ");
                            System.out.println("Codigo de moneda ISO 4217. ");
                            System.out.println("Ejemplos: ");
                            System.out.println("MXN -> peso mexicano ");
                            System.out.println("USD -> dolar ");
                            System.out.println("Puedes usar mayusculas y minusculas de manera indistinta. \n ");
                            break;
                        case 2:
                            String moneda1, moneda2;
                            System.out.println("Escribe el codigo de la moneda que desees convertir: ");
                           try {
                                moneda1 = String.valueOf(entrada.nextLine());
                                System.out.println("Escribe el codigo de la moneda a la que deseas convertir: ");
                                moneda2 = String.valueOf(entrada.nextLine());
                                conversion = consulta.buscarConversion(moneda1, moneda2);
                                if(conversion.base_code() == null || conversion.target_code() == null){
                                    System.out.println("No se encontro alguno de los codigos. \n");
                                } else{
                                    System.out.println("Escribe el monto que deseas convertir: ");
                                    montoConversion = Double.parseDouble(entrada.nextLine());
                                    conversion.setMonto(montoConversion);
                                    System.out.println(conversion);
                                    archivo.agregarConversion(conversion);
                                    System.out.println("Conversion completada \n");
                                }
                           } catch (NumberFormatException e){
                               System.out.println("No se escribio correctamente el monto de conversion");
                           } catch (IllegalArgumentException e) {
                               System.out.println("Los codigos de monedas no tienen el formato correcto\n");
                           }
                            break;
                        case 3:
                            System.out.println("Escribe el monto que deseas convertir: ");
                            try{
                                montoConversion = Double.parseDouble(entrada.nextLine());
                                conversion = consulta.buscarConversion("USD", "MXN");
                                conversion.setMonto(montoConversion);
                                System.out.println(conversion);
                                archivo.agregarConversion(conversion);
                                System.out.println("conversion completada \n");
                            } catch (NumberFormatException e){
                                System.out.println("No se escribio correctamente el monto de conversion");
                            }
                            break;
                        case 4:
                            System.out.println("Escribe el monto que deseas convertir: ");
                            try{
                                montoConversion = Double.parseDouble(entrada.nextLine());
                                conversion = consulta.buscarConversion("EUR", "MXN");
                                conversion.setMonto(montoConversion);
                                System.out.println(conversion);
                                archivo.agregarConversion(conversion);
                                System.out.println("conversion completada \n");
                            } catch (NumberFormatException e){
                                System.out.println("No se escribio correctamente el monto de conversion");
                            }
                            break;
                        case 5:
                            System.out.println("Escribe el monto que deseas convertir: ");
                            try{
                                montoConversion = Double.parseDouble(entrada.nextLine());
                                conversion = consulta.buscarConversion("BRL", "JPY");
                                conversion.setMonto(montoConversion);
                                System.out.println(conversion);
                                archivo.agregarConversion(conversion);
                                System.out.println("Conversion completada \n");
                            } catch (NumberFormatException e){
                                System.out.println("No se escribio correctamente el monto de conversion");
                            }
                            break;
                        case 6:
                            System.out.println("Escribe el monto que deseas convertir: ");
                            try{
                                montoConversion = Double.parseDouble(entrada.nextLine());
                                conversion = consulta.buscarConversion("GBP", "INR");
                                conversion.setMonto(montoConversion);
                                System.out.println(conversion);
                                archivo.agregarConversion(conversion);
                                System.out.println("Conversion completada, \n");
                            } catch (NumberFormatException e){
                                System.out.println("No se escribio correctamente el monto de conversion");
                            }
                            break;
                        case 7:
                            System.out.println("Gracias por usar la aplicacion.");
                            archivo.cerrarArchivo();
                            System.exit(1);
                            break;
                        default:
                            System.out.println("Opcion no valida.");
                            break;
                    }
            }while(true);
        }
    }

