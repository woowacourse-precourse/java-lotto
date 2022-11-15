package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BuyLotto buyLotto = new BuyLotto(InputBuyNum());
        Lotto lotto = new Lotto(InputWinningNum());
        BonusLotto bonusLotto = new BonusLotto(InputBonusNum(),lotto);
        MatchLotto matchLotto = new MatchLotto(buyLotto.getLotto_all(),lotto.getNumbers(),bonusLotto.getBonusNum());
        MatchLotto.calculateOutput(buyLotto.getBuyNum());
    }

    //구매금액 입력
    public static String InputBuyNum() {
        System.out.println("구매금액을 입력해 주세요");
        String buyNum = readLine();
        return buyNum;
    }

    //당첨번호 입력
    public static List<Integer> InputWinningNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer>WinningNum = new ArrayList<>();
        String[] inputNum = readLine().split(",");
        for (int i = 0; i < inputNum.length; i++) {
             WinningNum.add(Integer.parseInt(inputNum[i]));
        }
        return WinningNum;
    }
    //보너스 번호 입력
    public static int InputBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
         return Integer.parseInt(readLine());
    }

}
