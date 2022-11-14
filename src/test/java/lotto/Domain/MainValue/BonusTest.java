package lotto.Domain.MainValue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.List;

class BonusTest {
    @DisplayName("보너스 번호에 문자가 들어가면 에러가 발생한다")
    @Test
    void createBonusByChar() {
        String bonus = "a1";
        List<Integer> sixNum = List.of(1,2,3,4,5,6);

        assertThatThrownBy(() -> new Bonus(bonus, sixNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 잘 변환되는지 여부")
    @Test
    void checkReturnValue() {
        String bonus = "7";
        List<Integer> sixNum = List.of(11, 12, 13, 14, 15, 16);

        assertThat(new Bonus(bonus, sixNum).getNumber())
                .as("보너스 번호")
                .isEqualTo(7);
    }

    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아니면 에러가 발생한다")
    @Test
    void createBonusOutOfRange() {
        String bonus = "46";
        List<Integer> sixNum = List.of(1,2,3,4,5,6);

        assertThatThrownBy(() -> new Bonus(bonus, sixNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 같으면 에러가 발생한다")
    @Test
    void createBonusOverlap() {
        String bonus = "1";
        List<Integer> sixNum = List.of(1,2,3,4,5,6);

        assertThatThrownBy(() -> new Bonus(bonus, sixNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
