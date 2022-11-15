package lotto.result;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.domain.Rank;
import lotto.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    private OutputStream out;

    @BeforeEach
    void init() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("rank 통계 출력 테스트")
    @Test
    void showRankStats() {
        // given
        List<Integer> ranks = List.of(5, 1, 0, 0, 0, 1);
        List<String> answerMessage = List.of(Rank.ONE + "1", Rank.FIVE + "1");

        // when
        OutputView.showResult(ranks, 0);

        // then
        assertThat(out.toString()).contains(answerMessage);
    }

    @DisplayName("수익률 출력 테스트")
    @Test
    void showResultYield() {
        // given
        List<Integer> ranks = List.of(7, 0, 0, 0, 0, 1);
        int lottoPrice = 8000;
        String answer = "총 수익률은 62.5%입니다.";

        // when
        OutputView.showResult(ranks, lottoPrice);

        // then
        assertThat(out.toString()).contains(answer);
    }
}
