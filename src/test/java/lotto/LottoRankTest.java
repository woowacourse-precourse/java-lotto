package lotto;

import lotto.constant.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.constant.Rank.*;

public class LottoRankTest {

    @Test
    void FIFTH_랭크_테스트(){
        Rank ranks = judgeRank(3, false);
        Assertions.assertThat(ranks).isEqualTo(FIFTH_PLACE);
    }

    @Test
    void FOURTH_랭크_테스트(){
        Rank ranks = judgeRank(4, false);
        Assertions.assertThat(ranks).isEqualTo(FOURTH_PLACE);
    }
    @Test
    void THIRD_랭크_테스트(){
        Rank ranks = judgeRank(5, false);
        Assertions.assertThat(ranks).isEqualTo(THIRD_PLACE);
    }
    @Test
    void SECOND_랭크_테스트(){
        Rank ranks = judgeRank(5, true);
        Assertions.assertThat(ranks).isEqualTo(SECOND_PLACE);
    }
    @Test
    void FIRST_랭크_테스트(){
        Rank ranks = judgeRank(6, false);
        Assertions.assertThat(ranks).isEqualTo(FIRST_PLACE);
    }
    @Test
    void NOT_WINNING_랭크_테스트_MatchCount_2(){
        Rank ranks = judgeRank(2, false);
        Assertions.assertThat(ranks).isEqualTo(FIRST_PLACE);
    }
    @Test
    void NOT_WINNING_랭크_테스트_MatchCount_1(){
        Rank ranks = judgeRank(1, false);
        Assertions.assertThat(ranks).isEqualTo(FIRST_PLACE);
    }
}
