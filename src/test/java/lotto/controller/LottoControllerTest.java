package lotto.controller;

import lotto.validation.BonusNumberInputValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
