package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class UserTest {

    @DisplayName("로또 결과 출력 함수")
    @Test
    void printWinningResult() {
        User user = new User();
        ArrayList<Integer> answerResult = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        String bonusNumber = "7";

        assertDoesNotThrow(() -> user.printWinningResult(answerResult, bonusNumber));
    }

    @DisplayName("수익비율 출력 함수")
    @Test
    void printWinningRatio() {
        User user = new User();
        assertDoesNotThrow(() -> user.printWinningRatio(50000, 1000));
    }

}
