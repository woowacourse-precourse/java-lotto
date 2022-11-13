package lotto.mainframe;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private static int userInputMoney;
    private static List<Integer> userInputNumber;
    private static int userInputBonusNumber;
    private static int lottoAmount;

    public static void setUserInputMoney(String userInput) {
        userInputMoney = Integer.parseInt(userInput);
    }

    public static void setUserInputNumber(String userInput) {
        List<String> list = Arrays.asList(userInput.split(","));
        userInputNumber = list.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static void setUserInputBonusNumber(String userInput) {
        userInputBonusNumber = Integer.parseInt(userInput);
    }

    public static void setLottoAmount() {
        lottoAmount = userInputMoney / 1000;
    }

    public static int getUserInputMoney() {
        return userInputMoney;
    }

    public static List<Integer> getUserInputNumber() {
        return userInputNumber;
    }

    public static int getUserInputBonusNumber() {
        return userInputBonusNumber;
    }

    public static int getLottoAmount() {
        return lottoAmount;
    }
}
