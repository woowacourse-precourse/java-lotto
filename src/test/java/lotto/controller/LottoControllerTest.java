package lotto.controller;

import lotto.mock.MockInputView;
import lotto.mock.MockLottoService;
import lotto.view.OutputViewImpl;
import lotto.vo.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoController 테스트")
class LottoControllerTest {
    private final LottoController lottoController
            = new LottoController(
            new MockInputView("3000", "4, 7, 9, 14, 22, 43", "10"),
            new OutputViewImpl(),
            new MockLottoService(
                    List.of(
                            new Lotto(Arrays.asList(1, 12, 13, 27, 31, 38)),
                            new Lotto(Arrays.asList(4, 7, 9, 14, 10, 43)),
                            new Lotto(Arrays.asList(9, 14, 22, 29, 31, 34))
                    )
            )
    );

    @Test
    @DisplayName("LottoController의 runLotto 메소드를 실행하여 어플리케이션의 주요 입출력과 비즈니스 로직을 실행할 수 있다.")
    void givenLottoController_whenRunningLotto_thenProcessesLogic() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        lottoController.runLotto();

        //then
        assertThat(out.toString())
                .contains("구입금액을 입력해 주세요.",
                        "3개를 구매했습니다.",
                        "[1, 12, 13, 27, 31, 38]",
                        "[4, 7, 9, 10, 14, 43]",
                        "[9, 14, 22, 29, 31, 34]",
                        "당첨 번호를 입력해 주세요.",
                        "보너스 번호를 입력해 주세요.",
                        "당첨 통계",
                        "---",
                        "3개 일치 (5,000원) - 1개",
                        "4개 일치 (50,000원) - 0개",
                        "5개 일치 (1,500,000원) - 0개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                        "6개 일치 (2,000,000,000원) - 0개",
                        "총 수익률은 1000166.7%입니다.");
    }
}