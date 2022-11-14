package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        int user_buy_num = HowManyLotto();
        List<Integer>[] user_lotto = UserLotto(user_buy_num);
        PrintUserLotto(user_lotto);
        List<Integer> answer = MakeAnswer();
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
        String[] input_num = input.split(",");

        for (int i=0; i < input_num.length; i++) {
            answer.add(Integer.parseInt(input_num[i]));
        }

        if (!CheckAnswer(answer)) {
            throw  new IllegalArgumentException("[ERROR] 1부터 45사이의 쉼표로 구분된 서로 다른 6개의 숫자를 입력해 주세요.");
        }

        return answer;
    }

    static boolean CheckAnswer(List<Integer> answer) {
        Collections.sort(answer);
        Set<Integer> unique_answer = new HashSet<>(answer);

        if (answer.size() != 6 || unique_answer.size() != 6) return false;

        for (int i=0; i < answer.size(); i++) {
            if (answer.get(i) < 1 || answer.get(i) > 45) return false;
        }

        return true;
    }
}
