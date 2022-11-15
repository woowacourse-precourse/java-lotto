package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        lotteryStart();
    }

    public static List<Lotto> buyLottery(int money) {
        List<Lotto> all_lottery = new ArrayList<>();
        int lottery_cnt = money / 1000;

        for (int i = 0; i < lottery_cnt; i++) {
            Lotto lottery = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            all_lottery.add(lottery);
        }
        return all_lottery;
    }

    public enum LOTTERY_MATCHES {
        NONE,
        SIX,
        FIVE_BONUS,
        FIVE,
        FOUR,
        THREE
    }

    public static void printHowManyMatches(List<Lotto> all_lottery, Lotto win_lottery, int bonus) {
        HashMap<Integer, Integer> lottery_ranks = lotteryRanks(all_lottery, win_lottery, bonus);
        lottery_ranks.forEach((key, value) -> {
            if (key == LOTTERY_MATCHES.THREE.ordinal())
                System.out.println("3개 일치 (5,000원) - " + value + "개");
            if (key == LOTTERY_MATCHES.FOUR.ordinal())
                System.out.println("4개 일치 (50,000원) - " + value + "개");
            if (key == LOTTERY_MATCHES.FIVE.ordinal())
                System.out.println("5개 일치 (1,500,000원) - " + value + "개");
            if (key == LOTTERY_MATCHES.FIVE_BONUS.ordinal())
                System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + value + "개");
            if (key == LOTTERY_MATCHES.SIX.ordinal())
                System.out.println("6개 일치 (2,000,000,000원) - " + value + "개");
        });
    }

    public static HashMap<Integer, Integer> lotteryRanks(List<Lotto> all_lottery, Lotto win_lottery, int bonus) {
        HashMap<Integer, Integer> lottery_ranks = initLotteryRanks();

        for (Lotto lotto : all_lottery
        ) {
            int rank = lotto.rank(win_lottery, bonus);
            if (rank > 0)
                lottery_ranks.put(rank, lottery_ranks.get(rank) + 1);
        }
        return lottery_ranks;
    }

    public static HashMap<Integer, Integer> initLotteryRanks() {
        return new HashMap<>() {{
            put(1, 0);
            put(2, 0);
            put(3, 0);
            put(4, 0);
            put(5, 0);
        }};
    }

    public static double rateOfReturn(int lottery_cnt, HashMap<Integer, Integer> lottery_ranks) {
        int reward = 0;
        reward += lottery_ranks.get(1) * 2000000000;
        reward += lottery_ranks.get(2) * 30000000;
        reward += lottery_ranks.get(3) * 1500000;
        reward += lottery_ranks.get(4) * 50000;
        reward += lottery_ranks.get(5) * 5000;

        if (reward == 0)
            return 0;
        double investment_money = lottery_cnt * 1000;

        return Math.round((reward * 100 / investment_money) * 10) / 10.0;
    }

    public static void printHowManyLottery(List<Lotto> all_lottery) {
        System.out.println(all_lottery.size() + "개를 구매했습니다.");
        for (Lotto lotto : all_lottery
        ) {
            lotto.printNumbers();
        }
    }

    public enum ERROR {
        MONEY,
        WIN_NUM,
        BONUS
    }

    public static long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }

    public static void checkException(String input, int error_num) {
        String money_pattern = "^\\d*$";
        String lottery_pattern = "^[1-9]$|^[1-3]\\d$|^4[0-5]$";

        if (error_num == ERROR.MONEY.ordinal() && (!input.matches(money_pattern))) {
            System.out.println("[ERROR] 구입금액 입력 오류");
            throw new IllegalArgumentException();
        }
        if (error_num == ERROR.MONEY.ordinal() && Integer.parseInt(input) % 1000 != 0){
            System.out.println("[ERROR] 구입금액 입력 오류");
            throw new IllegalArgumentException();
        }

        if (error_num == ERROR.WIN_NUM.ordinal()) {
            checkWinNum(input);
        }
        if (error_num == ERROR.BONUS.ordinal() && !input.matches(lottery_pattern)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호 입력 오류");
        }
    }

    public static void checkWinNum(String input){
        if (countChar(input, ',') != 5) {
            System.out.println("[ERROR] 당첨 번호 입력 오류");
            throw new IllegalArgumentException();
        }
        String[] numbers = input.split(",");
        if (rangeError(numbers)) {
            System.out.println("[ERROR] 당첨 번호 입력 오류");
            throw new IllegalArgumentException();
        }
    }
    public static Boolean rangeError(String[] numbers) {
        boolean is_range_error = false;
        List<Integer> nums = new ArrayList<>();
        for (String num : numbers) nums.add(Integer.valueOf(num));
        for (int num : nums
        ) {
            if (num < 1 || num > 45) {
                is_range_error = true;
            }
        }
        return is_range_error;
    }

    public static List<Lotto> buyLottery() {
        System.out.println("구입금액을 입력 주세요.");
        String input = readLine();
        checkException(input, ERROR.MONEY.ordinal());
        int money = Integer.parseInt(input);
        List<Lotto> all_lottery = buyLottery(money);
        printHowManyLottery(all_lottery);
        return all_lottery;
    }

    public static Lotto winLottery() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        checkException(input, ERROR.WIN_NUM.ordinal());
        String[] win_nums = input.split(",");
        List<Integer> nums = new ArrayList<>();
        for (String num : win_nums) nums.add(Integer.valueOf(num));
        return new Lotto(nums);
    }

    public static int bonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = readLine();
        checkException(input, ERROR.BONUS.ordinal());
        return Integer.parseInt(input);
    }

    public static void lotteryStart() {
        try {
            List<Lotto> all_lottery = buyLottery();
            Lotto win_lottery = winLottery();
            int bonus = bonus();

            System.out.println("당첨 통계\n" + "---");
            printHowManyMatches(all_lottery, win_lottery, bonus);
            System.out.println("총 수익률은 " + rateOfReturn(all_lottery.size(), lotteryRanks(all_lottery, win_lottery, bonus)) + "%입니다.");

        }
        catch (Exception ignored){
        }

    }
}
