package lotto.domain;

import lotto.Util.InputPrint;
import lotto.Util.OutputPrint;
import lotto.valid.Validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private List<Integer> prizeNumbers;
    private int purchaseNumber;

    private int bonusNumber;

    public void inputMoney(){
        String startInput = InputPrint.startInput();
        purchaseNumber = Integer.parseInt(startInput);
        Validation.purchaseNumberValid(purchaseNumber);
    }

    public void inputPrizeNumbers(){
        prizeNumbers = Arrays.stream(InputPrint.prizeNumberInput().split(","))
                .map(num -> Integer.parseInt(num))
                .collect(Collectors.toList());
        Validation.prizeNumbersValid(prizeNumbers);
    }

    public void inputBonusNumber(){
        String bonus = InputPrint.bonusNumberInput();
        Validation.bonusNumberValid(bonus);
        this.bonusNumber = Integer.parseInt(bonus);
    }

    public int getPurchaseNumber() {
        return purchaseNumber;
    }

    public List<Integer> getPrizeNumbers() {
        return prizeNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
