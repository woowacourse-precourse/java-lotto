package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ResultTest {

    @DisplayName("Result와 Prize가 일치하였을때 True를 반환하는지 테스트한다.")
    @Test
    void isProperPrize() {
        //given
        Prize prize = Prize.SECOND;
        Result result = generateResult(5, true);
        //when
        boolean issProperPrize = result.isProperPrize(prize);
        //then
        assertThat(issProperPrize)
                  .isTrue();
    }

    Result generateResult(int number, boolean isBonus) {
        Result result = new Result();
        for (int i = 0; i < number; i++) {
            result.increaseMatchCount();
        }
        if (isBonus) {
            result.matchBonus();
        }
        return result;
    }
}