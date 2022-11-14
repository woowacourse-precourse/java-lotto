package lotto;

import net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        try {
            User user = new User();

            Print.printInsertMoney();
            long money = Input.readLong();


            user.payMoney(money);
            user.buyLotto();

            Print.printLotto(user.getUserLottos());

            WinningNumbers winningNumbers = new WinningNumbers();

            Print.printWinningNumber();
            List<Integer> newWinningNumbers = Input.readListInteger(",");
            winningNumbers.newWinningNumbers(newWinningNumbers);

            Print.printBonusNumber();
            int newBonusNumber = Input.readInteger();
            winningNumbers.newBonusNumber(newBonusNumber);

            Judgment judgment = new Judgment(user, winningNumbers);

            RankCounter rankCounter = judgment.calculateRank();
            Print.printRankCounter(rankCounter);

            double yield = judgment.calculateYield();
            Print.printYield(yield);

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
