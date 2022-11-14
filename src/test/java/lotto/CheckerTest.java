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
        Kiosk.winningNumbers = List.of(1, 2, 3, 7, 8, 9);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(Checker.countSameNumbers(lotto)).isEqualTo(3);
    }

    @DisplayName("당첨번호와 로또 번호를 비교한다.")
    @Test
    void compareLottoTest() {
        Kiosk.winningNumbers = List.of(1, 2, 3, 7, 8, 9);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(3, 4, 5, 6, 7, 8)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9))
        );
        Buyer buyer = new Buyer();
        buyer.buy(lottos);
        Checker.compareAll(buyer);
        assertThat(Checker.resultStatistics).isEqualTo(new Integer[]{1, 0, 0, 0, 2});
    }

    @DisplayName("2등 당첨 확인")
    @Test
    void winSecondPrizeTest() {
        Kiosk.winningNumbers = List.of(1, 2, 3, 7, 8, 9);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(3, 4, 5, 6, 7, 8)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(1, 2, 3, 7, 8, 10))
        );
        Buyer buyer = new Buyer();
        buyer.buy(lottos);
        EnumMap<RankNumber, Integer> expected = new EnumMap<RankNumber, Integer>(RankNumber.class);
        expected.put(RankNumber.FIRST, 1);
        expected.put(RankNumber.SECOND, 1);
        expected.put(RankNumber.THIRD, 0);
        expected.put(RankNumber.FOURTH, 0);
        expected.put(RankNumber.FIFTH, 2);
        assertThat(Checker.compareAll(buyer)).isEqualTo(expected);
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
