package lotto.dto;

import lotto.vo.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreInfoTest {
    @Nested
    @DisplayName("ScoreInfo 생성자 테스트")
    class ScoreInfoConstructorTest {
        @Test
        @DisplayName("새로운 ScoreInfo 객체를 생성하면 등수 별 점수가 초기화되어 있다.")
        void givenNothing_whenCreatingScoreInfo_thenInitializesScoreInfo() {
            //when
            ScoreInfo scoreInfo = new ScoreInfo();

            //then
            assertThat(scoreInfo.get(Score.FIRST)).isEqualTo(0);
            assertThat(scoreInfo.get(Score.SECOND)).isEqualTo(0);
            assertThat(scoreInfo.get(Score.THIRD)).isEqualTo(0);
            assertThat(scoreInfo.get(Score.FORTH)).isEqualTo(0);
            assertThat(scoreInfo.get(Score.FIFTH)).isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("주어진 등수에 해당하는 ScoreInfo 의 당첨 횟수를 증가시키는 addScore 테스트")
    class AddScoreTest {
        @Test
        @DisplayName("ScoreInfo 에 점수를 추가하면 해당 객체에 저장된 점수가 올라간다. 새 객체를 반환하지 않는다.")
        void givenScoreInfo_whenAddingScore_thenAddsScore() {
            //given
            ScoreInfo scoreInfo = new ScoreInfo();

            //when
            scoreInfo.addScore(Score.THIRD);
            scoreInfo.addScore(Score.FORTH);
            scoreInfo.addScore(Score.FORTH);

            //then
            assertThat(scoreInfo.get(Score.THIRD)).isEqualTo(1);
            assertThat(scoreInfo.get(Score.FORTH)).isEqualTo(2);
        }
    }
}