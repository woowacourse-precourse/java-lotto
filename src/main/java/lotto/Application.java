package lotto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        int lotto_cnt = getMoney();
        for(int i =0 ; i<lotto_cnt;i++){
            Lotto lotto = getLotto();

        }
    }
    public static Lotto getLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new lotto.Lotto(numbers);
        return lotto;
    }

    public static Lotto getWinNum(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<String> input_string_list = new ArrayList<String>(Arrays.asList(input.split(",")));
        List<Integer> input_integer_list = input_string_list.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        Lotto lotto = new lotto.Lotto(input_integer_list);
        return lotto;
    }

    public static int getBonusNum(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public static int getMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int input_money = Integer.parseInt(input);
        return input_money/1000;
    }
}
