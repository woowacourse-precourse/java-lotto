package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    List<Lotto> userLottoes;

    public User(){
        System.out.print("구입금액을 입력해 주세요.");

        String stringLottoMoney = Console.readLine();
        Exception.UserContainExceptNumber(stringLottoMoney);

        Integer lottoMoney = Integer.parseInt(stringLottoMoney);
        Exception.UserMoneyDivide1000(lottoMoney);
        lottoMoney /= 1000;


    }
}
