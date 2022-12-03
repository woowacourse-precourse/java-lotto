package lotto.view;

import java.util.List;

public class OutputView {
    public static void printMyLotto(List<List<Integer>> myLotto) {
        System.out.println("/n"+myLotto.size()+"개를 구매했습니다.");
        for (List<Integer> lotto : myLotto) {
            System.out.println(lotto);
        }
    }
}