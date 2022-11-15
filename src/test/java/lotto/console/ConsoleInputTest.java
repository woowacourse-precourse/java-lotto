package lotto.console;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ConsoleInputTest {


  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
  private final ConsoleInput consoleInput = new ConsoleInput();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }


  @Test
  void 금액입력시_숫자가아닌_문자가입력시_에러발생() {
    String givenInputMoney = "125z!z ";
    InputStream inputStream = new ByteArrayInputStream(givenInputMoney.getBytes());
    System.setIn(inputStream);

    assertThatThrownBy(() -> consoleInput.inputMoney())
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void 금액입력시_숫자가만입력되면_정상결과() {
    String givenInputMoney = "1255";
    InputStream inputStream = new ByteArrayInputStream(givenInputMoney.getBytes());
    System.setIn(inputStream);

    int result = consoleInput.inputMoney();

    assertThat(result).isEqualTo(Integer.parseInt(givenInputMoney));
  }


  @AfterEach
  public void tearDown() {
    System.setOut(standardOut);
  }


  @Nested
  class InputWinningNumberTest {

    @Test
    void 잘못된_형식의_입력_실패() {
      String givenInput = "1,2.3.46,4.2";
      InputStream inputStream = new ByteArrayInputStream(givenInput.getBytes());
      System.setIn(inputStream);

      assertThatThrownBy(() -> consoleInput.inputWinningNumber())
          .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자범위_초과로인한_실패() {
      String givenInput = "1,2,3,46,4,2";
      InputStream inputStream = new ByteArrayInputStream(givenInput.getBytes());
      System.setIn(inputStream);

      assertThatThrownBy(() -> consoleInput.inputWinningNumber())
          .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_번호로_인한_실패() {
      String givenInputNumber = "1,2,3,4,5,6";
      String bonusNumber = "6";
      InputStream inputStream = new ByteArrayInputStream(givenInputNumber.getBytes());
      InputStream bonusInputStream = new ByteArrayInputStream(bonusNumber.getBytes());
      System.setIn(inputStream);
      System.setIn(bonusInputStream);

      assertThatThrownBy(() -> consoleInput.inputWinningNumber())
          .isInstanceOf(IllegalArgumentException.class);
    }
  }
}