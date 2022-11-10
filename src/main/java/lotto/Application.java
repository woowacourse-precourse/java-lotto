package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
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
    }

     public static List<Integer> getLottoAnswer(){
        String read_answer = Console.readLine();
        return Arrays.stream(read_answer.split(",")).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
     }
}
