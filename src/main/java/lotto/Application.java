package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

// git check
public class Application {

    public static int Lotto_cnt(String my_money){
        return Integer.parseInt(my_money)/1000;
    }
    public static List<Integer> rnd_Lotto_number_maker(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String money,ans,bonus;
        int L_cnt;
        System.out.println("구입금액을 입력해 주세요.");
        L_cnt = Lotto_cnt(Console.readLine());
        System.out.printf("%d개를 구입했습니다.",L_cnt);




    }
}
