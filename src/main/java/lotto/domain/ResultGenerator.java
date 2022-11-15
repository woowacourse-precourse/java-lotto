package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultGenerator {
    public ResultGenerator() {

    }

    public Results createResults(Lottos lottos, PrizeLotto prizeLotto) {
        List<Result> results = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            results.add(getResult(lotto, prizeLotto));
        }
        return new Results(results);
    }

    public long howManyMatch(Lotto lotto, PrizeLotto prizeLotto) {
        return lotto.getNumbers().stream()
                .filter(number -> prizeLotto.getLotto().getNumbers().contains(number))
                .count();
    }

    public int howManyBonusNumber(Lotto lotto, PrizeLotto prizeLotto) {
        return Collections.frequency(lotto.getNumbers(), prizeLotto.getBonusNumber());
    }

    public Result getResult(Lotto lotto, PrizeLotto prizeLotto) {
        long numberOfMatchNumbers = howManyMatch(lotto, prizeLotto);
        int numberOfBonusNumber = howManyBonusNumber(lotto, prizeLotto);
        String resultCode = String.valueOf(numberOfMatchNumbers) + String.valueOf(numberOfBonusNumber);
        return Result.findByResultCode(resultCode);
    }
}
