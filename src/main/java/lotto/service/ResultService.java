package lotto.service;

import static lotto.Constants.LOTTO_NUMBERS_SIZE;
import static lotto.Constants.LOTTO_NUMBERS_SIZE_IS_INVALID_ERROR_MESSAGE;
import static lotto.Constants.LOTTO_NUMBER_IS_NOT_IN_RANGE_ERROR_MESSAGE;
import static lotto.Constants.LOTTO_NUMBER_IS_NOT_NUMBER_ERROR_MESSAGE;
import static lotto.Constants.LOTTO_WINNING_NUMBERS_SEPARATOR;
import static lotto.Constants.MAXIMUM_LOTTO_NUMBER;
import static lotto.Constants.MINIMUM_LOTTO_NUMBER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.repository.ResultRepository;
import lotto.repository.UserLottoRepository;

public class ResultService {
    private static ResultService instance;
    private static ResultRepository resultRepository;
    private static UserLottoRepository userLottoRepository;

    private ResultService() {
    }

    public static ResultService getInstance() {
        if (instance == null) {
            instance = new ResultService();
            resultRepository = ResultRepository.getInstance();
            userLottoRepository = UserLottoRepository.getInstance();
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
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE_IS_INVALID_ERROR_MESSAGE);
        }
    }

    public void validateNumber(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_NOT_NUMBER_ERROR_MESSAGE);
        }
        int parsed = Integer.parseInt(number);
        if (parsed < MINIMUM_LOTTO_NUMBER || parsed > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_NOT_IN_RANGE_ERROR_MESSAGE);
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

    public void getLottoResult() {

    }
}
