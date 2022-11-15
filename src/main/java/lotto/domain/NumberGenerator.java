package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public List<Integer> createRandomNumbers(){
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        // ErrorHandler#createLottoNumberError(randomNumbers);
        return randomNumbers;
    }



}
