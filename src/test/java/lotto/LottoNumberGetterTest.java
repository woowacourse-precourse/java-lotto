package lotto;

import lotto.data.LottoNumber;
import lotto.input.LottoNumberGetter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberGetterTest {
    @DisplayName("사용자가 올바른 형식의 당첨 번호와 보너스 번호를 입력할 경우, 이를 LottoNumber 타입 변수에 담아 반환한다.")
    @Test
    void getLottoNumberTest() {
        LottoNumberGetter lottoNumberGetter = new LottoNumberGetter();

        String winningNumbers = "1,2,3,6,10,45";
        String bonusNumber = "7";
        String input = winningNumbers + System.lineSeparator() + bonusNumber;

        System.setIn(new ByteArrayInputStream((input).getBytes()));
        LottoNumber lottoNumber = lottoNumberGetter.getLottoNumber();

        List<Integer> numbers = lottoNumber.getLotto().getNumbers();
        assertThat(numbers.size()).isEqualTo(6);
        List<Integer> expected = new ArrayList<>(List.of(1, 2, 3, 6, 10, 45));
        int index = 0;
        for (Integer number : numbers) {
            assertThat(number).isEqualTo(expected.get(index++));
        }

        assertThat(lottoNumber.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("사용자가 올바르지 않은 형식의 당첨 번호를 입력할 경우, 예외를 발생시킨다")
    @Test
    void throwExceptionIfNotValidWinningNumbers_1() {
        LottoNumberGetter lottoNumberGetter = new LottoNumberGetter();
        String winningNumbers = "1,2,3,6,10,10";
        assertThatThrownBy(
                () -> lottoNumberGetter.throwExceptionIfNotValidWinningNumbers(lottoNumberGetter.tokenizeWinningNumberInput(winningNumbers)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 올바르지 않은 형식의 당첨 번호를 입력할 경우, 예외를 발생시킨다")
    @Test
    void throwExceptionIfNotValidWinningNumbers_2() {
        LottoNumberGetter lottoNumberGetter = new LottoNumberGetter();
        String winningNumbers = "1,2,3,6,10";
        assertThatThrownBy(
                () -> lottoNumberGetter.throwExceptionIfNotValidWinningNumbers(lottoNumberGetter.tokenizeWinningNumberInput(winningNumbers)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 올바르지 않은 형식의 당첨 번호를 입력할 경우, 예외를 발생시킨다")
    @Test
    void throwExceptionIfNotValidWinningNumbers_3() {
        LottoNumberGetter lottoNumberGetter = new LottoNumberGetter();
        String winningNumbers = "1,2,3,6,10,1";
        assertThatThrownBy(
                () -> lottoNumberGetter.throwExceptionIfNotValidWinningNumbers(lottoNumberGetter.tokenizeWinningNumberInput(winningNumbers)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 올바르지 않은 형식의 보너스 번호를 입력할 경우, 예외를 발생시킨다")
    @Test
    void throwExceptionIfNotValidBonusNumber_1() {
        LottoNumberGetter lottoNumberGetter = new LottoNumberGetter();
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        String bonusNumber = "bonus";
        assertThatThrownBy(
                () -> lottoNumberGetter.throwExceptionIfNotValidBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 올바르지 않은 형식의 보너스 번호를 입력할 경우, 예외를 발생시킨다")
    @Test
    void throwExceptionIfNotValidBonusNumber_2() {
        LottoNumberGetter lottoNumberGetter = new LottoNumberGetter();
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        String bonusNumber = "4";
        assertThatThrownBy(
                () -> lottoNumberGetter.throwExceptionIfNotValidBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 올바르지 않은 형식의 보너스 번호를 입력할 경우, 예외를 발생시킨다")
    @Test
    void throwExceptionIfNotValidBonusNumber_3() {
        LottoNumberGetter lottoNumberGetter = new LottoNumberGetter();
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        String bonusNumber = "46";
        assertThatThrownBy(
                () -> lottoNumberGetter.throwExceptionIfNotValidBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
