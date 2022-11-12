package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class Application {
    public static List<Integer> lotto_answer = new ArrayList<>();
    public static int lotto_bonus = 0;
    public static int purchase_price = 0;
    public static int sum_of_prize = 0;
    public static int lotto_amount = 0;
    public static List<List<Integer>> lotto_list = new ArrayList<>();
    public static int first = 0, second = 0, third = 0, fourth = 0, fifth = 0;


    public static void main(String[] args) {
        lotto_list.clear();
        lotto_answer.clear();

        getPurchaseAmount(lotto_list);

        // TODO: 프로그램 구현
    }

    public static void getPurchaseAmount(List<List<Integer>> lotto_list) {
        System.out.println("구입금액을 입력해 주세요.");
        String temp = Console.readLine();
        try{
            Integer.parseInt(temp);
        }
        catch(NumberFormatException e){
            System.out.print("[ERROR]");
            throw new IllegalArgumentException("[ERROR]");
        }
        purchase_price = Integer.parseInt(temp);
        lotto_amount = purchase_price / 1000;
        System.out.println(lotto_amount + "개를 구매했습니다.");

        getLottoNumber(lotto_list, lotto_amount);
    }


    public static void getLottoNumber(List<List<Integer>> lotto_list, Integer lotto_amount) {
        List<Integer> numbers;
        while (lotto_list.size() < lotto_amount) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            //Collections.sort(numbers);
            lotto_list.add(numbers);
        }
        for (List<Integer> each_lotto : lotto_list) {
            System.out.println(each_lotto);
        }
        getLottoAnswer();

    }

    public static void getLottoAnswer() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String read_answer = Console.readLine();
        List<String> temp = List.of(read_answer.split(","));
        for (String a : temp) {
            lotto_answer.add(Integer.parseInt(a));
        }
        Lotto answer = new Lotto(lotto_answer);
        lotto_bonus = answer.getLottoAnswerBonus();
        compareLotto(lotto_list, lotto_answer, lotto_bonus);
    }


    public static void compareLotto(List<List<Integer>> lotto_list, List<Integer> lotto_answer, Integer bonus_number) {
        for (List<Integer> temp_user_lotto : lotto_list) {
            List<Integer> temp_lotto_answer = new ArrayList<>(lotto_answer);
            temp_lotto_answer.removeAll(temp_user_lotto);
            int a = temp_lotto_answer.size();
            if(temp_lotto_answer.size() > 1 && !temp_user_lotto.contains(bonus_number))
                a++;
            String for_prize = "prize_" + a;
            Prize prize = Prize.valueOf(for_prize);
            sum_of_prize += prize.getWinLotteryPrize();
            prize.addWinLotteryCount();
        }
        lottoResult();
    }

    public static void lottoResult() {

        double end = Math.round((double) sum_of_prize / (double) purchase_price * 1000.0) / 1000.0;
//        System.out.println(sum_of_prize);
//        System.out.println(purchase_price);
        BigDecimal bd = new BigDecimal(end * 100);

        System.out.println("당첨통계");
        System.out.println("-------------------");
        System.out.println("3개 일치 (5,000원) - " + Prize.prize_4.getWinLotteryCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + Prize.prize_3.getWinLotteryCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + Prize.prize_2.getWinLotteryCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Prize.prize_1.getWinLotteryCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Prize.prize_0.getWinLotteryCount() + "개");
        System.out.println("총 수익률은 " + bd.setScale(1, RoundingMode.CEILING) + "%입니다.");
    }
}
