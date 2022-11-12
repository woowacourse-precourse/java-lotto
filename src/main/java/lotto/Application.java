package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해주세요.");
        int money = Integer.parseInt(Console.readLine());
        User user = new User();
        List<List<Integer>> list = user.Count(money);
        System.out.println(list.size() + "개를 구입했습니다,");
        for(List<Integer> j : list){
            System.out.println(j);
        }
    }
}
