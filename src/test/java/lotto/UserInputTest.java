package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("구입 금액이 1000의 배수면 성공한다.")
    @Test
    void purchaseMoney() {
        runTest(UserInput::getPurchaseMoney, "1000");
        runTest(UserInput::getPurchaseMoney, "987654000");
    }

    @DisplayName("구입 금액이 자연수가 아니라면 예외가 발생한다.")
    @Test
    void purchaseMoneyWithNotNaturalNumber() {
        runTest(() -> {
            assertThatThrownBy(UserInput::getPurchaseMoney)
                    .isInstanceOf(IllegalArgumentException.class);
            assertThat(output()).contains(ERROR_MESSAGE);
        }, "1000j");

        runTest(() -> {
            assertThatThrownBy(UserInput::getPurchaseMoney)
                    .isInstanceOf(IllegalArgumentException.class);
            assertThat(output()).contains(ERROR_MESSAGE);
        }, "0");
    }

    @DisplayName("구입 금액이 1000의 배수가 아니라면 예외가 발생한다.")
    @Test
    void purchaseMoneyWithNotDividableBy1000() {
        runTest(() -> {
            assertThatThrownBy(UserInput::getPurchaseMoney)
                    .isInstanceOf(IllegalArgumentException.class);
            assertThat(output()).contains(ERROR_MESSAGE);
        }, "12345");

        runTest(() -> {
            assertThatThrownBy(UserInput::getPurchaseMoney)
                    .isInstanceOf(IllegalArgumentException.class);
            assertThat(output()).contains(ERROR_MESSAGE);
        }, "678900");
    }

    private void runTest(final Executable executable, final String... args) {
        command(args);
        assertSimpleTest(executable);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Override
    protected void runMain() {

    }
}