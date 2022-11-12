package lotto;

import lotto.domain.WinningInformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningInformationTest {
    @DisplayName("당첨 번호에 중복된 수가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningInformation(List.of(1, 2, 3, 4, 5, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningInformation(List.of(1, 2, 3, 4, 5, 7), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 45보다 큰 수가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByNumberGreaterThanMax(){
        assertThatThrownBy(() -> new WinningInformation(List.of(1, 2, 3, 4, 5, 100), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 1보다 작은 수가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByNumberLessThanMin(){
        assertThatThrownBy(() -> new WinningInformation(List.of(1, 2, 3, 4, 5, -34), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 45보다 큰 수가 있으면 예외가 발생한다.")
    @Test
    void createBonusNumberByNumberGreaterThanMax(){
        assertThatThrownBy(() -> new WinningInformation(List.of(1, 2, 3, 4, 5, 6), 100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 1보다 작은 수가 있으면 예외가 발생한다.")
    @Test
    void createBonusNumberByNumberLessThanMin(){
        assertThatThrownBy(() -> new WinningInformation(List.of(1, 2, 3, 4, 5, 6), -7))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
