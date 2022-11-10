package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class PurchaseTest {

    private static final Purchase purchase= new Purchase();


    @DisplayName("사용자가 지불한 금액을 로또의 개수로 바꿔준다.")
    @Test
    void changeToLotto() {
        //given
        String moneyInput = "14000";
        //when
        int numberOfLotto = purchase.changeToLotto(moneyInput);
        //then
        Assertions.assertThat(numberOfLotto).isEqualTo(14);
    }
}