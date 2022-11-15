package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.BonusNumberInputValidation;
import lotto.validation.PredictionNumbersInputValidation;
import lotto.validation.PurchasePriceInputValidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InputView {
    OutputView outputView = new OutputView();
    private List<Integer> predictionNumbers = new ArrayList<>();

    public int userInputPurchasePrice() {
        outputView.printPurchasePriceMessage();
        String inputPurchasePrice = Console.readLine();

        PurchasePriceInputValidation purchasePriceInputValidation = new PurchasePriceInputValidation();
        purchasePriceInputValidation.validate(inputPurchasePrice);

        int purchasePrice = Integer.parseInt(inputPurchasePrice);
        return purchasePrice;
    }

    public List<Integer> userInputPredictionNumbers() {
        outputView.printPredictionNumbersMessage();
        String inputPredictionNumbers = Console.readLine();

        PredictionNumbersInputValidation predictionNumbersInputValidation = new PredictionNumbersInputValidation();
        predictionNumbersInputValidation.validateInputFormat(inputPredictionNumbers);

        predictionNumbers = splitStringByCommaAndParseInt(inputPredictionNumbers);
        predictionNumbersInputValidation.validate(predictionNumbers);
        return predictionNumbers;
    }

    public int userInputBonusNumber() {
        outputView.printBonusNumberMessage();
        String inputBonusNumber = Console.readLine();

        BonusNumberInputValidation bonusNumberInputValidation = new BonusNumberInputValidation();
        bonusNumberInputValidation.validate(predictionNumbers, inputBonusNumber);

        int bonusNumber = splitStringByCommaAndParseInt(inputBonusNumber).get(0);
        return bonusNumber;
    }

    public static List<Integer> splitStringByCommaAndParseInt(String s) {
        String blankRemoved = s.replaceAll(" ", "");
        String[] splitByComma = blankRemoved.split(",");

        Stream<String> stream = Arrays.stream(splitByComma);
        IntStream parsedToInt = stream.mapToInt(Integer::parseInt);
        return parsedToInt.boxed().collect(Collectors.toList());
    }

}
