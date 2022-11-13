package lotto.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

public class ValidatorTest {
    private static Validator validator;

    public ValidatorTest() {
        validator = new Validator();
    }

    @Test
    void 문자열을_정수_배열로_변환() {
        String answer = "1,2,3,4,5,6";
        List answerList = List.of(1, 2, 3, 4, 5, 6);
        List list = validator.winningNumberInputValidator(answer);
        Assertions.assertEquals(answerList, list);
    }

    @Test
    void 문자열을_입력시_에러() {
        String inputNumbers = "a,2,3,4,5,6";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.winningNumberInputValidator(inputNumbers);
        });
    }

    @Test
    void 숫자개수가_작을경우_에러() {
        String inputNumbers = "1,2,3,4,5,";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.winningNumberInputValidator(inputNumbers);
        });
    }

    @Test
    void 중복된_숫자가_있을경우_에러() {
        String inputNumbers = "1,2,3,4,5,5";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.winningNumberInputValidator(inputNumbers);
        });
    }
}
