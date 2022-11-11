package lotto.model;

import lotto.model.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("LottoRank Unit Test")
class LottoRankTest {

    @Test
    @DisplayName("맞춘 번호 개수와 보너스 번호 유무를 통해 순위를 알 수 있습니다.")
    void testLottoRank() throws Exception {
        //given
        int correctCount = 6;
        boolean bounsFlag = false;

        //when
        LottoRank lottoRank = LottoRank.getRank(correctCount, bounsFlag);

        //then
        assertThat(lottoRank.getDescription()).isEqualTo("6개 일치");
        assertThat(lottoRank.getReward()).isEqualTo(2_000_000_000);
    }

    @Test
    @DisplayName("맞춘 번호의 개수가 3개 미만일 경우엔 순위에 들 수 없습니다.")
    void testLottoRank_IllegalArgumentException() throws Exception {
        //given
        int correctCount = 2;
        boolean bounsFlag = false;

        //when & then
        assertThat(LottoRank.getRank(correctCount, bounsFlag)).isEqualTo(LottoRank.NONE);
    }
}