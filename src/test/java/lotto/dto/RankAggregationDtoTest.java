package lotto.dto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RankAggregationDtoTest {

    @Test
    @DisplayName("RankAggregationDto 인스턴스 생성 테스트")
    void of() {
        // given
        Map<Rank, Integer> rankIntegerMap = new EnumMap<>(Rank.class);

        // when
        RankAggregationDto result = RankAggregationDto.of(rankIntegerMap);

        // then
        assertThat(rankIntegerMap).isEqualTo(result.getRankAggregationMap());
    }
}