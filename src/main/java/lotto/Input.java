package lotto;
import camp.nextstep.edu.missionutils.Console;
import static lotto.Validator.*;
public class Input {
    public static String getPurchaseMoney(){
        String purchasedMoney = Console.readLine();
        if (!isValidatePurchaseMoney(purchasedMoney))
            purchasedMoney = getPurchaseMoney();
        int purchaseMoney= Integer.parseInt(purchasedMoney);
        return purchasedMoney;
    }
    public static String getWinningNumber(){
        String WinningNumber = Console.readLine();
        if (!isValidateWinningMoney(WinningNumber))
            WinningNumber = getWinningNumber();
        return WinningNumber;
    }
    public static String getBonusNumber(){
        String BonusNumber = Console.readLine();
        if (!isValidateBonusMoney(BonusNumber))
            BonusNumber = getBonusNumber();
        return BonusNumber;
    }
}
