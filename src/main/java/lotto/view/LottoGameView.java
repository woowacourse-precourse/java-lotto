package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.InformationMessage;
import lotto.domain.Lotto;
import lotto.LottoRank;
import lotto.WinningResultMessage;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
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
    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + InformationMessage.PRINT_PURCHASE_COUNT.getMessage());
        lottos.forEach(lotto -> printSortedLotto(lotto.getNumbers()));
    }

    public void printSortedLotto(List<Integer> lotto) {
        System.out.println(getSortedByAscend(lotto));
    }

    public void printWinningResult(List<LottoRank> ranks) {
        Map<LottoRank, Integer> rankCount = getRankCount(ranks);

        InformationMessage.PRINT_WINNING_RESULT.print();
        InformationMessage.DIVISOR.print();
        Arrays.stream(WinningResultMessage.values())
                .forEach(message -> message.print(rankCount.getOrDefault(message.getLottoRank(), 0)));
    }

    public void printRateOfReturn(double rateOfReturn) {
        InformationMessage.PRINT_RATE_OF_RETURN.print(rateOfReturn);
    }

    private List<Integer> getSortedByAscend(List<Integer> lotto) {
        return lotto.stream()
                .sorted(Comparator.comparing(Integer::valueOf))
                .collect(Collectors.toList());
    }

    private Map<LottoRank, Integer> getRankCount(List<LottoRank> ranks) {
        Map<LottoRank, Integer> rankCount = new HashMap<>();
        ranks.forEach(lottoRank -> rankCount.put(lottoRank, rankCount.getOrDefault(lottoRank, 0) + 1));
        return rankCount;
    }
}
