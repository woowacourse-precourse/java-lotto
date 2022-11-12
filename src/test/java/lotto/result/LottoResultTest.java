package lotto.result;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {
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
        List<Integer> ranks = List.of(5,1,0,0,0,1);
        List<String> answerMessage = List.of(Rank.ONE+"1", Rank.FIVE+"1");

        // when
        LottoResult.showResult(ranks, 0);

        // then
        assertThat(out.toString()).contains(answerMessage);
    }
}
