package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    Validator validator;

    @BeforeEach
    void init(){
        validator = new Validator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"qwer","1234","222222","2v4f"})
    void moneyCheck(String s){
        assertThatThrownBy(()->{
            validator.moneyValidate(s);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}