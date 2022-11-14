package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int count = Buy.buyLotto(askMoney());

        List<Lotto> purchases = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            purchases.add(Buy.issueLotto());
        }

        Lotto winLotto = askWinLotto();
        int winBonus = askWinBonus();

    }

    public static int askMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Buy.isRightNumber(Console.readLine());
    }

    public static Lotto askWinLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String[] winNum = Console.readLine().split(",");
        String validate = String.join("",winNum);
        Buy.isRightNumber(validate);

        List<Integer> winNumber = new ArrayList<>();
        for(int i=0; i<winNum.length; i++) {
            winNumber.add(Integer.parseInt(winNum[i]));
        }

        Lotto winLotto = new Lotto(winNumber);

        return winLotto;
    }

    public static int askWinBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Buy.isRightNumber(Console.readLine());
        if(bonus<1|| bonus>45) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자의 범위가 적절하지 않습니다.");
        }
        System.out.println("winBonus:"+bonus);
        return bonus;
    }
}
