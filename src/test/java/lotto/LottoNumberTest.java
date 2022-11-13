package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @DisplayName("구입한 로또 번호가 오름차순으로 나오는지")
    @Test
    void getLottoNumbers() {
        LottoNumber lottoNumber = new LottoNumber(List.of(9, 8, 7, 6, 5, 4));

        assertThat(lottoNumber.getNumbers()).containsExactly(4, 5, 6, 7, 8, 9);
    }
}