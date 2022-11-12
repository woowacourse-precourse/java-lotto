package lotto.service;

import lotto.dao.PurchaseNumber;
import lotto.vo.Lotto;

import java.util.LinkedList;
import java.util.List;

public class LottoService {
    private final PurchaseNumber purchaseNumberDao;

    public LottoService() {
        this.purchaseNumberDao = PurchaseNumber.getInstance();
    }

    public void issueLotteryTicketsAs(int money) {
        if (money <= 0 || (money % 1000) > 0) {
            throw new IllegalArgumentException("올바른 금액을 입력해 주세요.");
        }

        int numberOfLotteries = (money / 1000);

        for (int count = 0; count < numberOfLotteries; count++) {
            this.purchaseNumberDao.insert(new Lotto(Lotto.createNumbers()));
        }
    }

    public List<Lotto> getIssueLotteryTickets() {
        return this.purchaseNumberDao.getAll();
    }


}
