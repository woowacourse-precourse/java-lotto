package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.UserLotto;
import lotto.domain.Bonus;

import java.util.List;

import static lotto.domain.Preprocessor.splitNumber;
import static lotto.domain.Preprocessor.convertStringToInt;
import static lotto.domain.Preprocessor.convertStringListToIntegerList;

import static lotto.domain.Guide.printGetMoney;
import static lotto.domain.Guide.printLottoCount;
import static lotto.domain.Guide.printBoughtLottoList;
import static lotto.domain.Guide.printGetWinningNumber;
import static lotto.domain.Guide.printGetBonusNumber;
import static lotto.domain.Guide.printLottoStatistics;
import static lotto.domain.Guide.printRateOfReturn;
import static lotto.domain.Guide.createLottoStatisticsMessage;

import static lotto.domain.NumberGenerator.createLottoList;
import static lotto.domain.UserLotto.createLottoResult;

public class Application {
    public static void main(String[] args) {
        printGetMoney();
        UserLotto user = new UserLotto(Console.readLine());
        int lottoCount = user.getLottoCount();
        printLottoCount(lottoCount);
        List<Lotto> boughtLotto = createLottoList(lottoCount);
        printBoughtLottoList(boughtLotto);
        printGetWinningNumber();
        Lotto winningNumbers = new Lotto(convertStringListToIntegerList(splitNumber(Console.readLine())));
        printGetBonusNumber();
        Bonus bonusNumber = new Bonus(convertStringToInt(Console.readLine()), winningNumbers);
        List<Integer> lottoResult = createLottoResult(boughtLotto, winningNumbers.getLotto(), bonusNumber.getBonusNumber());
        printLottoStatistics(createLottoStatisticsMessage(lottoResult));
        printRateOfReturn(user.getRateOfReturn(lottoResult), 1);
    }
}
