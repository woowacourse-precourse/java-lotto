package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.WinningRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoControllerTest {

    private LottoController lottoController;
    private Lotto baseLotto;

    @BeforeEach
    void setUp() {
        lottoController = new LottoController();
        baseLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest(name = "로또_자동생성_테스트 {index} : {0}")
    @CsvSource(value = {"5,5", "42,42"})
    void 로또_생성_테스트(int generatingNumber, int expectedLottoCount) {
        List<Lotto> lottos = lottoController.generateLottoAuto(generatingNumber);
        assertThat(lottos.size()).isEqualTo(expectedLottoCount);
    }

    @ParameterizedTest(name = "등수 확인 테스트 {index}: {7}등")
    @CsvSource(value = {
            "1,2,3,4,5,6,7,1",
            "1,2,3,4,5,8,6,2",
            "1,2,3,4,5,8,7,3",
            "1,2,3,4,7,8,40,4",
            "1,2,3,7,8,9,40,5",
            "1,2,7,8,9,10,4,6"
    })
    void 등수_확인_테스트(int num1, int num2, int num3, int num4, int num5, int num6, int bonusNum, int rankNum) {
        List<Integer> numbers = List.of(num1, num2, num3, num4, num5, num6);
        WinningLotto winningLotto = new WinningLotto(numbers, bonusNum);

        WinningRank actualRank = lottoController.judgeRank(winningLotto, baseLotto);
        WinningRank expectedRank = WinningRank.findByRank(rankNum);

        assertThat(actualRank).isEqualTo(expectedRank);
    }

    @Test
    void 당첨_로또_세기_테스트() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(1,2,3,4,5,7)),
                new Lotto(List.of(1,2,7,8,9,10)),
                new Lotto(List.of(5,6,7,8,9,10))
        );

        Map<WinningRank, Integer> winLottoCount = lottoController.countWinLotto(winningLotto, lottos);
        assertAll(
                () -> assertThat(winLottoCount.get(WinningRank.FIRST_RANK)).isEqualTo(1),
                () -> assertThat(winLottoCount.get(WinningRank.SECOND_RANK)).isEqualTo(1),
                () -> assertThat(winLottoCount.get(WinningRank.NONE_RANKED)).isEqualTo(2)
        );
    }

}