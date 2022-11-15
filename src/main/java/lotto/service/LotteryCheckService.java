package lotto.service;

import lotto.constant.ErrorMessage;
import lotto.domain.LotteryTicket;
import lotto.domain.User;
import lotto.repository.LotteryTicketRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class LotteryCheckService {
    static final String INVALID_TICKET_ERROR = ErrorMessage.INVALID_TICKET.getErrorMessage();

    public void updateUserLotteryResult(User user) throws NoSuchElementException {
        LotteryTicketRepository repository = LotteryTicketRepository.getInstance();
        List<LotteryTicket> tickets = user.getLotteryTickets();
        for (LotteryTicket ticket : tickets) {
            String id = ticket.getLotteryId();
            user.addResult(
                    id,
                    repository.findRankById(id).orElseThrow(() -> new NoSuchElementException(INVALID_TICKET_ERROR))
            );
        }
    }
}