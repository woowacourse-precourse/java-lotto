package lotto.domain.lotto;

import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    @Test
    @DisplayName("로또 한 장 구매")
    void generateRandomLottoNumber() {
        LottoGenerator lottoGenerator = new LottoGenerator();

        Lotto lotto = lottoGenerator.generateRandomLottoNumber();

        assertAll(
                () -> assertThat(lotto.getMaxNum()).isLessThanOrEqualTo(45),
                () -> assertThat(lotto.getMinNum()).isGreaterThanOrEqualTo(1),
                () -> assertThat(lotto.getCount()).isEqualTo(6)
        );
    }

    @Test
    @DisplayName("로또 여러 장 구매")
    void generateLottos() {
        LottoGenerator lottoGenerator = new LottoGenerator();

        LottoGroup lottoGroup = lottoGenerator.generateLottos(6);

        assertThat(lottoGroup.getCount()).isEqualTo(6);
    }
}