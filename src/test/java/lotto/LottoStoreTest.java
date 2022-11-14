package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LottoStoreTest {
    static LottoStore lottoStore;
    @BeforeAll
    static void init(){
        lottoStore = new LottoStore(List.of(
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(1,2,3,4,8,9))
        ));
    }

    @Test
    void calculateLottoYield() {
        //when
        double yield = lottoStore.calculateLottoYield(List.of(0,0,1,0,0));
        //then
        assertEquals(750.0,yield);
    }
}