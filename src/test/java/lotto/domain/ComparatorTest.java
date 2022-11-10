package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComparatorTest {

    private Comparator comparator;
    private List<Integer> userLotteryNumbers;
    private List<Integer> winningNumbers;

    @BeforeEach
    void initialize() {
        comparator = new Comparator();
        userLotteryNumbers = new ArrayList<>(Arrays.asList(1, 3, 7, 12, 23, 40));
        winningNumbers = new ArrayList<>(Arrays.asList(10, 11, 13, 16, 23, 26));
    }

    @Test
    void 로또_번호와_당첨_번호를_비교합니다() {
        int matchCount = comparator.getMatchCount(userLotteryNumbers, winningNumbers);

        assertThat(matchCount)
                .isEqualTo(1);
    }
}