package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ScoreTest {
    @DisplayName("당첨 번호가 클 때는 양수를 반환한다.")
    @Test
    void testWonNumberGrater(){
        Score score1 = new Score(2, 1);
        Score score2 = new Score(1, 1);

        assertThat(score1.compareTo(score2))
                .isGreaterThan(0);
    }

    @DisplayName("당첨 번호가 작을 때는 음수를 반환한다.")
    @Test
    void testWonNumberSmaller(){
        Score score1 = new Score(1, 1);
        Score score2 = new Score(2, 1);

        assertThat(score1.compareTo(score2))
                .isLessThan(0);
    }

    @DisplayName("당첨 번호는 같고 보너스 번호가 클 때는 양수를 반환한다.")
    @Test
    void testBonusNumberGrater(){
        Score score1 = new Score(1, 2);
        Score score2 = new Score(1, 1);

        assertThat(score1.compareTo(score2))
                .isGreaterThan(0);
    }

    @DisplayName("당첨 번호는 같고 보너스 번호가 작을 때는 음수를 반환한다.")
    @Test
    void testBonusNumberSmaller(){
        Score score1 = new Score(1, 1);
        Score score2 = new Score(1, 2);

        assertThat(score1.compareTo(score2))
                .isLessThan(0);
    }

    @DisplayName("당첨 번호와 보너스 번호 모두 같을 때는 0을 반환한다.")
    @Test
    void testSame(){
        Score score1 = new Score(1, 1);
        Score score2 = new Score(1, 1);

        assertThat(score1.compareTo(score2))
                .isEqualTo(0);
    }
}
