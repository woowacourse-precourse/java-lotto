package lotto.domain.settlementsysyem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ScoreTest {


    @Test
    void 비어있는_스코어를_추가할_수_있습니다() {
        var score = Score.generateEmptyScore();

        assertThat(score.getBonus()).isEqualTo(0);
        assertThat(score.getNormal()).isEqualTo(0);
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
}