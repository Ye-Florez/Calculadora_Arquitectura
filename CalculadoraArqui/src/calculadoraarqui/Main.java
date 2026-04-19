/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadoraarqui;

import java.util.Scanner;

/**
 *
 * @author Yelitz flórez
 * @author Karol Solano
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continuar;
        CalculadoraArqui temp = new CalculadoraArqui();
        do{
            System.out.println("=== Calculadora Multi-Base ===");
            System.out.println("Sistema: 10=Decimal  2=Binario  16=Hexadecimal  8=Octal");
            int sistema = 0;
            boolean sistemaValido = false;
            do {
                System.out.print("Elige sistema: ");
                sistema = sc.nextInt();
                try {                   
                    sistemaValido = temp.esSistema(sistema);
                } catch (IllegalArgumentException e) {
                    System.out.println("Sistema no valido. Por favor ingrese: 2, 8, 10 o 16");
                }
            } while (!sistemaValido);
            
            String op1 = " ";
            boolean digitosSistemaValido = false;
            do {
                System.out.print("Operando 1: ");
                op1 = sc.next();
                try {
                    digitosSistemaValido = temp.sonDigitosSistema(op1, sistema);
                } catch (IllegalArgumentException e) {
                    System.out.println("no es un numero del sistema ingresado anteriormente");
                }
            } while(!digitosSistemaValido);

            char operacion = ' ';
            boolean operacionValida = false;
            do {
                System.out.print("Operación (+, -, *, /): ");
                operacion = sc.next().charAt(0);
                try {
                    operacionValida = temp.esOperacion(operacion);
                } catch (IllegalArgumentException e){
                    System.err.println("Operacion no valida. Por favor ingrese: +, -, * o /");
                }
            } while (!operacionValida);

            String op2 = " ";
            boolean digitosSistemaValido2 = false;
            do {
                System.out.print("Operando 2: ");
                op2 = sc.next();
                try {
                    digitosSistemaValido2 = temp.sonDigitosSistema(op2, sistema);
                } catch (IllegalArgumentException e) {
                    System.out.println("no es un numero del sistema ingresado anteriormente");
                }
            } while(!digitosSistemaValido2);

            CalculadoraArqui calc = new CalculadoraArqui(op1, op2, sistema, operacion);
            String resultado = calc.operar(operacion);
            System.out.println("Resultado: " + resultado); 
                
            System.out.print("\n¿Desea realizar otra operación? (SI/NO): ");
            continuar = sc.next().toLowerCase();

        }while(continuar.equals("si") || continuar.equals("s"));
        
        System.out.println("¡Hasta luego!");
        sc.close();
    }
}

