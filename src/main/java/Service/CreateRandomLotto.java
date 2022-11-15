package Service;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateRandomLotto {

    public static List<List<Integer>> createRandomLottoNumber(int purchaseAmount) {
        int numberOfLotto = purchaseAmount / 1000;
        List<List<Integer>> randomLottoNumbers = new ArrayList<>();

        for (int count = 0; count < numberOfLotto; count++) {
            List<Integer> randomLottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomLottoNumber);
            randomLottoNumbers.add(randomLottoNumber);
        }
        return randomLottoNumbers;
    }
}
