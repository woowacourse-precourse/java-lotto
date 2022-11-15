package lotto.service;

import static lotto.LottoConstant.BONUS_NUMBER_INPUT_IS_NOT_IN_RANGE_ERROR_MESSAGE;
import static lotto.LottoConstant.BONUS_NUMBER_INPUT_IS_NOT_NUMBER_ERROR_MESSAGE;
import static lotto.LottoConstant.PURCHASE_AMOUNT_INPUT_IS_NOT_FALL_APART_ERROR_MESSAGE;
import static lotto.LottoConstant.PURCHASE_AMOUNT_INPUT_IS_NOT_NUMBER_ERROR_MESSAGE;
import static lotto.LottoConstant.PURCHASE_AMOUNT_INPUT_IS_TOO_LOW_TO_BUY_LOTTO_ERROR_MESSAGE;
import static lotto.LottoConstant.WINNING_LOTTO_NUMBER_INPUT_IS_NOT_IN_LOTTO_RANGE_ERROR_MESSAGE;
import static lotto.LottoConstant.WINNING_LOTTO_NUMBER_INPUT_IS_NOT_MATCH_REGEX_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Result;

public class LottoService {

    private static final String WINNING_NUMBER_INPUT_VALIDATE_REGEX = "^[0-9]+(,[0-9]+){5}$";

    private LottoService() {
    }

    public static long amountInputToInteger(String input) throws IllegalArgumentException {
        if (!input.chars().allMatch((Character::isDigit))) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_INPUT_IS_NOT_NUMBER_ERROR_MESSAGE);
        }
        long amount = Long.parseLong(input);
        if (amount < 1000) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_INPUT_IS_TOO_LOW_TO_BUY_LOTTO_ERROR_MESSAGE);
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_INPUT_IS_NOT_FALL_APART_ERROR_MESSAGE);
        }

        return amount;
    }

    public static long getLottoPurchaseCount(long amount) {
        return amount / 1000;
    }

    public static List<Lotto> getLottoNumbers(long purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < purchaseCount) {
            lottos.add(generateLottoNumber());
        }
        return lottos;
    }

    private static Lotto generateLottoNumber() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public static Lotto getWinningNumber(String input) throws IllegalArgumentException {
        if (!input.matches(WINNING_NUMBER_INPUT_VALIDATE_REGEX)) {
            throw new IllegalArgumentException(WINNING_LOTTO_NUMBER_INPUT_IS_NOT_MATCH_REGEX_ERROR_MESSAGE);
        }
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        if (!numbers.stream().allMatch(number -> (number >= 1 && number <= 45))) {
            throw new IllegalArgumentException(WINNING_LOTTO_NUMBER_INPUT_IS_NOT_IN_LOTTO_RANGE_ERROR_MESSAGE);
        }

        return new Lotto(List.copyOf(numbers));
    }

    public static int getBonusNumber(String input) throws IllegalArgumentException {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(BONUS_NUMBER_INPUT_IS_NOT_NUMBER_ERROR_MESSAGE);
        }

        int bonusNumber = Integer.parseInt(input);

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(BONUS_NUMBER_INPUT_IS_NOT_IN_RANGE_ERROR_MESSAGE);
        }
        return Integer.parseInt(input);
    }

    public static Map<Result, Integer> getWinningPoint(List<Lotto> lottoNumbers, Lotto winningLottoNumber,
                                                       int bonusNumber) {
        Map<Result, Integer> resultPoints = new HashMap<>();
        Arrays.stream(Result.values()).forEach(result -> resultPoints.put(result, 0));
        for (Lotto lottoNumber : lottoNumbers) {
            int winPoint = (int) lottoNumber.getNumbers().stream()
                    .filter(number -> winningLottoNumber.getNumbers().contains(number))
                    .count();
            boolean bonusPoint = lottoNumber.getNumbers().contains(bonusNumber);

            Optional<Result> optionalResult = Arrays.stream(Result.values())
                    .filter(winningPoint -> winningPoint.isWin(winPoint, bonusPoint)).findAny();
            if (optionalResult.isEmpty()) {
                continue;
            }
            Result result = optionalResult.get();
            resultPoints.put(result, resultPoints.get(result) + 1);
        }
        return resultPoints;
    }

    public static double getTotalRate(Map<Result, Integer> resultPoints, long amount) {
        double rate = 0;
        for (Result result : Result.values()) {
            rate += result.calculate(resultPoints.get(result));
        }
        return rate / amount * 100;
    }
}
