package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Lotto[] lottos = new Lotto[numberOfLotto()];
        
        for (int i = 0; i < lottos.length; i++) {
            lottos[i] = new Lotto(makeRandomNumbers());
        }

        List<Integer> winningNumber = inputWinningNumbers();

        int[] result = new int[6];
        for(int i=0; i<lottos.length; i++) {
            int rank = lottos[i].result(winningNumber);
            if(rank != 6) {
                result[rank]++;
            }
        }
        printResult(result, lottos.length);

    }

    private static void printResult(int[] result, int count) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + result[5] + "개");
        System.out.println("4개 일치 (50000원)- " + result[4] + "개");
        System.out.println("5개 일치 (1500000원)- " + result[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + result[2] + "개");
        System.out.println("6개 일치 (2000000000원)- " + result[1] + "개");
        System.out.println("총 수익률은 " + calculationYield(result,count
        ) + "입니다.");
    }

    private static String calculationYield(int[] result, int count) {
        int totalPrize = result[1]*2000000000 + result[2]*30000000 + result[3]*1500000 + result[4]*50000 + result[5]*5000;
        int yield = (int) ((double)totalPrize / (count*1000) * 100);

        return yield + "%";
    }

    private static List<Integer> inputWinningNumbers() {
        List<Integer> winningNumber = new ArrayList<>();
        String[] input = Console.readLine().split(",");
        for (String s : input) {
            winningNumber.add(Integer.parseInt(s));
        }
        return winningNumber;
    }

    private static int numberOfLotto() {
        String inputStringMoney = Console.readLine();
        int money = Integer.parseInt(inputStringMoney);
        if(money < 0 || money%1000 != 0) {
            throw new IllegalArgumentException();
        }
        return money/1000;
    }

    private static List<Integer> makeRandomNumbers() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return numberList;
    }
}
