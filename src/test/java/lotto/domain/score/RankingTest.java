package lotto.domain.score;

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
            var result = rankingAndCount.getKey()
                    .result();

            stringBuilder.append(result)
                    .append("\n");

        }
        var expected = "3개 일치 (5,000원)\n"
                + "4개 일치 (50,000원)\n"
                + "5개 일치 (1,500,000원)\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원)\n"
                + "6개 일치 (2,000,000,000원)";
        var actual = stringBuilder.toString()
                .trim();
        assertThat(actual).isEqualTo(expected);
    }
}