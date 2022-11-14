package lotto.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseControllerTest {
    private PurchaseController purchaseController = new PurchaseController();

    @DisplayName("사용자가 잘못된 금액을 입력했을 경우 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"000","100","12001","abcd","100a","9000000","  1000"})
    void inputMoneyByUser(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        Assertions.assertThatThrownBy(() -> purchaseController.inputMoneyByUser())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void purchaseLotto() {
        int numberOfLotto = purchaseController.purchaseLotto(14000);

        Assertions.assertThat(numberOfLotto).isEqualTo(14);
    }

    @DisplayName("사용자가 지불한 금액이 입력 요구 사항에 맞지 않을 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource({"000","100","12001"})
    void changeToLottoByNotNumberMoney(int money) {
        assertThatThrownBy(() -> purchaseController.purchaseLotto(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}