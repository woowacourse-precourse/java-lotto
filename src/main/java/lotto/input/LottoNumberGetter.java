package lotto.input;


import lotto.data.Lotto;
import lotto.data.LottoNumber;
import lotto.input.validation.code.BonusNumberValidationCode;
import lotto.input.validation.BonusNumberValidator;
import lotto.input.validation.code.WinningNumberValidationCode;
import lotto.input.validation.WinningNumberValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoNumberGetter {
    private static final String PROMPT_FOR_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_FOR_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private final WinningNumberValidator winningNumberValidator;
    private final BonusNumberValidator bonusNumberValidator;

    public LottoNumberGetter() {
        this.winningNumberValidator = new WinningNumberValidator();
        this.bonusNumberValidator = new BonusNumberValidator();
    }

    public LottoNumber getLottoNumber() {
        printPromptForWinningNumbers();
        List<String> tokensForWinningNumbers = tokenizeWinningNumberInput(getWinningNumbersFromConsole());
        throwExceptionIfNotValidWinningNumbers(tokensForWinningNumbers);
        List<Integer> winningNumbers = convertTokensToWinningNumbers(tokensForWinningNumbers);

        System.out.println();

        printPromptForBonusNumber();
        String tokenForBonusNumber = getBonusNumberFromConsole();
        throwExceptionIfNotValidBonusNumber(tokenForBonusNumber, winningNumbers);
        int bonusNumber = Integer.parseInt(tokenForBonusNumber);

        return new LottoNumber(new Lotto(winningNumbers), bonusNumber);
    }

    public void printPromptForWinningNumbers() {
        System.out.println(PROMPT_FOR_WINNING_NUMBERS);
    }

    public String getWinningNumbersFromConsole() {
        return readLine();
    }

    public void printPromptForBonusNumber() {
        System.out.println(PROMPT_FOR_BONUS_NUMBER);
    }

    public String getBonusNumberFromConsole() {
        return readLine();
    }

    public List<String> tokenizeWinningNumberInput(String userInput) {
        StringTokenizer tokenizer = new StringTokenizer(userInput, ", ");
        List<String> tokens = new ArrayList<>();

        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }

        return tokens;
    }

    public void throwExceptionIfNotValidWinningNumbers(List<String> tokens) {
        WinningNumberValidationCode result = this.winningNumberValidator.validateWinningNumber(tokens);
        if (result != WinningNumberValidationCode.VALID) {
            throw new IllegalArgumentException(result.getErrorMessage());
        }
    }

    public void throwExceptionIfNotValidBonusNumber(String token, List<Integer> winningNumbers) {
        BonusNumberValidationCode result = this.bonusNumberValidator.validateBonusNumber(token, winningNumbers);
        if (result != BonusNumberValidationCode.VALID) {
            throw new IllegalArgumentException(result.getErrorMessage());
        }
    }

    private List<Integer> convertTokensToWinningNumbers(List<String> tokens) {
        return tokens.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
