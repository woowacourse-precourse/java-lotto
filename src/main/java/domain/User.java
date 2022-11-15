package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User {
    public List<Integer> userNumber;

    public User() {
        this.userNumber = getLottoNumbers();
    }

    public User(List<Integer> userNumber) {
        this.userNumber = userNumber;
    }

    // 발행 로또 번호 초기화
    public List<Integer> getLottoNumbers() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        while (lottoNumber.size() != lottoNumber.stream().distinct().count()) {
            lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        }
        List<Integer> returnNumber = new ArrayList<>(lottoNumber);
        returnNumber.sort(Integer::compareTo);
        return returnNumber;
    }

}

