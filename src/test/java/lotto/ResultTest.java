package lotto;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.ResultType;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultTest {
    private final Result result = new Result();
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @AfterEach
    void tearDown(){
        System.setOut(standardOut);
    }

    @DisplayName("로또 번호와 당첨 번호를 비교한다.")
    @Test
    void compareLottoWithWinningNumber() {
        assertThat(result.compareLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)),Arrays.asList(1,2,3,4,9,8))).isEqualTo(4);

    }

    @DisplayName("로또 번호와 보너스 번호를 비교한다.")
    @Test
    void compareLottoWithBonusNumber() {
        assertThat(result.compareBonus(new Lotto(Arrays.asList(1,2,3,4,5,6)),"1")).isEqualTo(true);

    }
    @DisplayName("당첨 결과로 등수를 구한다.")
    @Test
    void makeRank() {
        assertThat(result.makeTotalWinnings(4,false)).isEqualTo(ResultType.FOUR);
    }

    @DisplayName("당첨금을 계산한다.")
    @Test
    void calculatePrize() {
        assertThat(result.makePrize(Map.of(ResultType.FOUR,2))).isEqualTo(100000);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateProfit() {
        double yield = result.calculateProfit(12000,5000);
        assertThat(Math.round(yield*10)/10.0).isEqualTo(41.7);
    }

}
