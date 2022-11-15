package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.EnumMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class LottoFactoryTest {
    @Test
    void testSetWinmoney() {
        LottoFactory lottoFactory = new LottoFactory();

        Map<LottoRanking, Integer> lottoRanking = new EnumMap<>(LottoRanking.class);

        lottoRanking.put(LottoRanking.FIRST, 1);
        lottoRanking.put(LottoRanking.SECOND, 1);
        lottoRanking.put(LottoRanking.THIRD, 1);
        lottoRanking.put(LottoRanking.FOURTH, 1);
        lottoRanking.put(LottoRanking.FIFTH, 1);

        lottoFactory.setWinmoney(lottoRanking);

        assertEquals(2031555000, lottoFactory.getWinMoney());
    }
}
