package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    @Test
    void 로또_결과() {
        LottoResult sixMatches = new LottoResult(List.of(1,2,3,4,5,6), List.of(1,2,3,4,5,6));
        LottoResult fiveMatches = new LottoResult(List.of(1,2,3,4,5,6), List.of(1,2,3,4,5,7));
        LottoResult fourMatches = new LottoResult(List.of(1,2,3,4,5,6), List.of(1,2,3,4,7,8));
        LottoResult threeMatches = new LottoResult(List.of(1,2,3,4,5,6), List.of(1,2,3,7,8,9));

        Assertions.assertEquals(6, sixMatches.get());
        Assertions.assertEquals(5, fiveMatches.get());
        Assertions.assertEquals(4, fourMatches.get());
        Assertions.assertEquals(3, threeMatches.get());
    }
}