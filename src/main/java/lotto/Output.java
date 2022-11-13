package lotto;

import java.util.List;

public class Output {

    public void printLotto(List<List<Integer>> allLotto ){
        int lottoCount=allLotto.size();
        System.out.println(lottoCount+"개를 구매했습니다.");
        for(List<Integer> lotto:allLotto){
            System.out.println(lotto);
        }
    }

    public void printWinningRate(List<Integer> winningCount){

    }

    public void printProfitRate(int earnedMoney, int payedMoney){

    }
}
