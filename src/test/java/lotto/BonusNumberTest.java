package lotto;

import lotto.Domain.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BonusNumberTest {
    @DisplayName("보너스 숫자가 리턴된다.")
    @Test
    void BonusNumberTest() {
        // given
        int bonusNumberTest = 7;
        BonusNumber bonusNumber = new BonusNumber(bonusNumberTest);

        // when
        int getBonusNum = bonusNumber.getBonusNumber();

        // then
        assertThat(getBonusNum).isEqualTo(bonusNumberTest);
    }
}
