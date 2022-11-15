package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import lotto.Constant.LottoUserValidationError;
import lotto.Constant.WinInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoUserTest {
    @DisplayName("1000으로 나누어 떨어지지 않는 경우 IllegalArgumentException, 메세지 확인")
    @ParameterizedTest
    @ValueSource(longs = {80, 500, 1200, 1600, 2200, 1334523, 8001, 7999})
    void 검증_1000으로_나누어떨어지지않는경우_IllegalArgumentException(long money) {
        assertThatThrownBy(() -> new LottoUser(money, new LottoSystem()))
                .isInstanceOf(IllegalArgumentException.class)
                .isEqualTo(LottoUserValidationError.MONEY_NOT_DEVIDED.exception);
    }

    @DisplayName("음수인 경우 IllegalArgumentException, 메세지 확인")
    @ParameterizedTest
    @ValueSource(longs = {-1, -100, -12412434})
    void 검증_음수인경우_IllegalArgumentException(long money) {
        assertThatThrownBy(() -> new LottoUser(money, new LottoSystem()))
                .isInstanceOf(IllegalArgumentException.class)
                .isEqualTo(LottoUserValidationError.MONEY_MINUS.exception);
    }

    @DisplayName("주어진 금액만큼 로또를 구매했는지, Lotto의 검증 형식에 맞춰서 번호를 생성했는지")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "1000,1", "2000,2", "5000,5", "10000,10", "13000,13", "20000000,20000"})
    void buyLottoTest(long money, int cnt) {
        LottoUser user = new LottoUser(money, new LottoSystem());
        user.buyLotto();
        List<Lotto> lottos = user.getLottos();
        assertEquals(lottos.size(), cnt);
    }

    @DisplayName("주어진 로또에 알맞은 WinInfo를 가지고 있는지")
    @ParameterizedTest
    @MethodSource("checkWinTestProvider")
    void checkWinTest(LottoSystem lottoSystem, List<Lotto> lottos, List<WinInfo> winInformations) {
        LottoUser user = new LottoUser(0, lottoSystem);
        List<Lotto> userLottos = user.getLottos();
        userLottos.clear();
        userLottos.addAll(lottos);
        List<WinInfo> userWinInformations = user.checkWin();

        assertEquals(userWinInformations, winInformations);
    }

    private static List<Arguments> checkWinTestProvider() {
        LottoSystem lottoSystem = new LottoSystem();
        lottoSystem.setWinNumbers(List.of(1, 2, 3, 4, 5, 6));
        lottoSystem.setBonusNumbers(7);

        List<Lotto> lottos = List.of(
                //matched 6 bonus 0
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(5, 3, 2, 6, 1, 4)),
                //matched 5 bonus 1
                new Lotto(List.of(1, 7, 3, 4, 5, 6)),
                new Lotto(List.of(1, 3, 2, 7, 6, 5)),
                //matched 5 bonus 0
                new Lotto(List.of(1, 2, 8, 4, 5, 6)),
                new Lotto(List.of(1, 4, 3, 2, 11, 6)),
                //matched 4 bonus 0
                new Lotto(List.of(1, 2, 9, 4, 11, 6)),
                new Lotto(List.of(1, 9, 2, 11, 4, 6)),
                //matched 4 bonus 1
                new Lotto(List.of(1, 2, 3, 4, 11, 7)),
                //matched 3 matched 0
                new Lotto(List.of(1, 2, 3, 17, 11, 13)),
                new Lotto(List.of(13, 17, 11, 2, 3, 1)),
                //matched 3 bonus 1
                new Lotto(List.of(1, 2, 3, 17, 11, 7)),
                //matched 2 bonus 0
                new Lotto(List.of(1, 2, 21, 17, 11, 9)),
                //matched 2 bonus 1
                new Lotto(List.of(1, 2, 21, 17, 11, 7)),
                //matched 1 bonus 0
                new Lotto(List.of(1, 25, 21, 17, 11, 9)),
                //matched 1 bonus 1
                new Lotto(List.of(1, 25, 21, 17, 11, 7)),
                //matched 0 bonus 0
                new Lotto(List.of(44, 25, 21, 17, 11, 9))
        );
        List<WinInfo> winInformations = List.of(
                WinInfo.WIN1,
                WinInfo.WIN1,
                WinInfo.WIN2,
                WinInfo.WIN2,
                WinInfo.WIN3,
                WinInfo.WIN3,
                WinInfo.WIN4,
                WinInfo.WIN4,
                WinInfo.WIN4,
                WinInfo.WIN5,
                WinInfo.WIN5,
                WinInfo.WIN5,
                WinInfo.NO_WIN,
                WinInfo.NO_WIN,
                WinInfo.NO_WIN,
                WinInfo.NO_WIN,
                WinInfo.NO_WIN
        );
        return List.of(
                Arguments.of(
                        lottoSystem,
                        lottos,
                        winInformations
                )
        );
    }

    @DisplayName("주어진 WinInfo에 대해 수익률을 잘 계산하는지")
    @ParameterizedTest
    @MethodSource("getReturnRateTestProvider")
    void getReturnRateTest(long money, List<WinInfo> winInformations, double returnRate) {
        LottoUser user = new LottoUser(money, new LottoSystem());
        List<WinInfo> userWinInformations = user.getWinInfomations();
        userWinInformations.clear();
        userWinInformations.addAll(winInformations);
        double userReturnRate = user.getReturnRate();

        assertEquals(userReturnRate, returnRate);
    }

    private static List<Arguments> getReturnRateTestProvider() {
        final List<Arguments> INPUTS = List.of(
                Arguments.of(
                        8000,
                        List.of(
                                WinInfo.WIN5,
                                WinInfo.NO_WIN,
                                WinInfo.NO_WIN,
                                WinInfo.NO_WIN,
                                WinInfo.NO_WIN,
                                WinInfo.NO_WIN,
                                WinInfo.NO_WIN,
                                WinInfo.NO_WIN
                        ),
                        0.625
                ),
                Arguments.of(
                        1000,
                        List.of(
                                WinInfo.WIN1
                        ),
                        2000000.0
                ),
                Arguments.of(
                        1000,
                        List.of(
                                WinInfo.NO_WIN
                        ),
                        0
                ),
                Arguments.of(
                        2000,
                        List.of(
                                WinInfo.WIN2,
                                WinInfo.WIN3
                        ),
                        15750.0
                ),
                Arguments.of(
                        7000,
                        List.of(
                                WinInfo.WIN1,
                                WinInfo.WIN2,
                                WinInfo.WIN3,
                                WinInfo.WIN4,
                                WinInfo.WIN5,
                                WinInfo.NO_WIN,
                                WinInfo.NO_WIN
                        ),
                        290222.14285714285714285714285714
                ),
                Arguments.of(
                        2000000000,
                        List.of(
                                WinInfo.WIN5,
                                WinInfo.NO_WIN,
                                WinInfo.NO_WIN
                        ),
                        0.0000025
                ),
                Arguments.of(
                        Long.valueOf("20000000000"),
                        List.of(
                                WinInfo.WIN5,
                                WinInfo.NO_WIN,
                                WinInfo.NO_WIN
                        ),
                        0.00000025
                ),
                Arguments.of(
                        Long.valueOf("2000000000000"),
                        List.of(
                                WinInfo.WIN5,
                                WinInfo.NO_WIN,
                                WinInfo.NO_WIN
                        ),
                        0.0000000025
                ),
                Arguments.of(
                        Long.valueOf("2000000000000"),
                        List.of(
                                WinInfo.WIN5,
                                WinInfo.WIN1,
                                WinInfo.NO_WIN
                        ),
                        0.0010000025
                )

        );

        return INPUTS;
    }

    @DisplayName("자신의 로또 통계를 잘 반환하는지")
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
        LottoUser lottoUser = new LottoUser(0, new LottoSystem());
        lottoUser.getWinInfomations().clear();
        lottoUser.getWinInfomations().addAll(INPUT);
        //when
        Map<WinInfo, Integer> statistics = lottoUser.getStatistics();
        //then
        assertEquals(statistics.get(WinInfo.NO_WIN), 2);
        assertEquals(statistics.get(WinInfo.WIN2), 3);
        assertEquals(statistics.get(WinInfo.WIN3), 3);
        assertEquals(statistics.get(WinInfo.WIN1), 1);
    }
}

