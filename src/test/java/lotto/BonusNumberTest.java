package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BonusNumberTest {
    private List<Integer> pickNumbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

    @DisplayName("보너스 번호가 숫자가 아니면 예외처리를 한다.")
    @Test
    void createBonusNumByNotNumber() {
        assertThatThrownBy(() -> new BonusNumber("a", pickNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외처리를 한다.")
    @Test
    void createBonusNumByDuplicate() {
        assertThatThrownBy(() -> new BonusNumber("3", pickNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상일 때")
    @Test
    void createBonusNum() {
        assertThatCode(() -> { new BonusNumber("12", pickNumbers); }).doesNotThrowAnyException();
    }
}
