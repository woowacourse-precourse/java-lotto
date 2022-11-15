package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
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

    @DisplayName("당첨 번호 일치 수와 보너스 번호 일치 수에 맞는 WinInfo를 반환하는지 테스트")
    @ParameterizedTest
    @MethodSource("getTestProvider")
    void getTest(int matchedCnt, int bonusMatchedCnt, WinInfo trg) {
        assertEquals(WinInfo.get(matchedCnt,bonusMatchedCnt), trg);
    }

    private static List<Arguments> getTestProvider() {
        return List.of(
                Arguments.of(6, 0, WinInfo.WIN1),
                Arguments.of(5, 1, WinInfo.WIN2),
                Arguments.of(5, 0, WinInfo.WIN3),
                Arguments.of(4, 0, WinInfo.WIN4),
                Arguments.of(3, 0, WinInfo.WIN5),
                Arguments.of(3, 2, WinInfo.WIN5),
                Arguments.of(2, 0, WinInfo.NO_WIN),
                Arguments.of(2, 1, WinInfo.NO_WIN),
                Arguments.of(2, 4, WinInfo.NO_WIN),
                Arguments.of(1, 0, WinInfo.NO_WIN)
        );
    }

    @DisplayName("getByOrder이 알맞은 WinInfo를 반환하는지 테스트")
    @Test
    void getByOrderTest() {
        assertEquals(WinInfo.getByOrder(0),WinInfo.NO_WIN);
        assertEquals(WinInfo.getByOrder(1),WinInfo.WIN1);
        assertEquals(WinInfo.getByOrder(2),WinInfo.WIN2);
        assertEquals(WinInfo.getByOrder(3),WinInfo.WIN3);
        assertEquals(WinInfo.getByOrder(4),WinInfo.WIN4);
        assertEquals(WinInfo.getByOrder(5),WinInfo.WIN5);
    }


    @DisplayName("getStatistics의 결과를 테스트")
    @Test
    void getStatisticsTest() {
        //given
        final List<WinInfo> INPUT = List.of(
                WinInfo.NO_WIN,
                WinInfo.WIN2,
                WinInfo.WIN3,
                WinInfo.WIN3,
                WinInfo.WIN3,
                WinInfo.WIN2,
                WinInfo.WIN1,
                WinInfo.WIN2,
                WinInfo.NO_WIN
        );
        //when
        Map<WinInfo,Integer> statistics = WinInfo.getStatistics(INPUT);
        //then
        assertEquals(statistics.get(WinInfo.NO_WIN),2);
        assertEquals(statistics.get(WinInfo.WIN2),3);
        assertEquals(statistics.get(WinInfo.WIN3),3);
        assertEquals(statistics.get(WinInfo.WIN1),1);
    }
}