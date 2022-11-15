package view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static view.Comment.*;
import static view.Error.*;

class ErrorTest {

    @Test
    void printMessage() {
        String message = "[ERROR] 숫자만 입력해주세요.";
        assertEquals(message, ERROR_NOT_NUMBER.getMessage());
        message = "[ERROR] 로또 번호가 부족합니다.";
        assertEquals(message, ERROR_LACK_NUMBER.getMessage());
        message = "[ERROR] 로또 번호가 중복되었습니다.";
        assertEquals(message, ERROR_OVERLAP_NUMBER.getMessage());
        message = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
        assertEquals(message, ERROR_RangeOver.getMessage());
        message = "[ERROR] 금액은 1,000원 단위로 떨어져야 합니다.";
        assertEquals(message, ERROR_AMOUNT_IS_NOT_RIGHT.getMessage());
    }

}