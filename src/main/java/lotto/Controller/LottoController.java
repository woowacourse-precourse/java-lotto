package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final List<List<Integer>> lottoNumber;

    public LottoController(int tickets) {
        this.lottoNumber =  new ArrayList<>(lottoGenerator(tickets));
    }

    public List<List<Integer>> getlottoBox() {
        return lottoNumber;
    }

    private List<List<Integer>> lottoGenerator(int tickets) {
        List<List<Integer>> lottoList = new ArrayList<>();
        for(int i=0; i<tickets; i++){
            lottoList.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return lottoList;
    }

}
