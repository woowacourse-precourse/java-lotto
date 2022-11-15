package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoPublisher {
    public static final int lottoNum = 6;
    public static final int lottoPrice = 1000;
    private int money;

    public LottoPublisher(){
    }

    public List<Lotto> createLotto(int money){
        int cnt = checkMoney(money);
        insertMoney(money);
        List<Lotto> ret = new ArrayList<>();
        for(int i=0; i<cnt; i++){
            List<Integer> lottoNums = Randoms.pickUniqueNumbersInRange(1, 45, lottoNum);
            Lotto lotto = new Lotto(lottoNums);
            ret.add(lotto);
        }
        return ret;
    }

    private void insertMoney(int money){
        this.money += money;
    }

    private int checkMoney(int money){
        if(money % lottoPrice != 0){
            throw new IllegalArgumentException("1,000원 단위로 입력하세요");
        }
        return money / lottoPrice;
    }
}
