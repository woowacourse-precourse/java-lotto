package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private final List<List<Integer>> lottoNumber;

    public LottoGenerator(int lottoCount) {
        this.lottoNumber = lottoGenerator(lottoCount);
    }

    public List<List<Integer>> getlottoNumbers(){
        return lottoNumber;
    }

    private List<List<Integer>> lottoGenerator(int lottoCount) {
        List<List<Integer>> lottoes = new ArrayList<>();
        for(int i=0; i<lottoCount; i++) {
            lottoes.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return lottoes;
    }

}
