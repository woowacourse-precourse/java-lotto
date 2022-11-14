package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;


public class ValidationTest extends ApplicationTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("구입 금액이 1000의 배수가 아니면 예외가 발생한다.")
    @Test
    void validateBudgetNotMultipleOf1000(){
        assertSimpleTest(() -> {
            runException("2022");
            assertThat(output().contains(ERROR_MESSAGE));
        });
    }

    @DisplayName("보너스 번호는 다른 로또 번호와 중복될 수 없다.")
    @Test
    void validateBonusNumberNotDuplicated(){
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,5,6", "5");
            assertThat(output().contains(ERROR_MESSAGE));
        });
    }

}
