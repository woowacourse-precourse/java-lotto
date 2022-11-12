package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public void play(){
        int money = insertMoney();
        int lottoCount = buyLotto(money);
        List<Lotto> lottoesBought = getLotto(lottoCount);
        for(int i=0; i<lottoesBought.size(); i++){
            Lotto lotto = lottoesBought.get(i);
            System.out.println(lotto.getNumbers());
        }
    }


    // 로또 구입금액 입력
    private int insertMoney(){
        System.out.println("구입 금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());

        return money;
    }

    private int buyLotto(int money){
        if (money % 1000 > 0){  // 천원단위로 나누어 떨어지지 않을 경우 예외처리
            throw new IllegalArgumentException("[ERROR]");
        }
        int lottoCount = money / 1000;
        return lottoCount;
    }

    private List<Lotto> getLotto(int lottoCount){
        LottoMachine lottoMachine = new LottoMachine(1, 45, 6);
        List<Lotto> lottoesBought = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++){
            Lotto lotto = new Lotto(lottoMachine.getNumbers());
            lottoesBought.add(lotto);
        }
        return lottoesBought;
    }

}
