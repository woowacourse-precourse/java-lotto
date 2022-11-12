package lotto.domain.settlementsysyem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RankingTest {

    @Test
    void 등수는_낙첨외_목록을_반환합니다() {
        var list = Ranking.generateList();
        var stringBuilder = new StringBuilder();

        for (var rankingAndCount : list.entrySet()) {
            stringBuilder.append(rankingAndCount.getKey().result()).append("\n");
        }
        var expected = "3개 일치 (5,000) \n"
                + "4개 일치 (50,000) \n"
                + "5개 일치 (15,000,000) \n"
                + "5개 일치, 보너스 볼 일치 (300,000,000) \n"
                + "6개 일치 (20,000,000)";

        assertThat(stringBuilder.toString().trim()).isEqualTo(expected);
    }
}