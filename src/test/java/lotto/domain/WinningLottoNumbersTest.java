package lotto.domain;

import lotto.exception.BonusNumberException;
import lotto.service.ProduceWinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoNumbersTest {
    WinningLottoNumbers winningLottoNumbers;
    List<Integer> expected = Arrays.asList(1,2,3,4,5,6);

    @BeforeEach
    void setUp() {
        winningLottoNumbers = new WinningLottoNumbers();
    }


    @Test
    @DisplayName("보너스 번호 숫자외의 값")
    public void bonusNumberNotNumber() {
        assertThatThrownBy(() -> new BonusNumberException().fullException("12a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 로또 번호 올바르게 생성되는가")
    void getWinningLottoNumbers() {
        List<Integer> winningNumbers = winningLottoNumbers.getWinningLottoNumbers("1,2,3,4,5,6");
        Assertions.assertThat(winningNumbers).isEqualTo(expected);
    }

    @Test
    @DisplayName("크기가 6이 아닐 경우 예외 발생")
    void winningNumbersException() {
        Assertions.assertThatThrownBy(() -> new WinningLottoNumbers().getWinningLottoNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    @DisplayName("45가 넘을 경우 예외 발생")
    void overNumber() {
        Assertions.assertThatThrownBy(() -> new WinningLottoNumbers().getWinningLottoNumbers("1,2,3,4,5,55"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    @DisplayName("중복 예외 발생")
    void duplicatedNumber() {
        Assertions.assertThatThrownBy(() -> new WinningLottoNumbers().getWinningLottoNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
