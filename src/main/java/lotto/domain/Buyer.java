package lotto.domain;


import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Buyer {

    private Long money;
    private List<Lotto> lottoNumbers;


    public void buyLotto() {
        this.lottoNumbers = LottoPublisher.publishLotto(this);
    }

    public void readyForBuyLotto() {
        this.money = Long.valueOf(Console.readLine());
    }

    public Long getMoney() {
        return money;
    }

}
