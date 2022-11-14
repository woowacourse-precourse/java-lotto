package model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    @DisplayName("[Result] coincideCount와 bonus필드를 이용하여 해당 enumr객체 찾아오는지 테스트")
    void getResult() {
        //given
        int coincideCount=3;
        boolean bonus=false;
        //when
        Result result = Result.getResult(coincideCount, bonus);
        //then
        assertThat(result).isEqualTo(Result.THREE);
    }

    @Test
    @DisplayName("[Result] 2등(5개+보너스번호) enum객체 찾아오는지 테스트")
    void getResultSecond() {
        //given
        int coincideCount=5;
        boolean bonus=true;
        //when
        Result result = Result.getResult(coincideCount, bonus);
        //then
        assertThat(result).isEqualTo(Result.FIVE_BONUS);
    }

    @Test
    @DisplayName("[Result] 3개 일치+bonus번호가 일치하는경우 Result리턴")
    void getResultExcept() {
        //given
        int coincideCount=3;
        boolean bonus=true;
        //when
        Result result = Result.getResult(coincideCount, bonus);
        //then
        assertThat(result).isEqualTo(Result.LOST);
    }

    @Test
    @DisplayName("[Result] Lost(낙첨)없이 Result 리스트 가져오는지 테스트")
    void getResultWithoutLost() {
        //given
        //when
        List<Result> resultsWithoutLost = Result.getResultsWithoutLost();
        //then
        assertThat(resultsWithoutLost.get(0)).isEqualTo(Result.THREE);
        assertThat(resultsWithoutLost.get(1)).isEqualTo(Result.FOUR);
        assertThat(resultsWithoutLost.get(2)).isEqualTo(Result.FIVE);
        assertThat(resultsWithoutLost.get(3)).isEqualTo(Result.FIVE_BONUS);
        assertThat(resultsWithoutLost.get(4)).isEqualTo(Result.SIX);
    }
}