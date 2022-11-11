package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class WinningNumberTest {

    @DisplayName("범위 확인 테스트 - 정상 테스트")
    @Test
    void givenList_whenValidateForRange_thenNothingHappen() {
        //Given
        List<Integer> list = List.of(1, 2, 4, 45, 13);

        //When
        Throwable t = catchThrowable(() -> validateForRange(list));

        //Then
        assertThat(t).doesNotThrowAnyException();
    }

    @DisplayName("범위 확인 테스트 - 범위 오류")
    @Test
    void givenList_whenValidateForRange_thenThrowException() {
        //Given
        List<Integer> list = List.of(1, 2, 4, 46, 1);

        //When
        Throwable t = catchThrowable(() -> validateForRange(list));

        //Then
        assertThat(t)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_RANGE_ERROR_MESSAGE);
    }

    private void validateForRange(List<Integer> WinningNumber) {
        if (!WinningNumber.stream().allMatch(num -> num >= MIN_LOTTO_NUMBER && num <= MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

}
