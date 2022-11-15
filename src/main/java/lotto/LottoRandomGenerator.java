package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoRandomGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 로또 범위에 맞지 않는 숫자값을 가지고 있습니다.";
    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 생성된 로또의 번호가 6개가 아닙니다.";
    private static final String OVERLAP_ERROR_MESSAGE = "[ERROR] 로또에 중복된 번호가 있습니다.";

    public Lotto createLotto(){
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(MIN_NUMBER,MAX_NUMBER,LOTTO_SIZE);
        Collections.sort(lottoNumber);
        checkCorrectLotto(lottoNumber);

        return new Lotto(lottoNumber);
    }

    private void checkCorrectLotto(List<Integer> lotto) {
        rangeCheck(lotto);
        sizeCheck(lotto);
        overlapCheck(lotto);
    }

    private void rangeCheck(List<Integer> lotto){
        for(int number : lotto){
            if(number<1 || number>45){
                throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
            }
        }
    }
    private void sizeCheck(List<Integer> lotto){
        if(lotto.size() == LOTTO_SIZE){
            return;
        }
        throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
    }

    private void overlapCheck(List<Integer> lotto){
        Set<Integer> overlapLotto = new HashSet<>(lotto);
        if(overlapLotto.size()==lotto.size()){
            return;
        }
        throw new IllegalArgumentException(OVERLAP_ERROR_MESSAGE);
    }

}
