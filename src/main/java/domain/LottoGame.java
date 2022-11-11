package domain;

import java.util.ArrayList;
import java.util.List;
import view.InputWinningLottoNumber;

public class LottoGame {

    List<List<Integer>> buyLottoList = new ArrayList<>();
    List<Integer> winningLottoList = new ArrayList<>();
    int bonusNumber;


    public void LottoGame() {
        this.buyLottoList =BuyLottoList.getBuyLottoList();
        this.winningLottoList = InputWinningLottoNumber.getWinningLottoList();
        this.bonusNumber = bonusNumber;
    }



    public void Game(){

        for(int i=0; i<buyLottoList.size(); i++){

            List<Integer> nowLottoList = buyLottoList.get(i);
            nowLottoList.add(matchCount(winningLottoList, nowLottoList));

        }

    }


    public static Integer matchCount(List<Integer> winningLottoList, List<Integer> nowBuyLottoList){
        long count = winningLottoList.stream().filter(n -> nowBuyLottoList.contains(n)).count();
        return Math.toIntExact(count);
    }


}
