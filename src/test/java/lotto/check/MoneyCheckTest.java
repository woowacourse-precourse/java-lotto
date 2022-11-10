package lotto;

import lotto.check.MoneyCheck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyCheckTest {

    MoneyCheck moneyCheck;

    @BeforeEach
    void init(){
        moneyCheck = new MoneyCheck();
    }

    @ParameterizedTest
    @ValueSource(strings = {"qwer","1234","222222","2v4f"})
    void moneyCheck(String s){
        assertThatThrownBy(()->{
            moneyCheck.check(s);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}