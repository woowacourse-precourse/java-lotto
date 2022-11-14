package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Application.generateLottoNumbers;
import static lotto.Application.purchasedLottos;
import static lotto.Application.noOfLottos;
import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;

class GenerateLottoNumbersMethodTest {
    static int index = 0;

    @Test
    void generateLottoNumbers_메소드_테스트1() {
        noOfLottos = 1;
        assertRandomUniqueNumbersInRangeTest(() -> {
                generateLottoNumbers();
                assertThat(purchasedLottos.get(index++))
                        .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
                }, List.of(2, 3, 4, 5, 1, 6)
        );
    }

    @Test
    void generateLottoNumbers_메소드_테스트2() {
        noOfLottos = 1;
        assertRandomUniqueNumbersInRangeTest(() -> {
                    generateLottoNumbers();
                    assertThat(purchasedLottos.get(index++))
                            .isEqualTo(List.of(2, 7, 13, 29, 37, 45));
                }, List.of(45, 2, 7, 29, 13, 37)
        );
    }

    @Test
    void generateLottoNumbers_메소드_테스트3() {
        noOfLottos = 1;
        assertRandomUniqueNumbersInRangeTest(() -> {
                    generateLottoNumbers();
                    assertThat(purchasedLottos.get(index++))
                            .isEqualTo(List.of(5, 7, 27, 31, 43, 45));
                }, List.of(7, 27, 31, 5, 43, 45)
        );
    }
}