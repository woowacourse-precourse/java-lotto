package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private final List<List<Integer>> lottoNumber;

    public LottoGenerator(int tickets) {
        this.lottoNumber =  new ArrayList<>(lottoGenerator(tickets));
    }

    public List<List<Integer>> getlottoBox() {
        return lottoNumber;
    }

    private List<List<Integer>> lottoGenerator(int tickets) {

        List<List<Integer>> lottoList = new ArrayList<>();
        for(int i=0; i<tickets; i++){
            List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lotto);
            lottoList.add(lotto);
        }
        return lottoList;
    }

}
