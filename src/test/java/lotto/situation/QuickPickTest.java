package lotto.situation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QuickPickTest {

    private List<Integer> quickPickNumbers = QuickPick.create();
    @DisplayName("로또 번호의 개수는 6개이다.")
    @Test
    void isNumberLengthSix() {
        assertThat(quickPickNumbers.size()).isEqualTo(LottoState.LENGTH.number());
    }
    @DisplayName("번호가 1~45 범위 안이다.")
    @Test
    void inBoundary() {
        for (int number : quickPickNumbers) {
            assertThat(number).isBetween(LottoState.START.number(), LottoState.END.number());
        }
    }
    @DisplayName("번호에 중복이 없다.")
    @Test
    void nonDuplicated() {
        Set<Integer> quickPickNumberSet = new HashSet<>(quickPickNumbers);
        assertThat(quickPickNumbers.size()).isEqualTo(quickPickNumberSet.size());
    }
    @DisplayName("반복 시행시 번호들이 등장하는 비율이 1/45이다.")
    @Test
    void numberRatio() {
        final double ERROR_RANGE = 0.01;
        int numberTrials = 5000000;
        double[] numberCounts = new double[LottoState.RANGE.number()];
        for (int trial = 0; trial < numberTrials; trial++) {
            List<Integer> quickPickNumbers = QuickPick.create();
            for (int number : quickPickNumbers) {
                numberCounts[number - LottoState.START.number()]++;
            }
        }
        for (double numberCount : numberCounts) {
            assertThat(numberCount / numberTrials / LottoState.LENGTH.number())
                    .isBetween((1 - ERROR_RANGE) / LottoState.RANGE.number(),
                            (1 + ERROR_RANGE) / LottoState.RANGE.number());
        }
    }
    @DisplayName("번호가 오름차순이다.")
    @Test
    void isAscendingOrder() {
        for (int i = 0; i < quickPickNumbers.size() - 1; i++) {
            assertThat(quickPickNumbers.get(i)).isLessThan(quickPickNumbers.get(i + 1));
        }
    }
}
