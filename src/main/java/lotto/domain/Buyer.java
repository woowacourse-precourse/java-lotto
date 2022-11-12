package lotto.domain;


import static lotto.exception.ExceptionHandler.ILLEGAL_VALUE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Buyer {

    private Long money;
    private List<Lotto> lottoNumbers;


    public void buyLotto() {
        this.lottoNumbers = LottoPublisher.publishLotto(this);
    }

    public void readyForBuyLotto() {
        try {
            this.money = Long.valueOf(Console.readLine());
        } catch (NumberFormatException exception) {
            ILLEGAL_VALUE.error();
        }
    }

    public Long getMoney() {
        return money;
    }

}
