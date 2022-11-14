package ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.CheckInputIllegal;
import message.InputMessage;

public class InputServiceImpl implements InputService{
    CheckInputIllegal checkInputIllegal = new CheckInputIllegal();
    static String userPayment;
    static int newUserPayment;
    static String userInput;
    static String userBonus;

    @Override
    public int getUserPayMessage() {
        System.out.println(InputMessage.USER_PAY.getMessage());
        userPayment = Console.readLine();
        checkInputIllegal.checkUserPayIllegal(userPayment);
        newUserPayment = Integer.parseInt(userPayment);
        return newUserPayment;
    }

    @Override
    public String getUserNumsMessage() {
        System.out.println(InputMessage.USER_NUMS.getMessage());
        userInput = Console.readLine();
        checkInputIllegal.checkUserInputIllegal(userInput);
        return userInput;
    }

    @Override
    public String getUserBonusNumMessage() {
        System.out.println(InputMessage.USER_BONUS_NUM.getMessage());
        userBonus = Console.readLine();
        checkInputIllegal.checkUserBonusIllegal(userBonus);
        return userBonus;
    }
}
