package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

// 랜덤 로또 숫자 생성
public class CreateLottoNumbers {

    List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    Lotto lotto = new Lotto(numbers);

}
