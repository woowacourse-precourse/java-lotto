package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Const;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private List<Lotto> buyerLotto;
    private int haveCount;

    public String inputPurchaseMoney(){
        System.out.println(Const.BUY_LOTTO_MESSAGE);
        String purchaseMoney = Console.readLine();
        haveLottoCount(purchaseMoney);
        registMyLotto();
        return Console.readLine();
    }

    public void haveLottoCount(String purchaseMoney){
        haveCount = Long.valueOf(purchaseMoney).intValue()/1000;
    }

    public void registMyLotto(){
        List<Lotto> newLotto = new ArrayList<>();
        for(int myLottoIndex = 0;myLottoIndex<haveCount;myLottoIndex++){
            newLotto.add(new Lotto(LottoNumCreator.getLottoNumbers()));
        }
        buyerLotto = newLotto;
    }

    public int howManyBuyerHaveLotto(){
        return haveCount;
    }

    public List<Lotto> buyerHaveLotto(){
        return buyerLotto;
    }
}
