package lotto.util;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @Test
    @DisplayName("lotto 6자리 번호 생성 성공")
    void generateNumbers_Success() {
        // Given
        // When
        List<Integer> lottoNumbers = LottoNumberGenerator.generateNumbers();

        // Then
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

}