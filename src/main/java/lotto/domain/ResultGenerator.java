package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultGenerator {
    public ResultGenerator() {

    }

    public static Results createResults(Lottos lottos, PrizeLotto prizeLotto) {
        List<Result> results = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            results.add(getResult(lotto, prizeLotto));
        }
        return new Results(results);
    }

    public static long howManyMatch(Lotto lotto, PrizeLotto prizeLotto) {
        return lotto.getNumbers().stream()
                .filter(number -> prizeLotto.getLotto().getNumbers().contains(number))
                .count();
    }

    public static int howManyBonusNumber(Lotto lotto, PrizeLotto prizeLotto) {
        return Collections.frequency(lotto.getNumbers(), prizeLotto.getBonusNumber());
    }

    public static Result getResult(Lotto lotto, PrizeLotto prizeLotto) {
        long numberOfMatchNumbers = howManyMatch(lotto, prizeLotto);
        int numberOfBonusNumber = howManyBonusNumber(lotto, prizeLotto);
        String resultCode = String.valueOf(numberOfMatchNumbers) + String.valueOf(numberOfBonusNumber);
        return Result.findByResultCode(resultCode);
    }
}
