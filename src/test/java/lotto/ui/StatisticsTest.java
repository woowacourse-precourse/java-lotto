package lotto.ui;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsTest {

    static Player player = new Player();
    static Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
    static int bonusNumber = 7;
    static LottoChecker lottoChecker = new LottoChecker(winningLotto, bonusNumber);

    @Test
    void 로또_5등_수익률(){
        // given
        int money = 100000;
        player.setMoney(money);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1,2,3,11,15,18))
        );
        player.setLottos(lottos);
        List<LottoReward> lottoRewards = lottoChecker.calculate(lottos);

        // when
        Statistics statistics = new Statistics(lottoRewards, player);
        statistics.analysis();

        // then
        assertThat(statistics.getRateOfReturn())
                .isEqualTo(statistics.getAwardMoney() / (float)statistics.getUsedMoney()*100);
    }

    @Test
    void 로또_꽝_수익률(){
        // given
        int money = 100000;
        player.setMoney(money);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );
        player.setLottos(lottos);
        List<LottoReward> lottoRewards = lottoChecker.calculate(lottos);

        // when
        Statistics statistics = new Statistics(lottoRewards, player);
        statistics.analysis();

        // then
        assertThat(statistics.getRateOfReturn())
                .isEqualTo(statistics.getAwardMoney() / (float)statistics.getUsedMoney()*100);
    }

    @Test
    void 로또_테스트(){
        // given
        int money = 100000;
        player.setMoney(money);
        List<Lotto> lottos = List.of(
                new Lotto(new ArrayList<>(List.of(8, 21, 23, 41, 42, 43))),
                new Lotto(new ArrayList<>(List.of(3, 5, 11, 16, 32, 38))),
                new Lotto(new ArrayList<>(List.of(7, 11, 16, 35, 36, 44))),
                new Lotto(new ArrayList<>(List.of(1, 8, 11, 31, 41, 42))),
                new Lotto(new ArrayList<>(List.of(13, 14, 16, 38, 42, 45))),
                new Lotto(new ArrayList<>(List.of(7, 11, 30, 40, 42, 43))),
                new Lotto(new ArrayList<>(List.of(2, 13, 22, 32, 38, 45))),
                new Lotto(new ArrayList<>(List.of(1, 3, 5, 14, 22, 45)))
        );
        player.setLottos(lottos);
        List<LottoReward> lottoRewards = lottoChecker.calculate(lottos);

        // when
        Statistics statistics = new Statistics(lottoRewards, player);
        statistics.analysis();

        // then
        assertThat(statistics.getWinningHistory().get(LottoReward.FIFTH)).isEqualTo(1);
    }


}