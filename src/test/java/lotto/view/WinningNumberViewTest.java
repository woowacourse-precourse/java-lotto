package lotto.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberViewTest {

    WinningNumberView winningNumberView;

    @BeforeEach
    void beforeEach() {
        winningNumberView = new WinningNumberView();
    }

    @ParameterizedTest
    @DisplayName("입력된 보너스 번호 유효 테스트")
    @ValueSource(strings = {"0", "123123", "46", "45123"})
    void inputBonusNumberTest(String inputBonusNumber) {

        InputStream inputStream = new ByteArrayInputStream(inputBonusNumber.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> winningNumberView.inputBonusNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1~45 사이의 숫자 하나만 입력해야합니다.");
    }

    @ParameterizedTest
    @DisplayName("입력된 당첨번호 유효 테스트")
    @CsvSource(value = {"123: [ERROR] 당첨번호의 개수는 6개", "\\n:[ERROR] 당첨번호의 개수는 6개", ", ,,:[ERROR] 당첨번호의 개수는 6개",
            ",,,, ,:[ERROR] 당첨번호의 개수는 6개", "ab2c ,5de, 4fg,3hi,j1k,lm:[ERROR] 당첨번호는 1", "1,2,3,4,5,46:[ERROR] 당첨번호는 1",
            "1,2,3,4,5,1:[ERROR] 당첨번호는 중복", "1,2,3,3, 3,3:[ERROR] 당첨번호는 중복"}
            , delimiter = ':')
    void inputWinningNumberTest(String winningNumbers, String expectedErrorMessage) {

        InputStream inputStream = new ByteArrayInputStream(winningNumbers.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> winningNumberView.inputWinningNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);
    }

    @Test
    @DisplayName("공백 제거 기능 테스트")
    void deleteBlankTest() {

        String input = "1  ,2 , 3 ,  4  ,5 , 6";
        String[] splitInput = input.split(",");
        String[] expected = {"1", "2", "3", "4", "5", "6"};

        String[] result = winningNumberView.deleteBlank(splitInput);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void inputStringParsing() {

        String input = " 123, 456, 789";
        String[] expected = {"123", "456", "789"};

        String[] result = winningNumberView.inputStringParsing(input);

        assertThat(result).isEqualTo(expected);
    }
}