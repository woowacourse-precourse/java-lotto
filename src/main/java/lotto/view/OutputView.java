package lotto.view;

import java.util.List;

import static lotto.Game.count;
import static lotto.Game.lottos;

public class OutputView {
    private static void changeLine(){
        System.out.println();
    }
    public static void countView(){
        System.out.printf("%d개를 구매했습니다.",count);
        changeLine();
    }
    public static void lottoView(){
        lottos.stream().forEach(lotto -> {
            System.out.println(lotto);
        });
        changeLine();
    }
}
