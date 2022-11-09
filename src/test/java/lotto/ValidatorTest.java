package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

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

    @Test
    void winningNumberTest(){
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        assertThat(winningNumber).isEqualTo(
                validator.winningNumberValidate("1,2,3,4,5,6")
        );
    }
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4 ,6,3","1,1,1,1,1","1,2,3,4,4,4"})
    void notWinningNumberTest(String s){
        assertThatThrownBy(()->{
            validator.winningNumberValidate(s);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}