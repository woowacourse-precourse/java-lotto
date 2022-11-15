package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoSystemTest {
    @DisplayName("로또 번호의 개수가 설정된 값이 아니라면 발생한다.")
    @ParameterizedTest
    @MethodSource("provider_검증_6개이외의당첨번호입력_IllegalArgumentException")
    void 검증_6개이외의당첨번호입력_IllegalArgumentException(List<Integer> winNumbers) {
        LottoSystem lottoSystem = new LottoSystem();
        assertThatThrownBy(() -> lottoSystem.setWinNumbers(winNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호가 너무 많거나 적습니다.");

    }

    private static List<Arguments> provider_검증_6개이외의당첨번호입력_IllegalArgumentException() {
        return List.of(
                Arguments.of(
                        List.of(
                                1, 2, 3, 4, 5, 6, 7
                        )
                ),
                Arguments.of(
                        List.of(
                                1, 2, 3, 4, 5
                        )
                )
        );
    }

    @DisplayName("로또 번호의 범위가 설정에서 벗어났다면 발생한다.")
    @ParameterizedTest
    @MethodSource("provider_검증_당첨번호범위벗어남_IllegalArgumentException")
    void 검증_당첨번호범위벗어남_IllegalArgumentException(List<Integer> winNumbers) {
        LottoSystem lottoSystem = new LottoSystem();
        assertThatThrownBy(() -> lottoSystem.setWinNumbers(winNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    }

    private static List<Arguments> provider_검증_당첨번호범위벗어남_IllegalArgumentException() {
        return List.of(
                Arguments.of(
                        List.of(
                                1, 2, 3, 4, 5, 46
                        )
                ),
                Arguments.of(
                        List.of(
                                0, 2, 3, 4, 5, 45
                        )
                )
        );
    }

    @DisplayName("로또 번호의 범위가 설정에서 벗어났다면 발생한다.")
    @ParameterizedTest
    @MethodSource("provider_검증_당첨번호중복_IllegalArgumentException")
    void 검증_당첨번호중복_IllegalArgumentException(List<Integer> winNumbers) {
        LottoSystem lottoSystem = new LottoSystem();
        assertThatThrownBy(() -> lottoSystem.setWinNumbers(winNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호에 중복된 숫자가 있으면 안됩니다.");

    }

    private static List<Arguments> provider_검증_당첨번호중복_IllegalArgumentException() {
        return List.of(
                Arguments.of(
                        List.of(
                                1, 2, 3, 4, 6, 6
                        )
                ),
                Arguments.of(
                        List.of(
                                1, 2, 3, 4, 5, 3
                        )
                )
        );
    }

    @DisplayName("보너스 번호의 범위가 범위를 벗어난 경우")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 검증_보너스번호범위벗어남_IllegalArgumentException(int bonusNumber) {
        LottoSystem lottoSystem = new LottoSystem();
        assertThatThrownBy(() -> lottoSystem.setBonusNumbers(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

    }

    @DisplayName("Lotto에 대해서 알맞은 WinInfo정보를 반환하는지")
    @ParameterizedTest
    @MethodSource("judgeWinTestProvider")
    void judgeWinTest(LottoSystem lottoSystem, Lotto lotto, WinInfo winInfo) {
        assertEquals(lottoSystem.judgeWin(lotto), winInfo);
    }

    private static List<Arguments> judgeWinTestProvider() {
        LottoSystem lottoSystem = new LottoSystem();
        lottoSystem.setWinNumbers(List.of(1, 2, 3, 4, 5, 6));
        lottoSystem.setBonusNumbers(7);

        return List.of(
                //matched 6 bonus 0
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        WinInfo.WIN1
                ),
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(6, 5, 4, 3, 2, 1)),
                        WinInfo.WIN1
                ),
                //matched 5 bonus 1
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1, 7, 3, 4, 5, 6)),
                        WinInfo.WIN2
                ),
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(6, 7, 5, 4, 3, 1)),
                        WinInfo.WIN2
                ),
                //matched 5 bonus 0
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1, 2, 8, 4, 5, 6)),
                        WinInfo.WIN3
                ),
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(3, 2, 1, 6, 11, 4)),
                        WinInfo.WIN3
                ),
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1, 2, 9, 4, 11, 6)),
                        WinInfo.WIN4
                ),
                //matched 4 bonus 0
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1, 9, 2, 4, 6, 11)),
                        WinInfo.WIN4
                ),
                //matched 4 bonus 1
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1, 3, 2, 4, 11, 7)),
                        WinInfo.WIN4
                ),
                //matched 3 bonus 0
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1, 2, 3, 17, 11, 13)),
                        WinInfo.WIN5
                ),
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(17, 3, 2, 11, 1, 13)),
                        WinInfo.WIN5
                ),
                //matched 3 bonus 1
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(7, 3, 1, 17, 11, 2)),
                        WinInfo.WIN5
                ),
                //matched 2 bonus 0
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1, 2, 21, 17, 11, 9)),
                        WinInfo.NO_WIN
                ),
                //matched 2 bonus 1
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1, 2, 21, 17, 11, 7)),
                        WinInfo.NO_WIN
                ),
                //matched 1 bonus 0
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1, 25, 21, 17, 11, 9)),
                        WinInfo.NO_WIN
                ),
                //matched 1 bonus 1
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(1, 25, 21, 17, 11, 7)),
                        WinInfo.NO_WIN
                ),
                //matched 0 bonus 0
                Arguments.of(
                        lottoSystem,
                        new Lotto(List.of(44, 25, 21, 17, 11, 9)),
                        WinInfo.NO_WIN
                )
        );
    }
}