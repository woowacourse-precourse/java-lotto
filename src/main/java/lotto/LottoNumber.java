package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoNumber {

    private static final int START_FROM = 1;
    private static final int END_TO = 45;
    private static final int NUMBER_OF = 6;

    public List<List<Integer>> getLottoNumberList(int lottoCount){
        List<List<Integer>> lottoNumberList = new ArrayList<>();
        for(int i=0; i<lottoCount; i++){
            lottoNumberList.add(getLottoNumbers());
        }
        return lottoNumberList;
    }

    private List<Integer> getLottoNumbers(){
        List<Integer> lottoNumbers =
                sortLottoNumbers(Randoms.pickUniqueNumbersInRange(START_FROM, END_TO, NUMBER_OF));

        return lottoNumbers;
    }

    private List<Integer> sortLottoNumbers(List<Integer> lottoNumbers){
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
