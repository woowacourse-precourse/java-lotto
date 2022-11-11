package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComparatorTest {

    private Comparator comparator;
    private List<Integer> userLotteryNumbers;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    @BeforeEach
    void initialize() {
        comparator = new Comparator();
        userLotteryNumbers = new ArrayList<>(Arrays.asList(1, 3, 7, 12, 23, 40));
        winningNumbers = new ArrayList<>(Arrays.asList(10, 11, 13, 16, 23, 26));
        bonusNumber = 7;
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호를 비교합니다")
    void getMatchCount() {
        int matchCount = comparator.getMatchCount(userLotteryNumbers, winningNumbers);

        assertThat(matchCount)
                .isEqualTo(1);
    }

    @Test
    @DisplayName("로또 번호와 보너스 번호를 비교합니다")
    void hasBonusNumber() {
        boolean hasBonusNumber = comparator.hasBonusNumber(userLotteryNumbers, bonusNumber);

        assertThat(hasBonusNumber)
                .isEqualTo(true);
    }
}