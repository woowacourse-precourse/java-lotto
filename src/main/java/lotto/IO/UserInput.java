package lotto.IO;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.StartLotto;

import java.util.ArrayList;

import static lotto.domain.exceptions.Exception.*;
import static lotto.IO.Output.requestBonusInput;
import static lotto.IO.Output.requestWinNum;

public class UserInput {
    public static void paymentInput() throws IllegalArgumentException {
        String inputPayment = Console.readLine();
        paymentInputCheck(inputPayment);
        StartLotto.payment = Integer.parseInt(inputPayment);
    }

    public static void winNumInput() throws IllegalArgumentException {
        requestWinNum();
        StartLotto.winNums = new ArrayList<>();
        String inputWinNums = Console.readLine();
        winNumInputErrorCheck(inputWinNums);
        String[] tmpWinNums = inputWinNums.split(",");
        for (String e : tmpWinNums) {
            int num = Integer.parseInt(e);
            StartLotto.winNums.add(num);
        }
    }

    public static void bonusNumInput() throws IllegalArgumentException {
        requestBonusInput();
        String inputBonusNum = Console.readLine();
        bonusErrorCheck(inputBonusNum);
        StartLotto.bonusNum = Integer.parseInt(inputBonusNum);
    }


}
