package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @ParameterizedTest
    @CsvSource(value = {"8000, 8", "6000, 6", "100000, 100"})
    public void 구매금액만큼_로또생성(String userInput, int expected){
        User user = new User(userInput);
        assertThat(user.getUserLottos().size()).isEqualTo(expected);
    }

    @DisplayName("구매 금액이 1000원보다 작으면 예외가 발생한다.")
    @Test
    public void createUnderThousandPurchase(){
        assertThatThrownBy(() -> new User("900"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액에 숫자가 아닌 값이 입력되면 예외가 발생한다.")
    @Test
    public void createNonDigitPurchase(){
        assertThatThrownBy(() -> new User("hihi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액에 숫자가 아닌 값이 입력되면 예외가 발생한다.")
    @Test
    public void createNonThousandUnitPurchase(){
        assertThatThrownBy(() -> new User("10001"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}