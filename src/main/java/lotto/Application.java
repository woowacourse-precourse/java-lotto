package lotto;

import camp.nextstep.edu.missionutils.Console;
import domain.Buyer;
import domain.WinningNumber;
import domain.Winnings;

import java.text.DecimalFormat;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.valueOf(Console.readLine());
        Buyer buyer = new Buyer(purchaseAmount);

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumberInput = Console.readLine();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.valueOf(Console.readLine());
        WinningNumber winningNumber = new WinningNumber(winningNumberInput, bonusNumber);

        Map<Winnings, Integer> winningStatistics = buyer.putWinningStatistics(winningNumber);
        List<Winnings> winnings = getKeyList(winningStatistics);
        Collections.sort(winnings, Collections.reverseOrder());
        System.out.println("당첨 통계\n---");
        for (Winnings winning : winnings) {
            if (winning.getPrice() == 0) {
                continue;
            }
            System.out.println(winning.getExpression() + " (" +
                    new DecimalFormat("###,###").format(winning.getPrice()) + "원) - " +
                    winningStatistics.get(winning) + "개");
        }
        String returnRate = buyer.calculateReturnRate();
        System.out.println("총 수익률은 " + returnRate + "%입니다.");
    }

    private static List<Winnings> getKeyList(Map<Winnings, Integer> winningStatistics) {
        List<Winnings> winnings = new ArrayList<>();
        Set<Winnings> set = winningStatistics.keySet();
        for (Winnings winning : set) {
            winnings.add(winning);
        }
        return winnings;
    }
}
