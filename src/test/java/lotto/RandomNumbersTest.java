package lotto;

import lotto.domain.LottoCondition;
import lotto.domain.RandomNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class RandomNumbersTest {
    private final int minNumber = LottoCondition.MIN_NUMBER.getNumber();
    private final int maxNumber = LottoCondition.MAX_NUMBER.getNumber();
    private final int count = LottoCondition.COUNT.getNumber();

    @DisplayName("랜덤 숫자 생성 성공")
    @Test
    void createRandomNumbersSuccess() {
        assertThatCode(() -> new RandomNumbers(minNumber, maxNumber, count))
                .doesNotThrowAnyException();
    }

    @DisplayName("랜덤 숫자 생성 시 겹치는 숫자는 없어야 한다.")
    @Test
    void createRandomNumbersToCheckOverlapping() {
        RandomNumbers randomNumbers = new RandomNumbers(minNumber, maxNumber, count);
        Set<Integer> numbersExceptOverlapped = new HashSet<>(randomNumbers.getRandomNumbers());

        assertThat(randomNumbers.getRandomNumbers().size()).isEqualTo(numbersExceptOverlapped.size());
    }

    @DisplayName("랜덤 숫자 생성 시 범위에 맞는 숫자가 생성되어야 한다.")
    @Test
    void createRandomNumbersToCheckCorrectRange() {
        RandomNumbers randomNumbers = new RandomNumbers(minNumber, maxNumber, count);
        randomNumbers.getRandomNumbers()
                        .forEach(number -> {
                            assertThat(number)
                                    .isGreaterThanOrEqualTo(minNumber)
                                    .isLessThanOrEqualTo(maxNumber);
                        });
    }

    @DisplayName("랜덤 숫자 생성 시 입력 개수에 맞는 숫자를 생성해야 한다.")
    @Test
    void createRandomNumbersToCheckCorrectCount() {
        RandomNumbers randomNumbers = new RandomNumbers(minNumber, maxNumber, count);
        assertThat(randomNumbers.getRandomNumbers()).hasSize(count);
    }
}
