package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        int pay = 0;
        int Lotto_cnt =0;

        System.out.println("구입금액을 입력해 주세요.");
        Lotto lotto_num = new Lotto(numbers); // 로또번호

        System.out.println("당첨 번호를 입력해 주세요.");
        lotto_num.
    }

/*    public static int Input(int pay){
        pay = Integer.parseInt(Console.readLine()); //구입금액
        System.out.println(pay);
        return pay;
    }
     public int NumberOfLotto(int pay, int Lotto_cnt){ // 로또 개수
        Lotto_cnt = pay / 1000;
        return Lotto_cnt;
    }*/

}
