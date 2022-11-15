package lotto.domain.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constants.GuideSentences;
import lotto.constants.RankingInformation;
import lotto.domain.model.Lotto;
import lotto.exception.InputExceptionHandler;

public class LottoGuide {

    public int getPurchaseAmount() {
        System.out.println(GuideSentences.INPUT_PURCHASE_AMOUNT.getSentence());

        String amountInput = Console.readLine();
        InputExceptionHandler.handleOneNumberExceptions(amountInput);

        int purchaseAmount = Integer.parseInt(amountInput);

        System.out.print("\n");

        return purchaseAmount;
    }

    public void informIssuedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + GuideSentences.OUTPUT_NUMBER_OF_PURCHASES.getSentence());

        lottos.forEach(oneLotto -> System.out.println(oneLotto.getNumbers()));
        System.out.print("\n");
    }

    public List<Integer> getWinningNumbers() {
        System.out.println(GuideSentences.INPUT_WINNING_NUMBER.getSentence());

        String inputNumbers = Console.readLine();
        InputExceptionHandler.handleWinningNumbersExceptions(inputNumbers);

        List<Integer> winningNumbers = convertInputToWinningNumbers(inputNumbers);

        System.out.print("\n");

        return winningNumbers;
    }

    private List<Integer> convertInputToWinningNumbers(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getBonusNumber() {
        System.out.println(GuideSentences.INPUT_BONUS_NUMBER.getSentence());

        String bonusNumberInput = Console.readLine();
        InputExceptionHandler.handleOneNumberExceptions(bonusNumberInput);
        int bonusNumber = Integer.parseInt(bonusNumberInput);

        System.out.print("\n");

        return bonusNumber;
    }

    public void informWinningStatistics(Map<RankingInformation, Integer> statistics) {
        System.out.println(GuideSentences.OUTPUT_WINNING_STATISTICS.getSentence());
        String countUnit = "개";

        for (RankingInformation oneRank : RankingInformation.values()) {
            String rankResult =
                    oneRank.getStatisticSentence() + statistics.get(oneRank).toString() + countUnit;
            System.out.println(rankResult);
        }
    }

    public void informRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateOfReturn);
    }
}
