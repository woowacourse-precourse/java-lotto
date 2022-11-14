package view;

import camp.nextstep.edu.missionutils.Console;
import utils.IllegalInputChecker;
import messages.InfoMessages;

public class InputServiceImpl implements InputService{
    IllegalInputChecker illegalInputChecker = new IllegalInputChecker();
    static String userPayment;
    static int newUserPayment;
    static String userInput;
    static String userBonus;

    @Override
    public int getUserPayMessage() {
        System.out.println(InfoMessages.USER_PAY);
        userPayment = Console.readLine();
        illegalInputChecker.checkUserPayIllegal(userPayment);
        newUserPayment = Integer.parseInt(userPayment);
        return newUserPayment;
    }

    @Override
    public String getUserNumsMessage() {
        System.out.println(InfoMessages.USER_NUMS);
        userInput = Console.readLine();
        illegalInputChecker.checkUserInputIllegal(userInput);
        return userInput;
    }

    @Override
    public String getUserBonusNumMessage() {
        System.out.println(InfoMessages.USER_BONUS_NUM);
        userBonus = Console.readLine();
        illegalInputChecker.checkUserBonusIllegal(userBonus);
        return userBonus;
    }
}