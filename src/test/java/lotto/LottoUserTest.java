package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoUserTest {
    @DisplayName("1000으로 나누어 떨어지지 않는 경우 IllegalArgumentException, 메세지 확인")
    @ParameterizedTest
    @ValueSource(longs = {80,500,1200,1600,2200,1334523,8001,7999})
    void 검증_1000으로_나누어떨어지지않는경우_IllegalArgumentException(long money) {
        assertThatThrownBy(() -> new LottoUser(money,new LottoSystem()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 1000원 단위로 나누어 떨어져야 합니다.");
    }

    @DisplayName("음수인 경우 IllegalArgumentException, 메세지 확인")
    @ParameterizedTest
    @ValueSource(longs = {-1,-100,-12412434})
    void 검증_음수인경우_IllegalArgumentException(long money) {
        assertThatThrownBy(() -> new LottoUser(money,new LottoSystem()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 0이상이여야 합니다");
    }

    @DisplayName("주어진 금액만큼 로또를 구매했는지, Lotto의 검증 형식에 맞춰서 번호를 생성했는지")
    @ParameterizedTest
    @CsvSource(value = {"0,0","1000,1","2000,2","5000,5","10000,10","13000,13","20000000,20000"})
    void buyLottoTest(long money, int cnt) {
        LottoUser user = new LottoUser(money,new LottoSystem());
        user.buyLotto();
        List<Lotto> lottos = user.getLottos();
        assertEquals(lottos.size(),cnt);
    }

    @DisplayName("주어진 로또에 알맞은 WinInfo를 가지고 있는지")
    @ParameterizedTest
    @MethodSource("checkWinTestProvider")
    void checkWinTest(LottoSystem lottoSystem, List<Lotto> lottos, List<WinInfo> winInformations) {
        LottoUser user = new LottoUser(0,lottoSystem);
        List<Lotto> userLottos = user.getLottos();
        userLottos.clear();
        userLottos.addAll(lottos);
        List<WinInfo> userWinInformations = user.checkWin();

        assertEquals(userWinInformations,winInformations);
    }
    private static List<Arguments> checkWinTestProvider() {
        LottoSystem lottoSystem = new LottoSystem();
        lottoSystem.setWinNumbers(List.of(1,2,3,4,5,6));
        lottoSystem.setBonusNumbers(7);

        List<Lotto> lottos = List.of(
                //matched 6 bonus 0
                new Lotto(List.of(1,2,3,4,5,6)),
                //matched 5 bonus 1
                new Lotto(List.of(1,7,3,4,5,6)),
                //matched 5 bonus 1
                new Lotto(List.of(1,2,3,7,5,6)),
                //matched 5 bonus 0
                new Lotto(List.of(1,2,8,4,5,6)),
                //matched 5 bonus 0
                new Lotto(List.of(1,2,3,4,11,6)),
                //matched 4 bonus 0
                new Lotto(List.of(1,2,9,4,11,6)),
                //matched 4 bonus 1
                new Lotto(List.of(1,2,3,4,11,7)),
                //matched 3 matched 0
                new Lotto(List.of(1,2,3,17,11,13)),
                //matched 3 bonus 1
                new Lotto(List.of(1,2,3,17,11,7)),
                //matched 2 bonus 0
                new Lotto(List.of(1,2,21,17,11,9)),
                //matched 2 bonus 1
                new Lotto(List.of(1,2,21,17,11,7)),
                //matched 1 bonus 0
                new Lotto(List.of(1,25,21,17,11,9)),
                //matched 1 bonus 1
                new Lotto(List.of(1,25,21,17,11,7)),
                //matched 0 bonus 0
                new Lotto(List.of(44,25,21,17,11,9))
        );
        List<WinInfo> winInformations = List.of(
                WinInfo.WIN1,
                WinInfo.WIN2,
                WinInfo.WIN2,
                WinInfo.WIN3,
                WinInfo.WIN3,
                WinInfo.WIN4,
                WinInfo.WIN4,
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

}

