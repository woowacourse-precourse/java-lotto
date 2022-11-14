package lotto.domain;

import lotto.domain.enums.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ManagerTest {

    Manager manager;

    @BeforeEach
    void beforeEach() {
        manager = new Manager();
    }

    @Test
    void 구입금액에_따른_로또_반환_테스트() {
        double money = 8000;
        int expect = 8;
        List<Lotto> lottos = manager.changeLottos(money);

        assertThat(lottos.size()).isEqualTo(expect);
    }

    @Test
    void 구입금액에_따른_로또_반환_테스트_0() {
        double money = 0;
        int expect = 0;
        List<Lotto> lottos = manager.changeLottos(money);

        assertThat(lottos.size()).isEqualTo(expect);
    }

    @Test
    void getCorrectCountTest() {
        Lotto userLotto = new Lotto(new ArrayList<>(List.of(6,5,4,3,2,1)));
        manager.setWinningNumbers("1,2,3,4,5,7");

        int expect = 5;
        int result = manager.getCorrectCount(userLotto);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void judgeRankTest() {
        assertAll(
            () -> assertThat(manager.judgeRank(0, true)).isEqualTo(Number.ZERO.getValue()),
            () -> assertThat(manager.judgeRank(1, true)).isEqualTo(Number.ZERO.getValue()),
            () -> assertThat(manager.judgeRank(2, true)).isEqualTo(Number.ZERO.getValue()),
            () -> assertThat(manager.judgeRank(3, true)).isEqualTo(Number.FIVE.getValue()),
            () -> assertThat(manager.judgeRank(4, true)).isEqualTo(Number.FOUR.getValue()),
            () -> assertThat(manager.judgeRank(5, false)).isEqualTo(Number.THREE.getValue()),
            () -> assertThat(manager.judgeRank(5, true)).isEqualTo(Number.TWO.getValue()),
            () -> assertThat(manager.judgeRank(6, true)).isEqualTo(Number.ONE.getValue())
        );
    }

    @Test
    void getWinningAmountTest() {
        assertAll(
            () -> assertThat(manager.getWinningAmount(0)).isEqualTo(Number.ZERO.getValue()),
            () -> assertThat(manager.getWinningAmount(1)).isEqualTo(Number.FIRST_WINNING_AMOUNT.getValue()),
            () -> assertThat(manager.getWinningAmount(2)).isEqualTo(Number.SECOND_WINNING_AMOUNT.getValue()),
            () -> assertThat(manager.getWinningAmount(3)).isEqualTo(Number.THIRD_WINNING_AMOUNT.getValue()),
            () -> assertThat(manager.getWinningAmount(4)).isEqualTo(Number.FOURTH_WINNING_AMOUNT.getValue()),
            () -> assertThat(manager.getWinningAmount(5)).isEqualTo(Number.FIFTH_WINNING_AMOUNT.getValue())
        );
    }
}