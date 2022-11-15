package lotto.receiver;

import camp.nextstep.edu.missionutils.Console;
import lotto.printer.Printer;
import lotto.validate.ValidateNumber;

import java.util.Scanner;

public class Receiver {

    public static int receiveHowMuch() {
        Printer.requestPurchase();
        String money = Console.readLine();
        return ValidateNumber.validatePurchaseMoney(money) / 1000;
    }

}