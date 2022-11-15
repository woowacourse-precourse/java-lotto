package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.LinkedList;
import java.util.List;
import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.model.RANKING;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 오름차순으로 정렬되어있지 않으면 예외가 발생한다.")
    @Test
    void createByNotSortedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 6, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복없는 6개의 번호를 가진 8개의 로또를 생성한다.")
    @Test
    void createLotteriesByZeroSize() {
        LottoController controller = new LottoController();
        List<Lotto> lotteries = controller.createLotteries(8);
        assertThat(lotteries)
            .hasSize(8)
            .allMatch(lotto -> lotto.getNumbers().size() == 6)
            .doesNotHaveDuplicates();
    }

    @DisplayName("0개 로또 생성을 시도하여 예외가 발생한다.")
    @Test
    void createLotteriesByEightSize() {
        LottoController controller = new LottoController();
        assertThatThrownBy(() -> {
            new Lotto(List.of(1, 2, 3, 4, 5, 6));
            controller.createLotteries(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호를 제외하고 번호 6개 모두 맞춰서 1등을 받는다.")
    @Test
    void match6NumberExcludeLuckyNo() {
        Lotto luckyLotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        Lotto userLotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        int luckyNo = 45;
        assertThat(userLotto.matchLottoWithLuckyNumber(luckyLotto, luckyNo))
            .isEqualTo(RANKING.FIRST);
    }

    @DisplayName("보너스 번호를 제외하고 번호 5개를 맞춰서 3등을 받는다.")
    @Test
    void match5NumberExcludeLuckyNo() {
        Lotto luckyLotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        Lotto userLotto = new Lotto(List.of(1, 3, 5, 7, 9, 15));
        int luckyNo = 45;
        assertThat(userLotto.matchLottoWithLuckyNumber(luckyLotto, luckyNo))
            .isEqualTo(RANKING.THIRD);
    }

    @DisplayName("보너스 번호를 제외하고 번호 4개를 맞춰서 4등을 받는다.")
    @Test
    void match4NumberExcludeLuckyNo() {
        Lotto luckyLotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        Lotto userLotto = new Lotto(List.of(1, 3, 5, 7, 10, 15));
        int luckyNo = 45;
        assertThat(userLotto.matchLottoWithLuckyNumber(luckyLotto, luckyNo))
            .isEqualTo(RANKING.FORTH);
    }

    @DisplayName("보너스 번호를 제외하고 번호 3개를 맞춰서 5등을 받는다.")
    @Test
    void match3NumberExcludeLuckyNo() {
        Lotto luckyLotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        Lotto userLotto = new Lotto(List.of(1, 3, 5, 8, 10, 15));
        int luckyNo = 45;
        assertThat(userLotto.matchLottoWithLuckyNumber(luckyLotto, luckyNo))
            .isEqualTo(RANKING.FIFTH);
    }

    @DisplayName("보너스 번호를 제외하고 번호 2개이하를 맞춰서 등수를 받지 않는다.")
    @Test
    void matchUnder2NumberExcludeLuckyNo() {
        Lotto luckyLotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        Lotto userLotto = new Lotto(List.of(1, 3, 4, 8, 10, 15));
        int luckyNo = 45;
        assertThat(userLotto.matchLottoWithLuckyNumber(luckyLotto, luckyNo))
            .isEqualTo(RANKING.NONE);
        userLotto = new Lotto(List.of(1, 4, 6, 8, 10, 15));
        assertThat(userLotto.matchLottoWithLuckyNumber(luckyLotto, luckyNo))
            .isEqualTo(RANKING.NONE);
        userLotto = new Lotto(List.of(2, 4, 6, 8, 10, 15));
        assertThat(userLotto.matchLottoWithLuckyNumber(luckyLotto, luckyNo))
            .isEqualTo(RANKING.NONE);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되어 예외를 발생한다.")
    @Test
    void match6NumberAndLuckyNo() {
        Lotto luckyLotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        Lotto userLotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        int luckyNo = 11;
        assertThatThrownBy(() -> userLotto.matchLottoWithLuckyNumber(luckyLotto, luckyNo))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호를 맞추고 번호 5개를 맞춰서 2등을 탄다.")
    @Test
    void match5NumberAndLuckyNo() {
        Lotto luckyLotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        Lotto userLotto = new Lotto(List.of(1, 3, 5, 7, 9, 15));
        int luckyNo = 15;
        assertThat(userLotto.matchLottoWithLuckyNumber(luckyLotto, luckyNo))
            .isEqualTo(RANKING.SECOND);
    }

    @DisplayName("보너스 번호를 맞추고 번호 4개를 맞춰서 3등을 받는다.")
    @Test
    void match4NumberAndLuckyNo() {
        Lotto luckyLotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        Lotto userLotto = new Lotto(List.of(1, 3, 5, 7, 10, 15));
        int luckyNo = 15;
        assertThat(userLotto.matchLottoWithLuckyNumber(luckyLotto, luckyNo))
            .isEqualTo(RANKING.THIRD);
    }

    @DisplayName("보너스 번호를 맞추고 번호 3개를 맞춰서 4등을 받는다.")
    @Test
    void match3NumberAndLuckyNo() {
        Lotto luckyLotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        Lotto userLotto = new Lotto(List.of(1, 3, 5, 8, 10, 15));
        int luckyNo = 15;
        assertThat(userLotto.matchLottoWithLuckyNumber(luckyLotto, luckyNo))
            .isEqualTo(RANKING.FORTH);
    }

    @DisplayName("보너스 번호를 맞추고 번호 2개이 맞춰서 5등을 받는다.")
    @Test
    void match2NumberAndLuckyNo() {
        Lotto luckyLotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        Lotto userLotto = new Lotto(List.of(1, 3, 4, 8, 10, 15));
        int luckyNo = 15;
        assertThat(userLotto.matchLottoWithLuckyNumber(luckyLotto, luckyNo))
            .isEqualTo(RANKING.FIFTH);
    }

    @DisplayName("보너스 번호를 맞추고 번호 1개 이하로 맞춰서 등수를 받지 못한다.")
    @Test
    void matchUnder1NumberAndLuckyNo() {
        Lotto luckyLotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        Lotto userLotto = new Lotto(List.of(1, 4, 6, 8, 10, 15));
        int luckyNo = 15;
        assertThat(userLotto.matchLottoWithLuckyNumber(luckyLotto, luckyNo))
            .isEqualTo(RANKING.NONE);
        userLotto = new Lotto(List.of(2, 4, 6, 8, 10, 15));
        assertThat(userLotto.matchLottoWithLuckyNumber(luckyLotto, luckyNo))
            .isEqualTo(RANKING.NONE);
    }

    @DisplayName("복권 5개중 5개 모두 못맞춰서 0의 수익률을 낸다.")
    @Test
    void generateEarningRate0() {
        Lotto luckyLotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        int luckyNo = 15;
        List<Lotto> userLotteries = new LinkedList<>();
        userLotteries.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        userLotteries.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        userLotteries.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        userLotteries.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        userLotteries.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        LottoController controller = new LottoController();
        double result = controller.generateEarningsRate(userLotteries, luckyLotto, luckyNo);
        assertThat(result)
            .isEqualTo(0);
    }

    @DisplayName("복권 8개중 1개가 3등이어서 62.5%의 수익률 낸다.")
    @Test
    void generateEarningRate62_5() {
        Lotto luckyLotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        int luckyNo = 15;
        List<Lotto> userLotteries = new LinkedList<>();
        userLotteries.add(new Lotto(List.of(1, 3, 5, 8, 10, 12)));
        userLotteries.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        userLotteries.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        userLotteries.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        userLotteries.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        userLotteries.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        userLotteries.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        userLotteries.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        LottoController controller = new LottoController();
        double result = controller.generateEarningsRate(userLotteries, luckyLotto, luckyNo);
        assertThat(result)
            .isEqualTo(62.5);
    }

    @DisplayName("복권 8개중 1개가 1등에 당첨되어 25_000_000%의 수익을 낸다.")
    @Test
    void generateEarningRateOver100() {
        Lotto luckyLotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        int luckyNo = 15;
        List<Lotto> userLotteries = new LinkedList<>();
        userLotteries.add(new Lotto(List.of(1, 3, 5, 7, 9, 11)));
        userLotteries.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        userLotteries.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        userLotteries.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        userLotteries.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        userLotteries.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        userLotteries.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        userLotteries.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        LottoController controller = new LottoController();
        double result = controller.generateEarningsRate(userLotteries, luckyLotto, luckyNo);
        assertThat(result)
            .isEqualTo(25_000_000.0);
    }
}
