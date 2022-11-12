package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeLottoNumber {
    private final int maxNumber = 6;
    private final int rangeStartValue = 1;
    private final int rangeEndValue = 45;


    public List<Integer> returnLottoNumber() {
        List<Integer> lottoNumber = new ArrayList<>();

        int initNum = Randoms.pickNumberInRange(rangeStartValue, rangeEndValue);
        lottoNumber.add(initNum);
        for(int i = 1; i<maxNumber; i++){
            lottoNumber = checkAndPutNumber(lottoNumber);
        }
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

    public List<Integer> checkAndPutNumber(List<Integer> lotto) {
        int tmp = Randoms.pickNumberInRange(rangeStartValue, rangeEndValue);

        for(int i = 0; i<lotto.size(); i++) {
            if(tmp == lotto.get(i)){
                tmp = Randoms.pickNumberInRange(rangeStartValue, rangeEndValue);
                i = -1;
            }
        }

        lotto.add(tmp);
        return lotto;
    }

}
