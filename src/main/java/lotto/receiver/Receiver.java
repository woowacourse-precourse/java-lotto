package lotto.receiver;

import camp.nextstep.edu.missionutils.Console;
import lotto.printer.Printer;
import lotto.validate.ValidateNumber;

import java.util.Scanner;

public class Receiver {

    public static int receiveHowMuch() {
        Printer.requestPurchase();
        String inputMoney = Console.readLine();
        int numberOfTicket = ValidateNumber.validatePurchaseMoney(inputMoney) / 1000;
        Printer.printNumberOfTickets(numberOfTicket);
        return numberOfTicket;
    }


}