package org.factoriaf5.imc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraIMCTest {

    
    @Test
    public void testCalcularIMC_PesoYAlturaPositivos() {
        CalculadoraIMC calculadora = new CalculadoraIMC();

        
        double peso = 70;
        double altura = 1.75;
        double resultadoEsperado = 70 / Math.pow(1.75, 2); // IMC = 22.8571...
        assertEquals(resultadoEsperado, calculadora.calcularIMC(peso, altura), 0.0001);

        
        peso = 50;
        altura = 1.60;
        resultadoEsperado = 50 / Math.pow(1.60, 2); // IMC = 19.5312...
        assertEquals(resultadoEsperado, calculadora.calcularIMC(peso, altura), 0.0001);

       
        peso = 100;
        altura = 1.80;
        resultadoEsperado = 100 / Math.pow(1.80, 2); // IMC = 30.8641...
        assertEquals(resultadoEsperado, calculadora.calcularIMC(peso, altura), 0.0001);
    }

   
    @Test
    public void testCalcularIMC_ExcepcionesPesoYAlturaNoPositivos() {
        CalculadoraIMC calculadora = new CalculadoraIMC();

       
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularIMC(-1, 1.75);
        });

        
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularIMC(70, -1.75);
        });

        
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularIMC(0, 1.75);
        });

        
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularIMC(70, 0);
        });

        
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularIMC(0, 0);
        });
    }

    
    @Test
    public void testClasificacionIMC() {
        CalculadoraIMC calculadora = new CalculadoraIMC();

        
        double imc = 15.5;
        assertEquals("Delgadez severa", calculadora.clasificacionIMC(imc));

        
        imc = 16.5;
        assertEquals("Delgadez moderada", calculadora.clasificacionIMC(imc));

        
        imc = 17.5;
        assertEquals("Delgadez", calculadora.clasificacionIMC(imc));

        
        imc = 22.0;
        assertEquals("Peso normal", calculadora.clasificacionIMC(imc));

        
        imc = 28.0;
        assertEquals("Sobrepeso", calculadora.clasificacionIMC(imc));

        
        imc = 32.0;
        assertEquals("Obesidad leve", calculadora.clasificacionIMC(imc));

        
        imc = 36.0;
        assertEquals("Obesidad moderada", calculadora.clasificacionIMC(imc));

        
        imc = 42.0;
        assertEquals("Obesidad morbida", calculadora.clasificacionIMC(imc));
    }

   
    @Test
    public void testClasificacionIMC_ExcepcionesIMCNoPositivo() {
        CalculadoraIMC calculadora = new CalculadoraIMC();

       
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.clasificacionIMC(-5);
        });

        
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.clasificacionIMC(0);
        });
    }
}