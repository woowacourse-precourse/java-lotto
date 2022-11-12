package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static List<Integer> lotto_answer = new ArrayList<>();
    public static int lotto_bonus = 0;
    public static int purchase_price = 0, sum_of_prize = 0;
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
        System.out.println("로또답 = " +lotto_list);
        getLottoAnswer();

    }

    public static void getLottoAnswer() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String read_answer = Console.readLine();
        List<String> temp = List.of(read_answer.split(","));
        for(String a : temp){
            lotto_answer.add(Integer.parseInt(a));
        }
        Lotto answer = new Lotto(lotto_answer);
        lotto_bonus = answer.getLottoAnswerBonus();
        compareLotto(lotto_list,lotto_answer,lotto_bonus);
    }


    public static void compareLotto(List<List<Integer>> lotto_list, List<Integer> lotto_answer, Integer bonus_number) {
        for(List<Integer> temp_user_lotto : lotto_list){
            List<Integer> temp_lotto_answer = new ArrayList<>(lotto_answer);
            String asdf = comparePrize(temp_user_lotto,temp_lotto_answer,bonus_number);
            Prize prize = Prize.valueOf(asdf);
            sum_of_prize += prize.getWinLotteryPrize();
            prize.addWinLotteryCount();
        }
    }

    public static String comparePrize(List<Integer> user_lotto, List<Integer> temp_answer, Integer user_bonus){
        temp_answer.removeAll(user_lotto);
        if(temp_answer.size() == 0) {
            return "first";
        }
        if(temp_answer.size() == 1 && user_lotto.contains(user_bonus)) {
            return "second";
        }
        if(temp_answer.size() == 1) {
            return "third";
        }
        if(temp_answer.size() == 2) {
            return "fourth";
        }
        if(temp_answer.size() == 3) {
            return "fifth";
        }
        return "nocount";
    }

}

