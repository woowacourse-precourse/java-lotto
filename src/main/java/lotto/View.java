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
    }

    public List<Integer> askWinningNumber() {
        List<Integer> winningLotto = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        for (int count = 0; count < 6; count++) {
            String number = Console.readLine();
            winningLotto.add(Integer.parseInt(number));
        }
        return winningLotto;
    }

    public int askBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }
}
