package lotto;

import enumCollections.RankNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheckerTest {
    @DisplayName("로또번호와 당첨번호를 비교하여 당첨된 등수를 알 수 있다.")
    @Test
    void compareLottoNumbersTest() {
        assertThat(Checker.getRank(5)).isEqualTo(RankNumber.THIRD);
    }

    @DisplayName("당첨번호와 일치하는 번호의 개수를 알 수 있다.")
    @Test
    void countSameNumbersTest() {
        Checker.winningNumbers = List.of(1, 2, 3, 7, 8, 9);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(Checker.countSameNumbers(lotto)).isEqualTo(3);
    }

    @DisplayName("당첨번호와 로또 번호를 비교한다.")
    @Test
    void compareLottoTest() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(3, 4, 5, 6, 7, 8)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9))
        );
        Buyer buyer = new Buyer();
        buyer.buy(lottos);
        assertThat(Checker.compareAllLottos(buyer, List.of(1, 2, 3, 7, 8, 9), 1))
                .isEqualTo(
                        getExpected(1, 0, 0, 0, 2)
                );
    }

    @DisplayName("2등 당첨 확인")
    @Test
    void winSecondPrizeTest() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(3, 4, 5, 6, 7, 8)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(1, 2, 3, 7, 8, 10))
        );
        Buyer buyer = new Buyer();
        buyer.buy(lottos);
        assertThat(Checker.compareAllLottos(buyer, List.of(1, 2, 3, 7, 8, 9), 3))
                .isEqualTo(
                        getExpected(1, 1, 0, 0, 2)
                );
    }

    private EnumMap<RankNumber, Integer> getExpected(
            int first,
            int second,
            int third,
            int fourth,
            int fifth
    ) {
        EnumMap<RankNumber, Integer> expected = new EnumMap<>(RankNumber.class);
        expected.put(RankNumber.FIRST, first);
        expected.put(RankNumber.SECOND, second);
        expected.put(RankNumber.THIRD, third);
        expected.put(RankNumber.FOURTH, fourth);
        expected.put(RankNumber.FIFTH, fifth);
        return expected;
    }

//    @DisplayName("총 당첨 금액 계산")
//    @Test
//    void getTotalWinningsTest() {
//        Kiosk.resultStatistics = new EnumMap<RankNumber, Integer>(RankNumber);
//        assertThat(Calculator.getTotalWinnings(Kiosk.resultStatistics)).isEqualTo(105000);
//    }
//
//    @DisplayName("수익률 계산")
//    @Test
//    void getYieldTest() {
//        Kiosk.resultStatistics = new int[]{0, 0, 0, 2, 1};
//        assertThat(Calculator.getYield(8000, Kiosk.resultStatistics)).isEqualTo(1300.0f);
//    }
//
//    @DisplayName("수익률 반올림 검사")
//    @Test
//    void getRoundedYieldTest() {
//        assertThat(Calculator.getRoundedYield(1300.145f)).isEqualTo(1300.15f);
//    }
}
