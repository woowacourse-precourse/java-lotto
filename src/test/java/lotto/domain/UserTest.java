package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.IllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    @DisplayName("금액이 숫자로만 이루어져 있지 않다면 예외가 발생한다.")
    @Test
    void createBuyAmountByWrongForm() {
        User user = new User();
        assertThatThrownBy(() -> user.setBuyAmount("1asd"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액의 첫부분이 0으로 시작하면 예외가 발생한다.")
    @Test
    void createBuyAmountByStartZero() {
        User user = new User();
        assertThatThrownBy(() -> user.setBuyAmount("01000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000원단위가 아니라면 예외가 발생한다.")
    @Test
    void createBuyAmountByWrongSize() {
        User user = new User();
        assertThatThrownBy(() -> user.setBuyAmount("1200"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 공백이면 예외가 발생한다.")
    @Test
    void createBuyAmountByBlank() {
        User user = new User();
        assertThatThrownBy(() -> user.setBuyAmount(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 설정하기.")
    @Test
    void setBuyAmount() {
        //given
        User user = new User();
        int buyAmount = 1000;

        //when
        user.setBuyAmount(String.valueOf(buyAmount));

        //then
        assertThat(buyAmount).isEqualTo(user.getBuyAmount());
    }

    @DisplayName("로또 저장하기.")
    @Test
    void setMyLotto() {
        //given
        final int myLottoCount = 1;
        User user = new User();
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        //when
        user.setMyLotto(lotto);

        //then
        assertThat(user.getMyLotto().size()).isEqualTo(myLottoCount);
    }
}
