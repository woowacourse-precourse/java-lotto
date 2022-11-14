package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Generator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private static final String RANGE_ERROR_MSG = "[ERROR] 로또 범위에 맞지 않는 숫자값을 가지고 있습니다.";
    private static final String SIZE_ERROR_MSG = "[ERROR] 생성된 로또의 번호가 6개가 아닙니다.";
    private static final String DUPLICATE_ERROR_MSG = "[ERROR] 로또에 중복된 번호가 있습니다.";

    public Lotto createLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER,MAX_NUMBER,LOTTO_SIZE);
        Collections.sort(lottoNumbers);
        validCheck(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

    private void validCheck(List<Integer> lotto) {
        validateSize(lotto);
        validateNumbersRange(lotto);
        validateDuplicate(lotto);
    }

    private void validateNumbersRange(List<Integer> lotto) {
        for(int number : lotto) {
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException(RANGE_ERROR_MSG);
            }
        }
    }

    private void validateDuplicate(List<Integer> lotto) {
        Set<Integer> duplicateNumbers = new HashSet<>(lotto);
        if(duplicateNumbers.size() == LOTTO_SIZE) {
            return;
        }
        throw new IllegalArgumentException(DUPLICATE_ERROR_MSG);
    }

    private void validateSize(List<Integer> lotto) {
        if(lotto.size() == LOTTO_SIZE){
            return;
        }
        throw new IllegalArgumentException(SIZE_ERROR_MSG);
    }

}
