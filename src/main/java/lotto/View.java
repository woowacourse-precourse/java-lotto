package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class View {
    public int askPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();
        return Integer.parseInt(price);
    }

    public void buyLottoList(int price, List<Lotto> lottoBundle) {
        System.out.println(price / 1000 + "개를 구매했습니다.");
        for (Lotto lotto : lottoBundle) {
            lotto.getNumbers().sort(Comparator.naturalOrder());
            System.out.println(lotto.getNumbers().toString());
        }
        System.out.println();
    }

    public List<Integer> askWinningNumber() {
        List<Integer> winningLotto = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String number = Console.readLine();
        System.out.println();
        number = number.replaceAll(" ", "");
        String[] winningNumbers = number.split(",");

        for (String winningNumber : winningNumbers) {
            winningLotto.add(Integer.parseInt(winningNumber));
        }
        return winningLotto;
    }

    public int askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        System.out.println();
        return Integer.parseInt(bonusNumber);
    }

    public void showWinCase(WinningCount winningCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + winningCount.getCount().get("3") + "개");
        System.out.println("4개 일치 (50,000원) - " + winningCount.getCount().get("4") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningCount.getCount().get("5") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningCount.getCount().get("bonus") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningCount.getCount().get("6") + "개");
    }
}
