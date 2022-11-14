package lotto.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

public class InputViewTest {

    private static InputView inputView;

    InputViewTest() {
        inputView = new InputView();
    }

    @Test
    void 돈_정상_입력_테스트() {
        String inputNumber = "1000";
        System.setIn(new ByteArrayInputStream(inputNumber.getBytes()));
        int answer = inputView.inputMoney();
        int compareNumber = 1000;
        Assertions.assertEquals(compareNumber, answer);
    }

    @Test
    void 잔돈_남을시_에러_테스트() {
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

    @Test
    void 당첨번호_입력_정수_배열로_변환() {
        String inputNumber = "1,2,3,4,5,6";
        List answerList = List.of(1, 2, 3, 4, 5, 6);
        System.setIn(new ByteArrayInputStream(inputNumber.getBytes()));
        List list = inputView.inputWinningNumber();
        Assertions.assertEquals(answerList, list);
    }

    @Test
    void 문자열을_입력시_에러() {
        String inputNumbers = "a,2,3,4,5,6";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            System.setIn(new ByteArrayInputStream(inputNumbers.getBytes()));
            inputView.inputWinningNumber();
        });
    }

    @Test
    void 숫자개수가_작을경우_에러() {
        String inputNumbers = "1,2,3,4,5,";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            System.setIn(new ByteArrayInputStream(inputNumbers.getBytes()));
            inputView.inputWinningNumber();
        });
    }

    @Test
    void 중복된_숫자가_있을경우_에러() {
        String inputNumbers = "1,2,3,4,5,5";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            System.setIn(new ByteArrayInputStream(inputNumbers.getBytes()));
            inputView.inputWinningNumber();
        });
    }

    @Test
    void 보너스번호_정상_입력() {
        String inputNumber = "10";
        int answer = 10;
        System.setIn(new ByteArrayInputStream(inputNumber.getBytes()));
        int bonusNumber = inputView.inputBonusNumber();
        Assertions.assertEquals(answer,bonusNumber);
    }

    @Test
    void 보너스번호_숫자_이외에_입력시_에러_테스트() {
        String inputNumber = "10a";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            System.setIn(new ByteArrayInputStream(inputNumber.getBytes()));
            int answer = inputView.inputBonusNumber();
        });
    }

    @Test
    void 보너스번호_범위밖_숫자_입력시_에러_테스트() {
        String inputNumber = "46";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            System.setIn(new ByteArrayInputStream(inputNumber.getBytes()));
            int answer = inputView.inputBonusNumber();
        });
    }

}
