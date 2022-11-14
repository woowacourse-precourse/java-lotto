package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLotto {
    public static final int LOTTO_PRICE=1000;
    List<Lotto> lottos;
    private int money;
    private int lottoCount;

    public UserLotto(int money){
        this.money=money;
        this.lottoCount=money/LOTTO_PRICE;
        makeLottoNumberList();
    }
    public int getMoney(){ return money;}
    public int getLottoCount(){ return lottoCount; }
    public List<Lotto> getLottos(){ return lottos; }
    public void makeLottoNumberList() throws IllegalArgumentException {
        List<Lotto> lottos=new ArrayList<>();
        for(int i=0; i< lottoCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            if (!lotto.getLotto().isEmpty()) {
                Collections.sort(lotto.getLotto());
                lottos.add(lotto);
            }
        }
        this.lottos=lottos;
    }
}
