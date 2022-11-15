package lotto.study.domain.result;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.domain.ingame.Lotto;
import lotto.domain.ingame.LuckyNumbers;
import lotto.domain.result.Statistic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatisticTest extends NsTest {

    LuckyNumbers luckyNumbers = new LuckyNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);


    @DisplayName("수익률 0%")
    @Test
    void 수익률_테스트1() {

        //given
        List<Lotto> userLotto = new ArrayList<>();
        int payAmount = 1000;
        userLotto.add(new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)));

        Statistic statistic = new Statistic(userLotto, luckyNumbers, payAmount);

        //when
        double actual = statistic.getProfitRate();

        //then
        assertThat(actual).isEqualTo(0);

    }

    @DisplayName("모든 랭크 당첨")
    @Test
    void 수익률_테스트2() {

        //given
        List<Lotto> userLotto = new ArrayList<>();
        int payAmount = 6000;
        userLotto.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        userLotto.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        userLotto.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)));
        userLotto.add(new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)));
        userLotto.add(new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)));
        userLotto.add(new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)));

        Statistic statistic = new Statistic(userLotto, luckyNumbers, payAmount);

        //when
        double actual = statistic.getProfitRate();
        double expected = ((double)(5000+50000+1500000+30000000+2000000000))/payAmount*100;

        //then
        assertEquals(expected,actual,0.001);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}