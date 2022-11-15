package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        int user_buy_num = HowManyLotto();
        Lotto[] user_lotto = UserLotto(user_buy_num);
        PrintUserLotto(user_lotto);
        List<Integer> answer = MakeAnswer();
        int bonus_num = MakeBonus(answer);
        Map<String, Integer> user_match_count = UserMatchingCount(user_lotto, answer, bonus_num);
        PrintResult(user_match_count);
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

    static Lotto[] UserLotto(int user_buy_num) {
        Lotto[] user_lotto = new Lotto[user_buy_num];

        for (int i=0; i < user_buy_num; i++) {
            Lotto lotto = new Lotto(MakeNumbers());
            user_lotto[i] = lotto;
        }

        return user_lotto;
    }

    static void PrintUserLotto(Lotto[] user_lotto) {
        for (int i=0; i < user_lotto.length; i++) {
            System.out.println(user_lotto[i].GetNumbers());
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

    static int MakeBonus(List<Integer> answer) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int bonus_num = Integer.parseInt(input);

        if (answer.contains(bonus_num)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 외의 번호를 입력해 주세요.");
        } return bonus_num;
    }

    static Map<String, Integer> UserMatchingCount(Lotto[] user_lotto, List<Integer> answer, int bonus_num) {
        Map<String, Integer> user_match_count = new HashMap<>();
        List<String> winning_count = List.of("0개", "1개", "2개", "3개", "4개", "5개", "5개+보너스", "6개");

        for (String count : winning_count) user_match_count.put(count, 0);

        for (Lotto lotto : user_lotto) {
            String match_count = MatchingCount(lotto.GetNumbers(), answer, bonus_num);
            user_match_count.put(match_count, user_match_count.get(match_count) + 1);
        }

        return user_match_count;
    }

    static String MatchingCount(List<Integer> lotto, List<Integer> answer, int bonus_num) {
        int count = 0;

        for (int num : lotto) {
            if (answer.contains(num)) count++;
        }

        String output = count + "개";

        if (count == 5) {
            if (lotto.contains(bonus_num)) output += "+보너스";
        }
        return output;
    }

    static void PrintResult(Map<String, Integer> user_match_count) {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + user_match_count.get("3개") + "개");
        System.out.println("4개 일치 (50,000원) - " + user_match_count.get("4개") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + user_match_count.get("5개") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + user_match_count.get("5개+보너스") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + user_match_count.get("6개") + "개");
    }
}
