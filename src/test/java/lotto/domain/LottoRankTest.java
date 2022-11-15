package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @Test
    void 보너스번호포함할경우확인() {
        Assertions.assertThat(LottoRank.getRank(5, true)).isEqualTo(LottoRank.SECOND_PRIZE);
    }

    @Test
    void 보너스포함하지않을경우확인() {
        Assertions.assertThat(LottoRank.getRank(0, false)).isEqualTo(LottoRank.MISS_PRIZE);
        Assertions.assertThat(LottoRank.getRank(3, false)).isEqualTo(LottoRank.FIFTH_PRIZE);
        Assertions.assertThat(LottoRank.getRank(4, false)).isEqualTo(LottoRank.FOURTH_PRIZE);
        Assertions.assertThat(LottoRank.getRank(5, false)).isEqualTo(LottoRank.THIRD_PRIZE);
        Assertions.assertThat(LottoRank.getRank(6, false)).isEqualTo(LottoRank.FIRST_PRIZE);
    }

    @Test
    void 맞춘개수잘가져오는지확인() {
        Assertions.assertThat(LottoRank.MISS_PRIZE.getCorrectCount()).isEqualTo(0);
        Assertions.assertThat(LottoRank.FIFTH_PRIZE.getCorrectCount()).isEqualTo(3);
        Assertions.assertThat(LottoRank.FOURTH_PRIZE.getCorrectCount()).isEqualTo(4);
        Assertions.assertThat(LottoRank.THIRD_PRIZE.getCorrectCount()).isEqualTo(5);
        Assertions.assertThat(LottoRank.SECOND_PRIZE.getCorrectCount()).isEqualTo(5);
        Assertions.assertThat(LottoRank.FIRST_PRIZE.getCorrectCount()).isEqualTo(6);
    }

    @Test
    void 로또보상잘가져오는지확인() {
        Assertions.assertThat(LottoRank.MISS_PRIZE.getLottoReward()).isEqualTo(0);
        Assertions.assertThat(LottoRank.FIFTH_PRIZE.getLottoReward()).isEqualTo(5000);
        Assertions.assertThat(LottoRank.FOURTH_PRIZE.getLottoReward()).isEqualTo(50000);
        Assertions.assertThat(LottoRank.THIRD_PRIZE.getLottoReward()).isEqualTo(1500000);
        Assertions.assertThat(LottoRank.SECOND_PRIZE.getLottoReward()).isEqualTo(30000000);
        Assertions.assertThat(LottoRank.FIRST_PRIZE.getLottoReward()).isEqualTo(2000000000);
    }

}