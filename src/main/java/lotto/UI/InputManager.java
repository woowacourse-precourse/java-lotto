package lotto.UI;

import lotto.UI.message.ErrorCode;
import lotto.UI.message.UIMessage;
import lotto.config.LottoConfig;

import java.util.List;
import java.util.stream.Collectors;

public class InputManager {
    public static int scanMoney() throws IllegalArgumentException {
        try {
            int price;

            UIPrinter.printMessage(UIMessage.ASK_PRICE.getMessage());
            price = UIScanner.scanInt();
            UIPrinter.printEmptyLine();

            if(price <= 0)
                throw new Exception();
            if(price % LottoConfig.LOTTO_PRICE != 0)
                throw new Exception();

            return price;
        } catch(Exception e) {
            throw new IllegalArgumentException(ErrorCode.WRONG_PURCHASE_PRICE.getValue());
        }
    }

    public static List<Integer> scanAnswer() throws IllegalArgumentException {
        try {
            System.out.println(UIMessage.ASK_ANSWER.getMessage());

            return UIScanner.scanIntStream().collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorCode.WRONG_ANSWER.getValue());
        } finally {
            UIPrinter.printEmptyLine();
        }
    }

    public static int scanBonus() throws IllegalArgumentException {
        try {
            System.out.println(UIMessage.ASK_BONUS.getMessage());

            return UIScanner.scanInt();
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorCode.WRONG_ANSWER.getValue());
        } finally {
            UIPrinter.printEmptyLine();
        }
    }
}
