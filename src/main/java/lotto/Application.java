package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static int pay = 0;
    static int tickets = 0;
    static List<List<Integer>> allLottoNumbers = new ArrayList<>();
    static List<String> winningNumber = new ArrayList<>();
    static int bonus = 0;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        buyLotto();
        tickets = ticketCal(pay);
        getLottoNumber(tickets);
        inputWinningNumber();
        inputBonus();

    }
    public static void buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        pay = Integer.parseInt(Console.readLine());
    }

    public static int ticketCal(int pay){
        int ticketNumber = 0;
        ticketNumber = pay/1000;
        System.out.println(ticketNumber+"개를 구매했습니다.");
        return pay/1000;
    }

    public static void getLottoNumber(int tickets){
        for(int i=0;i<tickets;i++){
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            allLottoNumbers.add(lottoNumbers);
        }
    }

    public static void inputWinningNumber(){
        String inputNumber;
        String[] processNumber;
        System.out.println("당첨 번호를 입력해 주세요.");

        inputNumber = Console.readLine();
        processNumber = inputNumber.split(",");

        for(int i=0;i<processNumber.length;i++){
            winningNumber.add(processNumber[i]);
        }
    }

    public static void inputBonus(){
        System.out.println("보너스 번호를 입력해 주세요.");
        bonus = Integer.parseInt(Console.readLine());
    }
}
