package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoSystemTest {
    @DisplayName("Lotto에 대해서 알맞은 WinInfo정보를 반환하는지")
    @ParameterizedTest
    @MethodSource("judgeWinTestProvider")
    void judgeWinTest(LottoSystem lottoSystem, Lotto lotto, WinInfo winInfo) {
        assertEquals(lottoSystem.judgeWin(lotto),winInfo);
    }

    private static List<Arguments> judgeWinTestProvider() {
        LottoSystem lottoSystem = new LottoSystem();
        lottoSystem.setWinNumbers(List.of(1,2,3,4,5,6));
        lottoSystem.setBonusNumbers(7);

        return List.of(
                //matched 6 bonus 0
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1,2,3,4,5,6)),
                        WinInfo.WIN1
                ),
                //matched 5 bonus 1
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1,7,3,4,5,6)),
                        WinInfo.WIN2
                ),
                //matched 5 bonus 1
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1,2,3,7,5,6)),
                        WinInfo.WIN2
                ),
                //matched 5 bonus 0
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1,2,8,4,5,6)),
                        WinInfo.WIN3
                ),
                //matched 5 bonus 0
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1,2,3,4,11,6)),
                        WinInfo.WIN3
                ),
                //matched 4 bonus 0
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1,2,9,4,11,6)),
                        WinInfo.WIN4
                ),
                //matched 4 bonus 1
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1,2,3,4,11,7)),
                        WinInfo.WIN4
                ),
                //matched 3 matched 0
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1,2,3,17,11,13)),
                        WinInfo.WIN5
                ),
                //matched 3 bonus 1
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1,2,3,17,11,7)),
                        WinInfo.WIN5
                ),
                //matched 2 bonus 0
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1,2,21,17,11,9)),
                        WinInfo.NO_WIN
                ),
                //matched 2 bonus 1
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1,2,21,17,11,7)),
                        WinInfo.NO_WIN
                ),
                //matched 1 bonus 0
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1,25,21,17,11,9)),
                        WinInfo.NO_WIN
                ),
                //matched 1 bonus 1
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1,25,21,17,11,7)),
                        WinInfo.NO_WIN
                ),
                //matched 0 bonus 0
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(55,25,21,17,11,9)),
                        WinInfo.NO_WIN
                )
        );
    }
}