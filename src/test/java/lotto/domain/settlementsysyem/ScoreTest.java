package lotto.domain.settlementsysyem;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ScoreTest {
    private final ScoreGenerator scoreGenerator = new ScoreGenerator();

    @Test
    void _스코어가_0점_0점이면_낙첨입니다() {
        var score = Score.generateEmptyScore();
        var actual = score.generateRank();
        Assertions.assertThat(actual).isEqualTo(Ranking.NOT_WINNING);
    }


    @ParameterizedTest
    @CsvSource(value = {"6:0"}, delimiterString = ":")
    void _스코어가_6점_0점이면_1등입니다(final Integer normal, final Integer bonus) {
        var score = this.scoreGenerator.generate(normal, bonus);
        var actual = score.generateRank();
        Assertions.assertThat(actual).isEqualTo(Ranking.FIRST_WINNING);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:1"}, delimiterString = ":")
    void 스코어가_5점_1점이면_2등입니다(final Integer normal, final Integer bonus) {
        var score = this.scoreGenerator.generate(normal, bonus);
        var actual = score.generateRank();
        Assertions.assertThat(actual).isEqualTo(Ranking.SECOND_WINNING);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:1", "5:0"}, delimiterString = ":")
    void 스코어가_5점_0점_혹은_4점_1점이면_3등입니다(final Integer normal, final Integer bonus) {
        var score = this.scoreGenerator.generate(normal, bonus);
        var actual = score.generateRank();
        Assertions.assertThat(actual).isEqualTo(Ranking.THIRD_WINNING);
    }


    @ParameterizedTest
    @CsvSource(value = {"3:1", "4:0"}, delimiterString = ":")
    void 스코어가_3점_1점_혹은_3점_0점이면_4등입니다(final Integer normal, final Integer bonus) {
        var score = this.scoreGenerator.generate(normal, bonus);
        var actual = score.generateRank();
        Assertions.assertThat(actual).isEqualTo(Ranking.FOURTH_WINNING);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:1"}, delimiterString = ":")
    void 스코어가_2점_1점이면_5등입니다(final Integer normal, final Integer bonus) {
        var score = this.scoreGenerator.generate(normal, bonus);
        var actual = score.generateRank();
        Assertions.assertThat(actual).isEqualTo(Ranking.FIFTH_WINNING);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "0:0", "1:0", "1:1", "2:0"}, delimiterString = ":")
    void 그_외의_경우는_전부_낙첨입니다(final Integer normal, final Integer bonus) {
        var score = this.scoreGenerator.generate(normal, bonus);
        var actual = score.generateRank();
        Assertions.assertThat(actual).isEqualTo(Ranking.NOT_WINNING);
    }

    @ParameterizedTest
    @CsvSource(value = {"6:1", "5:0", "0:0", "1:1", "2:1", "3:0"}, delimiterString = ":")
    void 스코어는_일반점수와_보너스점수가_같으면_같은_스코어입니다(final Integer normal, final Integer bonus) {
        var target = new Score(normal, bonus);
        var original = new Score(normal, bonus);

        assertThat(target).isEqualTo(original);
    }


    @ParameterizedTest
    @CsvSource(value = {"6:1", "5:0", "1:2", "4:0", "4:1", "3:0"}, delimiterString = ":")
    void 스코어는_일반점수와_보너스점수가_다르면_다른_스코어입니다(final Integer normal, final Integer bonus) {
        var target = new Score(normal, bonus);
        var original = new Score(bonus, normal);

        assertThat(target).isNotEqualTo(original);
    }


    class ScoreGenerator {
        public Score generate(final Integer normalCount, final Integer bonusCount) {
            var score = Score.generateEmptyScore();
            for (int i = 0; i < normalCount; i++) {
                score = score.plusNormal();
            }

            for (int i = 0; i < bonusCount; i++) {
                score = score.plusBonus();
            }
            return score;
        }
    }
}