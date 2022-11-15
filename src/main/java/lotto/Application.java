package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static ErrorControl errorControl = new ErrorControl();
    static int sameCount = 0;
    static boolean hitBonusNumber = false;
    static int hitThree = 0;
    static int hitFour = 0;
    static int hitFive = 0;
    static int hitFiveBonus = 0;
    static int hitSix = 0;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int ticket = getTicket();
        System.out.println(ticket + "개를 구매했습니다.");
        Lotto[] lottos = new Lotto[ticket];
        lottos = getLotto(ticket, lottos);

        Lotto correctLotto = getCorrectNumber();
        int bonusNumber = getBonusNumber();

        result(correctLotto, bonusNumber, lottos);
        printResult(lottos);
    }
    static public int getTicket(){
        System.out.println("구입금액을 입력해 주세요");
        String input = Console.readLine();
        errorControl.ticketPurchaseStrError(input);
        int purchase = Integer.parseInt(input);
        errorControl.ticketPurchaseThousandError(purchase);
        int ticket = Integer.parseInt(input) / 1000;
        System.out.println();

        return ticket;
    }
    static public Lotto[] getLotto(int ticket, Lotto[] lottos){
        for (int i = 0; i < ticket; i++) {
            lottos[i] = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            errorControl.isLottoOver(lottos[i]);
            errorControl.isLottoOverlap(lottos[i]);
            System.out.println(lottos[i].getLotto().toString());
        }
        System.out.println();
        return lottos;
    }
    static public Lotto getCorrectNumber(){
        System.out.println("당첨번호를 입력해주세요");
        String input = Console.readLine();
        String[] sp = input.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < sp.length; i++) {
            if (!sp[i].equals(","))
                list.add(Integer.parseInt(sp[i]));
        }
        Lotto correctLotto = new Lotto(list);
        errorControl.isLottoOverlap(correctLotto);
        System.out.println();
        return correctLotto;
    }
    static public int getBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요");
        String input = Console.readLine();
        int bonusNumber = Integer.parseInt(input);
        System.out.println();
        return bonusNumber;
    }
    static public void result(Lotto correctLotto, int bonusNumber, Lotto[] lottos){
        System.out.println("당첨 통계\n--");
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < 6; j++) {
                if (correctLotto.getLotto().contains(lottos[i].getLotto().get(j))) sameCount++;
                if (lottos[i].getLotto().get(j) == bonusNumber) hitBonusNumber = true;
                if (i % 6 == 5) {
                    if (sameCount == 3) hitThree++;
                    if (sameCount == 4) hitFour++;
                    if (sameCount == 5 && hitBonusNumber) hitFiveBonus++;
                    else if (sameCount == 5) hitFive++;
                    if (sameCount == 6) hitSix++;
                    sameCount = 0;
                    hitBonusNumber = false;
                }
            }
        }
    }
    static public  void printResult(Lotto[] lottos){
        int getMoney = hitThree * 5000 + hitFour * 50000 + hitFive * 1500000 + hitFiveBonus * 30000000 + hitSix * 2000000000;
        double yield = (double)getMoney / (double)lottos.length /10;
        System.out.println("3개 일치 (5,000원) - " + hitThree + "개");
        System.out.println("4개 일치 (50,000원) - " + hitFour + "개");
        System.out.println("5개 일치 (1,500,000원) - " + hitFive + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + hitFiveBonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + hitSix + "개");
        System.out.printf("총 수익률은 " + "%.1f" + "%%입니다.", yield);
    }

}
