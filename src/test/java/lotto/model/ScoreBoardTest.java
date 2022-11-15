package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardTest {

    @Test
    @DisplayName("스코어 보드 생성 확인")
    void checkScoreBoardInit() {
        ScoreBoard scoreBoard = new ScoreBoard();
        Assertions.assertThat(scoreBoard.getRankAndScore().size()).isEqualTo(5);
    }
}