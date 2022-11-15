package view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static view.Comment.*;

class CommentTest {

    @Test
    void printMessage() {
        String message = "구매금액을 입력해 주세요.";
        assertEquals(message, PRINT_INSERT_COIN.getMessage());
        message = "당첨 번호를 입력해 주세요.";
        assertEquals(message, PRINT_INSERT_WINNING_NUMBER.getMessage());
        message = "보너스 번호를 입력해 주세요";
        assertEquals(message, PRINT_ENTER_BONUS_NUMBER.getMessage());
    }

}