package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Lotto[] lottos = new Lotto[10];
        try {
            lottos = new Lotto[numberOfLotto()];
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
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
        System.out.println("3개 일치 (5,000원) - " + result[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + result[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result[1] + "개");
        System.out.println("총 수익률은 " + calculationYield(result,count
        ) + "입니다.");
    }

    private static String calculationYield(int[] result, int count) {
        long totalPrize = result[1]*2000000000 + result[2]*30000000 + result[3]*1500000 + result[4]*50000 + result[5]*5000;



        return String.format("%.1f",(float)totalPrize/(count*10)) + "%";
    }

    private static List<Integer> inputWinningNumbers() {
        List<Integer> winningNumber = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");
        for (String s : input) {
            if(Integer.parseInt(s) < 1 || Integer.parseInt(s) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            winningNumber.add(Integer.parseInt(s));
        }
        System.out.println("보너스 번호을 입력해 주세요.");
        winningNumber.add(Integer.parseInt(Console.readLine()));
        return winningNumber;
    }

    private static int numberOfLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputStringMoney = Console.readLine();
        int money;
        try {
            money = Integer.parseInt(inputStringMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }

        if(money < 0 || money%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
        System.out.println((money/1000) + "개를 구매했습니다.");
        return money/1000;
    }
    private static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private static List<Integer> makeRandomNumbers() {
        List<Integer> numberList = Randoms.pickUniqueNumbersInRange(1, 45,6);
        List<Integer> newList = new ArrayList<>();
        for(int number : numberList) newList.add(number);

        Collections.sort(newList);
        System.out.println(newList);

        return newList;
    }
}
