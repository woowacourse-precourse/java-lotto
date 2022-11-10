package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int count = Integer.parseInt(Console.readLine());


        System.out.println((count/1000)+"개를 구매했습니다.");
        LottoNumbers lottoNumbers = new LottoNumbers(count);

        List<List<Integer>> test = lottoNumbers.getNumbers();
        for (List<Integer> integers : test) {
            Collections.sort(integers);
            System.out.println("integers = " + integers);
        }


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
        for (List<Integer> integers : test) {
            Collections.sort(integers);
//            System.out.println("integers = " + integers);
        }
        manager.inputWinNumbers(test, basket);
    }
}
