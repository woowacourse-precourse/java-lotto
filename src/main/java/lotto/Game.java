package lotto;

import java.util.ArrayList;
import java.util.List;

public class Game {

    static UI ui = new UI();
    static Validation validation = new Validation();
    static int purchase;
    static Lotto winningNumber;
    static int bonusNumber;

    static void setPurchase(String input) throws IllegalArgumentException {
        validation.checkNull(input);
        validation.checkNumeric(input);
        purchase = Integer.parseInt(input);
        validation.checkDividable(purchase);
    }

    static void setWinningNumber(String input) throws IllegalArgumentException {
        validation.checkNull(input);
        validation.checkWinningFormat(input);
        List<Integer> number = new ArrayList<>();
        for (String token : input.split(",")) {
            number.add(Integer.parseInt(token));
        }
        winningNumber = new Lotto(number);
    }

    static void setBonusNumber(String input) throws IllegalArgumentException {
        validation.checkNull(input);
        validation.checkNumeric(input);
        bonusNumber = Integer.parseInt(input);
        validation.checkNumberInRange(bonusNumber);
        validation.checkBonusDuplicate(winningNumber, bonusNumber);
    }

}
