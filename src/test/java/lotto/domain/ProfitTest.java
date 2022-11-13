package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProfitTest {
    @Test
    public void HistoryTest() {
        History history = History.newInstance();
        history.report(Result.NONE);
        history.report(Result.THREE);
        history.report(Result.NONE);
        assertThat(history.calculateProfitRate()).isEqualTo("166.7");
    }
}
