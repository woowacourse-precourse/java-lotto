package lotto;

import lotto.utils.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {

    // 숫자인지 확인하는 메서드 체크
    @ParameterizedTest
    @ValueSource(strings = {"1e1", "111e", "1 1", "abc"})
    void 숫자인지_확인하는_메서드_체크(String input){
        assertThatThrownBy(()->{
            Validator.validateInteger(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    // 당첨 번호 확인하는 메서드 체크

    // 숫자의 개수 확인하는 메서드 체크

    //중복 확인하는 메서드 체크

    // 1000으로 나누어 떨어지는지 확인하는 메서드 체크

}
