package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lottos;
import lotto.util.InformationMessage;
import lotto.domain.Lotto;
import lotto.util.LottoRank;
import lotto.util.WinningResultMessage;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGameView {
    private final ViewValidator viewValidator;

    public LottoGameView(ViewValidator viewValidator) {
        this.viewValidator = viewValidator;
    }

    public int inputMoney() {
        InformationMessage.INPUT_PRICE.print();
        String money = Console.readLine();

        viewValidator.validateNumberType(money);
        viewValidator.validateMoneyIsZero(money);
        viewValidator.validateUnitOf1000(money);

        return Integer.parseInt(money);
    }

    public List<Integer> inputWinningNumbers() {
        InformationMessage.INPUT_WINNING_NUMBER.print();
        String winningNumbers = Console.readLine();

        viewValidator.validateNumbersType(winningNumbers);

        return convertWinningNumbers(winningNumbers);
    }

    private List<Integer> convertWinningNumbers(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        InformationMessage.INPUT_BONUS_NUMBER.print();
        String inputNumber = Console.readLine();

        viewValidator.validateNumberType(inputNumber);

        return Integer.parseInt(inputNumber);
    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos.getLottoCount() + InformationMessage.PRINT_PURCHASE_COUNT.getMessage());
        lottos.getlottos().forEach(this::printSortedLotto);
    }

    public void printSortedLotto(Lotto lotto) {
        System.out.println(lotto.getSortedByAscend());
    }

    public void printWinningResult(Map<LottoRank, Integer> rankCount) {
        InformationMessage.PRINT_WINNING_RESULT.print();
        InformationMessage.DIVISOR.print();
        Arrays.stream(WinningResultMessage.values())
                .forEach(message -> message.print(rankCount.getOrDefault(message.getLottoRank(), 0)));
    }

    public void printRateOfReturn(double rateOfReturn) {
        InformationMessage.PRINT_RATE_OF_RETURN.print(rateOfReturn);
    }
}
