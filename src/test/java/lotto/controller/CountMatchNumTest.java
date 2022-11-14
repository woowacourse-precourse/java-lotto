package lotto.controller;

import lotto.model.Lotto;
import lotto.model.UserLottoNum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountMatchNumTest {

    CountMatchNum countMatchNum;
    UserLottoNum userLottoNum;

    @BeforeEach
    void beforeEach() {
        countMatchNum = new CountMatchNum();
    }

    @Test
    @DisplayName("사용자 로또와 당첨 로또의 당첨 수 구하기")
    void countScore() {
        Assertions.assertThat(countMatchNum.countMatchNumber(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(5, 4, 3, 2, 1, 7))
        )).isEqualTo(5);
    }

    @Test
    void checkScoreIncrease() {
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 7, 8)));

        userLottoNum = new UserLottoNum(new ArrayList<Lotto>(List.of(lotto)));
        countMatchNum.DoMatchNumber(userLottoNum, new Lotto(List.of(5, 4, 3, 2, 1, 7)));

        System.out.println("countMatchNum.scoreBoard.rankAndScore = " + countMatchNum.scoreBoard.rankAndScore);

    }
}
