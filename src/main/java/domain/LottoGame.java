package domain;

import java.util.ArrayList;
import java.util.List;
import view.InputBonusNumber;
import view.InputWinningLottoNumber;

public class LottoGame {

    List<List<Integer>> buyLottoList = new ArrayList<>();
    List<Integer> winningLottoList = new ArrayList<>();
    List<Integer> matchCountList = new ArrayList<>();
    List<Integer> rankedList = new ArrayList<>();
    int bonusNumber;


    public void Game() {

        setting();
        for (int index = 0; index < buyLottoList.size(); index++) {
            List<Integer> nowLottoList = buyLottoList.get(index);
            matchCountList.add(matchCount(winningLottoList, nowLottoList, bonusNumber));
        }


    }
    public void setting() {
        this.buyLottoList = BuyLottoList.getBuyLottoList();
        this.winningLottoList = InputWinningLottoNumber.getWinningLottoList();
        this.bonusNumber = InputBonusNumber.getBonusNumber();
    }

    public static Integer matchCount(List<Integer> winningLottoList,
        List<Integer> nowBuyLottoList, int bonusNumber) {
        long count = winningLottoList.stream().filter(n -> nowBuyLottoList.contains(n)).count();
        if(count==5){
            if(isInBonusNumber(nowBuyLottoList, bonusNumber)){
                return 7;
            }
        }
        System.out.println("count = " + count);
        return Math.toIntExact(count);
    }




    public static boolean isInBonusNumber(List<Integer> nowBuyLottoList, int bonusNumber){
        return nowBuyLottoList.contains(bonusNumber);
    }




}
