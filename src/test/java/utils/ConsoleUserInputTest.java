package utils;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import statements.ErrorStatements;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleUserInputTest {
    ConsoleUserInput consoleUserInput = new ConsoleUserInput();
    Scanner scanner = new Scanner(System.in);
    public static InputStream testUserInput(String userInput){
        return new ByteArrayInputStream(userInput.getBytes());
    }

    @DisplayName("입력한 인자의 개수가 의도한 개수인지 확인한다.")
    @Test
    void checkValidLength(){
        InputStream in = testUserInput("1,2,3,4,5,6 7");
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThatThrownBy(()->
                consoleUserInput.inputWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개의 숫자가 ','로 제대로 구별되어 입력됐는지 확인한다.")
    @Test
    void checkValidFormat() {
        InputStream in = testUserInput("1,2,7,4,3 6");
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThatThrownBy(()->
            consoleUserInput.inputWinningNumbers() )
        .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개의 숫자가 1~45 범위 내에서 입력됐는지 확인한다.")
    @Test
    void checkRangeOfSixWinningNumbers(){
        String input = "1,2,3,4,0,5";

        assertThatThrownBy(()-> consoleUserInput.toIntegerNumbersWithoutComma(input))
        .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorStatements.SHOUT_NUMBER_RANGE_ERROR.alarmed());
    }

    @DisplayName("6개의 숫자가 숫자가 아닌 다른 문자로 입력됐는지 확인한다.")
    @Test
    void checkInvalidInput(){
        InputStream in = testUserInput("나,는,숫,자,가, 아니야~:) 😗 ");
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThatThrownBy(()-> consoleUserInput.inputWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorStatements.SHOUT_NOT_NUMBER_ERROR.alarmed());
    }

    @DisplayName("보너스 숫자의 입력값이 없는지 확인한다.")
    @Test
    void checkBonusNumberIsNothing(){
        InputStream in = testUserInput("");
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThatThrownBy(()-> consoleUserInput.inputWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자의 입력값이 공백인지 확인한다.")
    @Test
    void checkBonusNumberIsVacant(){
        InputStream in = testUserInput(" ");
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThatThrownBy(()-> consoleUserInput.inputWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자의 입력값이 숫자인지 확인한다.")
    @Test
    void checkBonusNumberIsNumber(){
        InputStream in = testUserInput("t");
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThatThrownBy(()-> consoleUserInput.inputWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자의 입력값이 1~45 범위내에 있는지 확인한다.")
    @Test
    void checkBonusNumberIsInRange(){
        InputStream in = testUserInput("77");
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThatThrownBy(()-> consoleUserInput.inputWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입을 위해 입력한 돈의 단위가 1000원 이상인지 확인한다.")
    @Test
    void checkPaymentInUnitsOfAThousand(){
        InputStream in = testUserInput("17820");
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThatThrownBy(()-> consoleUserInput.inputMoneyForLottos())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입을 위해 입력한 돈이 유효한 타입인지 확인한다.")
    @Test
    void checkPaymentIsValid(){
        InputStream in = testUserInput("정수가 아닌 값 입력 시 오류 발생");
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThatThrownBy(()-> consoleUserInput.inputMoneyForLottos())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
