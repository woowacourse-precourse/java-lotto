package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {
    Result result;

    @BeforeEach
    void setUp() {
        result = new Result();
    }

    @DisplayName("로또 1등 결과를 담고 있는 Result의 값에 일치하는 Prize가 잘 반환되는지 테스트한다.")
    @Test
    void generateFirstPrize() {
        //given
        result = generateResult(6, false);
        //when
        Prize prize = Prize.generatePrize(result);
        //then
        assertThat(prize)
                  .isEqualTo(Prize.FIRST);
    }

    @DisplayName("로또 2등 결과를 담고 있는 Result의 값에 일치하는 Prize가 잘 반환되는지 테스트한다.")
    @Test
    void generateSecondPrize() {
        //given
        result = generateResult(5, true);
        //when
        Prize prize = Prize.generatePrize(result);
        //then
        assertThat(prize)
                  .isEqualTo(Prize.SECOND);
    }

    @DisplayName("로또 3등 결과를 담고 있는 Result의 값에 일치하는 Prize가 잘 반환되는지 테스트한다.")
    @Test
    void generateThirdPrize() {
        //given
        result = generateResult(5, false);
        //when
        Prize prize = Prize.generatePrize(result);
        //then
        assertThat(prize)
                  .isEqualTo(Prize.THIRD);
    }

    @DisplayName("로또 4등 결과를 담고 있는 Result의 값에 일치하는 Prize가 잘 반환되는지 테스트한다.")
    @Test
    void generateFourthPrize() {
        //given
        result = generateResult(4, false);
        //when
        Prize prize = Prize.generatePrize(result);
        //then
        assertThat(prize)
                  .isEqualTo(Prize.FOURTH);
    }

    @DisplayName("로또 5등 결과를 담고 있는 Result의 값에 일치하는 Prize가 잘 반환되는지 테스트한다.")
    @Test
    void generateFifthPrize() {
        //given
        result = generateResult(3, false);
        //when
        Prize prize = Prize.generatePrize(result);
        //then
        assertThat(prize)
                  .isEqualTo(Prize.FIFTH);
    }

    @DisplayName("로또 5등 이하의 결과를 담고 있는 Result의 값에 일치하는 Prize가 잘 반환되는지 테스트한다.")
    @Test
    void generateNothingPrize() {
        //given
        result = generateResult(2, false);
        //when
        Prize prize = Prize.generatePrize(result);
        //then
        assertThat(prize)
                  .isEqualTo(Prize.NOTHING);
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