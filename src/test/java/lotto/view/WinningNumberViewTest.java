package lotto.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

        String input = " 123 ";
        String expected = "123";

        String result = winningNumberView.inputStringParsing(input);

        assertThat(result).isEqualTo(expected);
    }
}