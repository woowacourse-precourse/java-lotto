package lotto.mainframe;

public class User {

    private static String userInputMoney;
    private static String userInputNumber;
    private static String userInputBonusNumber;
    private static int lottoAmount;

    public static void setUserInputMoney(String userInput) {
        userInputMoney = userInput;
    }

    public static void setUserInputNumber(String userInput) {
        userInputNumber = userInput;
    }

    public static void setUserInputBonusNumber(String userInput) {
        userInputBonusNumber = userInput;
    }

    public static void setLottoAmount() {
        lottoAmount = Integer.parseInt(userInputMoney) / 1000;
    }

    public static String getUserInputMoney() {
        return userInputMoney;
    }

    public static String getUserInputNumber() {
        return userInputNumber;
    }

    public static String getUserInputBonusNumber() {
        return userInputBonusNumber;
    }

    public static int getLottoAmount() {
        return lottoAmount;
    }
}
