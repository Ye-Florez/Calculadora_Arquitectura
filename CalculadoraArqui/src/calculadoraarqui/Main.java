/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadoraarqui;

import java.util.Scanner;

/**
 *
 * @author Yelitz flórez
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Calculadora Multi-Base ===");
        System.out.println("Sistema: 10=Decimal  2=Binario  16=Hexadecimal  8=Octal");
        System.out.print("Elige sistema: ");
        int sistema = sc.nextInt();

        System.out.print("Operando 1: ");
        String op1 = sc.next();

        System.out.print("Operación (+, -, *, /): ");
        char operacion = sc.next().charAt(0);

        System.out.print("Operando 2: ");
        String op2 = sc.next();

        CalculadoraArqui calc = new CalculadoraArqui(op1, op2, sistema, operacion);
        String resultado = calc.operar(operacion);

        System.out.println("Resultado: " + resultado);
    }
}
