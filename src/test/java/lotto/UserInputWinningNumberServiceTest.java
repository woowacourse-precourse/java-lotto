package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import java.util.NoSuchElementException;
import lotto.domian.Lotto;
import lotto.service.UserInputWinningNumberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserInputWinningNumberServiceTest {

    UserInputWinningNumberService userInputWinningNumberService = new UserInputWinningNumberService();

    @DisplayName("checkThisWinningNumberIsValid 메서드 테스트")
    @Test
    void checkThisWinningNumberIsValidTest() {
        assertThatThrownBy(
          () -> userInputWinningNumberService.checkThisWinningNumberIsValid(new String[]{"1", "2", "3", "4", "5", ""}))
          .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
          () -> userInputWinningNumberService.checkThisWinningNumberIsValid(new String[]{"1", "2", "3", "4", "5"}))
          .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
          () -> userInputWinningNumberService.checkThisWinningNumberIsValid(
            new String[]{"1", "2", "3", "4", "5", "6", "7"}))
          .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
          () -> userInputWinningNumberService.checkThisWinningNumberIsValid(new String[]{"1", "2", "3", "4", "5", " "}))
          .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
          () -> userInputWinningNumberService.checkThisWinningNumberIsValid(
            new String[]{"1", "2", "3", "4", "5", "60"}))
          .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
          () -> userInputWinningNumberService.checkThisWinningNumberIsValid(new String[]{"1", "2", "3", "4", "5", "5"}))
          .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("checkThisBonusNumberIsValid 메서드 테스트")
    @Test
    void checkThisBonusNumberIsValidTest() {

        assertThatThrownBy(() -> userInputWinningNumberService.checkThisBonusNumberIsValid(""))
          .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> userInputWinningNumberService.checkThisBonusNumberIsValid(" "))
          .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> userInputWinningNumberService.checkThisBonusNumberIsValid("12 "))
          .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> userInputWinningNumberService.checkThisBonusNumberIsValid("1,2,3,4,5,6"))
          .isInstanceOf(NoSuchElementException.class);
        assertThatThrownBy(() -> userInputWinningNumberService.checkThisBonusNumberIsValid("abc"))
          .isInstanceOf(NoSuchElementException.class);
        assertThatThrownBy(() -> userInputWinningNumberService.checkThisBonusNumberIsValid("60"))
          .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("setLotto 메서드 테스트")
    @Test
    void setLottoTest() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        Lotto lotto = userInputWinningNumberService.setLotto(winningNumbers, bonusNumber);

        // then
        assertThat(lotto.getWinningNumbers()).isEqualTo(winningNumbers);
        assertThat(lotto.getBonusNumber()).isEqualTo(bonusNumber);
    }
}

