package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class BuyerTest {
    @Test
    void testSetWinmoney() {
        Buyer buyer = new Buyer();

        Map<LottoPrize, Integer> prizeList = new EnumMap<>(LottoPrize.class);

        prizeList.put(LottoPrize.FIRST, 1);
        prizeList.put(LottoPrize.SECOND, 1);
        prizeList.put(LottoPrize.THIRD, 1);
        prizeList.put(LottoPrize.FOURTH, 1);
        prizeList.put(LottoPrize.FIFTH, 1);

        buyer.setWinmoney(prizeList);

        assertEquals(2031555000, buyer.getWinMoney());
    }
}
