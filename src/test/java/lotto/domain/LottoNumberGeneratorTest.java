package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private List<Integer> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = lottoNumberGenerator.generate();
    }

    @Test
    @DisplayName("로또 번호 갯수 확인")
    void checkSize() {
        assertThat(lottoNumbers)
                .size()
                .isEqualTo(Lotto.NUMBER_COUNT);
    }

    @Test
    @DisplayName("로또 번호가 중복되지 않는지 확인")
    void checkDuplicate() {
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("로또 번호 정렬 여부 확인")
    void checkIsSorted() {
        assertThat(lottoNumbers).isSorted();
    }

    @Test
    @DisplayName("로또 번호 숫자 범위 확인")
    void checkRange() {
        assertThat(lottoNumbers).allSatisfy(
                lottoNumber -> assertThat(lottoNumber)
                        .isGreaterThanOrEqualTo(Lotto.NUMBER_RANGE_START)
                        .isLessThanOrEqualTo(Lotto.NUMBER_RANGE_END));
    }
}
