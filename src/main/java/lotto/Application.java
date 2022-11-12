package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {


    public static void main(String[] args) {
        System.out.println("구입금액을 입력해주세요.");
        int money = Integer.parseInt(Console.readLine());
        User user = new User();
        List<List<Integer>> AutoLotto = user.Count(money);
        user.PrintNumber(AutoLotto);
        user.UserLotto();



    }
}
