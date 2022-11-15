package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.TotalPrizeNumbers.*;
import static org.assertj.core.api.Assertions.*;

class TotalPrizeNumbersTest {

    @DisplayName("일반 당첨 번호를 6개 이상으로 입력하면 예외가 발생한다.")
    @Test
    void normalPrizeNumbersOverSix() {
        assertThatThrownBy(() -> validateNormalNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("일반 당첨 번호를 6개 이하로 입력하면 예외가 발생한다.")
    @Test
    void normalPrizeNumbersUnderSix() {
        assertThatThrownBy(() -> validateNormalNumbers(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("일반 당첨 번호 중 중복되는 번호가 있으면 예외가 발생한다.")
    @Test
    void normalPrizeNumbersDuplicate() {
        assertThatThrownBy(() -> validateNormalNumbers(List.of(1, 1, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("일반 당첨 번호 중 하나라도 1 ~ 45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void normalPrizeNumbersNotInRange() {
        assertThatThrownBy(() -> validateNormalNumbers(List.of(999, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 일반 당첨 번호들 중 하나와 중복된다면 예외가 발생한다.")
    @Test
    void bonusNumberOverlapWithNormalNumber() {
        List<Integer> prizeNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        assertThatThrownBy(() -> validateBonusNumber(bonusNumber, prizeNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1 ~ 45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void bonusNumberNotInRange() {
        List<Integer> prizeNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 99;

        assertThatThrownBy(() -> validateBonusNumber(bonusNumber, prizeNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("일반 당첨 번호만 가져와야 한다.")
    @Test
    void onlyNormalNumbers() {
        TotalPrizeNumbers totalPrizeNumbers = new TotalPrizeNumbers(List.of(44, 2, 12, 33, 27, 9), 7);

        assertThat(totalPrizeNumbers.getNormalNumbers().stream()
                .map(PrizeNumber::getPrizeNumber)
                .collect(Collectors.toList()))
                .isEqualTo(List.of(44, 2, 12, 33, 27, 9));
    }

    @DisplayName("보너스 번호만 가져와야 한다.")
    @Test
    void onlyBonusNumber() {
        TotalPrizeNumbers totalPrizeNumbers = new TotalPrizeNumbers(List.of(44, 2, 12, 33, 27, 9), 7);

        assertThat(totalPrizeNumbers.getBonusNumber()).isEqualTo(7);
    }
}