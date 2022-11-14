package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {
    private int count;
    private final List<Lotto> lottoList;

    public LottoBundle(int count) {
        this.count = count;
        this.lottoList = createLottoList();
    }


    private List<Lotto> createLottoList(){
        List<Lotto> lottoList1 = new ArrayList<>();
        while(this.count-->0){
            //로또 한개 생성 후 로또 뭉치에 추가
            lottoList1.add( createOneLotto());
        }
        return lottoList1;
    }
    private Lotto createOneLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
