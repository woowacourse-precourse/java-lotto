package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BonusTest {
    private Lotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    @Test
    void createDuplicateNumber() {
        assertThatThrownBy(() -> new Bonus(3, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 보너스 번호를 비교해 일치하는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"7, true", "9, true", "11, true", "13,false", "14, false"})
    void isMatch(int bonusNumber, boolean expected) {
        List<Integer> lottoNumbers = List.of(7, 8, 9, 10, 11, 12);

        Bonus bonus = new Bonus(bonusNumber, winningLotto);
        boolean actual = bonus.isMatch(lottoNumbers);

        assertThat(actual).isEqualTo(expected);
    }
}