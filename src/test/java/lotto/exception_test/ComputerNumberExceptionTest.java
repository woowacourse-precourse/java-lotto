package lotto.exception_test;

import lotto.exception.ComputerNumberException;
import lotto.exception.IllegalArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ComputerNumberExceptionTest {

    ComputerNumberException computerNumberException;

    @BeforeEach
    void initializeClass(){
        computerNumberException = new ComputerNumberException();
    }

    @DisplayName("입력이 숫자가 아니면 예외처리한다. ")
    @Test
    void notRightInputTest(){
        assertThatThrownBy(()->computerNumberException.validate("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
