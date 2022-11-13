package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.*;

public class Application {
    private static final String COMMON_ERROR_MESSAGE = "[ERROR]";

    static void ask_how_much_money() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    static String how_much_money() {
        String user_money;
        user_money = readLine();

        return user_money;
    }

    static void check_user_money(String user_money) {
        int test_user_money;

        try {
            test_user_money = Integer.parseInt(user_money);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        if ((test_user_money <= 0) || ((test_user_money % 1000) != 0)) {
            throw new IllegalArgumentException();
        }

        System.out.println();
    }

    static void print_money_error() {
        System.out.print(COMMON_ERROR_MESSAGE + " 구매 금액은 1000원으로 나누어 떨어져야 합니다.");
    }

    static int how_many(String user_money) {
        return Integer.parseInt(user_money) / 1000;
    }

    static List<Lotto> make_lotto(int how_many_lotto) {
        List<Lotto> lottos = new ArrayList<Lotto>();

        for (int i = 0; i < how_many_lotto; i++) {
            Lotto lotto = new Lotto(pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }

        return lottos;
    }

    static void print_lotto_info(List<Lotto> lottos) {
        System.out.print(lottos.size());
        System.out.println("개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto.get_numbers());
        }

        System.out.println();
    }

    static void ask_lotto_number() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    static String what_user_number() {
        String user_numbers;
        user_numbers = readLine();

        return user_numbers;
    }

    static List<Integer> split_user_number(String user_numbers) {
        List<Integer> user_number = new ArrayList<>();

        String[] split_numbers = user_numbers.split(",");
        for (String split_number : split_numbers) {
            try {
                user_number.add(Integer.parseInt(split_number));
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }

        return user_number;
    }

    static void print_integer_error() {
        System.out.print(COMMON_ERROR_MESSAGE + " 로또 번호는 6개이고, 1부터 45 사이의 숫자여야 합니다.");
    }

    static void print_user_lotto_error() {
        System.out.print(COMMON_ERROR_MESSAGE + " 로또 번호는 6개이고, 1부터 45 사이의 숫자여야 합니다.");
    }

    static void ask_bonus_number() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    static int what_user_bonus_number() {
        int user_bonus_number;

        String read_user_bonus_number = readLine();

        try {
            user_bonus_number = Integer.parseInt(read_user_bonus_number);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        return user_bonus_number;
    }

    static void print_not_one_number_error() {
        System.out.print(COMMON_ERROR_MESSAGE + " 보너스 번호는 1개이고, 로또 번호와 중복되지 않는 1부터 45 사이의 숫자여야 합니다.");
    }

    static void check_user_bonus_number(Lotto user_lotto, int user_bonus_number) {
        if (user_lotto.get_numbers().contains(user_bonus_number)) {
            throw new IllegalArgumentException();
        }

        if (user_bonus_number < 0 || user_bonus_number > 45) {
            throw new IllegalArgumentException();
        }

        System.out.println();
    }

    static void print_user_bonus_number_error() {
        System.out.print(COMMON_ERROR_MESSAGE + " 보너스 번호는 1개이고, 로또 번호와 중복되지 않는 1부터 45 사이의 숫자여야 합니다.");
    }

    static void alert_print_score() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    static int check_number_equal(Lotto lotto, Lotto user_lotto) {
        int number_equal = 0;

        for (int user_number : user_lotto.get_numbers()) {
            if (lotto.get_numbers().contains(user_number)) {
                number_equal += 1;
            }
        }

        return number_equal;
    }

    static int check_bonus_number_equal(Lotto lotto, int user_bonus_number) {
        if (lotto.get_numbers().contains(user_bonus_number)) {
            return 1;
        }

        return 0;
    }

    static List<List<Integer>> check_computer_user_score(List<Lotto> lottos, Lotto user_lotto, int user_bonus_number) {
        List<List<Integer>> scores = new ArrayList<List<Integer>>();

        for (Lotto lotto : lottos) {
            List<Integer> score = new ArrayList<>();

            int number_equal = check_number_equal(lotto, user_lotto);
            score.add(number_equal);

            int bonus_number_equal = check_bonus_number_equal(lotto, user_bonus_number);
            score.add(bonus_number_equal);

            scores.add(score);
        }

        return scores;
    }

    static int print_score_three(List<List<Integer>> scores) {
        int three = 0;

        for (List<Integer> score : scores) {
            if (score.get(0) == 3) {
                three += 1;
            }
        }

        System.out.println("3개 일치 (5,000원) - " + Integer.toString(three) + "개");

        return three;
    }

    static int print_score_four(List<List<Integer>> scores) {
        int four = 0;

        for (List<Integer> score : scores) {
            if (score.get(0) == 4) {
                four += 1;
            }
        }

        System.out.println("4개 일치 (50,000원) - " + Integer.toString(four) + "개");

        return four;
    }

    static int print_score_five(List<List<Integer>> scores) {
        int five = 0;

        for (List<Integer> score : scores) {
            if (score.get(0) == 5 && score.get(1) == 0) {
                five += 1;
            }
        }

        System.out.println("5개 일치 (1,500,000원) - " + Integer.toString(five) + "개");

        return five;
    }

    static int print_score_five_bonus(List<List<Integer>> scores) {
        int five_bonus = 0;

        for (List<Integer> score : scores) {
            if (score.get(0) == 5 && score.get(1) == 1) {
                five_bonus += 1;
            }
        }

        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Integer.toString(five_bonus) + "개");

        return five_bonus;
    }

    static int print_score_six(List<List<Integer>> scores) {
        int six = 0;

        for (List<Integer> score : scores) {
            if (score.get(0) == 6) {
                six += 1;
            }
        }

        System.out.println("6개 일치 (2,000,000,000원) - " + Integer.toString(six) + "개");

        return six;
    }

    static int calculate_winning_amount(List<Integer> save_score) {
        int winning_amout = 0;

        winning_amout += save_score.get(0) * Result.THREE.get_value();
        winning_amout += save_score.get(1) * Result.FOUR.get_value();
        winning_amout += save_score.get(2) * Result.FIVE.get_value();
        winning_amout += save_score.get(3) * Result.FIVE_BONUS.get_value();
        winning_amout += save_score.get(4) * Result.SIX.get_value();

        return winning_amout;
    }

    public static void main(String[] args) {
        ask_how_much_money();

        String user_money;
        user_money = how_much_money();

        try {
            check_user_money(user_money);
        } catch (IllegalArgumentException e) {
            print_money_error();
            return;
        }

        int how_many_lotto;
        how_many_lotto = how_many(user_money);

        List<Lotto> lottos;
        lottos = make_lotto(how_many_lotto);

        print_lotto_info(lottos);

        ask_lotto_number();

        String user_numbers;
        user_numbers = what_user_number();

        List<Integer> user_number;
        try {
            user_number = split_user_number(user_numbers);
        } catch (IllegalArgumentException e) {
            print_integer_error();
            return;
        }

        Lotto user_lotto;
        try {
            user_lotto = new Lotto(user_number);
        } catch (IllegalArgumentException e) {
            print_user_lotto_error();
            return;
        }

        ask_bonus_number();

        int user_bonus_number;
        try {
            user_bonus_number = what_user_bonus_number();
        } catch (IllegalArgumentException e) {
            print_not_one_number_error();
            return;
        }

        try {
            check_user_bonus_number(user_lotto, user_bonus_number);
        } catch (IllegalArgumentException e) {
            print_user_bonus_number_error();
            return;
        }

        alert_print_score();

        List<List<Integer>> scores = new ArrayList<List<Integer>>();
        scores = check_computer_user_score(lottos, user_lotto, user_bonus_number);

        List<Integer> save_score = new ArrayList<>();
        save_score.add(print_score_three(scores));
        save_score.add(print_score_four(scores));
        save_score.add(print_score_five(scores));
        save_score.add(print_score_five_bonus(scores));
        save_score.add(print_score_six(scores));

        int winning_amount;
        winning_amount = calculate_winning_amount(save_score);
    }
}
