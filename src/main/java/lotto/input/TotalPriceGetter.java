package lotto.input;

import lotto.input.validation.TotalPriceValidator;
import lotto.input.validation.code.TotalPriceValidationCode;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class TotalPriceGetter {
    private static final String PROMPT_TOTAL_PRICE = "구입금액을 입력해 주세요.";

    private final TotalPriceValidator totalPriceValidator;

    public TotalPriceGetter() {
        this.totalPriceValidator = new TotalPriceValidator();
    }

    public int getTotalPriceFromUser() {
        promptUserForTotalPrice();
        String userInput = getTotalPriceFromConsole();
        throwExceptionIfUserInputTotalPriceNotValid(userInput);

        return Integer.parseInt(userInput);
    }

    public void promptUserForTotalPrice() {
        System.out.println(PROMPT_TOTAL_PRICE);
    }

    public String getTotalPriceFromConsole() {
        return readLine();
    }

    public void throwExceptionIfUserInputTotalPriceNotValid(String userInput) {
        TotalPriceValidationCode result = this.totalPriceValidator.getUserTotalPriceInputValidationCode(userInput);
        if (result != TotalPriceValidationCode.VALID_NUMBER) {
            throw new IllegalArgumentException(result.getErrorMessage());
        }
    }
}
