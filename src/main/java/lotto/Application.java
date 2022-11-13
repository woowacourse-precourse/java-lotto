package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static int pay = 0;
    static int tickets = 0;
    static List<List<Integer>> allLottoNumbers = new ArrayList<>();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        buyLotto();
        tickets = ticketCal(pay);
        getLottoNumber(tickets);

    }
    public static void buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        pay = Integer.parseInt(Console.readLine());
    }

    public static int ticketCal(int pay){
        return pay/1000;
    }

    public static void getLottoNumber(int tickets){
        for(int i=0;i<tickets;i++){
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            allLottoNumbers.add(lottoNumbers);
        }
    }
}
