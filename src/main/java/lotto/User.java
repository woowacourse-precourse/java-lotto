package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class User {
    List<Integer> userNumber;

    public User() {
        this.userNumber = getLottoNumbers();
    }

    // 발행 로또 번호 초기화
    public List<Integer> getLottoNumbers() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        while (lottoNumber.size() != lottoNumber.stream().distinct().count()) {
            lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        }
        lottoNumber.sort(Integer::compareTo);
        return lottoNumber;
    }

}
