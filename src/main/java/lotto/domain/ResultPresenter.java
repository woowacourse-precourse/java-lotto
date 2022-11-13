package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Const;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultPresenter {
    public List<Integer> winnerNumbers;
    public int bonusNumber;

    public int firstWinningCount = 0;
    public int secondWinningCount = 0;
    public int thirdWinningCount = 0;
    public int fourthWinningCount = 0;
    public int fifthWinningCount = 0;

    public void run(){
        inputWinnerNum();
        inputBonusNum();
    }

    public void inputWinnerNum(){
        System.out.println(Const.ENTER_LOTTO_NUM);
        String winnerNum = Console.readLine();
        winnerNumbers = winnerNumToList(winnerNum);
        System.out.println();
        // validate method 넣기
    }

    public void inputBonusNum(){
        System.out.println(Const.ENTER_BONNUS_NUM);
        bonusNumber = Integer.valueOf(Console.readLine());
        System.out.println();
        // validate method 넣기
    }

    public void checkWinner(Buyer buyer){
        for(Lotto buyerLottos : buyer.getHaveLotto()){
            int collectCount = 0;
            int bonusCount = 0;

            List<Integer> buyerLottoNum = buyerLottos.returnLottoNumbers();
            buyerLottoNum.retainAll(winnerNumbers);

            if(buyerLottoNum.contains(bonusNumber)) bonusCount++;
            collectCount = buyerLottoNum.size();

            plusWinnerCount(collectCount, bonusCount);
        }
    }

    public void plusWinnerCount(int collectCount, int bonusCount){
        // 3,4,5,5+1,6 else 안쓰고 해결하기
        if(collectCount==6) firstWinningCount++;
        else if(collectCount==5 && bonusCount==1) secondWinningCount++;
        else if(collectCount==5) thirdWinningCount++;
        else if(collectCount==4) fourthWinningCount++;
        else if(collectCount==3) fifthWinningCount++;
    }

    public void printStatistics(){
        System.out.println(Const.PRINT_STATISTICS);
        System.out.println("---");
        System.out.printf("3개 일치 (%d원) - %d개%n",Const.FIFTH_WINNINGS,fifthWinningCount);
        System.out.printf("4개 일치 (%d원) - %d개%n",Const.FOURTH_WINNINGS,fourthWinningCount);
        System.out.printf("5개 일치 (%d원) - %d개%n",Const.THIRD_WINNINGS,thirdWinningCount);
        System.out.printf("5개 일치, 보너스 볼 일치 (%d원) - %d개%n",Const.SECOND_WINNINGS,secondWinningCount);
        System.out.printf("6개 일치 (%d원) - %d개%n",Const.FIRST_WINNINGS,firstWinningCount);

    }

    public List<Integer> winnerNumToList(String winnerNum){
        return Arrays.asList(winnerNum.split(",")).stream().map(Integer::valueOf).collect(Collectors.toList());
    }
}
