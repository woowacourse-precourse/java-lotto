package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        inputPrint();
        String inputMoney = Console.readLine();
        int lottoCount = Lotto.calculate(inputMoney);
        countPrint(lottoCount);

        List<List<Integer>> allLotto = new ArrayList<>();

        for(int i = 0; i < lottoCount; i++){
            List <Integer> numbers = new ArrayList<>();
            Lotto lotto = new Lotto(numbers);
            allLotto.add(Lotto.allNumbers);
        }

        disableWarning();

        numbersPrint();
        String inputNumbers = Console.readLine();
        Winning.addWinning(inputNumbers);

        bonusPrint();
        String inputBonus = Console.readLine();
        Winning.addBonus(inputBonus);

        Compare compare = new Compare();

        Report report = new Report(Rank.None);

        int totalPrize = 0;

        for(int i = 0; i < allLotto.size(); i++){
            int matchNumber = compare.matchCount(allLotto.get(i),Winning.numbers);
            boolean matchBonus = compare.matchBonus(allLotto.get(i), Winning.numbers);

            Rank rank = Rank.valueOf(matchNumber, matchBonus);

            report = new Report(rank);
            report.winningCount(matchNumber, matchBonus);

            totalPrize += rank.getPrize();
        }
        double returnRate = returnRate(lottoCount * 1000, totalPrize);
        reportPrint(report.winningCount, returnRate);
    }

    public static void inputPrint(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void countPrint(int lottoCount){
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void numbersPrint(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void bonusPrint(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void reportPrint(Integer[] winningCount, double returnRate){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + winningCount[1] + "개");
        System.out.println("4개 일치 (50,000원) - " + winningCount[2] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningCount[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningCount[4] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningCount[5] + "개");
        System.out.println("총 수익률은 " + returnRate + "%입니다.");
    }

    public static double returnRate(int inputMoney, int totalPrize){
        double returnRate = totalPrize / (double) inputMoney * 100;
        return ((double)Math.round(returnRate * 100) / 100);
    }


    public static void disableWarning() {
        System.err.close();
        System.setErr(System.out);
    }

}