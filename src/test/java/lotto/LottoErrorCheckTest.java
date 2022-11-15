package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.LottoErrorCheck.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoErrorCheckTest {
    @DisplayName("로또 구입 금액이 1000원 미만인 경우")
    @Test
    void moneyUnderThousand() {
        assertThatThrownBy(() -> {
            String money = "500";
            moneyErrorCheck(money);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 영어로 입력된 경우")
    @Test
    void moneyEnglish() {
        assertThatThrownBy(() -> {
            String money = "thousand";
            moneyErrorCheck(money);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 구입 금액이 음수로 입력된 경우")
    @Test
    void moneyMinus() {
        assertThatThrownBy(() -> {
            String money = "-1000";
            moneyErrorCheck(money);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 구입 금액이 1000으로 나누어 떨이지지 않는 경우")
    @Test
    void moneyNotDividedThousand() {
        assertThatThrownBy(() -> {
            String money = "1100";
            moneyErrorCheck(money);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("당첨번호 입력 형식이 잘못된 경우 ")
    @Test
    void winningNumberFormatError() {
        assertThatThrownBy(() -> {
            String number = "1 2 3 4 5 6";
            List<String> numbers = Arrays.asList(number.split(","));
            winningNumberErrorCheck(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 6자리 숫자가 아닌 경우 - 5자리인 경우")
    @Test
    void winningNumberSize5() {
        assertThatThrownBy(() -> {
            String number = "";
            List<String> numbers = Arrays.asList(number.split(","));
            winningNumberErrorCheck(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 6자리 숫자가 아닌 경우 - 7자리인 경우")
    @Test
    void winningNumberSize7() {
        assertThatThrownBy(() -> {
            String number = "";
            List<String> numbers = Arrays.asList(number.split(","));
            winningNumberErrorCheck(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 중복이 있는 경우")
    @Test
    void winningNumberDuplication() {
        assertThatThrownBy(() -> {
            String number = "1,2,3,4,5,5";
            List<String> numbers = Arrays.asList(number.split(","));
            winningNumberErrorCheck(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 45보다 큰 숫자가 있는 경우")
    @Test
    void winningNumberOver45() {
        assertThatThrownBy(() -> {
            String number = "1,2,3,4,5,46";
            List<String> numbers = Arrays.asList(number.split(","));
            winningNumberErrorCheck(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("당첨번호에 1보다 작은 숫자가 있는 경우")
    @Test
    void winningNumberUnder1() {
        assertThatThrownBy(() -> {
            String number = "0,2,3,4,5,6";
            List<String> numbers = Arrays.asList(number.split(","));
            winningNumberErrorCheck(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }



    @DisplayName("보너스번호가 숫자가 아닌 경우 - 숫자&영어")
    @Test
    void bonusNumberNotNumber1() {
        assertThatThrownBy(() -> {
            String number = "1a";
            bonusNumberErrorCheck(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호가 숫자가 아닌 경우 - 영어&숫자")
    @Test
    void bonusNumberNotNumber2() {
        assertThatThrownBy(() -> {
            String number = "b2";
            bonusNumberErrorCheck(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호가 영어인 경우")
    @Test
    void bonusNumberEnglish() {
        assertThatThrownBy(() -> {
            String number = "asdqwe";
            bonusNumberErrorCheck(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호가 45보다 큰 숫자인 경우")
    @Test
    void bonusNumberOver45() {
        assertThatThrownBy(() -> {
            String number = "46";
            bonusNumberErrorCheck(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호가 1보다 작은 숫자인 경우")
    @Test
    void bonusNumberUnder1() {
        assertThatThrownBy(() -> {
            String number = "0";
            bonusNumberErrorCheck(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호가 당첨번호에 있는 경우")
    @Test
    void bonusNumberIncludedWinningNumbers() {
        assertThatThrownBy(() -> {
            Integer bonusNumber = 1;
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            checkBonusNumberIncludedWinningNumber(winningNumbers, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
