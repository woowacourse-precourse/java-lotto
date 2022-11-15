package lotto.service;

import static lotto.Constants.LOTTO_NUMBERS_SIZE;
import static lotto.Constants.LOTTO_NUMBERS_SIZE_IS_INVALID_ERROR_MESSAGE;
import static lotto.Constants.LOTTO_NUMBER_IS_NOT_IN_RANGE_ERROR_MESSAGE;
import static lotto.Constants.LOTTO_NUMBER_IS_NOT_NUMBER_ERROR_MESSAGE;
import static lotto.Constants.LOTTO_WINNING_NUMBERS_SEPARATOR;
import static lotto.Constants.MAXIMUM_LOTTO_NUMBER;
import static lotto.Constants.MINIMUM_LOTTO_NUMBER;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.ErrorHandler;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinningResult;
import lotto.repository.ResultRepository;

public class ResultService {
    private static ResultService instance;
    private static ResultRepository resultRepository;

    private ResultService() {
    }

    public static ResultService getInstance() {
        if (instance == null) {
            instance = new ResultService();
            resultRepository = ResultRepository.getInstance();
        }
        return instance;
    }

    public List<String> splitWinningNumbers(String input) {
        return Arrays.asList(input.split(LOTTO_WINNING_NUMBERS_SEPARATOR));
    }

    public void validate(List<String> winningNumbers) {
        for (String number : winningNumbers) {
            validateNumber(number);
        }
        if (winningNumbers.size() != LOTTO_NUMBERS_SIZE) {
            ErrorHandler.handle(LOTTO_NUMBERS_SIZE_IS_INVALID_ERROR_MESSAGE);
        }
    }

    public void validateNumber(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            ErrorHandler.handle(LOTTO_NUMBER_IS_NOT_NUMBER_ERROR_MESSAGE);
        }
        int parsed = Integer.parseInt(number);
        if (parsed < MINIMUM_LOTTO_NUMBER || parsed > MAXIMUM_LOTTO_NUMBER) {
            ErrorHandler.handle(LOTTO_NUMBER_IS_NOT_IN_RANGE_ERROR_MESSAGE);
        }
    }

    public void saveWinningNumbers(List<String> winningNumbers) {
        resultRepository.save(
                new Lotto(winningNumbers.stream()
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
        );
    }

    public void saveBonusNumber(String bonusNumber) {
        resultRepository.save(Integer.parseInt(bonusNumber));
    }

    public void saveLottoResult(List<Lotto> issuedLotteries) {
        Lotto winningLotto = resultRepository.findWinningLotto();
        int bonusNumber = resultRepository.findBonusNumber();
        Map<WinningResult, Integer> winningResultCount = new HashMap<>();

        for (Lotto issued : issuedLotteries) {
            int cnt = issued.getSameNumberCount(winningLotto, issued);
            WinningResult winningResult = WinningResult.getWinningResult(
                    new Result(cnt, issued.hasBonusNumber(bonusNumber)));
            if (winningResult != null) {
                winningResultCount.put(winningResult, winningResultCount.getOrDefault(winningResult, 0) + 1);
            }
        }
        resultRepository.save(winningResultCount);
    }

    public Map<WinningResult, Integer> getLottoResultCount() {
        return resultRepository.findLottoResultCount();
    }
}
