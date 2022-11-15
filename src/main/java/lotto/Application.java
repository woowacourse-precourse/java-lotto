package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        UserLotto userLotto;
        Lotto lotto;
        Print print = new Print();
        int bonusNumber;

        System.out.println("구입금액을 입력해 주세요");
        try {
            userLotto = new UserLotto(readLine());
            System.out.println(userLotto.money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        userLotto.generateTickets();
        print.printNumbers(userLotto.lottoTickets);

        try {
            lotto = new Lotto(userLotto.getLottoNumbers(readLine()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        try {
           bonusNumber = Bonus.getInputToInt(readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Bonus bonus = new Bonus(bonusNumber);
        int result[] = lotto.castLotto(userLotto.lottoTickets, bonus);

        print.printWinningStatistics(result);
        print.printProfit(result, userLotto.money);
    }
}
