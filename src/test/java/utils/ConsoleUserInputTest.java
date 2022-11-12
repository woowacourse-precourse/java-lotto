package utils;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleUserInputTest {

    @DisplayName("6개의 숫자가 ','로 제대로 구별되어 입력됐는지 확인한다.")
    @Test
    void checkValidFormat() {
        var consoleUserInput = new ConsoleUserInput();

        assertThatThrownBy(()->
            consoleUserInput.userInput = "1,2,7,4,3 6")
        .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개의 숫자가 1~45 범위 내에서 입력됐는지 확인한다.")
    @Test
    void checkSizeOfSixWinningNumbers(){
        var consoleUserInput = new ConsoleUserInput();
        String input = "1,2,3,4,0,5";

        assertThatThrownBy(()-> consoleUserInput.toIntegerNumbersWithoutComma(input))
        .isInstanceOf(IllegalArgumentException.class);
    }

}
