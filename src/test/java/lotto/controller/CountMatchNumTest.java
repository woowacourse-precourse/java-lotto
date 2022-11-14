package lotto.controller;

import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountMatchNumTest {

    CountMatchNum countMatchNum;

    @BeforeEach
    void beforeEach() {
        countMatchNum = new CountMatchNum();
    }

    @Test
    @DisplayName("스코어 보드 초기화")
    void checkInitScoreBoard() {
        countMatchNum.initScoreBoard();

        Assertions.assertThat(countMatchNum.scoreBoard.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("사용자 로또와 당첨 로또의 당첨 수 구하기")
    void countScore() {
        Assertions.assertThat(countMatchNum.countMatchNumber(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(5, 4, 3, 2, 1, 7))
        )).isEqualTo(5);
    }
}
