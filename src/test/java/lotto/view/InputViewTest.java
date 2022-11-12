package lotto.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class InputViewTest {

    private static InputView inputView;

    InputViewTest() {
        inputView = new InputView();
    }

    @Test
    void 정상_입력_테스트() {
        String inputNumber = "1000";
        System.setIn(new ByteArrayInputStream(inputNumber.getBytes()));
        int answer = inputView.inputMoney();
        int compareNumber = 1000;
        Assertions.assertEquals(compareNumber, answer);
    }

    @Test
    void 단위_에러_테스트() {
        String inputNumber = "1100";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            System.setIn(new ByteArrayInputStream(inputNumber.getBytes()));
            int answer = inputView.inputMoney();
        });
    }

    @Test
    void 숫자_이외에_입력시_에러_테스트() {
        String inputNumber = "10a";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            System.setIn(new ByteArrayInputStream(inputNumber.getBytes()));
            int answer = inputView.inputMoney();
        });
    }
}
