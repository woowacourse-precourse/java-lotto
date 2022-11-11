package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

import static constants.Constants.START_MSG;

public class User {
    public List<Lotto> purchaseLotto;
    public int purchaseMoney;
    public int purchaseLottoNum;

    public void buyLotto(){
        purchaseMoney = scanPayMoney();
        purchaseLottoNum = purchaseMoney/1000;
        purchaseLotto = issueLotto(purchaseLottoNum);
    }

    private List<Lotto> issueLotto(int purchaseLottoNum) {
        LottoGenerator generator = new LottoGenerator();
        List<Lotto> tempLotto = new ArrayList<>();
        for(int buy=0;buy<purchaseLottoNum;buy++){
            List<Integer> generatedNums =  generator.generateRandomNums();
            tempLotto.add(new Lotto(generatedNums));
        }
        return tempLotto;
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
