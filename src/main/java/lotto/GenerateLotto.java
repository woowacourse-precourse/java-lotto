package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.util.Sets;

public class GenerateLotto {
    private List<List<Integer>> lottoNumberGroup = new ArrayList<>();
    private int lottoQuantity;

    public GenerateLotto(){}
/*
    public GenerateLotto(int lottoQuantity){
        this.lottoQuantity = lottoQuantity;
    }
*/
    public List<Integer> generateLottoNumber(){
        List<Integer> lottoNumbers;
        Set<Integer> checkDuplication;

        do {
            lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            checkDuplication = Sets.newHashSet(lottoNumbers);
        } while (lottoNumbers.size() != checkDuplication.size());

        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
