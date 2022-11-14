package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int user_buy_num = HowManyLotto();
        List<Integer>[] user_lotto = UserLotto(user_buy_num);
        PrintUserLotto(user_lotto);
    }

    static int HowManyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int input_money = Integer.parseInt(input);
        int user_buy_num = input_money / 1000;

        if (input_money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력해 주세요.");
        }

        System.out.println("\n" + user_buy_num + "개를 구매했습니다.");
        return user_buy_num;
    }

    static List<Integer> MakeNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    static List<Integer>[] UserLotto(int user_buy_num) {
        List<Integer>[] user_lotto = new List[user_buy_num];

        for (int i=0; i < user_buy_num; i++) {
            Lotto lotto = new Lotto(MakeNumbers());
            user_lotto[i] = lotto.GetNumbers();
        }

        return user_lotto;
    }

    static void PrintUserLotto(List<Integer>[] user_lotto) {
        for (int i=0; i < user_lotto.length; i++) {
            System.out.println(user_lotto[i]);
        }
    }

    static List<Integer> MakeAnswer() {
        List<Integer> answer = new ArrayList<>();

        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        return answer;
    }
}
