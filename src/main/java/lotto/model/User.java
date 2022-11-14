package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidation;

import java.util.ArrayList;

public class User {
    private final InputValidation inputValidation = new InputValidation();

    public void inputPrice() {
        String price = Console.readLine();
        inputValidation.validatePrice(price);
        countLotto = calculateCountLotto(price);
    }

    private int calculateCountLotto(String line) {
        return Integer.parseInt(line) / 1000;
    }
    }
}
