package controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import java.util.List;
import java.util.ArrayList;
import data.InputGuideData;

public class LottoMaker {
    private static final int price = 1000;
    private int money;
    private void validate(int money){
        if(money % price != 0){
            throw new IllegalArgumentException();
        }
    }

    public LottoMaker(String money) {
        this.money = Integer.parseInt(money);
        validate(this.money);
        System.out.print(this.money / price);
        InputGuideData.printData("BUY_LOTTO");
    }


    /**
     * 로또를 발행하는 메서드
     * @return 발행된 메서드 리턴
     */
    public List<Lotto> publishLotto(){
        int amount = money / price;
        List<Lotto> lottos = new ArrayList<>();

        for(int lotto = 0; lotto < amount; lotto ++ ){
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)));
        }
        return lottos;
    }
}
