package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) {

        List<List<Integer>> lotto_list = new ArrayList<>();
        getPurchaseAmount(lotto_list);

        // TODO: 프로그램 구현
    }

    public static void getPurchaseAmount(List<List<Integer>> lotto_list){
        int purchase_price = 0;
        int lotto_amount = 0;
        System.out.println("구입금액을 입력해 주세요.");
        purchase_price = Integer.parseInt(Console.readLine());
        lotto_amount = purchase_price/1000;
        getLottoNumber(lotto_list, lotto_amount);
    }


    public static void getLottoNumber(List<List<Integer>> lotto_list, Integer lotto_amount){
        List<Integer> numbers;
        while(lotto_list.size() < lotto_amount) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lotto_list.add(numbers);
        }
        List<Integer> lotto_answer = getLottoAnswer();
        int bonus_number = getLottoAnswerBonus();
        compareLotto(lotto_list, lotto_answer, bonus_number);
    }

     public static List<Integer> getLottoAnswer(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String read_answer = Console.readLine();

        String[] split_answer = read_answer.split(",");
        if(checkValidLottoLength(split_answer))
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자를 입력해주시기 바랍니다.");
        for(String s : split_answer){
            if(!checkValidLottoRange(Integer.parseInt(s)))
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
        }
        return answer;
     }

    private static Boolean checkValidLottoLength(String[] split_answer) {
        return split_answer.length == 6;
    }

    private static Boolean checkValidLottoRange(int number){
        return number >= 1 && number <= 45;
    }

    public static Integer getLottoAnswerBonus(){
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus_number = Integer.parseInt(Console.readLine());
        if(!checkValidLottoRange(bonus_number))
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
        return bonus_number;
    }

    public static void compareLotto(List<List<Integer>> lotto_list, List<Integer> lotto_answer, Integer bonus_number){
        System.out.println(lotto_list);
        System.out.println(lotto_answer);
        System.out.println(bonus_number);
    }

}
