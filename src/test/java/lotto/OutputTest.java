package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest extends NsTest {

    @Test
    void 올바른_로또_출력_lottoNumberPrinter(){
        Lotto lottoArrayInput = new Lotto(List.of(1,2,3,4,5,6));

        Output.lottoNumberPrinter(lottoArrayInput);

        assertThat(output()).contains(
                "[1, 2, 3, 4, 5, 6]"
        );
    }

    @Test
    void 올바른_당첨통계_출력_winningStatisticPrinter(){
        int[] correctCountInput = new int[]{0,0,1,0,0};

        Output.winningStatisticPrinter(correctCountInput);

        assertThat(output()).contains(
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개"
        );
    }

    @Test
    void 올바른_수익률_출력_yieldCalculation(){
        int[] correctCountInput = new int[]{0,0,1,0,0};
        int purchasedValueInput = 1000;

        Output.yieldCalculation(correctCountInput, purchasedValueInput);
        String outputResult = output();
        assertThat(outputResult).isEqualTo("총 수익률은 150,000.0%입니다.");
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
