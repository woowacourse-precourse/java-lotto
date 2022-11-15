package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Input input = new Input();
            MakingLotto makingLotto = new MakingLotto();

            System.out.println("구입금액을 입력해 주세요.");
            int money = input.setMoney();
            List<Lotto> allLotto = getLotto(money);

            String lottoString = getLottString(input);
            int bonus = getBonus(input);

            Lotto winningLotto = makingLotto.getWinningLotto(lottoString);
            showLotto(allLotto, bonus, winningLotto, money);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static List<Lotto> getLotto(int money){
        MakingLotto makingLotto=new MakingLotto();
        int count=makingLotto.getLottoCount(money);
        List<Lotto> allLotto=makingLotto.getAllLotto(count);

        Output output=new Output();
        output.printLotto(allLotto);

        return allLotto;
    }

    public static String getLottString(Input input){
        System.out.println("당첨 번호를 입력해 주세요.");
        String lottoString= input.setWinningLotto();
        System.out.println(lottoString);
        return lottoString;
    }

    public static int getBonus(Input input){
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus= input.setBonusNumber();
        System.out.println(bonus);
        return bonus;
    }

    public static void showLotto(List<Lotto> allLotto, int bonus, Lotto winningLotto, int money){
        Output output=new Output();
        CalculatingLotto calculatingLotto=new CalculatingLotto();

        List<Integer>allRank= calculatingLotto.calculateAllLotto(winningLotto,bonus,allLotto);
        List<Integer>rankingCount=calculatingLotto.countRank(allRank);

        int earnedMoney=output.printWinningRate(rankingCount);

        output.printProfitRate(earnedMoney,money);
    }
}
