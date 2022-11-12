package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.utils.Messages.ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest extends NsTest {

    @DisplayName("구매 금액에 숫자가 아니면 예외가 발생한다")
    @Test
    void createNonNumericInput(){
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("구매 금액이 1000원 미만일 경우 예외가 발생한다")
    @Test
    void createLessThousandInput(){
        assertSimpleTest(() -> {
            runException("999");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
