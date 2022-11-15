package lotto.util;

import static lotto.constant.Constant.*;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domian.UserSingleLottoNumber;

public class GenerateLottoNumbers {
    public List<Integer> listSort(List<Integer> unsortedList) {
        List<Integer> sortedList = new ArrayList<>(unsortedList);
        Collections.sort(sortedList);
        return sortedList;
    }
    public List<UserSingleLottoNumber> generateLottoNumber(long lottoQuantity) {
        List<UserSingleLottoNumber> userAllLottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUMBER_OF_LOTTO_NUMBERS);
            userAllLottoNumbers.add(new UserSingleLottoNumber(listSort(lottoNumber)));
        }
        return userAllLottoNumbers;
    }
}
