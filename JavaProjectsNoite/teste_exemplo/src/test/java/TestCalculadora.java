
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.Calculadora;

public class TestCalculadora {
    
    Calculadora calc = new Calculadora();

    //Criar os testes
    @Test
    public void testSoma() {
        double resultado = calc.soma(5, 8);
        assertEquals(13, resultado, 0);
    }

    @Test
    public void testSubtrai() {
        double resultado = calc.subtrai(10, 12);
        assertEquals(-2, resultado, 0);
    }

    @Test
    public void testMultiplica() {
        double resultado = calc.multiplica(3, 4);
        assertEquals(12, resultado, 0);
    }
    @Test    
    public void testDivisao() {
        double resultado = calc.divide(12, 6);
        assertEquals(2, resultado, 0);
    }

    @Test
    public void testDivisaoZero() {
        // Verifica se a exceção é lançada ao dividir por zero
        assertThrows(IllegalArgumentException.class, () -> calc.divide(10, 0));
    }
}
