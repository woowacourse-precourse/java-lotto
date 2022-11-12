package lotto.service;

import lotto.dao.Ticket;
import lotto.vo.Lotto;

import java.util.List;

public class LottoService {
    private final Ticket ticketDao;

    public LottoService() {
        this.ticketDao = Ticket.getInstance();
    }

    public void issueLotteryTicketsAs(int money) {
        if (money <= 0 || (money % 1000) > 0) {
            throw new IllegalArgumentException("올바른 금액을 입력해 주세요.");
        }

        int numberOfLotteries = (money / 1000);

        for (int count = 0; count < numberOfLotteries; count++) {
            this.ticketDao.insert(new Lotto(Lotto.createNumbers()));
        }
    }

    public List<Lotto> getIssueLotteryTickets() {
        return this.ticketDao.getAll();
    }


}
