package lotto;

import lotto.domain.*;
import lotto.utils.LottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgmentTest {

    @DisplayName("로또 추첨하여 등수 값 테스트, 1등 번호 추첨 시나리오")
    @Test
    void drawLottoFirstClassTest() throws Exception{
        User user = new User();
        Integer[] numbers = {1,2,3,4,5,6};
        Lotto lotto = new Lotto(new ArrayList<>(List.of(numbers)));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        Field userLottos = User.class.getDeclaredField("userLottos");
        userLottos.setAccessible(true);
        userLottos.set(user, lottos);

        WinningNumbers winningNumbers = new WinningNumbers();
        Integer[] winNumbers = {1,2,3,4,5,6};
        winningNumbers.newWinningNumbers(new ArrayList<>(List.of(winNumbers)));
        winningNumbers.newBonusNumber(7);

        Judgment judgment = new Judgment(user, winningNumbers);

        Method drawLotto = Judgment.class.getDeclaredMethod("drawLotto", int.class);
        drawLotto.setAccessible(true);
        Rank rank = (Rank) drawLotto.invoke(judgment, 0);

        assertThat(rank).isEqualTo(Rank.FIRST_CLASS);
    }

    @DisplayName("로또 추첨하여 등수 값 테스트, 2등 번호 추첨 시나리오")
    @Test
    void drawLottoSecondClassTest() throws Exception{
        User user = new User();
        Integer[] numbers = {1,2,3,4,5,7};
        Lotto lotto = new Lotto(new ArrayList<>(List.of(numbers)));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        Field userLottos = User.class.getDeclaredField("userLottos");
        userLottos.setAccessible(true);
        userLottos.set(user, lottos);

        WinningNumbers winningNumbers = new WinningNumbers();
        Integer[] winNumbers = {1,2,3,4,5,6};
        winningNumbers.newWinningNumbers(new ArrayList<>(List.of(winNumbers)));
        winningNumbers.newBonusNumber(7);

        Judgment judgment = new Judgment(user, winningNumbers);

        Method drawLotto = Judgment.class.getDeclaredMethod("drawLotto", int.class);
        drawLotto.setAccessible(true);
        Rank rank = (Rank) drawLotto.invoke(judgment, 0);

        assertThat(rank).isEqualTo(Rank.SECOND_CLASS);
    }

    @DisplayName("순위 별 당첨금액 테스트")
    @Test
    void rankPrizeTest() throws Exception {
        User user = new User();
        WinningNumbers winningNumbers = new WinningNumbers();
        RankCounter rankCounter = new RankCounter();
        rankCounter.addRank(Rank.FIRST_CLASS);
        rankCounter.addRank(Rank.SECOND_CLASS);
        rankCounter.addRank(Rank.THIRD_CLASS);
        rankCounter.addRank(Rank.FIRTH_CLASS);
        rankCounter.addRank(Rank.FIFTH_CLASS);
        rankCounter.addRank(Rank.LOSE_LOTTO);

        Judgment judgment = new Judgment(user, winningNumbers);
        Field rankCounterField = Judgment.class.getDeclaredField("rankCounter");
        rankCounterField.setAccessible(true);
        rankCounterField.set(judgment, rankCounter);
        Method calculatePrizeMoney = Judgment.class.getDeclaredMethod("calculatePrizeMoney", Rank.class);
        calculatePrizeMoney.setAccessible(true);
        Long prizeMoneyFirst = (Long) calculatePrizeMoney.invoke(judgment, Rank.FIRST_CLASS);
        Long prizeMoneySecond = (Long) calculatePrizeMoney.invoke(judgment, Rank.SECOND_CLASS);
        Long prizeMoneyThird = (Long) calculatePrizeMoney.invoke(judgment, Rank.THIRD_CLASS);
        Long prizeMoneyFirth = (Long) calculatePrizeMoney.invoke(judgment, Rank.FIRTH_CLASS);
        Long prizeMoneyFifth = (Long) calculatePrizeMoney.invoke(judgment, Rank.FIFTH_CLASS);
        Long prizeMoneyLose = (Long) calculatePrizeMoney.invoke(judgment, Rank.LOSE_LOTTO);

        assertThat(prizeMoneyFirst).isEqualTo(2000000000);
        assertThat(prizeMoneySecond).isEqualTo(30000000);
        assertThat(prizeMoneyThird).isEqualTo(1500000);
        assertThat(prizeMoneyFirth).isEqualTo(50000);
        assertThat(prizeMoneyFifth).isEqualTo(5000);
        assertThat(prizeMoneyLose).isEqualTo(0);
    }

    @DisplayName("총 당첨 금액 계산 테스트")
    @Test
    void totalPrizeMoneyTest() throws Exception {
        User user = new User();
        WinningNumbers winningNumbers = new WinningNumbers();
        RankCounter rankCounter = new RankCounter();
        rankCounter.addRank(Rank.FIRST_CLASS);
        rankCounter.addRank(Rank.SECOND_CLASS);
        rankCounter.addRank(Rank.THIRD_CLASS);
        rankCounter.addRank(Rank.FIRTH_CLASS);
        rankCounter.addRank(Rank.FIFTH_CLASS);
        rankCounter.addRank(Rank.LOSE_LOTTO);

        Judgment judgment = new Judgment(user, winningNumbers);
        Field rankCounterField = Judgment.class.getDeclaredField("rankCounter");
        rankCounterField.setAccessible(true);
        rankCounterField.set(judgment, rankCounter);

        Long targetMoney = 2000000000L + 30000000L + 1500000L + 50000L + 5000L;

        Method calculateTotalPrizeMoney = Judgment.class.getDeclaredMethod("calculateTotalPrizeMoney");
        calculateTotalPrizeMoney.setAccessible(true);
        Long totalPrizeMoney = (Long) calculateTotalPrizeMoney.invoke(judgment);

        assertThat(totalPrizeMoney).isEqualTo(targetMoney);
    }
}