package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    List<Integer> userNumber;

    public Buyer() {
        this.userNumber = getLottoNumbers();
    }

    // 발행 로또 번호 초기화
    public List<Integer> getLottoNumbers() {
        List<Integer> returnNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        returnNumber.sort(Integer::compareTo);
        return returnNumber;
    }

    public List<Integer> getUserNumber() {
        return userNumber;
    }
}
