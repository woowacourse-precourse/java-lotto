package domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    static Result result;

    @BeforeAll
    public static void setResult() {
        result = new Result();
    }

    @Test
    public void round_test() {
        assertThat(result.roundProfit(12.456)).isEqualTo(12.5);
        assertThat(result.roundProfit(123.123)).isEqualTo(123.1);
    }

    @Test
    public void calcProfit_test() {
        assertThat(result.calcProfit(8000, 5000)).isEqualTo(62.5) ;
    }

    @Test
    public void profit_test() {
        assertThat(result.roundProfit(123.123)).isEqualTo(123.1);
        assertThat(result.roundProfit(0.123)).isEqualTo(0.1);
        assertThat(result.roundProfit(0.564)).isEqualTo(0.6);
    }
}
