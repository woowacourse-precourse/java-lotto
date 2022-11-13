package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BuyLottoTest extends NsTest {
    /* buyLotto Test */
    @DisplayName("구입 금액만큼 로또를 구매하는지 확인")
    @Test
    void checkBuyLottoForMoneyTest() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6", "7");
            assertThat(output()).contains("8개를 구매했습니다.");
        });
    }

    public void runMain() {
        Application.main(new String[]{});
    }
}
