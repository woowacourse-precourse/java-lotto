package view;

import java.util.List;

public class PrintBuyLottoList {


    public void printLottoList(int count, List<List<Integer>> printList){
        System.out.println(count + "개를 구매했습니다.");
        for (List<Integer> integers : printList) {
            System.out.println(integers);
        }
    }


}
