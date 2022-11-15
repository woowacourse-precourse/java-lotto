package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    @DisplayName("장당 구매 가격으로 나눌 수 없는 구입 금액을 설정 시 예외가 발생한다.")
    @Test
    public void setIndivisibleBudget(){
        User user = new User();
        assertThatThrownBy(() -> user.setBudget(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    public void profitRateTest(){
        User user = new User();
        user.setBudget(1000);
        user.buyLotto(1);
        Lotto lotto = user.getLottos().get(0);
        List<Integer> winningNumbers = lotto.getNumbers();
        user.confirmWinning(winningNumbers, 0);
        assertThat(user.getProfitRate()).isEqualTo(2000000);
    }

}