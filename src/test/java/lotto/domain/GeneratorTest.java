package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lotto.Constants.NUMBER;
import lotto.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GeneratorTest {
    @DisplayName("로또 인스턴스를 인자로 받아 일치하는 당첨번호 및 보너스번호 개수를 HashMap에 담아 반환해준다")
    @Test
    void judgeWinningCountTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = Generator.class.getDeclaredMethod("countCorrectNumber", Lotto.class);
        method.setAccessible(true);

        List<Integer> winningNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto.setWinningNumbers(winningNumbers);
        Lotto.setBonusNumber(7);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        HashMap<String, Integer> winningSummary = (HashMap<String, Integer>) method.invoke(Generator.class, lotto);

        HashMap<String, Integer> expectSummary = new HashMap<String, Integer>();
        expectSummary.put("winningCount", 6);
        expectSummary.put("bonusCount", 0);
        assertThat(winningSummary).isEqualTo(expectSummary);
    }

    @Test
    void judgeWinningCountTest_2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = Generator.class.getDeclaredMethod("countCorrectNumber", Lotto.class);
        method.setAccessible(true);

        List<Integer> winningNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto.setWinningNumbers(winningNumbers);
        Lotto.setBonusNumber(7);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 7, 10));
        HashMap<String, Integer> winningSummary = (HashMap<String, Integer>) method.invoke(Generator.class, lotto);

        HashMap<String, Integer> expectSummary = new HashMap<String, Integer>();
        expectSummary.put("winningCount", 4);
        expectSummary.put("bonusCount", 1);
        assertThat(winningSummary).isEqualTo(expectSummary);
    }

    @Test
    void calculateProfitTest() {
        double result = Generator.calculateProfit(3000, 2_030_000_000);
        assertThat(result).isEqualTo(67666666.7);

    }

    @Test
    void countRankTest() {
        Buyer buyer = new Buyer();
        List<Integer> winningNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto.setWinningNumbers(winningNumbers);
        Lotto.setBonusNumber(7);

        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        buyer.setPurchasedLotto(lotto1);
        buyer.setPurchasedLotto(lotto2);
        buyer.setPurchasedLotto(lotto3);

        Generator.countRank(buyer);

        HashMap<String, Integer> buyerWinningSummary = new HashMap<String, Integer>() {
            {
                put(Ranking.FIRST.getLabel(), 3);
                put(Ranking.SECOND.getLabel(), NUMBER.ZERO);
                put(Ranking.THIRD.getLabel(), NUMBER.ZERO);
                put(Ranking.FOURTH.getLabel(), NUMBER.ZERO);
                put(Ranking.FIFTH.getLabel(), NUMBER.ZERO);
                put(Ranking.LOSE.getLabel(), NUMBER.ZERO);
            }
        };

        assertThat(buyer.getWinningSummary()).isEqualTo(buyerWinningSummary);

    }
}
