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
            System.out.println(lotto.sort());
        }
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

        if (user_bonus_number < 0 || user_bonus_number  > 45) {
            throw new IllegalArgumentException();
        }
    }

    static void print_user_bonus_number_error() {
        System.out.print(COMMON_ERROR_MESSAGE + " 보너스 번호는 1개이고, 로또 번호와 중복되지 않는 1부터 45 사이의 숫자여야 합니다.");
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
    }
}
