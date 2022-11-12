package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class DataProcessing {
    public List<Integer> lottoRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> sortLottoNumbers(List<Integer> sortNumbers) {
        Collections.sort(sortNumbers);
        return sortNumbers;
    }

    public int conversionMoney(String money) {
        return Integer.parseInt(money);
    }

    public String[] splitLottoNumber(String lottoNumbers) {
        return lottoNumbers.split(",");
    }
}