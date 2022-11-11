package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import view.PrintBuyLottoList;

public class BuyLottoList {

    PrintBuyLottoList printBuyLottoList = new PrintBuyLottoList();
    static List<List<Integer>> buyLottoList = new ArrayList<>();

    public void putLottoNumberList(int money){
        int pick_count= money/1000;
        for(int number=0; number<pick_count; number++){
            setLottoNumberList(buyLottoList, number);
          }

        printBuyLottoList.printLottoList(pick_count, buyLottoList);
    }

    private void setLottoNumberList(List<List<Integer>> pickList, int number) {
        List<Integer> integers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(integers);
        pickList.add(integers);
    }

    public static List<List<Integer>> getBuyLottoList() {
        return buyLottoList;
    }
}
