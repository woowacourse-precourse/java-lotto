package lotto.repository;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constant.LotteryRank;
import lotto.domain.LotteryTicket;
import org.junit.jupiter.api.*;
import java.util.List;

public class LotteryTicketRepositoryTest {
    @AfterEach
    void afterEach() {
        LotteryTicketRepository repository = LotteryTicketRepository.getInstance();
        repository.clearStore();
        repository.clearDrawResult();
    }

    @DisplayName("저장된 로또 티켓을 lotteryId로 조회한다.")
    @Test
    void findByValidLotteryId() {
        LotteryTicketRepository repository = LotteryTicketRepository.getInstance();
        LotteryTicket lotteryTicket = new LotteryTicket(List.of(1, 2, 3, 4, 5, 6));
        String lotteryId = lotteryTicket.getLotteryId();

        repository.addLotteryTicket(lotteryTicket);
        assertThat(repository.findTicketById(lotteryId))
                .isPresent()
                .hasValue(lotteryTicket);
    }

    @DisplayName("존재하지 않는 lotteryId로 조회시 반환되는 LotteryTicket이 없다.")
    @Test
    void findByNonExistentLotteryId() {
        LotteryTicketRepository repository = LotteryTicketRepository.getInstance();
        String lotteryId = "nothing";

        assertThat(repository.findTicketById(lotteryId))
                .isNotPresent();
    }

    @DisplayName("로또 추첨 전에 당첨 결과 조회시 LotteryRank.BEFORE_DRAW을 반환한다.")
    @Test
    void findRankOfLotteryTicketBeforeDraw() {
        LotteryTicketRepository repository = LotteryTicketRepository.getInstance();
        LotteryTicket lotteryTicket = new LotteryTicket(List.of(1, 2, 3, 4, 5, 6));
        String lotteryId = lotteryTicket.getLotteryId();

        repository.addLotteryTicket(lotteryTicket);
        assertThat(repository.findRankById(lotteryId))
                .isPresent()
                .hasValue(LotteryRank.BEFORE_DRAW);
    }
}
