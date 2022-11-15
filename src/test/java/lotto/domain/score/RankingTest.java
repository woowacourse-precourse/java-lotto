package lotto.domain.score;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @Test
    void 점수에따라_스코어를_반환합니다() {
        assertThat(Ranking.generateRankByScore(new Score(6, 0))).isEqualTo(Ranking.FIRST_WINNING);
        assertThat(Ranking.generateRankByScore(new Score(5, 1))).isEqualTo(Ranking.SECOND_WINNING);
        assertThat(Ranking.generateRankByScore(new Score(5, 0))).isEqualTo(Ranking.THIRD_WINNING);
        assertThat(Ranking.generateRankByScore(new Score(4, 1))).isEqualTo(Ranking.FOURTH_WINNING);
        assertThat(Ranking.generateRankByScore(new Score(4, 0))).isEqualTo(Ranking.FOURTH_WINNING);
        assertThat(Ranking.generateRankByScore(new Score(3, 1))).isEqualTo(Ranking.FIFTH_WINNING);
        assertThat(Ranking.generateRankByScore(new Score(3, 0))).isEqualTo(Ranking.FIFTH_WINNING);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "0:1", "1:0", "1:1", "2:0", "2:1"}, delimiterString = ":")
    void 해당점수는_낙첨입니다(final Integer normal, final Integer bonus) {
        assertThat(Ranking.generateRankByScore(new Score(normal, bonus))).isEqualTo(Ranking.NOT_WINNING);

    }
}