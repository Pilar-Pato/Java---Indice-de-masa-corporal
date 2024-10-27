package org.factoriaf5.imc;
import java.util.Scanner;

public class CalculadoraIMC {

    public double calcularIMC(double peso, double altura) {
        if (peso <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Peso y altura deben ser positivos");
        }
        return peso / (altura * altura);
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su peso en kilogramos: ");
        double peso = scanner.nextDouble();
        System.out.print("Ingrese su altura en metro:");
        double altura = scanner.nextDouble();

        double imc = peso / (altura * altura);
        System.out.println("Tu indice de masa corparal es: " + imc);
       
            if (imc < 16) {
            System.out.println("Delgadez severa");
        } 
            else if (imc >= 16 && imc < 17) {
            System.out.println("Delgadez moderada");
        } 
            else if (imc >= 17 && imc < 18.5) {
            System.out.println("Delgadez leve");
        } 
            else if (imc >= 18.5 && imc < 25) {
            System.out.println("Peso normal");
        } 
            else if (imc >= 25 && imc < 30) {
            System.out.println("Sobrepeso"); 

        } 
            else if (imc >= 30 && imc < 35) {
            System.out.println("Obesidad leve");
        } 
            else {
            System.out.println("Obesidad mórbida");
        }

        scanner.close();
    }
}
