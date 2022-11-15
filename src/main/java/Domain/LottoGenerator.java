package Domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public List<Integer> createLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(sortLottoNumbers);
        return sortLottoNumbers;
    }

    private void haveOnlyNumbers(String price) {
        final String numberRegex = "[0-9]+";
        if (!price.matches(numberRegex)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자만 입력하세요");
        }
    }

}

