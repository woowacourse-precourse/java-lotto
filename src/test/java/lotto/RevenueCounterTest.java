package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RevenueCounterTest {
    @Test
    public void MatchTest() {
        ArrayList<List<Integer>> lottos = new ArrayList<>();
        lottos.add(List.of(3, 1));
        lottos.add(List.of(3, 0));
        lottos.add(List.of(4, 1));
        lottos.add(List.of(5, 0));
        lottos.add(List.of(5, 1));
        lottos.add(List.of(6, 0));

        RevenueCounter revenueCounter = new RevenueCounter();
        Map<WinningCase, List<Integer>> revenue = revenueCounter.convertToMoney(lottos);
        System.out.println(WinningCase.SIX);


        Assertions.assertEquals(revenue.get(WinningCase.THREE), List.of(2, 10000));
        Assertions.assertEquals(revenue.get(WinningCase.FOUR), List.of(1, 50000));
        Assertions.assertEquals(revenue.get(WinningCase.FIVE), List.of(1, 1500000));
        Assertions.assertEquals(revenue.get(WinningCase.FIVE_BONUS), List.of(1, 30000000));
        Assertions.assertEquals(revenue.get(WinningCase.SIX), List.of(1, 2000000000));
//        revenue.entrySet().forEach(o -> {
//            System.out.println(o.getKey() + " " + o.getValue());
//        });



    }
}
