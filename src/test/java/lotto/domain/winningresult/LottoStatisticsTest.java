package lotto.domain.winningresult;

import java.lang.reflect.Field;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoDraw;
import lotto.domain.lotto.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {
    private static final int LOTTO_LIST_INDEX = 1;

    @Test
    public void 로또_당첨_결과_저장_테스트_5등_2등() throws IllegalAccessException {
        List<Lotto> declaredLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9))
        );
        Lottos lottos = getLottosByDeclaredLotto(declaredLottos);

        LottoDraw lottoDraw = LottoDraw.of(List.of(1, 2, 3, 4, 5, 13), 6);
        LottoStatistics lottoStatistics = LottoStatistics.of(lottos, lottoDraw);

        Assertions.assertThat(lottoStatistics.count(WinningType.SECOND_PLACE)).isEqualTo(1);
        Assertions.assertThat(lottoStatistics.count(WinningType.FIFTH_PLACE)).isEqualTo(1);
    }

    @Test
    public void 로또_당첨_결과_저장_테스트_4등_4등() throws IllegalAccessException {
        List<Lotto> declaredLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8))
        );
        Lottos lottos = getLottosByDeclaredLotto(declaredLottos);

        LottoDraw lottoDraw = LottoDraw.of(List.of(1, 2, 3, 4, 41, 42), 43);
        LottoStatistics lottoStatistics = LottoStatistics.of(lottos, lottoDraw);

        Assertions.assertThat(lottoStatistics.count(WinningType.FOURTH_PLACE)).isEqualTo(2);
    }

    @Test
    public void 로또_당첨_결과_저장_테스트_1등_2등_3등() throws IllegalAccessException {
        List<Lotto> declaredLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 6, 9))
        );
        Lottos lottos = getLottosByDeclaredLotto(declaredLottos);

        LottoDraw lottoDraw = LottoDraw.of(List.of(1, 2, 3, 4, 5, 6), 8);
        LottoStatistics lottoStatistics = LottoStatistics.of(lottos, lottoDraw);

        Assertions.assertThat(lottoStatistics.count(WinningType.FIRST_PLACE)).isEqualTo(1);
        Assertions.assertThat(lottoStatistics.count(WinningType.SECOND_PLACE)).isEqualTo(1);
        Assertions.assertThat(lottoStatistics.count(WinningType.THIRD_PLACE)).isEqualTo(1);
    }

    @Test
    public void 수익률_테스트_수익() throws IllegalAccessException {
        List<Lotto> declaredLottos = List.of(
                new Lotto(List.of(1, 2, 3, 14, 15, 16)),
                new Lotto(List.of(1, 2, 3, 14, 17, 18)),
                new Lotto(List.of(11, 12, 13, 14, 17, 18)),
                new Lotto(List.of(11, 12, 13, 14, 17, 18))
        );
        Lottos lottos = getLottosByDeclaredLotto(declaredLottos);

        LottoDraw lottoDraw = LottoDraw.of(List.of(1, 2, 3, 40, 41, 42), 43);
        LottoStatistics lottoStatistics = LottoStatistics.of(lottos, lottoDraw);

        // 4,000원 -> 5등 2개 (10,000원 수익)
        double expectedRate = (10_000.0 / 4_000.0) * 100;
        Assertions.assertThat(lottoStatistics.getRewardRate()).isEqualTo(expectedRate);
    }

    @Test
    public void 수익률_테스트_손실() throws IllegalAccessException {
        List<Lotto> declaredLottos = List.of(
                new Lotto(List.of(1, 2, 3, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 17, 18)),
                new Lotto(List.of(11, 12, 13, 14, 17, 18)),
                new Lotto(List.of(11, 12, 13, 14, 17, 18)),
                new Lotto(List.of(11, 12, 13, 14, 17, 18)),
                new Lotto(List.of(11, 12, 13, 14, 17, 18))
        );
        Lottos lottos = getLottosByDeclaredLotto(declaredLottos);

        LottoDraw lottoDraw = LottoDraw.of(List.of(1, 2, 3, 40, 41, 42), 43);
        LottoStatistics lottoStatistics = LottoStatistics.of(lottos, lottoDraw);

        // 6,000원 -> 5등 1개 (5,000원 수익)
        double expectedRate = (5_000.0 / 6_000.0) * 100;
        Assertions.assertThat(lottoStatistics.getRewardRate()).isEqualTo(expectedRate);
    }

    @Test
    public void 수익률_테스트_최대_수익() throws IllegalAccessException {
        List<Lotto> declaredLottos = List.of(
                new Lotto(List.of(1, 2, 3, 14, 15, 16))
        );
        Lottos lottos = getLottosByDeclaredLotto(declaredLottos);

        LottoDraw lottoDraw = LottoDraw.of(List.of(1, 2, 3, 14, 15, 16), 17);
        LottoStatistics lottoStatistics = LottoStatistics.of(lottos, lottoDraw);

        // 1,000원 -> 1등 1개 (2,000,000,000원 수익)
        double expectedRate = (2_000_000_000.0 / 1_000.0) * 100;
        Assertions.assertThat(lottoStatistics.getRewardRate()).isEqualTo(expectedRate);
    }

    @Test
    public void 수익률_테스트_최대_손실() throws IllegalAccessException {
        List<Lotto> declaredLottos = List.of(
                new Lotto(List.of(1, 2, 3, 14, 15, 16))
        );
        Lottos lottos = getLottosByDeclaredLotto(declaredLottos);

        LottoDraw lottoDraw = LottoDraw.of(List.of(31, 32, 33, 34, 35, 36), 37);
        LottoStatistics lottoStatistics = LottoStatistics.of(lottos, lottoDraw);

        // 1,000원 -> 0원 수익
        double expectedRate = (0.0 / 1_000.0) * 100;
        Assertions.assertThat(lottoStatistics.getRewardRate()).isEqualTo(expectedRate);
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