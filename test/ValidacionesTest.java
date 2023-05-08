package Practica_evaluacion.test;

import Practica_evaluacion.Utils.Validaciones;

import static org.junit.jupiter.api.Assertions.*;

class ValidacionesTest {

    @org.junit.jupiter.api.Test
    void validación_tarjeta() {
        assertTrue(Validaciones.validación_tarjeta("4015394992567893"));
        assertTrue(Validaciones.validación_tarjeta(""));
        assertFalse(Validaciones.validación_tarjeta("213"));
    }

    @org.junit.jupiter.api.Test
    void solo_numero() {
        assertTrue(Validaciones.solo_numero("5"));
        assertFalse(Validaciones.solo_numero("h"));
        assertTrue(Validaciones.solo_numero(""));
        assertFalse(Validaciones.solo_numero("@"));

    }

    @org.junit.jupiter.api.Test
    void primera_letra() {
        assertEquals(Validaciones.primera_letra("Pipo Pope Pipas Parque"),"PPPP78");
        assertNotEquals(Validaciones.primera_letra("Pipo Pope PipasParque"),"PPPP78");
        assertNotEquals(Validaciones.primera_letra("PipoPopePipasParque"),"PPPP78");
        assertNotEquals(Validaciones.primera_letra("Pipo"),"PPPP78");
        assertNotEquals(Validaciones.primera_letra("  e  "),"PPPP78");
        assertNotEquals(Validaciones.primera_letra("@"),"PPPP78");
    }

    @org.junit.jupiter.api.Test
    void fechaCorrecta() {
        assertTrue(Validaciones.fechaCorrecta("19-12-1999"));
        assertTrue(Validaciones.fechaCorrecta("19/12/1999"));
        assertFalse(Validaciones.fechaCorrecta("00-00-00"));
        assertFalse(Validaciones.fechaCorrecta("00/00/00"));
        assertFalse(Validaciones.fechaCorrecta("04-10-2015"));
        assertFalse(Validaciones.fechaCorrecta("04/10/2015"));
        assertFalse(Validaciones.fechaCorrecta("04-10-2033"));
        assertFalse(Validaciones.fechaCorrecta("04/10/2033"));
        assertFalse(Validaciones.fechaCorrecta("-04-10-2015"));
        assertFalse(Validaciones.fechaCorrecta("-04/10/2015"));

    }

    @org.junit.jupiter.api.Test
    void comprobar_fecha_entrada_salida() {
        assertTrue(Validaciones.comprobar_fecha_entrada_salida("01-01-2023","02-02-2023"));
        assertFalse(Validaciones.comprobar_fecha_entrada_salida("01-01-2004","02-02-2004"));
        assertFalse(Validaciones.comprobar_fecha_entrada_salida("0","0"));
        assertFalse(Validaciones.comprobar_fecha_entrada_salida("0","0"));

    }

    @org.junit.jupiter.api.Test
    void nombrecorrecto() {
        assertTrue(Validaciones.nombrecorrecto("sergio",false));
        assertFalse(Validaciones.nombrecorrecto("6",false));
        assertFalse(Validaciones.nombrecorrecto("a@a",false));
        assertFalse(Validaciones.nombrecorrecto("@",true));

    }

    @org.junit.jupiter.api.Test
    void emailcorrecto() {
        assertTrue(Validaciones.emailcorrecto("a@a.es"));
        assertFalse(Validaciones.emailcorrecto("a@.es"));
        assertFalse(Validaciones.emailcorrecto("@a.es"));
        assertFalse(Validaciones.emailcorrecto("@.es"));
        assertFalse(Validaciones.emailcorrecto("a@a.mes"));
        assertFalse(Validaciones.emailcorrecto("a@e@a.es"));
        assertFalse(Validaciones.emailcorrecto("a @a.es"));
    }

    @org.junit.jupiter.api.Test
    void numerocorrecto() {
        assertTrue(Validaciones.numerocorrecto("694493951"));
        assertFalse(Validaciones.numerocorrecto("a"));
        assertFalse(Validaciones.numerocorrecto("1"));
        assertFalse(Validaciones.numerocorrecto("@"));
        assertFalse(Validaciones.numerocorrecto(""));
        assertFalse(Validaciones.numerocorrecto("123456789"));
        assertFalse(Validaciones.numerocorrecto("123456 578"));
    }

}