package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {

    private static final int START_FROM = 1;
    private static final int END_TO = 45;
    private static final int NUMBER_OF = 6;

    private static final String BOUGHT_HOW_MANY = "개를 구매했습니다.";

    public List<List<Integer>> getLottoNumberList(int lottoCount){
        List<List<Integer>> lottoNumberList = new ArrayList<>();
        for(int i=0; i<lottoCount; i++){
            lottoNumberList.add(getLottoNumbers());
        }
        return lottoNumberList;
    }

    public void outputLottoNumberList(int lottoCount, List<List<Integer>> lottoNumberList){
        StringBuilder sb = new StringBuilder();
        sb.append(lottoCount);
        sb.append(BOUGHT_HOW_MANY + "\n");
        for(int i=0; i<lottoCount; i++){
            sb.append(lottoNumberList.get(i) + "\n");
        }

        System.out.println(sb);
    }
    private List<Integer> getLottoNumbers(){
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(START_FROM, END_TO, NUMBER_OF);
        ArrayList<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.addAll(lottoNumber);
        return sortLottoNumbers(lottoNumbers);
    }

    private List<Integer> sortLottoNumbers(List<Integer> lottoNumbers){
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
