package lotto.domain.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateMoneyTest {

    ValidateMoney validateMoney = new ValidateMoney();

    @DisplayName("예외처리확인 - 문자 입력 불가")
    @Test
    void validateInputMoneyIsAllNumber1(){
        assertThatThrownBy(()-> validateMoney.validate("1234T"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외처리확인 - 마이너스 및 특수문자 불가")
    @Test
    void validateInputMoneyIsAllNumber2(){
        assertThatThrownBy(()-> validateMoney.validate("-123"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외처리확인 - 올바른 단위 입력")
    @Test
    void validateInputMoneyIsRightUnit(){
            assertThatThrownBy(()-> validateMoney.validate("123"))
                    .isInstanceOf(IllegalArgumentException.class);
    }
}
