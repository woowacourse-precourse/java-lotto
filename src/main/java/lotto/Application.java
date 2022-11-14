package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            LotteryShop.dollar = get_dollar();
            LotteryShop.get_my_lottery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int get_dollar() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]잘못된 입력입니다!");
        }
    }
}
