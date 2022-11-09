package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    LottoNumber lottoNumber = new LottoNumber();

    @Test
    void 로또번호_크기_확인() {
        List<Integer> lottoNumbers = lottoNumber.create();

        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    void 로또번호_중복_확인() {
        List<Integer> lottoNumbers = lottoNumber.create();
        int lottoSize = lottoNumbers.stream()
                .distinct()
                .collect(Collectors.toList()).size();

        assertThat(lottoNumbers.size()).isEqualTo(lottoSize);
    }

    @Test
    void 로또번호_정렬_확인() {
        List<Integer> lottoNumbers = lottoNumber.create();

        for (int i = 0; i < lottoNumbers.size() - 1; i++) {
            assertThat(lottoNumbers.get(i)).isLessThan(lottoNumbers.get(i + 1));
        }
    }
}