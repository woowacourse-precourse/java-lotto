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

    @Test
    void getLottoRankResultsByLottosTest() {
        //given
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(1,2,3,4,5,7));
        Lotto lotto3 = new Lotto(List.of(1,2,3,4,5,8));
        Lotto lotto4 = new Lotto(List.of(3,4,5,6,7,8));
        Lotto lotto5 = new Lotto(List.of(3,4,5,7,8,9));

        //when
        List<Lotto> lottos = List.of(lotto1,lotto2,lotto3,lotto4,lotto5);
        List<Integer> lottoRankResult = lottoService.getLottoRankResultsByLottos(lottos);
        System.out.println(lottoRankResult);

        //then
        assertEquals(lottoRankResult, List.of(1,1,1,1,1));
    }
}