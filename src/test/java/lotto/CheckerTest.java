package lotto;

import enumCollections.RankNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheckerTest {
    static Buyer buyer;

    @BeforeEach
    void initializeBuyer() {
        buyer = new Buyer();
        buyer.buy(
                List.of(
                        new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                        new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                        new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                        new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                        new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                        new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                        new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                        new Lotto(List.of(1, 3, 5, 14, 22, 45))
                )
        );
    }

    @DisplayName("로또번호와 당첨번호를 비교하여 당첨된 등수를 알 수 있다.")
    @Test
    void compareLottoNumbersTest() {
        initializeParameters(
                List.of(1, 8, 11, 31, 42, 45),
                2
        );
        assertThat(Checker.compareAllLottos(
                buyer,
                Checker.winningNumbers,
                Checker.bonusNumber
        )).isEqualTo(getExpected(0, 0, 1, 0, 0));
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

    static void initializeParameters(List<Integer> winningNumbers, int bonusNumber) {
        Checker.winningNumbers = winningNumbers;
        Checker.bonusNumber = bonusNumber;
    }
}
