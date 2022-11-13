package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGeneratorTest {
    private static final int PRICE_PER_LOTTO = 1000;

    @DisplayName("구입 금액 만큼 로또 발행 테스트")
    @ParameterizedTest
    @CsvSource({"8000", "1000", "24000"})
    void generateLotto(Integer purchasePrice) {
        Price price = new Price(purchasePrice);
        LottoGenerator lottoGenerator = new LottoGenerator(price);

        assertThat(lottoGenerator.generateLotto().size()).isEqualTo(price.getPurchasePrice() / PRICE_PER_LOTTO);
    }
}