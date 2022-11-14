package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EarningRateCalculateTest {

    private static EarningRateCalculator calculator;

    @BeforeAll
    static void init()
    {
        calculator = EarningRateCalculator.getInstance();
    }

    @DisplayName("3장 사서 3장모두 5등 당첨된 경우")
    @Test
    void calculateExample()
    {
        List<Prize> prizes = List.of(Prize.Fifth,Prize.Fifth,Prize.Fifth);
        double percentage = calculator.calculate(prizes, 3_000);
        Assertions.assertThat(percentage).isEqualTo(500.00);
    }

    @DisplayName("9장 사서 2장 5등 1장 4등이 당첨된 경우")
    @Test
    void calculateExample1()
    {
        List<Prize> prizes = List.of(Prize.Fifth,Prize.Fifth,Prize.Fourth);
        double percentage = calculator.calculate(prizes, 9_000);
        Assertions.assertThat(percentage).isEqualTo(666.67);
    }

    @DisplayName("13장 사서 2장 5등 1장 4등 1장 3등이 당첨된 경우")
    @Test
    void calculateExample2()
    {
        List<Prize> prizes = List.of(Prize.Fifth,Prize.Fifth,Prize.Fourth,Prize.Third);
        double percentage = calculator.calculate(prizes, 13_000);
        Assertions.assertThat(percentage).isEqualTo(12000.00);
    }

    @DisplayName("1장 사서 2등이 당첨된 경우")
    @Test
    void calculateExample3()
    {
        List<Prize> prizes = List.of(Prize.Second);
        double percentage = calculator.calculate(prizes, 1_000);
        Assertions.assertThat(percentage).isEqualTo(3000000.00);
    }

    @DisplayName("1장 사서 1등이 당첨된 경우")
    @Test
    void calculateExample4()
    {
        List<Prize> prizes = List.of(Prize.First);
        double percentage = calculator.calculate(prizes, 1_000);
        Assertions.assertThat(percentage).isEqualTo(200000000.00);
    }

    @DisplayName("31장 사서 5등이 5번 당첨된 경우")
    @Test
    void calculateExample5()
    {
        List<Prize> prizes = List.of(Prize.Fifth,Prize.Fifth,Prize.Fifth,Prize.Fifth,Prize.Fifth);
        double percentage = calculator.calculate(prizes, 31_000);
        Assertions.assertThat(percentage).isEqualTo(80.65);
    }

    @DisplayName("79장 사서 5등이 7번, 4등이 2번 당첨된 경우")
    @Test
    void calculateExample6()
    {
        List<Prize> prizes = List.of(Prize.Fifth,Prize.Fifth,Prize.Fifth,Prize.Fifth,Prize.Fifth,Prize.Fifth,Prize.Fifth,Prize.Fourth,Prize.Fourth);
        double percentage = calculator.calculate(prizes, 79_000);
        Assertions.assertThat(percentage).isEqualTo(170.89);
    }

}
