package view;

import camp.nextstep.edu.missionutils.Console;
import utils.IllegalInputFormChecker;
import message.InputMessage;

public class InputServiceImpl implements InputService{
    IllegalInputFormChecker illegalInputFormChecker = new IllegalInputFormChecker();
    static String userPayment;
    static int newUserPayment;
    static String userInput;
    static String userBonus;

    @Override
    public int getUserPayMessage() {
        System.out.println(InputMessage.USER_PAY);
        userPayment = Console.readLine();
        illegalInputFormChecker.checkUserPayIllegal(userPayment);
        newUserPayment = Integer.parseInt(userPayment);
        return newUserPayment;
    }

    @Override
    public String getUserNumsMessage() {
        System.out.println(InputMessage.USER_NUMS);
        userInput = Console.readLine();
        illegalInputFormChecker.checkUserInputIllegal(userInput);
        return userInput;
    }

    @Override
    public String getUserBonusNumMessage() {
        System.out.println(InputMessage.USER_BONUS_NUM);
        userBonus = Console.readLine();
        illegalInputFormChecker.checkUserBonusIllegal(userBonus);
        return userBonus;
    }
}
