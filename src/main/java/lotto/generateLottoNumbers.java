package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class generateLottoNumbers {
    public static List<Lotto> generate(int Number_of_Purchase){
        List<Lotto> LottoNumbers = new ArrayList<>();
        List<Integer> lottoNumber;
        while (Number_of_Purchase >0){
            lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            LottoNumbers.add(new Lotto(lottoNumber));
            Number_of_Purchase--;
        }
        return LottoNumbers;
    }
}
