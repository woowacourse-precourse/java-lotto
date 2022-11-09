package lotto.service;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LottoGameServiceTest {

    LottoGameService lottoGameService;

    @BeforeEach
    void generateLottoGameService() {
        lottoGameService = new LottoGameService();
    }
    @ParameterizedTest
    @ValueSource(strings = {"10000", "20000", "35000", "1000"})
    void 로또_발행_개수_반환(String lottoPurchaseAmount) {
        int lottoIssueCount = lottoGameService.getLottoIssueCount(lottoPurchaseAmount);

        assertThat(lottoIssueCount).isEqualTo(Integer.parseInt(lottoPurchaseAmount) / 1000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"500", "1500", "1750", "10002"})
    void 로또_구입_금액이_1000으로_나누어_떨어지지_않으면_예외_발생(String lottoPurchaseAmount) {
        assertThatThrownBy(() -> lottoGameService.getLottoIssueCount(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}