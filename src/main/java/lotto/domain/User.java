package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.Money;

public class User {

    private static int userInputMoney;
    private static List<Integer> userInputNumber;
    private static int userInputBonusNumber;
    private static int lottoAmount;
    private static List<List<Integer>> lotteries = new ArrayList<>();

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
        lottoAmount = userInputMoney / Money.MONEY_UNIT.getMoneyAsInteger();
    }

    public static void setLotteries(List<Integer> lotto) {
        lotteries.add(lotto);
    }

    public static int getUserInputMoney() {
        return userInputMoney;
    }

    public List<Integer> getUserInputNumber() {
        return userInputNumber;
    }

    public int getUserInputBonusNumber() {
        return userInputBonusNumber;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }

    public List<List<Integer>> getLotteries() {
        return lotteries;
    }
}
