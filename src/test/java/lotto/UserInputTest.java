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

    @DisplayName("당첨 번호가 유효하다면 성공한다.")
    @Test
    void getValidWinningNumbers() {
        runTest(UserInput::getWinningNumbers, "1,2,3,4,5,6", "9");
    }

    @DisplayName("당첨 번호가 숫자가 아니라면 예외가 발생한다.")
    @Test
    void getInvalidWinningNumbers() {
        runTest(() -> {
            assertThatThrownBy(UserInput::getWinningNumbers)
                    .isInstanceOf(IllegalArgumentException.class);
            assertThat(output()).contains(ERROR_MESSAGE);
        }, "1a,2b,3c,4,5,6", "8");

        runTest(() -> {
            assertThatThrownBy(UserInput::getWinningNumbers)
                    .isInstanceOf(IllegalArgumentException.class);
            assertThat(output()).contains(ERROR_MESSAGE);
        }, "1   3,2a5,3,4,5,6", "8");
    }

    @DisplayName("보너스 번호가 숫자가 아니라면 예외가 발생한다.")
    @Test
    void getInvalidWinningNumbersBonus() {
        runTest(() -> {
            assertThatThrownBy(UserInput::getWinningNumbers)
                    .isInstanceOf(IllegalArgumentException.class);
            assertThat(output()).contains(ERROR_MESSAGE);
        }, "1,2,3,4,5,6", "8abc");
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