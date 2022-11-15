package lotto.domain;

import lotto.domain.Lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoLogic {

    static int lottoCount;
//    static Lotto getLotto = new Lotto();
    private static List<Lotto> lottos;

    public void logic(String lottoMoneyInput){
        LottoInput lottoInput = new LottoInput();
        this.lottoCount = lottoInput.lottoCount(lottoMoneyInput); // 로또 개수
        buyLottos(this.lottoCount);
    }

    public int getLottoCount(){
        return this.lottoCount;
    }

    public List<Integer> CreateLottoNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public void buyLottos(int lottoCount){
        this.lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++){
            this.lottos.add(new Lotto(CreateLottoNumber()));
        }
    }

    public List<Lotto> getLottos(){
        return this.lottos;
    }


}
