package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.BaseLotto;

import java.util.List;

public class Game {

    private User user = new User();
    private Winning winning = new Winning();


    public void gameStart(){
        System.out.println(BaseLotto.INPUTVALUE.getDescription());
        String input = Console.readLine();
        user.purchaseLotto(input);
        System.out.println(user.getCntLotto() + BaseLotto.PURCHASE.getDescription());
        for(Lotto lotto: user.getLottos()){
            System.out.println(lotto.toStringLotto());
        }
        System.out.println(BaseLotto.INPUTWINNING.getDescription());
        String inputWinning = Console.readLine();
        winning.setWinnings(inputWinning);
        System.out.println(BaseLotto.INPUTBONUS.getDescription());
        String inputBonus = Console.readLine();
        winning.setBonus(inputBonus);

        System.out.println("당첨 통계");
        System.out.println("---");
        List<Integer> totalLotto = winning.getTotalWinning(user.getLottos());
        System.out.println(BaseLotto.THREESUCCESS.getDescription() + " - " + totalLotto.get(0)+"개");
        System.out.println(BaseLotto.FOURSUCCESS.getDescription() + " - " + totalLotto.get(1)+"개");
        System.out.println(BaseLotto.FIVESUCCESS.getDescription() + " - " + totalLotto.get(2)+"개");
        System.out.println(BaseLotto.FIVEANDBONUSSUCCESS.getDescription() + " - " + totalLotto.get(3)+"개");
        System.out.println(BaseLotto.SIXSUCCESS.getDescription() + " - " + totalLotto.get(4)+"개");
        System.out.println(BaseLotto.TOTALRETURN.getDescription() + " " + winning.getToTalRate(Integer.parseInt(input))*100+"%입니다.");
    }
}
