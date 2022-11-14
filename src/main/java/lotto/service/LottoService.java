package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LuckyNumber;
import lotto.message.ErrorMessage;
import lotto.message.NumberType;
import lotto.repository.LottoRepository;
import lotto.validation.Validator;
import lotto.view.input.Input;
import lotto.view.output.Output;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

    LottoRepository lottoRepository;
    Validator validator;

    Input input;

    Output output;
    public LottoService() {
        this.lottoRepository = new LottoRepository();
        this.validator = new Validator();
        this.input = new Input();
        this.output = new Output();
    }

    public int getMoney() throws IllegalArgumentException{
        String money = input.scanMoneyInput();
        if (!validator.isNumeric(money)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_TYPE_ERROR.getErrorMessage());
        }
        if (!validator.isCorrectUnit(money)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_UNIT_ERROR.getErrorMessage());
        }
        return Integer.parseInt(money);
    }

    public void buyLotto(int money) throws IllegalArgumentException {
        int purchaseQuantity = money/NumberType.IN_THOUSANDS.getNumberType();
        output.printLottoCountForBuy(purchaseQuantity);
        pickAndSaveLotto(purchaseQuantity);
        List<Lotto> lottos = lottoRepository.findAll();
        output.printAllLottos(lottos);
    }

    public void pickAndSaveLotto(int purchaseQuantity) {
        while (purchaseQuantity-- > 0) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottoRepository.add(lotto);
        }
    }

    public LuckyNumber pickLuckyNumber() throws IllegalArgumentException {
        HashSet<Integer> winningNumbers = pickWinningNumbers();
        int bonusNumber = pickBonusNumber(winningNumbers);
        LuckyNumber luckyNumber = new LuckyNumber(winningNumbers, bonusNumber);
        return luckyNumber;
    }

    public int pickBonusNumber(HashSet<Integer> winningNumbers) throws IllegalArgumentException {
        String bonusNumberInput = input.scanBonusNumber();
        checkBonusNumberInput(bonusNumberInput, winningNumbers);
        return Integer.parseInt(bonusNumberInput);
    }

    public HashSet<Integer> pickWinningNumbers() throws IllegalArgumentException {
        String winningNumbersInput = input.scanWinnerNumbers();
        checkWinningNumberInput(winningNumbersInput);
        return changeStringToHashSet(winningNumbersInput);
    }

    public HashSet<Integer> changeStringToHashSet(String winningNumbersInput) {
        String[] numbers = winningNumbersInput.split(",");
        HashSet<Integer> winningNumber = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(HashSet::new));
        return winningNumber;
    }

    public void checkWinningNumberInput(String winningNumbersInput) throws IllegalArgumentException {
        if (!validator.isCorrectDigitAtComma(winningNumbersInput)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_DIGIT_ERROR.getErrorMessage());
        }
        if (!validator.isNumericAtComma(winningNumbersInput)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_TYPE_ERROR.getErrorMessage());
        }
        if (!validator.isExistInBoundaryAtComma(winningNumbersInput)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_BOUNDARY_ERROR.getErrorMessage());
        }
        if (!validator.isUniqueNumberAtComma(winningNumbersInput)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_DUPLICATED_ERROR.getErrorMessage());
        }
    }

    public void checkBonusNumberInput(String bonusNumberInput, HashSet<Integer> winningNumbers) throws IllegalArgumentException {
        if (!validator.isNumeric(bonusNumberInput)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_TYPE_ERROR.getErrorMessage());
        }
        if (!validator.isExistInBoundary(bonusNumberInput)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_BOUNDARY_ERROR.getErrorMessage());
        }
        if (!validator.isUniqueNumber(bonusNumberInput, winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATED_ERROR.getErrorMessage());
        }
    }
    public void printResult(LuckyNumber luckyNumber, int money) {
        output.printResultGuideMessage();
        int[] prizeResult = getPrizeResult(luckyNumber);
        output.printPrizeResult(prizeResult);
        BigDecimal profitRate = calculateProfitRate(money, prizeResult);
        output.printProfitRate(profitRate);
    }

    public BigDecimal calculateProfitRate(int moneyInput, int[] prizeResult) {
        BigDecimal totalPrize = calculateTotalPrize(prizeResult);
        BigDecimal money = new BigDecimal(moneyInput / NumberType.IN_THOUSANDS.getNumberType());
        BigDecimal hundred = new BigDecimal(NumberType.HUNDRED.getNumberType());
        BigDecimal profitRate = totalPrize.divide(money, NumberType.THREE.getNumberType(), RoundingMode.HALF_UP)
                .multiply(hundred)
                .setScale(NumberType.ONE.getNumberType(), RoundingMode.DOWN);
        return profitRate;
    }

    public BigDecimal calculateTotalPrize(int[] prizeResult) {
        int totalPrize = 0;
        totalPrize += prizeResult[NumberType.FIRST_PRIZE.getNumberType()] * NumberType.FIRST_PRIZE_REWARD.getNumberType();
        totalPrize += prizeResult[NumberType.SECOND_PRIZE.getNumberType()] * NumberType.SECOND_PRIZE_REWARD.getNumberType();
        totalPrize += prizeResult[NumberType.THIRD_PRIZE.getNumberType()] * NumberType.THIRD_PRIZE_REWARD.getNumberType();
        totalPrize += prizeResult[NumberType.FOURTH_PRIZE.getNumberType()] * NumberType.FOURTH_PRIZE_REWARD.getNumberType();
        totalPrize += prizeResult[NumberType.FIFTH_PRIZE.getNumberType()] * NumberType.FIFTH_PRIZE_REWARD.getNumberType();
        return new BigDecimal(totalPrize);
    }

    public int[] getPrizeResult(LuckyNumber luckyNumber) {
        int[] prizeResult = new int[NumberType.NUMBER_OF_PRIZE_TYPE.getNumberType()];
        List<Lotto> lottos = lottoRepository.findAll();
        for (Lotto lotto : lottos) {
            countPrizeResultForEachLotto(lotto, luckyNumber, prizeResult);
        }
        return prizeResult;
    }

    public void countPrizeResultForEachLotto(Lotto lotto, LuckyNumber luckyNumber, int[] prizeResultCount) {
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        int winningCount = calculateWinningCount(lottoNumbers, luckyNumber);
        int bonusCount = calculateBonusCount(lottoNumbers, luckyNumber);

        if (winningCount == NumberType.THREE.getNumberType()) {
            prizeResultCount[NumberType.FIFTH_PRIZE.getNumberType()]++;
        }
        if (winningCount == NumberType.FOUR.getNumberType()) {
            prizeResultCount[NumberType.FOURTH_PRIZE.getNumberType()]++;
        }
        if (winningCount == NumberType.FIVE.getNumberType() && bonusCount == NumberType.ZERO.getNumberType()) {
            prizeResultCount[NumberType.THIRD_PRIZE.getNumberType()]++;
        }
        if (winningCount == NumberType.FIVE.getNumberType() && bonusCount == NumberType.ONE.getNumberType()) {
            prizeResultCount[NumberType.SECOND_PRIZE.getNumberType()]++;
        }
        if (winningCount == NumberType.SIX.getNumberType()) {
            prizeResultCount[NumberType.FIRST_PRIZE.getNumberType()]++;
        }
    }

    public int calculateBonusCount(List<Integer> lottoNumbers, LuckyNumber luckyNumber) {
        int bonusNumber = luckyNumber.getBonusNumber();
        if (lottoNumbers.contains(bonusNumber)) {
            return NumberType.ONE.getNumberType();
        }
        return NumberType.ZERO.getNumberType();
    }

    public int calculateWinningCount(List<Integer> lottoNumbers, LuckyNumber luckyNumber) {
        int count = 0;
        HashSet<Integer> winningNumbers = luckyNumber.getWinningNumbers();

        for (Iterator<Integer> iterator = lottoNumbers.iterator(); iterator.hasNext();) {
            if (winningNumbers.contains(iterator.next())) {
                count++;
                iterator.remove();
            }
        }
        return count;
    }
}
