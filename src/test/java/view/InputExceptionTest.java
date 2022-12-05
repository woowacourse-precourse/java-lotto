package view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputExceptionTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void null_test(String userInput) {
        assertThatThrownBy(()->{
            InputException.nullException(userInput);
        }).isInstanceOf(IllegalArgumentException.class) ;
    }

    @ParameterizedTest
    @ValueSource(strings = {"1r", "r1", "rr"})
    public void isNumber_test(String userInput) {
        assertThatThrownBy(()->{
            InputException.notNumberException(userInput);
        }).isInstanceOf(IllegalArgumentException.class) ;
    }

    @ParameterizedTest
    @ValueSource(ints = {14300, 800, 1100})
    public void isNotDividedThousand_test(int userInput) {
        assertThatThrownBy(()->{
            InputException.notDividedThousandException(userInput);
        }).isInstanceOf(IllegalArgumentException.class) ;
    }


}
