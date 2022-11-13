package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Generator {

    public List<Integer> generateRandomLottoNumber(){

        List<Integer> randomLottoNumber = pickUniqueNumbersInRange(1, 45,6);

        return randomLottoNumber;
    }





}
