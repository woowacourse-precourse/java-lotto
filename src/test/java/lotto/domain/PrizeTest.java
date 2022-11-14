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

    @DisplayName("로또 1등 결과를 담고 있는 Result의 값에 일치하는 Prize가 잘 반환되는지 테스트")
    @Test
    void generateFirstPrize() {
        //given
        for (int i = 0; i < 6; i++) {
            result.increaseMatchCount();
        }
        //when
        Prize prize = Prize.generatePrize(result);
        //then
        assertThat(prize)
                  .isEqualTo(Prize.FIRST);
    }

    @DisplayName("로또 2등 결과를 담고 있는 Result의 값에 일치하는 Prize가 잘 반환되는지 테스트")
    @Test
    void generateSecondPrize() {
        //given
        for (int i = 0; i < 5; i++) {
            result.increaseMatchCount();
        }
        result.matchBonus();
        //when
        Prize prize = Prize.generatePrize(result);
        //then
        assertThat(prize)
                  .isEqualTo(Prize.SECOND);
    }

    @DisplayName("로또 3등 결과를 담고 있는 Result의 값에 일치하는 Prize가 잘 반환되는지 테스트")
    @Test
    void generateThirdPrize() {
        //given
        for (int i = 0; i < 5; i++) {
            result.increaseMatchCount();
        }
        //when
        Prize prize = Prize.generatePrize(result);
        //then
        assertThat(prize)
                  .isEqualTo(Prize.THIRD);
    }

    @DisplayName("로또 4등 결과를 담고 있는 Result의 값에 일치하는 Prize가 잘 반환되는지 테스트")
    @Test
    void generateFourthPrize() {
        //given
        for (int i = 0; i < 4; i++) {
            result.increaseMatchCount();
        }
        //when
        Prize prize = Prize.generatePrize(result);
        //then
        assertThat(prize)
                  .isEqualTo(Prize.FOURTH);
    }

    @DisplayName("로또 5등 결과를 담고 있는 Result의 값에 일치하는 Prize가 잘 반환되는지 테스트")
    @Test
    void generateFifthPrize() {
        //given
        for (int i = 0; i < 3; i++) {
            result.increaseMatchCount();
        }
        //when
        Prize prize = Prize.generatePrize(result);
        //then
        assertThat(prize)
                  .isEqualTo(Prize.FIFTH);
    }

    @DisplayName("로또 5등 이하의 결과를 담고 있는 Result의 값에 일치하는 Prize가 잘 반환되는지 테스트")
    @Test
    void generateNothingPrize() {
        //given
        for (int i = 0; i < 2; i++) {
            result.increaseMatchCount();
        }
        //when
        Prize prize = Prize.generatePrize(result);
        //then
        assertThat(prize)
                  .isEqualTo(Prize.NOTHING);
    }
}