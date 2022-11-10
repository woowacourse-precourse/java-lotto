package lotto.controller;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoControllerTest {

    private LottoController lottoController;

    @BeforeEach
    void setUp() {
        lottoController = new LottoController();
    }

    @ParameterizedTest(name = "로또_자동생성_테스트 {index} : {0} 원 - {1}개")
    @CsvSource(value = {"5000,5", "42000,42"})
    void 로또_생성_테스트(int purchaseAmount, int expectedLottoCount) {
        List<Lotto> lottos = lottoController.generateLottoAuto(purchaseAmount);
        assertThat(lottos.size()).isEqualTo(expectedLottoCount);
    }
}