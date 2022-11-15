package lotto;// @ author ninaaano

import lotto.Input;
import lotto.domain.Lotto;
import lotto.view.ErrorMessage;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class InputConsole {

    private static Lotto userInputNumber;
    private static int userInputBonusNumber;

    private static int money;
    private static final int LOTTO_PRICE = 1000;

    // 이게 있어야할까?
    public InputConsole() {
    }

    public static int buyLotto(){
        InputView.BUYLOTTO_MESSAGE.getMessage();

        String userInput = Input.input();
        checkString(userInput);
        int money = Integer.parseInt(userInput);

        checkMoney(money);

        return money;
    }

    public static List<Integer> inputNumber() {
        InputView.INPUTNUMBER_MESSAGE.getMessage();
        String userInputNumber = Input.input();
        List<Integer> userInputLottoNumbers = new ArrayList<>();
        for (String number : userInputNumber.split(",")) {
            userInputLottoNumbers.add(Integer.valueOf(number));
        }
        checkString(userInputNumber);
        return userInputLottoNumbers;
    }

    public static int inputBonusNumber(){
        InputView.INPUTBONUSNUMBER_MESSAGE.getMessage();
        String userInputBonusNumber = Input.input();
        validateBonusNumber();
        return Integer.parseInt(userInputBonusNumber);
    }

    private static void validateBonusNumber() {
        if (userInputNumber.getNumbers().contains(userInputBonusNumber)) {
            throw ErrorMessage.DUPLICATE.getError();
        }
        if (userInputBonusNumber < 1 || userInputBonusNumber > 45) {
            throw ErrorMessage.OUTOFRANGE.getError();
        }
    }

    private static boolean checkString(String userInput){
        try {
                Integer.parseInt(userInput);
            } catch (IllegalArgumentException e){
            throw ErrorMessage.STRINGEXCEPTION.getError();
        }
        return true;
    }

    private static void checkMoney(int money){
        if(money < 1000) {
            throw ErrorMessage.AMOUNTBOUNDS.getError();
        }
        if(!(money % LOTTO_PRICE == 0)){
            throw ErrorMessage.AMOUNTBOUNDS.getError();
        }
    }


}
