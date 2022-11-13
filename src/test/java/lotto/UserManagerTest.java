package lotto;

import org.junit.jupiter.api.Test;

import java.io.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class UserManagerTest {

    // 사용자 입력
    void putSystemInput(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    /**
     * getPrice - 로또 구입 금액 입력
     */
    @Test
    void getPrice_테스트() {
        String price = Integer.toString(ProgramManager.LOTTO_PRICE);
        putSystemInput(price);
        assertThat(ProgramManager.LOTTO_PRICE).isEqualTo(UserManager.getInput_price());
    }

    @Test
    void getPrice_0_시작_예외_테스트() {
        String price = "0" + ProgramManager.LOTTO_PRICE;
        putSystemInput(price);

        assertSimpleTest(() ->
                assertThatThrownBy(UserManager::getInput_price)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void getPrice_숫자_이외_값_예외_테스트() {
        String price = "10아랄라000";
        putSystemInput(price);

        assertSimpleTest(() ->
                assertThatThrownBy(UserManager::getInput_price)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void getPrice_구입_단위_예외_테스트() {
        String price = Integer.toString(ProgramManager.LOTTO_PRICE + 1);
        putSystemInput(price);

        assertSimpleTest(() ->
                assertThatThrownBy(UserManager::getInput_price)
                        .isInstanceOf(IllegalArgumentException.class));
    }

}
