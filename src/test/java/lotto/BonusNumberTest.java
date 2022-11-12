package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    public List<Integer> numbers;

    @BeforeEach
    void createNumbers() {
        numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
    }

    @DisplayName("보너스 번호에 숫자 이외의 문자가 포함되어 있으면 예외가 발생한다.")
    @Test
    void createBonusNumberByCharacter() {
        assertThatThrownBy(() -> new BonusNumber("ab-", numbers))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BonusNumber(".", numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 숫자 이외의 문자가 포함되어 있으면 예외가 발생한다.")
    @Test
    void createBonusNumberWithInvalidNumber() {
        assertThatThrownBy(() -> new BonusNumber("0", numbers))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BonusNumber("46", numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복된다면 예외가 발생한다.")
    @Test
    void createBonusNumberByReplicate() {
        assertThatThrownBy(() -> new BonusNumber("1", numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
