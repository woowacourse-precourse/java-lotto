package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    private Integer lottoCount;
    UserLotto userLottoes;

    public User(){
        Print.PrintUserPurchaseAmount();

        String stringLottoMoney = Console.readLine();
        Exception.UserContainExceptNumber(stringLottoMoney);

        this.lottoCount = Integer.parseInt(stringLottoMoney);
        Exception.UserMoneyDivide1000(lottoCount);
        this.lottoCount /= 1000;

        Print.PrintUserPurchaseLottoAmount(this.lottoCount);

        this.userLottoes = new UserLotto(lottoCount);

        for (Lotto l : userLottoes.getUserLottoes()){
            System.out.println("l.getNumbers() = " + l.getNumbers());
        }
    }
}
