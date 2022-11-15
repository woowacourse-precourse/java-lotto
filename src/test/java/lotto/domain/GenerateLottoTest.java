package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GenerateLottoTest {

    @DisplayName("발행 갯수에 따라 생성되는 복권의 수를 비교해본다.")
    @Test
    void createLottoByDuplicatedNumber() {
        GenerateLottoNumber generateLottoNumber = new GenerateLottoNumber(10);
        assertThat(generateLottoNumber.getLottoNumber().size()).isEqualTo(10);
    }
}
