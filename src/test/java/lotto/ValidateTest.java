package lotto;

import lotto.util.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class ValidateTest{
    private Validator validator;

    @BeforeEach
    void constructor(){
        validator = new Validator();
    }


    @Test
    void 콤마_예외테스트(){
        String input = "1 2 3 4 5 6";
        assertThatThrownBy(()-> validator.inputNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("콤마");
    }

    @Test
    void 당첨숫자_문자_예외테스트(){
        assertThatThrownBy(()-> validator.inputNumber("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만");

    }

    @Test
    void 중복_테스트(){
        assertThatThrownBy(()->validator.inputNumber("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복 없이");
    }

    @Test
    void 보너스_중복_테스트(){
        assertThatThrownBy(()-> validator.bonusTotal("5", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @Test
    void 보너스_숫자_테스트() {
        assertThatThrownBy(() -> validator.bonusTotal("a", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 ");
    }

    @Test
    void 당첨숫자_개수_테스트(){
        assertThatThrownBy(()-> validator.inputNumber("1,2,3,4,5,6,7"))
        .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("6개의 ");
    }

    @Test
    void 당첨숫자_범위_테스트(){
        assertThatThrownBy(()-> validator.inputNumber("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("1부터 45 사이의");
    }
}
