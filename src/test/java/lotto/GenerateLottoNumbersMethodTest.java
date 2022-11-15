package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Application.generateLottoNumbers;
import static lotto.Application.purchasedLottos;
import static lotto.Application.noOfLottos;
import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;

class GenerateLottoNumbersMethodTest {
    static int index = 0;

    @DisplayName("생성된 당첨 번호는 정렬된다(1).")
    @Test
    void generateLottoNumbersMethodTest1() {
        noOfLottos = 1;
        assertRandomUniqueNumbersInRangeTest(() -> {
                generateLottoNumbers();
                assertThat(purchasedLottos.get(index++))
                        .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
                }, List.of(2, 3, 4, 5, 1, 6)
        );
    }

    @DisplayName("생성된 당첨 번호는 정렬된다(2).")
    @Test
    void generateLottoNumbersMethodTest2() {
        noOfLottos = 1;
        assertRandomUniqueNumbersInRangeTest(() -> {
                    generateLottoNumbers();
                    assertThat(purchasedLottos.get(index++))
                            .isEqualTo(List.of(2, 7, 13, 29, 37, 45));
                }, List.of(45, 2, 7, 29, 13, 37)
        );
    }
}