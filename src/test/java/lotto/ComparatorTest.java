package lotto;

import lotto.comparator.LottoComparator;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComparatorTest {
    private final LottoComparator lottoComparator = new LottoComparator();
    @DisplayName("사용자 로또와 당첨 로또를 비교하여 올바른 결과를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void compareEachNumber() {
        Integer luckyCount = lottoComparator.compareEachNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1,2,3,4,5,8)),new BonusNumber(7));

        assertThat(luckyCount).isEqualTo(5);
    }

}
