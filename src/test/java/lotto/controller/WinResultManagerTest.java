package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinResultManagerTest {

    @Tag("WinResultManager")
    @DisplayName("일치하는 번호의 개수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,3,5,14,22,45:3", "3,5,11,16,32,38:2"})
    void returnCorrectNumber(String numbers, int expected) {
        List<Integer> winNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> lottoNumber = new ArrayList<>(Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        assertThat(WinResultManager.returnCorrectNumber).isEqualTo(expected);
    }
}
