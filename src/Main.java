import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException { //El "throws InterruptedException" nos sirve para hacer servir el sleep
        Scanner input = new Scanner(System.in);

        int option = 0; //Variable que sirve para escojer en el menú
        int suboption = 0; //Variable que sirve para el submenú
        Object[][] matriz = new Object[8][3];
        String nombre = "";
        boolean creado = false;
        boolean opcionValida = false;
        boolean persInsert = false;

        do {
            System.out.println("1. Insertar y modificar personajes");
            System.out.println("2. Batalla por equipos");
            System.out.println("4. Salir");
            if (input.hasNextInt()) { //Validamos si el usuario ha escrito un número entero
                option = input.nextInt();
                opcionValida = true;
            } else {
                System.out.println(" ");
                System.out.println("Error: Debes ingresar un número entero.");
                System.out.println(" ");
                input.next();
                opcionValida = false;
            }
// ------------------------------------------------ INSERTAR Y MODIFICAR PERSONAJES ------------------------------------
            if (option == 1){ //Opcion 1 = Insertar personaje

                do {
                    System.out.println("-------------PERSONAJES------------"); //Creación del Menú
                    System.out.println(" ");
                    System.out.println("1.1 Insertar personaje");
                    System.out.println("1.2 Modificar personaje");
                    System.out.println("1.3 Volver atrás");

                    if (input.hasNextInt()) { //Validamos si el usuario ha escrito un número entero
                        suboption = input.nextInt();
                        opcionValida = true;
                    } else {
                        System.out.println(" ");
                        System.out.println("Error: Debes ingresar un número entero.");
                        System.out.println(" ");
                        input.next();
                        opcionValida = false;
                    }

                    if (suboption == 1){ //Insertar Personaje
                        persInsert = true;

                        if (creado){
                            System.out.println("Ya has insertado los personajes");
                            System.out.println("Volviendo al menú...");
                            Thread.sleep(2000);
                        }else {
                            System.out.println(" ");
                            for (int i = 0; i < matriz.length; i++) {
                                input.nextLine();
                                for (int j = 0; j < 2; j++) {
                                    if (j == 0) {
                                        System.out.println("Inserta el nombre del personaje Nº." + i);
                                        nombre = input.nextLine();
                                        matriz[i][j] = nombre;
                                    }
                                    if (j == 1) {
                                        do {
                                            System.out.println("Introduce el poder de " + nombre);
                                            if (input.hasNextInt()) { //Validamos si el usuario ha escrito un número entero
                                                matriz[i][j] = input.nextInt();
                                                opcionValida = true;
                                                System.out.println("Creando a " + nombre + "...");
                                                Thread.sleep(500);
                                            } else {
                                                System.out.println(" ");
                                                System.out.println("Error: Debes ingresar un número entero.");
                                                System.out.println(" ");
                                                input.next();
                                                opcionValida = false;
                                            }
                                        }while (!opcionValida);
                                    }

                                }
                            }
                            creado = true;
                        }


                    } else if (suboption == 2) {
                        int espacio = 0;
                        do {


                            System.out.println(" ");
                            System.out.println("Escoje que personaje quieres modificar");
                            System.out.println(" ");

                            for (int i = 0; i < matriz.length; i++){ //Printamos los personajes y huecos disponibles

                                if (matriz[i][0] == null){
                                    System.out.print(i+".vacío ");
                                }else {
                                    System.out.print(i + "." + matriz[i][0] + " ");
                                }
                            }
                            System.out.println(" ");

                            if (input.hasNextInt()) { //Validamos si el usuario ha escrito un número entero
                                espacio = input.nextInt();
                                opcionValida = true;
                            }else {
                                System.out.println(" ");
                                System.out.println("Error: Debes ingresar un número entero.");
                                System.out.println(" ");
                                input.next();
                                opcionValida = false;
                            }



                        }while (!opcionValida);

                        if (matriz[espacio][0] == null){ //Si el hueco està vacio no nos dejará insertar el nombre
                            System.out.println("Error no hay personaje para modificar");
                            Thread.sleep(2000);
                        }else {
                            int selecion = 0;
                            do {

                                System.out.println("¿Estás seguro que quieres modificar a " + matriz[espacio][0] + "?"); //Confirmación de modificar el personaje
                                System.out.println("1. Si / 2. No");
                                if (input.hasNextInt()) { //Validamos si el usuario ha escrito un número entero
                                    selecion = input.nextInt();
                                    opcionValida = true;
                                }else {
                                    System.out.println(" ");
                                    System.out.println("Error: Debes ingresar un número entero.");
                                    System.out.println(" ");
                                    input.next();
                                    opcionValida = false;
                                }
                            }while (!opcionValida);

                            input.nextLine();
                            if (selecion == 1) { //Condicional para saber si quiere modificar el personaje
                                System.out.println("¿Que nombre le quieres poner a " + matriz[espacio][0] + "?");
                                nombre = input.nextLine();
                                matriz[espacio][0] = nombre;

                                do {

                                    System.out.println("Introduce el poder de " + nombre);
                                    if (input.hasNextInt()) { //Validamos si el usuario ha escrito un número entero
                                        matriz[espacio][1] = input.nextInt();
                                        opcionValida = true;
                                    } else {
                                        System.out.println(" ");
                                        System.out.println("Error: Debes ingresar un número entero.");
                                        System.out.println(" ");
                                        input.next();
                                        opcionValida = false;
                                    }
                                }while (!opcionValida);


                                System.out.println("Modificando personaje...");
                                Thread.sleep(2000);

                            } else if (selecion == 2) {
                                System.out.println("Volviendo al menú...");
                                Thread.sleep(2000);
                            } else { //Si selecciona un número que no sea 1 0 2 dará error
                                System.out.println("Error: Número fuera de rango");
                                System.out.println("Volviendo al menú...");
                                Thread.sleep(2000);
                            }
                        }

                    }
                    System.out.println(" ");
                }while (suboption != 3);
            }
//------------------------------------------ Batalla Por Equipos ----------------------------
            if (option == 2 && persInsert == true) {
                int valor = 0;
                int valor1 = 0;
                int valor2 = 0;
                int equipo1 = 0;
                int equipo2 = 0;

                for (int i = 0; i < matriz.length; i++) { //Printamos los nombres de los personajes y su poder
                    nombre = (String) matriz[i][0];
                    // valor = (int) matriz[i][1];
                    System.out.println("Nombre: " + nombre + ", Poder: " + matriz[i][1]);
                }

                System.out.println();
                System.out.println("Selecciona tus equipos");

                for (int i = 0; i < 8; i++) { //El usuario escoje el equipo de cada personaje
                    nombre = (String) matriz[i][0];
                    valor = (int) matriz[i][1];
                    int neq = 0;
                    do {
                        System.out.println(nombre + ": ¿Equipo 1 o 2?");
                        neq = input.nextInt();
                        if (neq != 1 && neq != 2) {
                            System.out.println("Error: Inserta un valor entre 1 y 2");
                        }
                    } while (neq != 1 && neq != 2);


                    if (neq == 1) {
                        if (equipo1 >= 4) { // Si el equipo está lleno se assignara automaticamente al equipo contrario
                            System.out.println("Equipo 1 completo! se assignara el personaje al equipo 2");
                            valor2 += valor;
                            equipo1++;
                            matriz[i][2] = 2;
                        } else {
                            valor1 += valor;
                            equipo1++;
                            matriz[i][2] = 1;
                        }
                    }
                    if (neq == 2) { // Si el equipo está lleno se assignara automaticamente al equipo contrario
                        if (equipo2 >= 4) {
                            System.out.println("Equipo 2 completo! se assignara el personaje al equipo 1");
                            valor2 += valor;
                            equipo1++;
                            matriz[i][2] = 1;
                        } else {
                            valor2 += valor;
                            equipo2++;
                            matriz[i][2] = 2;
                        }
                    }
                    System.out.println(" ");
                }

                System.out.println("Equipo 1: ");
                System.out.println(" ");

                for (int i = 0; i < 8; i++) { // Printamos los personajes de cada equipo
                    if ((int) matriz[i][2] == 1) {
                        System.out.print(matriz[i][0] + " ");
                    }
                    Thread.sleep(500);
                }
                System.out.println(" ");
                System.out.println("VS");

                for (int i = 0; i < 8; i++) { // Printamos los personajes de cada equipo
                    if ((int) matriz[i][2] == 2) {
                        System.out.print(matriz[i][0] + " ");
                    }
                    Thread.sleep(500);
                }
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("Equipo 2: ");


                System.out.println(" ");

                System.out.println("¡LA BATALLA HA EMPEZADO!");

                for (int i = 0; i < 20; i++){ // Barra de carga para dar vida al juego
                    System.out.print("=");
                    Thread.sleep(300);
                }
                System.out.println(" ");
                System.out.println("¡LA BATALLA HA LLEGADO A SU FIN!");
                System.out.println(" ");


                Thread.sleep(1000);


                if (valor1 > valor2) {
                    System.out.println("El EQUIPO 1 es el vencedor!");
                    System.out.println(" ");
                }
                if (valor1 < valor2) {
                    System.out.println("El EQUIPO 2 es el vencedor!");
                    System.out.println(" ");
                }

            }
            if (option == 2 && persInsert == false) { //Control de errores si no estan creados los personajes para jugar
                System.out.println(" ");
                System.out.println("¡Inserta tus personajes antes de batallar!");
                System.out.println(" ");
            }
        }while (option != 4);
    }
}