package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getTicketCount(){
        System.out.println(Constant.INPUT_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static String[] getLottoNumbers(){
        System.out.println(Constant.INPUT_LOTTO_NUMBERS);
        return Console.readLine().split(Constant.SEPERATOR);
    }

    public static String getBonusNumbers(){
        System.out.println(Constant.INPUT_BONUS_NUMBER);
        return Console.readLine();
    }



}
