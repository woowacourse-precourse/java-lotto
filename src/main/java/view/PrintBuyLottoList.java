package view;

import java.util.List;

public class PrintBuyLottoList {


    public void printLottoList(int count, List<List<Integer>> printList){
        System.out.println(count + "개 구매하셨습니다.");
        for (List<Integer> integers : printList) {
            System.out.println(integers);
        }
    }


}
