package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static List<Integer> lotto_answer = new ArrayList<>();
    public static int lotto_bonus = 0;
    public static int purchase_price = 0;
    public static int lotto_amount = 0;
    public static List<List<Integer>> lotto_list = new ArrayList<>();

    public static void main(String[] args) {
        lotto_list.clear();
        lotto_answer.clear();

        getPurchaseAmount(lotto_list);

        // TODO: 프로그램 구현
    }

    public static void getPurchaseAmount(List<List<Integer>> lotto_list) {
        System.out.println("구입금액을 입력해 주세요.");
        purchase_price = Integer.parseInt(Console.readLine());
        lotto_amount = purchase_price / 1000;
        getLottoNumber(lotto_list, lotto_amount);
    }


    public static void getLottoNumber(List<List<Integer>> lotto_list, Integer lotto_amount) {
        List<Integer> numbers;
        while (lotto_list.size() < lotto_amount) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lotto_list.add(numbers);
        }
        getLottoAnswer();

    }

    public static void getLottoAnswer() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String read_answer = Console.readLine();

        String[] split_answer = read_answer.split(",");
        if (!checkValidLottoLength(split_answer)) {
            System.out.println("로또답오류");
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자를 입력해주시기 바랍니다.");
        }
        for (String s : split_answer) {
            int int_each_answer = Integer.parseInt(s);
            if (!checkValidLottoRange(int_each_answer)) {
                System.out.println("로또답오류");
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
            }
            if (lotto_answer.contains(int_each_answer)) {
                System.out.println("로또답오류");
                throw new IllegalArgumentException("[ERROR] 잘못된 값이 입력되었습니다.");
            }

            lotto_answer.add(int_each_answer);
        }
        getLottoAnswerBonus();
    }

    private static Boolean checkValidLottoLength(String[] split_answer) {
        return split_answer.length == 6;
    }

    private static Boolean checkValidLottoRange(int number) {
        return number >= 1 && number <= 45;
    }

    public static void getLottoAnswerBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        lotto_bonus = Integer.parseInt(Console.readLine());
        if (!checkValidLottoRange(lotto_bonus)) {
            System.out.println("로또보너스오류");
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
        }
        compareLotto(lotto_list, lotto_answer, lotto_bonus);
    }

    public static void compareLotto(List<List<Integer>> lotto_list, List<Integer> lotto_answer, Integer bonus_number) {
        System.out.println(lotto_list);
        System.out.println(lotto_answer);
        System.out.println(bonus_number);
    }

}
