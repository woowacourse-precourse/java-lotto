package lotto.datamodel;

import static org.assertj.core.api.Assertions.*;

import lotto.datamodel.util.Transform;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TransformTest {
    Transform test = new Transform();

    @DisplayName("입력값을 정수 리스트로 변환하고 잘못된 입력이면 예외가 발생한다.")
    @Test
    void isValidWinNumbers() {
        assertThatThrownBy(() -> test.numberTransform("1,2,3,4f,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값을 정수로 변환하고")
    @Test
    void isValidBonusNumber() {
        assertThatThrownBy(() -> test.bonusTransform("dwe"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
