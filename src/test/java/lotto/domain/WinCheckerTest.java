package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.enumeration.Rank;
import org.junit.jupiter.api.Test;

public class WinCheckerTest {

    @Test
    void 보너스_당첨번호_포함시_예외_테스트() {
        assertThatThrownBy(() -> new WinChecker(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 올바로_등수_체크_하는지_테스트() {
        //given
        WinChecker winChecker = new WinChecker(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        //when
        Map<Rank, Integer> testResult = winChecker.checkLotto(lottos);

        //then
        Map<Rank, Integer> result = new HashMap<Rank, Integer>() {{
            put(Rank.FIRST, 1);
        }};
        assertThat(result).isEqualTo(testResult);
    }
}
