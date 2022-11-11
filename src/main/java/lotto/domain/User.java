package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static constants.Constants.START_MSG;

public class User {
    public List<Lotto> purchaseLotto;
    public int purchaseMoney;
    public int purchaseLottoNum;

    public void buyLotto(){
        purchaseMoney = scanPayMoney();
        purchaseLottoNum = purchaseMoney%1000;
    }

    private int scanPayMoney() {
        System.out.println(START_MSG);
        int money = Integer.parseInt(Console.readLine());
        validateMoney(money);
        return money;
    }

    public void validateMoney(int money) {
        if(money%1000 ==0 )return;
        throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 끝나야 합니다. ");
    }



}
