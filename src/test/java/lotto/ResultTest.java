package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ResultTest {
    @DisplayName("구매한 로또 번호와 당첨 번호 비교가 정상적으로 이루어지는 지 확인")
    @Test
    void compareWinningAndPurchase() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(List.of(4, 5, 6, 7, 8, 9));
        assertThat(Result.countWinningNumber(lotto, winningNumber)).isEqualTo(3);
    }

    @DisplayName("전체 수익이 정상적으로 계산되는지 확인")
    @Test
    void checkTotalPrize() {
        Winning.FIRST.cnt++;
        Winning.FOURTH.cnt++;

        assertThat(Result.totalPrize()).isEqualTo(2_000_050_000);
    }
}