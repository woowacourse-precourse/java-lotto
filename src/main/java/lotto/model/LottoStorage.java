package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.controller.ExceptionHandler;

public class LottoStorage {

    private static List<List<Integer>> lottoTickets = new ArrayList<>();

    private static int numberOfTickets = 0;

    private static List<Integer> winNumbers = new ArrayList<>();
    private static int bonusNumber = 0;
    private static String inputMoney = "";

    public static void setLottoTickets(List<List<Integer>> tickets) {
        lottoTickets = tickets;
    }

    public static void setNumberOfTickets(int numberOfTicket) {
        numberOfTickets = numberOfTicket;
    }

    public static void setWinNumbers(List<Integer> winNumbersInput) {
        Lotto lotto = new Lotto(winNumbersInput);
        ExceptionHandler.validateWinNumber(winNumbersInput);
        winNumbers = winNumbersInput;
    }

    public static void setBonusNumber(int bonusNumberInput) {
        ExceptionHandler.validateBonusNumber(bonusNumberInput);
        bonusNumber = bonusNumberInput;
    }

    public static void setInputMoney(String money) {
        inputMoney = money;
    }

    public static List<List<Integer>> getLottoTickets() {
        return lottoTickets;
    }

    public static int getNumberOfTickets() {
        return numberOfTickets;
    }

    public static List<Integer> getWinNumbers() {
        return winNumbers;
    }

    public static int getBonusNumber() {
        return bonusNumber;
    }

    public static String getInputMoney() { return inputMoney; }
}
