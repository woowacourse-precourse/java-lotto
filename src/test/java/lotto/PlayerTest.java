package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest extends NsTest {

    @Test
    void 로또구입금액_1000단위_아닌_경우_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1250"))
                    .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 로또구입금액_숫자_외_문자_입력_시_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1xx"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


}