package lotto.domain_test;
import lotto.domain.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BonusNumberTest {

    BonusNumber bonusNumber;

    @Test
    @DisplayName("보너스 번호 생성자에 정수형 입력변수는 저장된다.")
    void checkVariableInConstructor(){
        bonusNumber = new BonusNumber(31);
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(31);
    }
}
