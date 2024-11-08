/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.montes_albertoexamen;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Martin Montes
 */
public class Montes_albetoExamen {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;
            
            do {
                System.out.println("\n=== Menu de Opciones ==="); //AMMM
                System.out.println("1. Piramide");
                System.out.println("2. El Mayor");
                System.out.println("3. Ingreso de Canales");
                System.out.println("4. Contar Vocales");
                System.out.println("5. Salir");
                System.out.print("Selecciona una opcion: ");
                opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer
                
                switch (opcion) {
                    case 1 -> piramide(scanner);
                    case 2 -> elMayor(scanner);
                    case 3 -> ingresoDeCanales(scanner);
                    case 4 -> contarVocales(scanner);
                    case 5 -> System.out.println("HASTA LUEGO");
                    default -> System.out.println("Opcion no valida. Por favor, selecciona una opcion entre el 1 y 5.");
                }
            } while (opcion != 5);
        }
    }

    // Opción 1: Pirámide
    public static void piramide(Scanner scanner) {
        System.out.print("Cantidad de filas de la piramide: ");
        int filas = scanner.nextInt();
        int numero = 1;

        for (int i = 1; i <= filas; i++) {
            int suma = 0;
            for (int j = 0; j < i; j++) {
                System.out.print(numero + " ");
                suma += numero;
                numero += 2;
            }
            System.out.println("= " + suma);
        }
    }

    // Opción 2: El Mayor
    public static void elMayor(Scanner scanner) {
        ArrayList<Integer> numeros = new ArrayList<>();
        String respuesta;

        do {
            System.out.print("Ingresa un numero entero: ");
            numeros.add(scanner.nextInt());
            scanner.nextLine(); // Limpiar el buffer
            System.out.print("Deseas ingresar otro numero? (si/no): ");
            respuesta = scanner.nextLine();
        } while (respuesta.equalsIgnoreCase("si"));

        int maximo = numeros.stream().max(Integer::compare).orElse(0);
        double promedio = numeros.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Numero mayor ingresado: " + maximo);
        System.out.println("Promedio de los numeros ingresados: " + promedio);
    }

    // Opción 3: Ingreso de Canales
    public static void ingresoDeCanales(Scanner scanner) {
        System.out.print("Nombre de Cliente: ");
        int canalesHD = 0, canalesNormales = 0;
        String respuesta = null;

        do {
            System.out.print("Ingresa el tipo de canal (HD/NORMAL): ");
            String tipoCanal = scanner.nextLine();
            if (tipoCanal.equalsIgnoreCase("HD")) {
                canalesHD++;
            } else if (tipoCanal.equalsIgnoreCase("NORMAL")) {
                canalesNormales++;
            } else {
                System.out.println("Tipo de canal no válido.");
                continue;
            }
            System.out.print("Deseas ingresar otro canal? (si/no): ");
            respuesta = scanner.nextLine();
        } while (respuesta.equalsIgnoreCase("si"));

        System.out.print("Ingresa el tipo de Caja Digital (LIGHTBOX/HDBOX/DVRBOX): ");
        String tipoCaja = scanner.nextLine();
        int costoCaja = switch (tipoCaja.toUpperCase()) {
            case "LIGHTBOX" -> 50;
            case "HDBOX" -> 100;
            case "DVRBOX" -> 150;
            default -> {
                System.out.println("Tipo de caja no válido, se asignará costo de 0.");
                yield 0;
            }
        };

        int subtotal = (canalesNormales * 20) + (canalesHD * 30) + costoCaja;
        double impuesto = subtotal * 0.15;
        double total = subtotal + impuesto;

        System.out.println("\nDetalle de la Factura:");
        System.out.println("Canales Normales: " + canalesNormales);
        System.out.println("Canales HD: " + canalesHD);
        System.out.println("Subtotal a pagar: " + subtotal + " Lps");
        System.out.println("Impuesto (15%): " + impuesto + " Lps");
        System.out.println("Total a Pagar: " + total + " Lps");
    }

    // Opción 4: Contar Vocales
    public static void contarVocales(Scanner scanner) {
        System.out.print("Ingresa una cadena de texto: ");
        String texto = scanner.nextLine();
        int contadorVocales = 0;

        for (char c : texto.toCharArray()) {
            switch (c) {
                case 'a', 'e', 'i', 'o', 'u' -> contadorVocales++;
                default -> {
                }
            }
        }

        System.out.println("La cantidad de vocales en minuscula es: " + contadorVocales);
    }
}

    
