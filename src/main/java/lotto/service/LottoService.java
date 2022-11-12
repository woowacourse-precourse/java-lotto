package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LuckyNumber;
import lotto.message.ErrorMessage;
import lotto.repository.LottoRepository;
import lotto.validation.Validator;
import lotto.view.input.Input;
import lotto.view.output.Output;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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
        int buyCount = money/1000;
        output.printLottoCountForBuy(buyCount);
        pickAndSaveLotto(buyCount);
        List<Lotto> lottos = lottoRepository.findAll();
        output.printAllLottos(lottos);

    }

    public void pickAndSaveLotto(int buyCount) {
        while (buyCount-- > 0) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
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
}
