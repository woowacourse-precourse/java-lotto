package lotto.domain.winningresult;

import java.lang.reflect.Field;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoDraw;
import lotto.domain.lotto.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningResultsTest {
    private static final int LOTTO_LIST_INDEX = 1;

    @Test
    public void 로또_당첨_결과_저장_테스트_5등_2등() throws IllegalAccessException {
        Lotto lottoA = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lottoB = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        List<Lotto> declaredLottos = List.of(lottoA, lottoB);
        Lottos lottos = getLottosByDeclaredLotto(declaredLottos);

        LottoDraw lottoDraw = LottoDraw.of(List.of(1, 2, 3, 4, 5, 13), 6);
        WinningResults winningResults = WinningResults.of(lottos, lottoDraw);

        Assertions.assertThat(winningResults.count(WinningResultType.SECOND_PLACE)).isEqualTo(1);
        Assertions.assertThat(winningResults.count(WinningResultType.FIFTH_PLACE)).isEqualTo(1);
    }

    @Test
    public void 로또_당첨_결과_저장_테스트_4등_4등() throws IllegalAccessException {
        Lotto lottoA = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lottoB = new Lotto(List.of(1, 2, 3, 4, 7, 8));

        List<Lotto> declaredLottos = List.of(lottoA, lottoB);
        Lottos lottos = getLottosByDeclaredLotto(declaredLottos);

        LottoDraw lottoDraw = LottoDraw.of(List.of(1, 2, 3, 4, 41, 42), 43);
        WinningResults winningResults = WinningResults.of(lottos, lottoDraw);

        Assertions.assertThat(winningResults.count(WinningResultType.FOURTH_PLACE)).isEqualTo(2);
    }

    @Test
    public void 로또_당첨_결과_저장_테스트_1등_2등_3등() throws IllegalAccessException {
        Lotto lottoA = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lottoB = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto lottoC = new Lotto(List.of(1, 2, 3, 4, 6, 9));

        List<Lotto> declaredLottos = List.of(lottoA, lottoB, lottoC);
        Lottos lottos = getLottosByDeclaredLotto(declaredLottos);

        LottoDraw lottoDraw = LottoDraw.of(List.of(1, 2, 3, 4, 5, 6), 8);
        WinningResults winningResults = WinningResults.of(lottos, lottoDraw);

        Assertions.assertThat(winningResults.count(WinningResultType.FIRST_PLACE)).isEqualTo(1);
        Assertions.assertThat(winningResults.count(WinningResultType.SECOND_PLACE)).isEqualTo(1);
        Assertions.assertThat(winningResults.count(WinningResultType.THIRD_PLACE)).isEqualTo(1);
    }

    private Lottos getLottosByDeclaredLotto(List<Lotto> declaredLottos) throws IllegalAccessException {
        Lottos lottos = Lottos.from(1000);
        Class<? extends Lottos> lottosClass = lottos.getClass();
        Field[] declaredFields = lottosClass.getDeclaredFields();
        declaredFields[LOTTO_LIST_INDEX].setAccessible(true);
        declaredFields[LOTTO_LIST_INDEX].set(lottos, declaredLottos);

        return lottos;
    }


}