package lotto.domain;

import lotto.Util.InputPrint;
import lotto.Util.OutputPrint;
import lotto.valid.Validation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private int purchaseNumber;

    public void inputMoney(){
        String startInput = InputPrint.startInput();
        int money = Integer.parseInt(startInput);
        Validation.purchaseNumberValid(money);
        purchaseNumber = money / 1000;
    }

    public int getPurchaseNumber() {
        return purchaseNumber;
    }
}
