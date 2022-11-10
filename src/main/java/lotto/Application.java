package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> test1 = List.of(1,2,3,4,5,6);
        List<Integer> test2 = new ArrayList<>();


        int count = Integer.parseInt(Console.readLine());
        System.out.println((count/1000)+"개를 구매했습니다.");
        LottoNumbers lottoNumbers = new LottoNumbers(count);

        System.out.println("당첨 번호를 입력해주세요.");
        String num = Console.readLine();
//        Lotto lotto = new Lotto(num);
        System.out.println("보너스 번호를 입력해주세요.");
        String num2 = Console.readLine();

        List<List<Integer>> test = lottoNumbers.getNumbers();
        for (List<Integer> integers : test) {
            Collections.sort(integers);
            System.out.println("integers = " + integers);
        }
    }
}
