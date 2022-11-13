package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.ExceptionHandler;
import lotto.data.InputForm;

public class LottoForm {

    public int inputPrice() throws IllegalArgumentException {
        InputForm.INPUT_PRICE.printMessage();

        String priceInput = Console.readLine();
        ExceptionHandler.checkNumeric(priceInput);

        int price = Integer.parseInt(priceInput);
        ExceptionHandler.checkNotDivisibleByThousand(price);

        return price;
    }
}
