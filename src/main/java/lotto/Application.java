package lotto;

import static lotto.domain.constant.IntValueConstant.LOTTO_MAXIMUM_NUMBER;
import static lotto.domain.constant.IntValueConstant.LOTTO_MINIMUM_NUMBER;
import static lotto.domain.constant.IntValueConstant.LOTTO_NUMBER_OF_DIGITS;
import static lotto.exception.ExceptionHandler.ILLEGAL_RANGE;
import static lotto.exception.ExceptionHandler.ILLEGAL_VALUE;
import static lotto.exception.ExceptionHandler.INPUT_SIX_DIGITS;
import static lotto.exception.ExceptionHandler.OVERLAP_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Buyer;
import lotto.domain.Lotto;

public class Application {

    private static final List<Set<Integer>> lottoGameResults = new ArrayList<>();

    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        buyer.readyForBuyLotto();
        buyer.buyLotto();

        Set<Integer> winningNumbers = createWinningNumbers();
        validateWinningNumbers(winningNumbers);

        List<Integer> bonusNumber = createBonusNumber(winningNumbers);
        compareWinningNumbersWithBuyerLottoNumbers(winningNumbers, buyer.getLottoNumbers());
        compareBonusNumberWithBuyerLottoNumbers(bonusNumber, buyer.getLottoNumbers());
    }

    private static Set<Integer> createWinningNumbers() {
        String inputValues = Console.readLine();

        return Arrays.stream(inputValues.split(","))
                     .map(Integer::parseInt)
                     .collect(Collectors.toSet());
    }

    private static void validateWinningNumbers(Set<Integer> winningNumbers) {
        validateRangeNumbers(winningNumbers);
        validateOverlapWinningNumbers(winningNumbers);

        if (winningNumbers.size() != LOTTO_NUMBER_OF_DIGITS.getValue()) {
            INPUT_SIX_DIGITS.error();
        }
    }

    private static void validateRangeNumbers(Set<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_MINIMUM_NUMBER.getValue() || number > LOTTO_MAXIMUM_NUMBER.getValue()) {
                ILLEGAL_RANGE.error();
            }
        }
    }

    private static void validateOverlapWinningNumbers(Set<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_OF_DIGITS.getValue()) {
            OVERLAP_NUMBER.error();
        }
    }

    private static List<Integer> createBonusNumber(Set<Integer> winningNumbers) {
        try {
            List<Integer> bonusNumber = Collections.singletonList(Integer.parseInt(Console.readLine()));

            validateRangeNumbers(new HashSet<>(bonusNumber));
            validateOverlapBonusNumberWithWinningNumbers(bonusNumber, winningNumbers);

            return bonusNumber;

        } catch (NumberFormatException exception) {
            ILLEGAL_VALUE.error();
        }

        return Collections.emptyList();
    }

    private static void validateOverlapBonusNumberWithWinningNumbers(List<Integer> bonusNumber,
            Set<Integer> winningNumbers) {

        for (Integer winningNumber : winningNumbers) {
            if (Objects.equals(winningNumber, bonusNumber.get(0))) {
                OVERLAP_NUMBER.error();
            }
        }
    }

    private static void compareWinningNumbersWithBuyerLottoNumbers(Set<Integer> winningNumbers, List<Lotto> lottoNumbers) {
        for (Lotto lottoNumber : lottoNumbers) {

            Set<Integer> lottoGameResult = new HashSet<>(winningNumbers);

            for (int i = 0; i < LOTTO_NUMBER_OF_DIGITS.getValue(); i++) {
                lottoGameResult.add(lottoNumber.getNumbers()
                                               .get(i));

                lottoGameResults.add(lottoGameResult);
            }
        }
    }

    private static void compareBonusNumberWithBuyerLottoNumbers(List<Integer> bonusNumber, List<Lotto> lottoNumbers) {
        for (int i = 0; i < lottoGameResults.size(); i++) {
            if (Objects.equals(lottoNumbers.get(i)
                                           .getNumbers()
                                           .get(i), bonusNumber.get(0)) && lottoGameResults.get(i)
                                                                                           .size() == 7) {
                //TODO: 이 친구는 2등이다.
            }
        }
    }


}
