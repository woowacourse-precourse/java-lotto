package lotto.domain;

import lotto.constant.Status;
import lotto.domain.constant.LottoProperty;
import lotto.constant.ValidationErrorMessage;
import lotto.domain.LotteryTicket;
import lotto.domain.LotteryResult;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int money;
    private List<LotteryTicket> lotteryTickets;
    private LotteryResult lotteryResult;

    public User (int money) {
        validate(money);
        this.money = money;
        lotteryTickets = new ArrayList<>();
    }

    public void validate (int money) {
        if (!isMultipleOfThousand(money)) {
            throw new IllegalArgumentException(ValidationErrorMessage.INVALID_MONEY_AMOUNT.getErrorMessageWithoutPrefix());
        }
    }

    private boolean isMultipleOfThousand (int money) {
        return money % LottoProperty.PRICE.getProperty() == Status.EMPTY.getStatus();
    }

    public void buyLotteryTicket(LotteryTicket lotteryTicket) {
        money -= LottoProperty.PRICE.getProperty();
        lotteryTickets.add(lotteryTicket);
    }

    public int getMoney() {
        return money;
    }

    public List<LotteryTicket> getLotteryTickets() {
        return new ArrayList<>(lotteryTickets);
    }
}
