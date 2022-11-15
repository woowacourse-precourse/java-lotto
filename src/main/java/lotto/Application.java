package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input=new Input();

        System.out.println("구입금액을 입력해 주세요.");
        int money= input.setMoney();

        MakingLotto makingLotto=new MakingLotto();
        int count=makingLotto.getLottoCount(money);
        List<Lotto> allLotto=makingLotto.getAllLotto(count);

        Output output=new Output();
        output.printLotto(allLotto);

        System.out.println("당첨 번호를 입력해 주세요.");
        String lottoString= input.setWinningLotto();
        System.out.println(lottoString);
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus= input.setBonusNumber();
        System.out.println(bonus);

        Lotto winningLotto= makingLotto.getWinningLotto(lottoString);

        CalculatingLotto calculatingLotto=new CalculatingLotto();

        List<Integer>allRank= calculatingLotto.calculateAllLotto(winningLotto,bonus,allLotto);
        List<Integer>rankingCount=calculatingLotto.countRank(allRank);

        int earnedMoney=output.printWinningRate(rankingCount);

        output.printProfitRate(earnedMoney,money);
    }
}
