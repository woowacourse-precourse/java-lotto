package lotto;

import lotto.domain.WinningsCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningsCalculatorTest {
    List<Integer> winningNumbers = List.of(8, 10, 2, 1, 5, 7);
    int bonusNumber = 40;
    WinningsCalculator winningsCalculator = new WinningsCalculator(winningNumbers, bonusNumber);

    @DisplayName("숫자 리스트와 타겟 숫자가 일치 여부 확인 - 성공")
    @Test
    void isExistentNumber_Success() {
        List<Integer> numbers = List.of(8, 10, 2, 1, 5, 7);
        int targetNumber = 7;
        assertThat(winningsCalculator.isExistentNumber(numbers, targetNumber))
                .isTrue();
    }

    @DisplayName("숫자 리스트와 타겟 숫자가 일치 여부 확인 - 실패")
    @Test
    void isExistentNumber_Fail() {
        List<Integer> numbers = List.of(8, 10, 2, 1, 5, 7);
        int targetNumber = 13;
        assertThat(winningsCalculator.isExistentNumber(numbers, targetNumber))
                .isFalse();
    }

    @DisplayName("당첨 번호와 일치하는 개수 세기")
    @Test
    void countMatchingWinningNumbers() {
        List<Integer> lottoNumbers = List.of(2, 3, 5, 7, 10, 40);
        int matchingCount = 4;
        assertThat(winningsCalculator.countMatchingWinningNumbers(lottoNumbers))
                .isEqualTo(matchingCount);
    }

    @DisplayName("보너스 번호와 일치하는 개수 세기")
    @Test
    void countMatchingBonusNumbers() {
        List<Integer> lottoNumbers = List.of(7, 2, 5, 3, 10, 41);
        int matchingCount = 0;
        assertThat(winningsCalculator.countMatchingBonusNumbers(lottoNumbers))
                .isEqualTo(matchingCount);
    }
}


/*
로또 번호와 추첨 번호 비교하여 일치하는 개수 세기
 */