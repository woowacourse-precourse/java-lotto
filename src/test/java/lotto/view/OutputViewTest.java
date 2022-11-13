package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.ResultStatistics;
import lotto.domain.WinLotto;
import lotto.enums.ResultStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class OutputViewTest {
    List<Lotto> lottos = new ArrayList<>();

    @BeforeEach
    void init() {
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)));
        lottos.add(new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18)));
    }

    @Test
    void test() {
        WinLotto winLotto = new WinLotto(Arrays.asList(4, 5, 6, 7, 8, 9), 10);
        List<Result> results = OutputView.getResults(lottos, winLotto);
        ResultStatistics resultStatistics = new ResultStatistics(results);
        assertThat(resultStatistics.getMatchCount(ResultStatus.MATCH3)).isEqualTo(2);
    }
}