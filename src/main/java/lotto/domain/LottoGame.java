package lotto.domain;

import camp.nextstep.edu.missionutils.*;
import lotto.Enum.ErrorCode;
import lotto.Enum.WinningType;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


    private Player player;
    private Lotto lotto;
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
        System.out.println(INPUT_PURCHASE_AMOUNT);
        String purchaseAmount = Console.readLine();
        if(isNumber(purchaseAmount)){
            money = Integer.parseInt(purchaseAmount);
            this.player = new Player(money);
        }
    }

    private List<Integer> inputWinningNumbers(){

        System.out.println(INPUT_WINNING_NUMBER);
        String[] sampleNumbers = Console.readLine().split(",");
        for (String sampleNumber : sampleNumbers) {
            isNumber(sampleNumber);
        }
        List<Integer> winningNumbers = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            winningNumbers.add(Integer.parseInt(sampleNumbers[i]));
        }
        lotto = new Lotto(winningNumbers);
        return winningNumbers;
    }

    private int inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        String inputBonusNumber = Console.readLine();
        isNumber(inputBonusNumber);
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        lotto.rangeCheck(bonusNumber);
        if(lotto.hasBonusNumber(bonusNumber)){
            throw new IllegalArgumentException(ErrorCode.DUPLICATION_NUMBER.getMessage());
        }
        return bonusNumber;
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


    public boolean isNumber(String number){

        if(!number.matches("\\d+")){
            throw new IllegalArgumentException(ErrorCode.NOT_ONE_NUMBER.getMessage());
        }
        return true;
    }

}
