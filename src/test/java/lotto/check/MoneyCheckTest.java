package lotto.check;

import lotto.check.MoneyCheck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyCheckTest {


    @DisplayName("숫자 아닌 값, 중복 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"qwer","1234","222222","2v4f"})
    void moneyCheck(String s){
        assertThatThrownBy(()->{
            MoneyCheck.check(s);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}