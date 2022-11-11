package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.List;

import static constants.Constants.*;

public class UserIOService {

    public int scanPayMoney() {
        System.out.println(START_MSG);
        int money = Integer.parseInt(Console.readLine());
        validateMoney(money);
        return money;
    }

    public void validateMoney(int money) {
        if (money % LOTTO_PRICE == 0) return;
        throw new IllegalArgumentException(PAY_MONEY_ERROR);
    }


    public String print(int purchaseLottoNum, List<Lotto> purchaseLotto) {
        StringBuilder printString = new StringBuilder();
        printString.append(BLANK_BR); //한줄 공백
        printString.append(purchaseLottoNum).append(PURCHASE_MSG).append("\n");
        for(Lotto now : purchaseLotto){
            printString.append(now).append("\n");
        }
        return printString.toString();
    }
}
