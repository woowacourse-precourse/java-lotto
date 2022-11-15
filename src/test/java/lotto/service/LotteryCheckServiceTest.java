package lotto.service;

import lotto.domain.LotteryTicket;
import lotto.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

public class LotteryCheckServiceTest {
    @DisplayName("비정상적으로 획득한 티켓에 대해 NoSuchElementException 에러를 발생시킨다.")
    @Test
    void checkInvalidTicket() {
        LotteryCheckService lotteryCheckService = new LotteryCheckService();
        User user = new User(1000);
        LotteryTicket ticket = new LotteryTicket(List.of(1, 2, 3, 4, 5, 6));
        user.buyLotteryTicket(ticket);

        assertThatThrownBy(() -> lotteryCheckService.updateUserLotteryResult(user))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("해당 티켓은 판매된 티켓이 아닙니다.");
    }
}
