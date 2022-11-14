package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoProgramTest {
    LottoProgram lottoProgram = new LottoProgram();

    @DisplayName("중복된 당첨번호를 입력하면 예외가 발생한다.")
    @Test
    void inputWinningNumberByDuplicatedNumber() {
        List<Integer> numbers = Arrays.asList(1,1,2,3,4,5);
        int bonusNumber = 10;

        Assertions.assertThatThrownBy(
                () -> lottoProgram.createWinningLotto(numbers,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개가 아닌 당첨번호를 입력하면 예외가 발생한다.")
    @Test
    void inputWinningNumberBySizeOver() {
        List<Integer> numbers = Arrays.asList(1,9,8,7,6,5,4);
        int bonusNumber = 10;

        Assertions.assertThatThrownBy(
                () -> lottoProgram.createWinningLotto(numbers,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 벗어난 보너스 번호를 입력하면 예외가 발생한다.")
    @Test
    void inputBonusNumberOverRange() {
        List<Integer> numbers = Arrays.asList(1,9,8,7,6,5,4);
        int bonusNumber = 47;

        Assertions.assertThatThrownBy(
                () -> lottoProgram.createWinningLotto(numbers,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}