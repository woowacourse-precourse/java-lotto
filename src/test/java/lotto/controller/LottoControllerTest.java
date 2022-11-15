package lotto.controller;

import lotto.domain.Lotto;
import lotto.validation.BonusNumberInputValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoControllerTest {
    private LottoController lottoController;

    @BeforeEach
    public void initialize() {
        lottoController = new LottoController();
    }

    @Test
    public void computeAmountOfLottoTest() {
        assertSimpleTest(() -> {
            assertThat(lottoController.computeAmountOfLotto(8000)).isEqualTo(8);
        });
    }

    @Test
    public void generateLottoTest() {
        int amountOfLotto = 8;
        lottoController.generateLotto(amountOfLotto);

        assertSimpleTest(() -> {
            assertThat(lottoController.getLottos().size()).isEqualTo(amountOfLotto);
        });
    }

    @Test
    public void computeMatchCountsTest() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottoController.setLottos(lottos);

        List<Integer> predictionNumbers = List.of(8, 21, 23, 3, 5, 11);
        int bonusNumber = 4;

        assertSimpleTest(() -> {
            assertThat(lottoController.computeMatchCounts(predictionNumbers, bonusNumber))
                    .isEqualTo(List.of(List.of(3, 0), List.of(3, 0)));
        });
    }

    @Test
    public void recordWinningLogTest() {
        List<List<Integer>> matchCounts = List.of(List.of(3,0), List.of(4,0));
        lottoController.recordWinningLog(matchCounts);

        assertSimpleTest(() -> {
            assertThat(lottoController.getWinningLog()).isEqualTo(new int[] {1, 1, 0, 0, 0});
        });

    }

    @Test
    public void computeRateOfReturnTest() {
        int purchasePrice = 2000;
        lottoController.setWinningLog(new int[] {1, 1, 0, 0, 0});

        assertSimpleTest(() -> {
            assertThat(lottoController.computeRateOfReturn(purchasePrice)).isEqualTo(2750.0);
        });
    }
}
