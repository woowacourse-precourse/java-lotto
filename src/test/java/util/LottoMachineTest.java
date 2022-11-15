package util;

import domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

   @Test
    void getLotto() {
        List<Lotto> list = LottoMachine.getLotto(1);
        assertEquals(list.get(0).getNumbers().size(), 6);
        System.out.println(list.get(0).getNumbers());
    }

    @Test
    void getLotto2() {
        List<Lotto> list = LottoMachine.getLotto(8);
        assertEquals(list.size(), 8);
    }
}