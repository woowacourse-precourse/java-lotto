package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserServiceTest {
    private final UserService userService = new UserService();

    @DisplayName("유저가 구매금액으로 문자를 입력한 경우 예외가 발생한다.")
    @Test
    void validatePayMoney() {
        assertThatThrownBy(() -> userService.stringToInter("dkk"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유저가 구매한 금액이 1000원 단위가 아니거나 0원 이하라면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {12345, -1000})
    void validatePayMoney(int money) {
        assertThatThrownBy(() -> userService.validateMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유저가 구매한 금액만큼의 로또가 생성되는지 확인한다.")
    @Test
    void checkIssuedLottoNums() {
        assertThat(userService.issueLotto(7).size()).isEqualTo(7);
    }

}