import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.Calculadora;

public class TestCalculadora {
    
    Calculadora cac = new Calculadora();

    //Criar os testes
    @Test
    public void testSoma() {
        double resultado = cac.soma(5, 8);
        assertEquals(13, resultado, 0);
    }

    public void testSubtrai() {
        double resultado = cac.subtrai(10, 5);
        assertEquals(5, resultado, 0);
    }

    public void testMultiplica() {
        double resultado = cac.multiplica(3, 4);
        assertEquals(12, resultado, 0);
    }
    
    public void testDivide() {
        double resultado = cac.divide(12, 3);
        assertEquals(4, resultado, 0);
    }
}
