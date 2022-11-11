package lotto.domain;

import lotto.domain.enums.Number;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertSame;

class ManagerTest {

    Manager manager = new Manager();

    @Test
    void 구입금액에_따른_로또_장수_반환_테스트() {
        int money = 8000;
        int expect = 8;
        int result = manager.changeLottoCount(money);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void 구입금액에_따른_로또_장수_반환_테스트_0() {
        int money = 0;
        int expect = 0;
        int result = manager.changeLottoCount(money);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void 잘못된_구입금액_입력_100단위() {
        int money = 8500;
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> manager.changeLottoCount(money));
    }

    @Test
    void 잘못된_구입금액_입력_음수() {
        int money = -10000;
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> manager.changeLottoCount(money));
    }

    @Test
    void getCorrectCountTest() {
        List<Integer> userLotto = new ArrayList<>(List.of(6,5,4,3,2,1));
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,7));
        manager.setWinningNumbers(winningNumbers);

        int expect = 5;
        int result = manager.getCorrectCount(userLotto);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void isCorrectBonusTest() {
        List<Integer> userLotto = new ArrayList<>(List.of(6,5,4,3,2,1));
        manager.setBonusNumber(1);

        boolean result = manager.isCorrectBonus(userLotto);

        assertThat(result).isEqualTo(true);
    }

    @Test
    void judgeRankTest() {
        assertAll(
            () -> assertSame(manager.judgeRank(3, true), Number.FIVE.getValue()),
            () -> assertSame(manager.judgeRank(4, true), Number.FOUR.getValue()),
            () -> assertSame(manager.judgeRank(5, false), Number.THREE.getValue()),
            () -> assertSame(manager.judgeRank(5, true), Number.TWO.getValue()),
            () -> assertSame(manager.judgeRank(6, true), Number.ONE.getValue()),
            () -> assertSame(manager.judgeRank(2, true), Number.ZERO.getValue()),
            () -> assertSame(manager.judgeRank(1, true), Number.ZERO.getValue()),
            () -> assertSame(manager.judgeRank(0, true), Number.ZERO.getValue())
        );
    }

}