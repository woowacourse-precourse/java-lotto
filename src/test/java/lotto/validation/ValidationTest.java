package lotto.validation;

import lotto.BuyLotto;
import lotto.Validation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {

    public static BuyLotto byl;

    @BeforeAll
    static void import_initialize(){
        byl=new BuyLotto();
    }


    @ParameterizedTest
    //given
    @ValueSource(strings = {"a","abc","한글_되나요?","이것도안되야함","1234","121200000000002"})
    void validation_user_input_money_유저의_입력값이_유효하지_않을경우_예외발생(String source) {
        //when
        assertThatThrownBy(()-> byl.prepare_money(source))
                .isInstanceOf(IllegalArgumentException.class)
                //then
                .hasMessageContaining("[ERROR]","1000원 단위","숫자");
    }
}