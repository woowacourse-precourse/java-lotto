package lotto;

import lotto.domain.Lotto;
import lotto.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UsetTest {

    @Test
    @DisplayName("사용자의 지불금액이 1,000원 단위가 아니면 예외를 발생시킨다.")
    void createUserByPaymentMismatch() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));

        assertThatThrownBy(() -> new User(lottoList, 2500))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자의 지불금액이 0원 이라면 예외를 발생시킨다.")
    void createUserByPaymentIsZero() {
        assertThatThrownBy(() -> new User(null, 0))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
