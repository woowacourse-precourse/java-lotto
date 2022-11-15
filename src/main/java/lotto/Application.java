package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

// git check
public class Application {

    public static int Lotto_start(){
        System.out.println("구입금액을 입력해 주세요.");
        int L_cnt = Integer.parseInt(Console.readLine())/1000;
        System.out.printf("%d개를 구매했습니다.\n",L_cnt);
        return L_cnt;
    }
    public static List<Lotto> Lotto_maker(int cnt){
        List<Lotto> lottos = new ArrayList<>(cnt);
        for(int i=0;i<cnt;i++){
            Lotto lotto = new Lotto(rnd_Lotto_number_maker());
            lottos.add(lotto);
        }
        return lottos;
    }
    public static List<Integer> rnd_Lotto_number_maker(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
    public static void main(String[] args) {
        Statistics statistics = new Statistics();
        int temp=0,L_cnt = Lotto_start();
        List<Lotto> lottoList = Lotto_maker(L_cnt);
        System.out.println("당첨 번호를 입력해 주세요");
        String ans_num = Console.readLine();


    }
}
