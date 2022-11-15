package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constant.LotteryRank;
import lotto.domain.LotteryTicket;
import lotto.domain.WinningNumber;
import lotto.repository.LotteryTicketRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LotteryDrawServiceTest {
    @AfterEach
    void afterEach() {
        LotteryTicketRepository repository = LotteryTicketRepository.getInstance();
        repository.clearStore();
        repository.clearDrawResult();
    }

    @DisplayName("5개 숫자가 일치하고 보너스 숫자가 일치하는 로또 티켓의 추첨 결과를 업데이트한다.")
    @Test
    void updateSecondRankTicket() {
        LotteryTicketRepository repository = LotteryTicketRepository.getInstance();
        LotteryTicket ticket = new LotteryTicket(List.of(1, 2, 3, 10, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 3, 25, 6, 5, 2), 10);
        String ticketId = ticket.getLotteryId();
        repository.addLotteryTicket(ticket);

        LotteryDrawService drawService = new LotteryDrawService();
        drawService.updateResult(winningNumber);

        assertThat(repository.findRankById(ticketId).orElseThrow()).isEqualTo(LotteryRank.SECOND);
    }

    @DisplayName("6개 숫자가 모두 일치하는 로또 티켓의 rank를 LotteryRank.FIRST로 반환한다.")
    @Test
    void rankAsFirst() {
        LotteryTicket ticket = new LotteryTicket(List.of(1, 2, 3, 10, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 3, 10, 6, 5, 2), 12);

        LotteryDrawService drawService = new LotteryDrawService();
        assertThat(drawService.rank(ticket, winningNumber)).isEqualTo(LotteryRank.FIRST);
    }

    @DisplayName("5개 숫자와 보너스 숫자가 일치하는 로또 티켓의 rank를 LotteryRank.SECOND로 반환한다.")
    @Test
    void rankAsSecond() {
        LotteryTicket ticket = new LotteryTicket(List.of(1, 2, 3, 10, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 3, 25, 6, 5, 2), 10);

        LotteryDrawService drawService = new LotteryDrawService();
        assertThat(drawService.rank(ticket, winningNumber)).isEqualTo(LotteryRank.SECOND);
    }

    @DisplayName("5개 숫자만 일치하는 로또 티켓의 rank를 LotteryRank.THIRD로 반환한다.")
    @Test
    void rankAsThird() {
        LotteryTicket ticket = new LotteryTicket(List.of(1, 2, 3, 10, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 3, 25, 6, 5, 2), 11);

        LotteryDrawService drawService = new LotteryDrawService();
        assertThat(drawService.rank(ticket, winningNumber)).isEqualTo(LotteryRank.THIRD);
    }
}
