package domain;

import controller.BonusController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusTest {
    BonusController bonusController = new BonusController();

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusByDuplicatedNumber() {
        assertThatThrownBy(() -> bonusController.createBonusNumber("44",
                new Lotto(List.of(1,2,3,4,5,44))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }

    @DisplayName("보너스 번호가 하나의 숫자 형식이 아니면 예외가 발생한다.")
    @Test
    void createBonusByNotAllowedFormat() {
        assertThatThrownBy(() -> bonusController.createBonusNumber("2 3",
                new Lotto(List.of(1,2,3,4,5,6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 한 개의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createBonusByOutOfRange() {
        assertThatThrownBy(() -> bonusController.createBonusNumber("47",
                new Lotto(List.of(1,2,3,4,5,10))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
