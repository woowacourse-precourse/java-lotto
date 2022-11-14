package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class WinInfoTest {
    @DisplayName("모든 WinInfo에 대해 match함수가 잘 작동하는지 테스트")
    @ParameterizedTest
    @MethodSource("matchTestProvider")
    void matchTest(int matchedCnt, int bonusMatchedCnt, WinInfo trg, boolean result) {
        assertEquals(trg.match(matchedCnt, bonusMatchedCnt), result);
    }


    private static List<Arguments> matchTestProvider() {
        return List.of(
                Arguments.of(6, 0, WinInfo.WIN1, true),
                Arguments.of(5, 1, WinInfo.WIN2, true),
                Arguments.of(5, 0, WinInfo.WIN3, true),
                Arguments.of(4, 0, WinInfo.WIN4, true),
                Arguments.of(3, 0, WinInfo.WIN5, true),
                Arguments.of(2, 0, WinInfo.NO_WIN, false),
                Arguments.of(-1, -1, WinInfo.NO_WIN, true)
        );
    }

}