package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String payment = Console.readLine();
        Integer amountOfLotto = Lotto.amountOfLotto(payment);
        System.out.println(amountOfLotto+"개를 구매했습니다.");
        ArrayList<List<Integer>> myLottoNumbers = Lotto.getRandomLottoNumber(amountOfLotto);
        System.out.println("당첨  번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        List<Integer> getWinningNumber = Lotto.getTypingWinningNumber(winningNumber);
        System.out.println("보너스 번호를 입력해 주세요");
        String bonus = Console.readLine();
        Integer bonusNumber = Integer.parseInt(bonus);
        Integer[] getWinningNum = Lotto.getWinningCount(myLottoNumbers, getWinningNumber, bonusNumber);
        Lotto.winningStatistics(getWinningNum);
        String revenueRate = Lotto.getRevenueRate(Integer.parseInt(payment), getWinningNum);
        System.out.println("총 수익률은 "+revenueRate+"%입니다.");
    }
}
