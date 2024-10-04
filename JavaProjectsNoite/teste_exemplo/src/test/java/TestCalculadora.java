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

    @Test
    public void testSubtrai() {
        double resultado = cac.subtrai(10, 12);
        assertEquals(-2, resultado, 0);
    }

    @Test
    public void testMultiplica() {
        double resultado = cac.multiplica(3, 4);
        assertEquals(12, resultado, 0);
    }
    @Test    
    public void testDivide() {
        double resultado = cac.divide(12, 3);
        assertEquals(4, resultado, 0);
    }
}
