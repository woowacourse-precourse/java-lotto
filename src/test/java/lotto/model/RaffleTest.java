package lotto.model;

import lotto.type.PrizeType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RaffleTest {
    @DisplayName("두 개의 생성자가 동일한 일을 하는지 비교한다.")
    @Test
    void setBonus() {
        Lotto lotto = Lotto.fromRandomNumbers();
        Bonus bonus = new Bonus(7);

        Raffle raffle1 = new Raffle(lotto, bonus);
        Raffle raffle2 = new Raffle(lotto);
        raffle2.setBonus(bonus);

        assertThat(raffle1.equals(raffle2)).isTrue();
    }


    @ParameterizedTest(name = "객체가 동등한지 확인하기")
    @MethodSource("testData")
    void testEquals(Raffle raffle, Raffle other, boolean result) {
        assertThat(raffle.equals(other)).isEqualTo(result);
    }

    @ParameterizedTest(name = "해쉬코드가 동등한지 확인하기")
    @MethodSource("testData")
    void testHashCode(Raffle raffle, Raffle other, boolean result) {
        assertThat(raffle.hashCode() == other.hashCode()).isEqualTo(result);
    }

    static Stream<Arguments> testData() {
        Lotto lotto1 = Lotto.fromRandomNumbers();
        Lotto lotto2 = Lotto.fromRandomNumbers();
        Bonus bonus1 = new Bonus(1);
        Bonus bonus2 = new Bonus(2);

        return Stream.of(
                Arguments.of(new Raffle(lotto1, bonus1), new Raffle(lotto1, bonus1), true),
                Arguments.of(new Raffle(lotto1, bonus1), new Raffle(lotto1, bonus2), false),
                Arguments.of(new Raffle(lotto1, bonus1), new Raffle(lotto2, bonus2), false),
                Arguments.of(new Raffle(lotto1, bonus1), new Raffle(lotto2, bonus1), false)
        );
    }

    @ParameterizedTest(name = "당첨 번호 및 보너스 번호와 로또 번호를 비교한다.")
    @MethodSource("getPrizeTypeWithData")
    void getPrizeTypeWith(Lotto lotto, PrizeType result) {
        Raffle raffle = new Raffle(new Lotto(List.of(11, 12, 13, 14, 15, 16)), new Bonus(22));
        assertThat(raffle.getPrizeTypeWith(lotto)).isEqualTo(result);
    }

    static Stream<Arguments> getPrizeTypeWithData() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(11, 12, 13, 14, 15, 16)), PrizeType.FIRST_PRIZE),
                Arguments.of(new Lotto(List.of(11, 12, 13, 14, 15, 22)), PrizeType.SECOND_PRIZE),
                Arguments.of(new Lotto(List.of(11, 12, 13, 14, 15, 17)), PrizeType.THIRD_PRIZE),
                Arguments.of(new Lotto(List.of(11, 12, 13, 14, 17, 18)), PrizeType.FOURTH_PRIZE),
                Arguments.of(new Lotto(List.of(11, 12, 13, 17, 18, 19)), PrizeType.FIFTH_PRIZE),
                Arguments.of(new Lotto(List.of(11, 12, 17, 18, 19, 20)), PrizeType.NOTHING),

                Arguments.of(new Lotto(List.of(11, 12, 13, 14, 17, 22)), PrizeType.NOTHING)
        );
    }
}