package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class ProfitTest {
    @Test
    public void HistoryTest() {
        History history = History.newInstance();
        history.report(Result.NONE);
        history.report(Result.THREE);
        history.report(Result.NONE);
        assertThat(history.calculateProfitRate()).isEqualTo("166.7");
    }
    @Test
    public void HistoryTest2() {
        History history = History.newInstance();
        history.report(Result.NONE);
        history.report(Result.NONE);
        history.report(Result.NONE);
        history.report(Result.NONE);
        history.report(Result.NONE);
        history.report(Result.NONE);
        history.report(Result.NONE);
        history.report(Result.THREE);
        assertThat(history.calculateProfitRate()).isEqualTo("62.5");
    }
}
