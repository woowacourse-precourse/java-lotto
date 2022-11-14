package lotto;
import camp.nextstep.edu.missionutils.Console;
public class Input {
    public static String getPurchaseMoney(){
        String purchasedMoney = Console.readLine();
        // validate 해야함.
        return purchasedMoney;
    }
    public static String getWinningNumber(){
        String WinningNumber = Console.readLine();
        // validate 해야 함
        return WinningNumber;
    }
    public static String getBonusNumber(){
        String BonusNumber = Console.readLine();
        // validate 해야 함
        return BonusNumber;
    }
}
