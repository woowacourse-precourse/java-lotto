package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
//        System.out.println(Manager.Hi.valueOf("THREE").getHi());
//        Manager.Hi[] hi = Manager.Hi.values();
//        for (Manager.Hi hi1 : hi) {
//            System.out.println(hi1.name());
//        }
        String result = Console.readLine();
        LottoNumbers lottoNumbers = new LottoNumbers(result);
        int count = Integer.parseInt(result);
        System.out.println((count/1000)+"개를 구매했습니다.");
//        test t = new test(count);
//        List<Integer> zz = t.getNumbers();
//        Collections.sort(zz);
//        System.out.println(zz);

        List<List<Integer>> test = lottoNumbers.getNumbers();
        for (List<Integer> integers : test) {
            System.out.println(integers);
        }


//
//
        System.out.println("당첨 번호를 입력해주세요.");
        String[] str = new String[6];
        str = Console.readLine().split(",");
        List<Integer> basket = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            basket.add(Integer.parseInt(str[i]));
        }
        Lotto lotto = new Lotto(basket);
        System.out.println("보너스 번호를 입력해주세요.");
        int num2 = Integer.parseInt(Console.readLine());


        Manager manager = new Manager();
        manager.inputWinNumbers(test, basket);
    } ///
//    private enum Hi {
//        ONE("1개일치"),
//        THREE("3개일치"),
//        FOUR("4개일치"),
//        FIVE("5개일치");
//
//        private String hi;
//
//
//        Hi(String hi) {
//            this.hi = hi;
//        }
//
//        public String getHi() {
//            return hi;
//        }
//    }
}
