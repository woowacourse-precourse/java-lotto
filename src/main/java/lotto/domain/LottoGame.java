package lotto.domain;

import camp.nextstep.edu.missionutils.*;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private Player player;
    private int money;

    public LottoGame(){

    }

    public void start(){

        inputPurchaseAmount();
        System.out.println();
        System.out.println(player.howManyLotto(money)+"개를 구매했습니다.");
        player.printLottos();
        List<Integer> winningNumbers = inputWinningNumbers();
        System.out.println();

        int bonusNumber = inputBonusNumber();
        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("---");
        double yield = winningStatistics(winningNumbers,bonusNumber);
        System.out.println("총 수익률은 "+ yield+"%입니다.");

    }

    private void inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String a = Console.readLine();
        if(a.matches("\\d+")){
            money = Integer.parseInt(a);
            this.player = new Player(money);
            return;
        }
        throw new IllegalArgumentException(ErrorCode.NOT_NUMBER.getMessage());
    }

    private List<Integer> inputWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] sampleIntputNumbers = Console.readLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            winningNumbers.add(Integer.parseInt(sampleIntputNumbers[i]));
        }
        return winningNumbers;
    }
    private int inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }

    private double winningStatistics(List<Integer> winningNumbers, int bonusNumber){
        int[] matchNumber = player.winningLottoMatching(winningNumbers,bonusNumber);
        int totalMoney = 0;
        for (int i = 3; i < 8; i++) {
            int[] index = {0,0,0,3,4,5,7,6};
            WinningType winningType = WinningType.findByNumber(index[i]);
            totalMoney += winningType.getWinningPrice()*matchNumber[index[i]];
            System.out.println(winningType.printWinningMessage(matchNumber[index[i]]));
        }
        return Math.round((totalMoney/(double)money)*10000)/100.0;
    }

}
