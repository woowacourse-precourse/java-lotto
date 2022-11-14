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
import static lotto.domain.Bonus.bonusIsNumeric;

public class Application {
    static final int ROUND_NUMBER = 1;

    public static void main(String[] args) {
        try {
            UserLotto user = createUserLotto();
            List<Lotto> lottos = getLottoList(user.getLottoCount());
            printLottoList(lottos);

            Lotto winningNumbers = createWinningNumbers();
            List<Integer> lottoResult = createLottoResult(lottos, winningNumbers.getLotto(),
                    createBonusNumber(winningNumbers).getBonusNumber());
            printResults(lottoResult, user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static UserLotto createUserLotto() throws IllegalArgumentException {
        printGetMoney();
        return new UserLotto(readLine());
    }

    public static List<Lotto> getLottoList(int lottoCount) throws IllegalArgumentException {
        printLottoCount(lottoCount);
        return createLottoList(lottoCount);
    }

    public static Lotto createWinningNumbers() throws IllegalArgumentException {
        printGetWinningNumber();
        return new Lotto(convertStringListToIntegerList(splitNumber(readLine())));
    }

    public static Bonus createBonusNumber(Lotto winningNumbers) throws IllegalArgumentException {
        printGetBonusNumber();
        String bonusNumber = readLine();
        bonusIsNumeric(bonusNumber);
        return new Bonus(convertStringToInt(bonusNumber), winningNumbers);
    }

    public static void printResults(List<Integer> lottoResult, UserLotto user) {
        printLottoStatistics(createLottoStatisticsMessage(lottoResult));
        printRateOfReturn(user.getRateOfReturn(lottoResult), ROUND_NUMBER);
    }
}
