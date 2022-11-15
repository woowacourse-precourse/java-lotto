package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoMoneyTest {
    @ParameterizedTest
    @DisplayName("로또 구입 금액이 1000원 미만이거나, 1000의 배수가 아니거나, 숫자가 아닌 문자를 입력했을 때")
    @ValueSource(strings = {"1","2","998","999","1000j","123ab","1450"})
    void 로또_금액_입력_1000원_미만(String input){
        Assertions.assertThatThrownBy(()->new LottoMoney(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
