package lotto;

import lotto.numbers.WinningNumbers;
import lotto.numbers.WinningNumbersImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class WinningNumbersTest {
    @Test
    void 중복_보너스_숫자_테스트() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;
        //when
        Throwable throwable = catchThrowable(() -> {
            WinningNumbers winningNumbers = new WinningNumbersImpl(numbers, bonusNumber);
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_범위_초과_보너스_숫자_테스트() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);
        int bonusNumber = 6;
        //when
        Throwable throwable = catchThrowable(() -> {
            WinningNumbers winningNumbers = new WinningNumbersImpl(numbers, bonusNumber);
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상_테스트() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 45;
        //when
        WinningNumbers winningNumbers = new WinningNumbersImpl(numbers, bonusNumber);
        //then
        assertThat(winningNumbers)
                .isNotNull();
    }
}
