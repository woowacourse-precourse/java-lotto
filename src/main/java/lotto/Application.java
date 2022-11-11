package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        /*LottoPurchase purchase = new LottoPurchase();
        purchase.getPayAmount();*/

        /*NumberGenerator ng = new NumberGenerator(1);

        Lotto lotto = new Lotto(ng.generateNumbers());
        System.out.println(lotto.getLotto());*/

        String s = Console.readLine();
        String[] st = s.split(",");
        System.out.println(s);
        System.out.println(Arrays.toString(st));


    }
}
