package lotto.service;

import lotto.domain.LotteryTicket;
import lotto.domain.User;
import lotto.repository.LotteryTicketRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class LotteryCheckService {
    public void updateUserLotteryResult(User user) {
        LotteryTicketRepository repository = LotteryTicketRepository.getInstance();
        List<LotteryTicket> tickets = user.getLotteryTickets();
        for (LotteryTicket ticket : tickets) {
            String id = ticket.getLotteryId();
            user.addResult(id, repository.findRankById(id).orElseThrow(() -> new NoSuchElementException("")));
        }
    }
}
