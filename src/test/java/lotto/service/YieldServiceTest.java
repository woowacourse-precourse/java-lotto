package lotto.service;

import lotto.domain.Rank;
import lotto.dto.RankAggregationDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class YieldServiceTest {

    @Test
    @DisplayName("수익률 계산하기 테스트")
    void calculate() {
        // given
        Map<Rank, Integer> map = new EnumMap<>(Rank.class) {{
            put(Rank.FIFTH, 1);
        }};

        RankAggregationDto rankAggregationDto = RankAggregationDto.of(map);
        int payment = 8000;
        String expectedValue = "62.5";

        // when
        YieldService service = new YieldService();
        String result = service.calculate(rankAggregationDto, payment);

        // then
        assertThat(expectedValue).isEqualTo(result);
    }
}