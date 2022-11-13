package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoScoreDtoTest {
    @DisplayName("LottoScoreDto 는 점수를 그대로 반환함")
    @Test
    void case1() {
        LottoScoreDto lottoScoreDto = new LottoScoreDto(1, 2, 3, 4, 5, 0.7);
        assertThat(lottoScoreDto.getThree()).isEqualTo(1);
        assertThat(lottoScoreDto.getFour()).isEqualTo(2);
        assertThat(lottoScoreDto.getFive()).isEqualTo(3);
        assertThat(lottoScoreDto.getFiveBonus()).isEqualTo(4);
        assertThat(lottoScoreDto.getSix()).isEqualTo(5);
        assertThat(lottoScoreDto.getRate()).isEqualTo(0.7);
    }
}
