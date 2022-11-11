package lotto.service;

import lotto.LottoNumbersGenerator;
import lotto.LottoWinningRank;
import lotto.model.Lotto;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGameService {

    private static final int A_LOTTO_PRICE = 1000;
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String LOTTO_PURCHASE_AMOUNT_DIVIDE_REST_EXCEPTION_MESSAGE = "로또 구입 금액은 1,000원으로 나누어 떨어져야합니다.";
    private static final String LOTTO_PURCHASE_AMOUNT_NOT_DIGIT_EXCEPTION_MESSAGE = "로또 구입 금액은 숫자여야합니다.";
    private static final String DIGIT_REGEX = "^[0-9]+$";
    private static final int CORRECT_LOTTO_WINNING_NUMBERS_SIZE = 6;
    private static final String LOTTO_WINNING_NUMBERS_SIZE_EXCEPTION_MESSAGE = "로또 당첨 번호의 개수는 6개여야합니다.";
    private static final String LOTTO_WINNING_NUMBERS_DUPLICATE_EXCEPTION_MESSAGE = "로또 당첨 번호는 중복될 수 없습니다.";
    private static final String LOTTO_WINNING_NUMBERS_RANGE_EXCEPTION_MESSAGE = "로또 당첨 번호의 범위는 1~45여야합니다.";
    private static final String LOTTO_WINNING_NUMBERS_REGEX = "^[0-9,]+$";
    private static final String LOTTO_WINNING_NUMBERS_TYPE_EXCEPTION_MESSAGE = "로또 당첨 번호는 공백 없이 쉼표로 구분된 숫자여야합니다.";
    private static final String BONUS_NUMBER_NOT_DIGIT_EXCEPTION_MESSAGE = "보너스 번호는 숫자여야합니다.";
    private static final String BONUS_NUMBER_RANGE_EXCEPTION_MESSAGE = "보너스 번호의 범위는 1~45여야합니다.";
    private static final String BONUS_NUMBER_WINNING_NUMBERS_DUPLICATE_EXCEPTION_MESSAGE = "보너스 번호는 당첨 번호에 있는 번호를 제외한 번호여야합니다.";
    private static final int LOTTO_WINNING_RANK_MAP_INIT_VALUE = 0;

    // Key : 로또 당첨 등수 ENUM / Value : 해당 등수에 당첨된 횟수인 당첨 통계를 위한 HashMap
    private final Map<LottoWinningRank, Integer> lottoWinningRankMap = new HashMap<>();

    private final List<List<Integer>> purchaseLottoNumbers = new ArrayList<>();

    public LottoGameService() {
        initLottoWinningRankMap();
    }

    private void initLottoWinningRankMap() {
        lottoWinningRankMap.put(LottoWinningRank.FIRST, LOTTO_WINNING_RANK_MAP_INIT_VALUE);
        lottoWinningRankMap.put(LottoWinningRank.SECOND, LOTTO_WINNING_RANK_MAP_INIT_VALUE);
        lottoWinningRankMap.put(LottoWinningRank.THIRD, LOTTO_WINNING_RANK_MAP_INIT_VALUE);
        lottoWinningRankMap.put(LottoWinningRank.FOURTH, LOTTO_WINNING_RANK_MAP_INIT_VALUE);
        lottoWinningRankMap.put(LottoWinningRank.FIFTH, LOTTO_WINNING_RANK_MAP_INIT_VALUE);
    }

    public void addLottoNumberToLottoNumbers() {
        Lotto lotto = new Lotto(LottoNumbersGenerator.generateLottoNumbers());
        purchaseLottoNumbers.add(lotto.getNumbers());
    }

    public int getLottoIssueCount(String lottoPurchaseAmount) {
        validateLottoIssueCount(lottoPurchaseAmount);
        return Integer.parseInt(lottoPurchaseAmount) / A_LOTTO_PRICE;
    }

    public void validateLottoIssueCount(String lottoPurchaseAmount) {
        if (isLottoPurchaseAmountNotDigit(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + LOTTO_PURCHASE_AMOUNT_NOT_DIGIT_EXCEPTION_MESSAGE);
        }
        if (isRestOfLottoPurchaseAmountDivideBy1000NotZero(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + LOTTO_PURCHASE_AMOUNT_DIVIDE_REST_EXCEPTION_MESSAGE);
        }
    }

    public void validateLottoWinningNumbers(String inputLottoWinningNumber) {
        if (isLottoWinningNumbersWrongType(inputLottoWinningNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + LOTTO_WINNING_NUMBERS_TYPE_EXCEPTION_MESSAGE);
        }

        List<Integer> convertedLottoWinningNumbers = inputWinningNumberConvertToCollection(inputLottoWinningNumber);
        if (isLottoWinningNumbersSizeNotSix(convertedLottoWinningNumbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + LOTTO_WINNING_NUMBERS_SIZE_EXCEPTION_MESSAGE);
        }
        if (isLottoWinningNumbersDuplicate(convertedLottoWinningNumbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + LOTTO_WINNING_NUMBERS_DUPLICATE_EXCEPTION_MESSAGE);
        }
        if (isLottoWinningNumbersWrongRange(convertedLottoWinningNumbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + LOTTO_WINNING_NUMBERS_RANGE_EXCEPTION_MESSAGE);
        }
    }

    public void validateBonusNumber(String lottoWinningNumbers, String bonusNumber) {
        if (isBonusNumberNotDigit(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + BONUS_NUMBER_NOT_DIGIT_EXCEPTION_MESSAGE);
        }
        if (isBonusNumberWrongRange(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + BONUS_NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
        if (isBonusNumberDuplicateWinningNumbers(lottoWinningNumbers, bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + BONUS_NUMBER_WINNING_NUMBERS_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private boolean isRestOfLottoPurchaseAmountDivideBy1000NotZero(String lottoPurchaseAmount) {
        return Integer.parseInt(lottoPurchaseAmount) % A_LOTTO_PRICE != 0;
    }

    private boolean isLottoPurchaseAmountNotDigit(String lottoPurchaseAmount) {
        return !Pattern.compile(DIGIT_REGEX).matcher(String.valueOf(lottoPurchaseAmount)).matches();
    }

    public long getPurchaseNumbersMatchWinningNumbersCount(List<Integer> purchaseLottoNumbers, List<Integer> lottoWinningNumbers) {
        return lottoWinningNumbers.stream()
                .filter(purchaseLottoNumbers::contains)
                .count();
    }

    public boolean isPurchaseNumbersMatchBonusNumber(List<Integer> purchaseLottoNumbers, int bonusNumber) {
        return purchaseLottoNumbers.contains(bonusNumber);
    }

    public boolean isLottoWinningNumbersSizeNotSix(List<Integer> lottoWinningNumbers) {
        return lottoWinningNumbers.size() != CORRECT_LOTTO_WINNING_NUMBERS_SIZE;
    }

    private boolean isLottoWinningNumbersDuplicate(List<Integer> lottoWinningNumbers) {
        long numbersDistinctSize = lottoWinningNumbers.stream()
                .distinct().count();
        return numbersDistinctSize != CORRECT_LOTTO_WINNING_NUMBERS_SIZE;
    }

    private boolean isLottoWinningNumbersWrongRange(List<Integer> lottoWinningNumbers) {
        long correctNumbersRangeCount = lottoWinningNumbers.stream()
                .filter(number -> number >= 1 && number <= 45)
                .count();
        return correctNumbersRangeCount != CORRECT_LOTTO_WINNING_NUMBERS_SIZE;
    }

    private boolean isLottoWinningNumbersWrongType(String inputLottoWinningNumber) {
        return !Pattern.compile(LOTTO_WINNING_NUMBERS_REGEX).matcher(inputLottoWinningNumber).matches();
    }

    private boolean isBonusNumberNotDigit(String bonusNumber) {
        return !Pattern.compile(DIGIT_REGEX).matcher(bonusNumber).matches();
    }

    private boolean isBonusNumberWrongRange(String bonusNumber) {
        return Integer.parseInt(bonusNumber) < 1 || Integer.parseInt(bonusNumber) > 45;
    }

    private boolean isBonusNumberDuplicateWinningNumbers(String lottoWinningNumbers, String bonusNumber) {
        List<Integer> collectedLottoWinningNumbers = Arrays.stream(lottoWinningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return collectedLottoWinningNumbers.contains(Integer.parseInt(bonusNumber));
    }

    public List<Integer> inputWinningNumberConvertToCollection(String lottoWinningNumber) {
        List<String> strLottoWinningNumbers = Stream.of(lottoWinningNumber.split(","))
                .collect(Collectors.toList());

        return strLottoWinningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

    public void updateWinningRankMap(LottoWinningRank lottoWinningRank) {
        if (lottoWinningRank != LottoWinningRank.NO_RANK) {
            lottoWinningRankMap.put(lottoWinningRank, lottoWinningRankMap.get(lottoWinningRank) + 1);
        }
    }

    public LottoWinningRank decideWinningRank(List<Integer> purchaseLottoNumbers,
                                              String lottoWinningNumbers,
                                              String bonusNumber) {
        List<Integer> collectedLottoWinningNumbers = Arrays.stream(lottoWinningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int convertedBonusNumber = Integer.parseInt(bonusNumber);
        long purchaseNumbersMatchWinningNumbersCount =
                getPurchaseNumbersMatchWinningNumbersCount(purchaseLottoNumbers, collectedLottoWinningNumbers);
        return LottoWinningRank.decideLottoWinningRank(purchaseNumbersMatchWinningNumbersCount,
                isPurchaseNumbersMatchBonusNumber(purchaseLottoNumbers, convertedBonusNumber));
    }

    public String getEarningsRatio(String lottoPurchaseAmount) {
        double sumLottoWinningMoney = 0;
        List<LottoWinningRank> lottoWinningRanks = lottoWinningRankMap.entrySet().stream()
                .filter(lottoWinningRank -> lottoWinningRank.getValue() != 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        for (LottoWinningRank lottoWinningRank : lottoWinningRanks) {
            String commaRemovedWinningMoney = removeWinningMoneyComma(lottoWinningRank);
            int convertedWinningMoney = Integer.parseInt(commaRemovedWinningMoney);
            sumLottoWinningMoney += convertedWinningMoney;
        }
        double convertedLottoPurchaseAmount = Double.parseDouble(lottoPurchaseAmount);
        double earningsRatio = (sumLottoWinningMoney / convertedLottoPurchaseAmount) * 100;
        return String.format("%,.1f", earningsRatio) + "%";
    }

    public String removeWinningMoneyComma(LottoWinningRank lottoWinningRank) {
        String originalWinningMoney = lottoWinningRank.getWinningMoney();
        return originalWinningMoney.replace(",", "");
    }

    public List<List<Integer>> getPurchaseLottoNumbers() {
        return purchaseLottoNumbers;
    }
}
