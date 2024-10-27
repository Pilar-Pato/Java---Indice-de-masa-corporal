package org.factoriaf5.imc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraIMCTest {

    @Test
    public void testCalcularIMC_PesoNormal() {
        
        CalculadoraIMC calculadora = new CalculadoraIMC();
       
        double peso = 70.0;
        double altura = 1.8;
        double imc = calculadora.calcularIMC(peso, altura);
        double expectedIMC = 21.6;
        assertEquals(expectedIMC, imc, 0.01);  
    }

    @Test
    public void testCalcularIMC_DelgadezS() {
        
        CalculadoraIMC calculadora = new CalculadoraIMC();
        double peso = 40.0;
        double altura = 1.7;
        double expectedIMC = 13.84;
        assertEquals(expectedIMC, calculadora.calcularIMC(peso, altura), 0.01);
    }
    @Test
    public void testCalcularIMC_DelgadezM() {
        CalculadoraIMC calculadora = new CalculadoraIMC();
        double peso = 45.0;
        double altura = 1.7;
        double expectedIMC = 15.57;
        assertEquals(expectedIMC, calculadora.calcularIMC(peso, altura), 0.01);
    }

    @Test
    public void testCalcularIMC_DelgadezL() {
        CalculadoraIMC calculadora = new CalculadoraIMC();
        double peso = 55.0;
        double altura = 1.7;
        double expectedIMC = 19.04;
        assertEquals(expectedIMC, calculadora.calcularIMC(peso, altura), 0.01);
    }

    @Test
    public void testCalcularIMC_Sobrepeso() {
        CalculadoraIMC calculadora = new CalculadoraIMC();
        double peso = 76.0;
        double altura = 1.7;
        double expectedIMC = 26.29;
        assertEquals(expectedIMC, calculadora.calcularIMC(peso, altura), 0.01);
    }

    @Test
    public void testCalcularIMC_ObesidadL() {
        CalculadoraIMC calculadora = new CalculadoraIMC();
        double peso = 85.0;
        double altura = 1.7;
        double expectedIMC = 29.41;
        assertEquals(expectedIMC, calculadora.calcularIMC(peso, altura), 0.01);
    }

    @Test
    public void testCalcularIMC_ObesidadM() {
        CalculadoraIMC calculadora = new CalculadoraIMC();
        double peso = 120.0;
        double altura = 1.6;
        double expectedIMC = 46.88;
        assertEquals(expectedIMC, calculadora.calcularIMC(peso, altura), 0.01);
    }
    @Test
    public void testCalcularIMC_PesoNega() {
        CalculadoraIMC calculadora = new CalculadoraIMC();
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularIMC(-5, 1.7);
        });
    }

    @Test
    public void testCalcularIMC_AlturaNeg() {
        CalculadoraIMC calculadora = new CalculadoraIMC();
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularIMC(70, -1.7);
        });
    }

    @Test
    public void testCalcularIMC_ExceptionPeso() {
        CalculadoraIMC calculadora = new CalculadoraIMC();
        assertThrows(NumberFormatException.class, () -> {
            // Simulamos una excepción de formato al intentar convertir una cadena a double
            double peso = Double.parseDouble("h");
            calculadora.calcularIMC(peso, 1.7);
        });
    }

    @Test
    public void testCalcularIMC_ExceptionAltura() {
        CalculadoraIMC calculadora = new CalculadoraIMC();
        assertThrows(NumberFormatException.class, () -> {
        double altura = Double.parseDouble("m");
        calculadora.calcularIMC(70, altura);
    });
}
}
