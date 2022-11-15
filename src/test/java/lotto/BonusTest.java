package lotto;

import lotto.domain.Bonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusTest {

    @DisplayName("보너스 번호가 입력한 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void checkDuplicatedNumber() {
        final List<Integer> lotto = List.of(1,2,3,4,5,6);
        assertThatThrownBy(() -> new Bonus("3", lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아닌 경우 예외가 발생한다..")
    @Test
    void checkBonusNumber() {
        final List<Integer> lotto = List.of(1,2,3,4,5,6);
        assertThatThrownBy(() -> new Bonus("j", lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 숫자가 1~45 이내가 아니면 예외가 발생한다.")
    @Test
    void createLottoByChar() {
        final List<Integer> lotto = List.of(1,2,3,4,5,6);
        assertThatThrownBy(() -> new Bonus("46", lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력이 잘 되는지 확인")
    @Test
    void inputBonusNumber() {
        final List<Integer> lotto = List.of(1,2,3,4,5,6);
        Bonus bonus =  new Bonus("43", lotto);

        int result = 43;

        assertThat(bonus.getBonus()).isEqualTo(result);
    }
}
