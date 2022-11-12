package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheckerTest {
    @DisplayName("로또번호와 당첨번호를 비교하여 당첨된 등수를 알 수 있다.")
    @Test
    void compareLottoNumbersTest() {
        assertThat(Checker.getRank(5)).isEqualTo(PrizeRank.THIRD);
    }

    @DisplayName("당첨번호와 일치하는 번호의 개수를 알 수 있다.")
    @Test
    void countSameNumbersTest() {
        LottoKiosk.winningNumbers = List.of(1, 2, 3, 7, 8, 9);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(Checker.countSameNumbers(lotto)).isEqualTo(3);
    }

    @DisplayName("당첨번호와 로또 번호를 비교한다.")
    @Test
    void compareLottoTest() {
        LottoKiosk.winningNumbers = List.of(1, 2, 3, 7, 8, 9);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(3, 4, 5, 6, 7, 8)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9))
        );
        Checker.compare(lottos);
        assertThat(LottoKiosk.resultStatistics).isEqualTo(new Integer[]{1, 0, 0, 0, 2, 0});
    }
}
