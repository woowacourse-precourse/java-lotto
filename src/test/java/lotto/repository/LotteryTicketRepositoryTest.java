package lotto.repository;

import lotto.domain.LotteryTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class LotteryTicketRepositoryTest {
    @DisplayName("저장된 로또 티켓을 lotteryId로 조회한다.")
    @Test
    void findByValidLotteryId() {
        LotteryTicketRepository repository = new LotteryTicketRepository();
        LotteryTicket lotteryTicket = new LotteryTicket(List.of(1, 2, 3, 4, 5, 6));
        String lotteryId = lotteryTicket.getLotteryId();

        repository.addLotteryTicket(lotteryTicket);
        assertThat(repository.findByLotteryId(lotteryId))
                .isPresent()
                .hasValue(lotteryTicket);
    }

    @DisplayName("존재하지 않는 lotteryId로 조회시 반환되는 LotteryTicket이 없다.")
    @Test
    void findByNonExistentLotteryId() {
        LotteryTicketRepository repository = new LotteryTicketRepository();
        String lotteryId = "nothing";

        assertThat(repository.findByLotteryId(lotteryId))
                .isNotPresent();
    }
}
