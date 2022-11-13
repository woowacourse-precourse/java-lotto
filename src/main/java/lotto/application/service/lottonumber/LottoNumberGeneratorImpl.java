package lotto.application.service.lottonumber;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberGeneratorImpl implements LottoNumberGenerator {
    @Override
    public List<List<Integer>> generateLottoNumber(int purchaseNumber) {
        List<List<Integer>> generatedLottoNumber = new ArrayList<>();

        for (int number = 0; number < purchaseNumber / 1000; number++) {
            generatedLottoNumber.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }

        return generatedLottoNumber;
    }
}
