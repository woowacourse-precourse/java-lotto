package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {
    @DisplayName("입력된 보너스 번호가 숫자가 맞는지 확인.")
    @Test
    void checkBonusException1() {
        Assertions.assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            String inputBonus = "  a  ";
            Bonus.inputValidity(inputBonus, lotto);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            String inputBonus = "";
            Bonus.inputValidity(inputBonus, lotto);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            String inputBonus = " ";
            Bonus.inputValidity(inputBonus, lotto);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 보너스 번호가 정답에 없는지 확인.")
    @Test
    void checkBonusException2() {
        Assertions.assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            String inputBonus = "1";
            Bonus.inputValidity(inputBonus, lotto);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            String inputBonus = "3";
            Bonus.inputValidity(inputBonus, lotto);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 보너스 번호가 범위에 있는지 확인.")
    @Test
    void checkBonusException3() {
        Assertions.assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(List.of(1, 47, 4, 5, 6, 7));
            String inputBonus = "48";
            Bonus.inputValidity(inputBonus, lotto);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(List.of(1, 2, 4, 5, 6, 7));
            String inputBonus = "0";
            Bonus.inputValidity(inputBonus, lotto);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}