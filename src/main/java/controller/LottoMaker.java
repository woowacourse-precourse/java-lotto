package controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import java.util.List;
import java.util.ArrayList;

public class LottoMaker {
    private final int money;

    private void validate(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }

    public LottoMaker(String money) {
        this.money = Integer.parseInt(money);
        validate(this.money);
    }


    /**
     * 로또를 발행하는 메서드
     * @return 발행된 메서드 리턴
     */
    public List<Lotto> publishLotto(){
        int amount = money / 1000;
        List<Lotto> lottos = new ArrayList<>();

        for(int lotto = 0; lotto < amount; lotto ++ ){
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)));
        }
        return lottos;
    }
}
