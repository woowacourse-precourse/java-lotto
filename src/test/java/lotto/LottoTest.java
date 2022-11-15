package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

   /*  @DisplayName("입력된 숫자가 1, 45 사이의 수가 아닐경우 예외가 발생한다.")
    @Test
    void checkInputOutOfRange(){
        Lotto test = new Lotto(List.of(-1,2,3,4,5,6));

        assertThatThrownBy(()-> {test.isNumberInRange();}).isInstanceOf(IllegalArgumentException.class);
    }*/

    /* @Test
    void inputChecker()
    {
        String pattern = "[0-9]{1}|^[1-3]{1}[0-9]{1},";
        String temp = pattern + pattern + pattern+pattern+pattern + "[0-9]{1}|^[1-3]{1}[0-9]{1}";
        String input = "30,30,30,30,30,30";
        assertThat(Pattern.matches(temp, input)).isEqualTo(true);
    }*/

   /* @Test
    void checkPrintNumbers()
    {
        Lotto test = new Lotto(List.of(1,2,3,4,5,6));
        OutputStream captor;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        test.printNumber();
        assertThat(captor.toString().trim()).contains("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void checkPurchaseAmount()
    {
        InputManager test = new InputManager();
        int temp = test.purchaseAmount();
        assertThat(temp).isEqualTo(8);
    }*/
}
