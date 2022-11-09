package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import view.PrintBuyLottoList;

public class BuyLottoList {

    PrintBuyLottoList printBuyLottoList = new PrintBuyLottoList();


    public void putLottoNumberList(int money){
        List<List<Integer>> pickList = new ArrayList<>();
        int pick_count= money/1000;
        for(int number=0; number<pick_count; number++){
            setLottoNumberList(pickList, number);
          }
        printBuyLottoList.printLottoList(pick_count, pickList);
    }

    private void setLottoNumberList(List<List<Integer>> pickList, int number) {
        pickList.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(pickList.get(number));
    }


}
