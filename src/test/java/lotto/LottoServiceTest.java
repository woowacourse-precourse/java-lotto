package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    static LottoService lottoService;
    @BeforeAll
    static void init(){
        lottoService = new LottoService(List.of(1,2,3,4,5,6),7);
    }

    @Test
    void generateLottoTest() {
        //given
        Lotto lotto = lottoService.generateLotto();
        //when
        Set<Integer> uniqueLottoNumbers = new HashSet(lotto.getNumbers());
        //then
        assertEquals(6, uniqueLottoNumbers.size());
    }
}