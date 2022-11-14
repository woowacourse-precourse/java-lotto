package lotto;

import lotto.domain.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class UserTest {
    @Test
    void 로또_발행() {
        List<Integer> answer = User.getLottoNumbers();
        long count = answer.stream().distinct().count();
        assertThat(count).isEqualTo(6L);
    }

    @Test
    void 사용자의_구매횟수만큼_로또숫자_발행() {
        User user = new User("5000");
        user.getPurchaseLottoList();
        assertThat(user.purchaseNumbers.size()).isEqualTo(5);
    }
    @Test
    void 구매_금액_예외_처리() {

        assertThatThrownBy(() -> new User("5555"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 구매금액이 1000의 배수가 아닙니다.");
    }
}
