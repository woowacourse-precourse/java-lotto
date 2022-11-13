package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void makeLottoNumber(int[][] lottoArray ,int lottoCount){
        for (int i = 0; i < lottoCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            for (int j = 0; j < lottoArray[i].length; j++){
                lottoArray[i][j] = numbers.get(j);
            }

            Arrays.sort(lottoArray[i]);
            lottoNumberPrinter(lottoArray[i]);
        }
    }

    public static void lottoNumberPrinter(int[] lottoArray){
        System.out.print("[");
        for(int j = 0; j < lottoArray.length - 1; j++){
            System.out.print(lottoArray[j] + ", ");
        }
        System.out.println(lottoArray[5] + "]");
    }

    public static void numberCompare(int lottoCount, int[][] lottoArray, int[] userInputLottoNumber, int userInputBonusNumber, int purchasedValue){
        int[] correctCount = new int[5];

        for(int i = 0; i < lottoCount; i++){
            int countTmp = 0;

            countTmpCounter(lottoArray[i], userInputLottoNumber, countTmp);

            winningStatisticsMaker(lottoArray[i], userInputBonusNumber, correctCount, countTmp);
        }
        winningStatisticPrinter(correctCount);
        yieldCalculation(correctCount, purchasedValue);
    }

    public static void countTmpCounter(int[] lottoArray, int[] userInputLottoNumber, int countTmp){
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                if (lottoArray[i] == userInputLottoNumber[j]){
                    countTmp++;
                }
            }
        }
    }

    public static void winningStatisticsMaker(int[] lottoArray, int userInputBonusNumber, int[] correctCount, int countTmp){
        for (int i = 3; i <= 6; i++){
            if (countTmp == i){
                correctCount[i - 3]++;
            }
        }

        if (countTmp == 5){
            for (int i = 0; i < 6; i++){
                if (lottoArray[i] == userInputBonusNumber){
                    correctCount[2]--;
                    correctCount[3]++;
                }
            }
        }
    }

    public static void winningStatisticPrinter(int[] correctCount){
        System.out.println("\n당첨 통계\n---");

        System.out.println("3개 일치 (5,000원) - " +correctCount[0]+ "개");
        System.out.println("4개 일치 (50,000원) - " +correctCount[1]+ "개");
        System.out.println("5개 일치 (1,500,000원) - " +correctCount[2]+ "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " +correctCount[3]+ "개");
        System.out.println("6개 일치 (2,000,000,000원) - " +correctCount[4]+ "개");
    }

    public static void yieldCalculation(int[] correctCount, int purchasedValue){
        int[] profit = new int[]{5000,50000,1500000,30000000,2000000000};

        int grossIncome = 0;
        for (int i = 0; i < 5; i++){
            grossIncome += profit[i] * correctCount[i];
        }

        double yield = (double) grossIncome * 100 / (double) purchasedValue;

        System.out.print("총 수익률은 ");
        System.out.print(String.format("%.1f", yield));
        System.out.println("%입니다.");
    }

    public static int buyLotto(int purchasedValue){
        System.out.println("구입금액을 입력해 주세요.");
        purchasedValue = Integer.parseInt(Console.readLine());

        if (purchasedValue % 1000 != 0) {
            System.out.println("[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
            throw new IllegalArgumentException();
        }

        int lottoCount = purchasedValue / 1000;
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");

        return lottoCount;
    }

    public static void userInputLottoNumber(String userInputLotto, String[] userInputLottoTmp, int[] userInputLottoNumber, int userInputBonusNumber){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        userInputLotto = Console.readLine();
        userInputLottoTmp = userInputLotto.split(",");
        for (int i = 0; i < userInputLottoTmp.length; i++) {
            userInputLottoNumber[i] = Integer.parseInt(userInputLottoTmp[i]);
        }

        System.out.println("\n보너스 번호를 입력해 주세요.");
        userInputBonusNumber = Integer.parseInt(Console.readLine());
    }

    public static void startLotto() {
        int purchasedValue = 0;
        String userInputLotto = "";
        String[] userInputLottoTmp = new String[6];
        int[] userInputLottoNumber = new int[6];
        int userInputBonusNumber = 0;

        int lottoCount = buyLotto(purchasedValue);

        int[][] lottoArray = new int[lottoCount][6];

        makeLottoNumber(lottoArray ,lottoCount);
        userInputLottoNumber(userInputLotto, userInputLottoTmp, userInputLottoNumber, userInputBonusNumber);
        numberCompare(lottoCount, lottoArray, userInputLottoNumber, userInputBonusNumber, purchasedValue);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startLotto();
    }
}
