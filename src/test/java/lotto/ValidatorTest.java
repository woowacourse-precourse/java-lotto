package lotto;

import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import lotto.validation.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void init() {
        this.validator = new Validator();
    }

    @Test
    @DisplayName("String에서 int로 변환이 불가능 할 시 false를 리턴한다.")
    void isNumericTest() {
        //given
        String input = "123a";
        //when
        boolean result = validator.isNumeric(input);
        //then
        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("입력한 돈이 1000원 단위가 아닐 시 false를 리턴한다.")
    void isCorrectUnitTest() {
        //given
        String inputMoney = "15300";
        //when
        boolean result = validator.isCorrectUnit(inputMoney);
        //then
        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("입력한 당첨번호가 콤마로 구분된 6자리 문자가 아닐 시 false를 리턴한다.")
    void isCorrectDigitAtCommaTest() {
        //given
        String winningNumberInput = "5,4,7,2,1";
        //when
        boolean result = validator.isCorrectDigitAtComma(winningNumberInput);
        //then
        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("입력한 당첨번호가 콤마로 구분된 숫자가 아닐 시 false를 리턴한다.")
    void isNumericAtCommaTest() {
        //given
        String winningNumberInput = "1,3,5,a,4,7";
        //when
        boolean result = validator.isNumericAtComma(winningNumberInput);
        //then
        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("입력한 당첨번호가 1~45 사이의 숫자가 아닐 시 false를 리턴한다.")
    void isExistInBoundaryAtCommaTest() {
        //given
        String winningNumberInput = "47,2,3,5,6,9";
        //when
        boolean result = validator.isExistInBoundaryAtComma(winningNumberInput);
        //then
        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("입력한 당첨번호들 간에 중복된 번호가 있으면 false를 리턴한다.")
    void isUniqueNumberAtCommaTest() {
        //given
        String winningNumberInput = "1,1,2,3,4,5";
        //when
        boolean result = validator.isUniqueNumberAtComma(winningNumberInput);
        //then
        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("입력한 보너스 번호가 1~45 사이의 숫자가 아닐 시 false를 리턴한다.")
    void isExistInBoundaryTest() {
        //given
        String bonusNumber = "47";
        //when
        boolean result = validator.isExistInBoundary(bonusNumber);
        //then
        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("입력한 보너스 번호가 당첨번호와 겹칠 경우 false를 리턴한다.")
    void isUniqueNumberTest() {
        //given
        HashSet<Integer> winningNumbers = new HashSet<>(List.of(1,2,3,4,5,6));
        String bonusNumber = "1";
        //when
        boolean result = validator.isUniqueNumber(bonusNumber, winningNumbers);
        //then
        assertThat(result).isEqualTo(false);
    }
}
