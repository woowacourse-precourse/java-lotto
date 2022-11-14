package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.domain.Lotto;
import lotto.domain.UserLotto;
import lotto.domain.Bonus;

import java.util.List;

import static lotto.domain.Preprocessor.splitNumber;
import static lotto.domain.Preprocessor.convertStringToInt;
import static lotto.domain.Preprocessor.convertStringListToIntegerList;

import static lotto.domain.Guide.*;

import static lotto.domain.NumberGenerator.createLottoList;
import static lotto.domain.UserLotto.createLottoResult;

public class Application {
    static final int ROUND_NUMBER = 1;

    public static void main(String[] args) {
        UserLotto user = createUserLotto();
        int lottoCount = user.getLottoCount();
        List<Lotto> lottos = getLottoList(lottoCount);

        printLottoList(lottos);

        Lotto winningNumbers = createWinningNumbers();
        Bonus bonusNumber = createBonusNumber(winningNumbers);
        List<Integer> lottoResult = createLottoResult(lottos, winningNumbers.getLotto(),
                bonusNumber.getBonusNumber());

        printLottoStatistics(createLottoStatisticsMessage(lottoResult));
        printRateOfReturn(user.getRateOfReturn(lottoResult), ROUND_NUMBER);
    }

    public static UserLotto createUserLotto() {
        printGetMoney();
        return new UserLotto(readLine());
    }

    public static List<Lotto> getLottoList(int lottoCount) {
        printLottoCount(lottoCount);
        return createLottoList(lottoCount);
    }

    public static Lotto createWinningNumbers() {
        printGetWinningNumber();
        return new Lotto(convertStringListToIntegerList(splitNumber(readLine())));
    }

    public static Bonus createBonusNumber(Lotto winningNumbers) {
        printGetBonusNumber();
        return new Bonus(convertStringToInt(readLine()), winningNumbers);
    }
}
