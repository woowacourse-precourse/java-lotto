package lotto;

import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
    private final LottoNumbers lottoNumbers = new LottoNumbers();

    @DisplayName("구입 금액에 맞춰서 로또 생성한다.")
    @Test
    void createLottoNumbersByAmount() {
         assertThat(lottoNumbers.printLotto(7).size()).isEqualTo(7);
    }

}
