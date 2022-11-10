package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    private Integer lottoMoney;
    UserLotto userLottoes;

    public User(){
        Print.PrintUserPurchaseAmount();

        String stringLottoMoney = Console.readLine();
        Exception.UserContainExceptNumber(stringLottoMoney);

        this.lottoMoney = Integer.parseInt(stringLottoMoney);
        Exception.UserMoneyDivide1000(lottoMoney);
        this.lottoMoney /= 1000;

        Print.PrintUserPurchaseLottoAmount(this.lottoMoney);
    }
}
