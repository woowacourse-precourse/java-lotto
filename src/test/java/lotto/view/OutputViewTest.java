package lotto.view;

import lotto.domain.PurchasedLottos;
import lotto.domain.Rank;
import lotto.domain.Result;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {

    @Test
    void 자동_생성_로또_번호_출력_테스트() {
        OutputView outputView = new OutputView();
        PurchasedLottos lottos = new PurchasedLottos(3);


        outputView.printPurchasedLottos(3, lottos);
    }

    @Test
    void 당첨_통계_출력_테스트() {
        OutputView outputView = new OutputView();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Result result = new Result();
        result.add(Rank.THREE);

        outputView.printResult(result, 8000);

        assertThat(out.toString())
                .isEqualTo("당첨 통계" + System.lineSeparator()
                        + "---" + System.lineSeparator()
                        + "3개 일치 (5,000원) - 1개" + System.lineSeparator()
                        + "4개 일치 (50,000원) - 0개" + System.lineSeparator()
                        + "5개 일치 (1,500,000원) - 0개" + System.lineSeparator()
                        + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개" + System.lineSeparator()
                        + "6개 일치 (2,000,000,000원) - 0개" + System.lineSeparator()
                        + "총 수익률은 62.5%입니다."
                );
    }
}
