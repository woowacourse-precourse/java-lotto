package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimulatorTest {
    @DisplayName("구입금액이 1,000원 단위가 아닐 시 예외가 발생한다.")
    @Test
    void invalidPurchasePriceMultiple() {
        assertThatThrownBy(() -> new Simulator(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 0일 경우 예외가 발생한다.")
    @Test
    void invalidPurchasePriceZero() {
        assertThatThrownBy(() -> new Simulator(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 음수일 경우 예외가 발생한다.")
    @Test
    void invalidPurchasePriceNegative() {
        assertThatThrownBy(() -> new Simulator(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1,000원 단위일 경우 정상 처리한다.")
    @Test
    void validPurchasePrice() {
        Simulator simulator = new Simulator(2000);
    }

    @DisplayName("유효한 구입금액은 알맞은 수량으로 변환된다. (Case 1)")
    @Test
    void validPurchasePriceCase1() {
        Simulator simulator = new Simulator(2000);
        assertThat(simulator.getQuantity()).isEqualTo(2);
    }

    @DisplayName("유효한 구입금액은 알맞은 수량으로 변환된다. (Case 2)")
    @Test
    void validPurchasePriceCase2() {
        Simulator simulator = new Simulator(1000);
        assertThat(simulator.getQuantity()).isEqualTo(1);
    }

    @DisplayName("유효한 구입금액은 알맞은 수량으로 변환된다. (Case 3)")
    @Test
    void validPurchasePriceCase3() {
        Simulator simulator = new Simulator(14000);
        assertThat(simulator.getQuantity()).isEqualTo(14);
    }

    @DisplayName("복권 발행 출력 값 확인.")
    @Test
    void generateLottoStringOutputTest() {
        Simulator simulator = new Simulator(1000);
        assertRandomUniqueNumbersInRangeTest(
                () -> assertThat(simulator.generate().toString()).isEqualTo("[1, 2, 3, 4, 5, 6]"),
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("복권 발행 시 오름차순으로 정렬한다.")
    @Test
    void generateLottoStringOutputSortTest() {
        Simulator simulator = new Simulator(1000);
        assertRandomUniqueNumbersInRangeTest(
                () -> assertThat(simulator.generate().toString()).isEqualTo("[1, 2, 3, 4, 5, 6]"),
                List.of(6, 5, 4, 3, 2, 1)
        );
    }

    @DisplayName("보너스 번호가 1과 45 사이일 경우 정상 처리된다.")
    @Test
    void setBonusNumberByValidRange() {
        Simulator simulator = new Simulator(1000);
        simulator.setWinning(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 23);
    }

    @DisplayName("보너스 번호가 45보다 클 경우 예외가 발생한다.")
    @Test
    void setBonusNumberBiggerThanValidRange() {
        Simulator simulator = new Simulator(1000);
        assertThatThrownBy(
                () -> simulator.setWinning(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1보다 작을 경우 예외가 발생한다.")
    @Test
    void setBonusNumberLessThanValidRange() {
        Simulator simulator = new Simulator(1000);
        assertThatThrownBy(
                () -> simulator.setWinning(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 이미 속해있을 경우 예외가 발생한다.")
    @Test
    void setDuplicateBonusNumber() {
        Simulator simulator = new Simulator(1000);
        assertThatThrownBy(
                () -> simulator.setWinning(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1등부터 5등까지 5개 로또 결과 합산하기.")
    @Test
    void firstToFifthGeneratedLottoTest() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Simulator simulator = new Simulator(5000);
                    assertThat(

                            simulator
                                    .setWinning(winningLotto, bonus)
                                    .getStatistic()
                    )
                            .isEqualTo(List.of(1, 1, 1, 1, 1));
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 8, 9, 10)
        );
    }

    @DisplayName("미당첨 5개 로또 결과 합산하기.")
    @Test
    void fiveNothingGeneratedLottoTest() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Simulator simulator = new Simulator(5000);
                    assertThat(

                            simulator
                                    .setWinning(winningLotto, bonus)
                                    .getStatistic()
                    )
                            .isEqualTo(List.of(0, 0, 0, 0, 0));
                },
                List.of(7, 8, 9, 10, 11, 12),
                List.of(11, 12, 13, 14, 15, 16),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(17, 18, 19, 10, 11, 12),
                List.of(7, 8, 9, 10, 11, 12)
        );
    }

    @DisplayName("5개 중 1개 1등 로또 결과 합산하기.")
    @Test
    void oneFirstWinningGeneratedLottoTest() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Simulator simulator = new Simulator(5000);
                    assertThat(

                            simulator
                                    .setWinning(winningLotto, bonus)
                                    .getStatistic()
                    )
                            .isEqualTo(List.of(1, 0, 0, 0, 0));
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(11, 12, 13, 14, 15, 16),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(17, 18, 19, 10, 11, 12),
                List.of(7, 8, 9, 10, 11, 12)
        );
    }

    @DisplayName("5개 중 3개 2등 로또 결과 합산하기.")
    @Test
    void threeSecondWinningGeneratedLottoTest() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Simulator simulator = new Simulator(5000);
                    assertThat(

                            simulator
                                    .setWinning(winningLotto, bonus)
                                    .getStatistic()
                    )
                            .isEqualTo(List.of(0, 3, 0, 0, 0));
                },
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(17, 18, 19, 10, 11, 12),
                List.of(7, 8, 9, 10, 11, 12)
        );
    }

    @DisplayName("5개 중 5개 각기 다른 5등 로또 결과 합산하기.")
    @Test
    void fiveFifthWinningGeneratedLottoTest() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Simulator simulator = new Simulator(5000);
                    assertThat(

                            simulator
                                    .setWinning(winningLotto, bonus)
                                    .getStatistic()
                    )
                            .isEqualTo(List.of(0, 0, 0, 0, 5));
                },
                List.of(1, 2, 3, 10, 11, 12),
                List.of(2, 3, 4, 10, 11, 12),
                List.of(3, 4, 5, 10, 11, 12),
                List.of(4, 5, 6, 10, 11, 12),
                List.of(1, 3, 5, 10, 11, 12)
        );
    }

    @DisplayName("1등부터 5등까지 당첨 금액 환산하기")
    @Test
    void convertFirstPlaceToWinningPrice() {
        assertThat(Rank.valueOfRank(1).getWinningPrice()).isEqualTo(2_000_000_000);
        assertThat(Rank.valueOfRank(2).getWinningPrice()).isEqualTo(30_000_000);
        assertThat(Rank.valueOfRank(3).getWinningPrice()).isEqualTo(1_500_000);
        assertThat(Rank.valueOfRank(4).getWinningPrice()).isEqualTo(50_000);
        assertThat(Rank.valueOfRank(5).getWinningPrice()).isEqualTo(5_000);
    }

    @DisplayName("누적 등수를 누적 금액으로 환산하기 - 1")
    @Test
    void convertTotalWinsToTotalWinningPriceCase1() {
        List<Integer> wins = List.of(0, 0, 2, 1, 1);
        assertThat(Simulator.calculateTotalWinningPrice(wins)).isEqualTo(3_055_000);
    }

    @DisplayName("누적 등수를 누적 금액으로 환산하기 - 2")
    @Test
    void convertTotalWinsToTotalWinningPriceCase2() {
        List<Integer> wins = List.of(5, 4, 0, 0, 1);
        assertThat(Simulator.calculateTotalWinningPrice(wins)).isEqualTo(new BigInteger("10120005000"));
    }

    @DisplayName("누적 등수를 누적 금액으로 환산하기 - 3")
    @Test
    void convertTotalWinsToTotalWinningPriceCase3() {
        List<Integer> wins = List.of(0, 0, 3, 54, 214);
        assertThat(Simulator.calculateTotalWinningPrice(wins)).isEqualTo(8_270_000);
    }
}
