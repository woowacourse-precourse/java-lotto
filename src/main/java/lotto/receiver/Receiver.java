package lotto.receiver;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.printer.Printer;
import lotto.validate.ValidateNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Receiver {

    public static int receiveHowMuch() {
        Printer.requestPurchase();
        String inputMoney = Console.readLine();
        int numberOfTicket = ValidateNumber.validatePurchaseMoney(inputMoney) / 1000;
        Printer.printNumberOfTickets(numberOfTicket);
        return numberOfTicket;
    }

    public static List<Integer> receiveWinNumber() {
        Printer.requestWinningNumber();
        String numberTemp = Console.readLine();
        String[] winningNumberTemp = numberTemp.split(",");
        List<Integer> winningNumber = new ArrayList<>();

        for(String number : winningNumberTemp) {
            winningNumber.add(Integer.parseInt(number));
        }
        return winningNumber;
    }
}