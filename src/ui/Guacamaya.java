package ui;

import java.util.Scanner;

public class Guacamaya {
        private static double[] precio;
        private static int[] Cantidades;
        private static int NumeroProductos;
        
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Bienvenido a Guacamaya!");
            System.out.print("Digite el numero de referencias de producto diferentes vendidas en el dia: ");
            NumeroProductos = scanner.nextInt();
            
            precio = new double[NumeroProductos];
            Cantidades = new int[NumeroProductos];
            
            int option;
            do {
                showMenu();
                option = scanner.nextInt();
                ManejoOption(option, scanner);
            } while (option != 6);
            
            scanner.close();
        }
        
        private static void showMenu() {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Solicitar precios ($) y cantidades de cada referencia de producto vendida en el dia");
            System.out.println("2. Calcular la cantidad total de unidades vendidas en el dia");
            System.out.println("3. Calcular el precio promedio de las referencias de producto vendidas en el dia");
            System.out.println("4. Calcular las ventas totales (dinero recaudado) durante el dia");
            System.out.println("5. Consultar el numero de referencias de productos que en el dia han superado un limite minimo de ventas");
            System.out.println("6. Salir");
            System.out.print("\nDigite la opción a ejecutar: ");
        }
        
        private static void ManejoOption(int option, Scanner scanner) {
            switch (option) {
                case 1:
                    requestProductData(scanner);
                    break;
                case 2:
                    System.out.println("La cantidad total de unidades vendidas en el dia fue de: " + TotalUnidades());
                    break;
                case 3:
                    System.out.println("El precio promedio de las referencias de producto vendidas en el dia fue de: " + PrecioPromedio());
                    break;
                case 4:
                    System.out.println("Las ventas totales (dinero recaudado) durante el dia fueron: " + TotalVendidos());
                    break;
                case 5:
                    System.out.print("Digite el limite minimo de ventas a analizar: ");
                    double limit = scanner.nextDouble();
                    System.out.println("De las " + NumeroProductos + " referencias vendidas en el dia, " + ProductosSobreLimite(limit) + " superaron el limite de ventas de " + limit);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
            }
        }
        
        private static void requestProductData(Scanner scanner) {
            for (int i = 0; i < NumeroProductos; i++) {
                System.out.print("Ingrese el precio del producto " + (i + 1) + ": ");
                precio[i] = scanner.nextDouble();
                System.out.print("Ingrese la cantidad vendida del producto " + (i + 1) + ": ");
                Cantidades[i] = scanner.nextInt();
            }
        }
        
        private static int TotalUnidades() {
            int total = 0;
            for (int Cantidad : Cantidades) {
                total += Cantidad;
            }
            return total;
        }
         
     
             //Descripcion: Este se encarga de calcular el promedio de los productos 
             //pre: Los precios ya estan inicializados
             //pos: Su salida es el promedio de los productos 

        private static double PrecioPromedio() {
            double totalPrecio = 0;
            for (double price : precio) {
                totalPrecio += price;
            }
            return NumeroProductos > 0 ? totalPrecio / NumeroProductos: 0;
        }
        
     
        //Descripcion: Este metodo se usa para las unidades venidas en el dia 
        //pre: Los arreglos de los precios estan iniciados
        //pos: Su salida es el total de unidades que se totalizan 
        
        private static double TotalVendidos() {
            double totalVendido = 0;
            for (int i = 0; i < NumeroProductos; i++) {
                totalVendido += precio[i] * Cantidades[i];
            }
            return totalVendido;
        }
        //Desripcion: Este metodo se usa para identificar los productos sobre el limite estipulado 
        //pre: Lo arreglos de los precios y cantidades ya estam establecidos 
        //pos: su salida son los productos que sobre pasan el limite
        
        private static int ProductosSobreLimite(double limit) {
            int count = 0;
            for (int i = 0; i < NumeroProductos; i++) {
                if ((precio[i] * Cantidades[i]) > limit) {
                    count++;
                }
            }
            return count;
        }
    }
