package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void makeLottoNumber(int lottoCount){
        int[][] lottoArray = new int[lottoCount][6];

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

            for(int j = 0; j < 6; j++){

                for(int k = 0; k < 6; k++) {
                    if (lottoArray[i][j] == userInputLottoNumber[k]) {
                        countTmp++;
                    }
                }
            }

            winningStatisticsMaker(lottoArray[i], userInputBonusNumber, correctCount, countTmp);
            winningStatisticPrinter(correctCount);
            yieldCalculation(correctCount, purchasedValue);
        }
    }

    public static void winningStatisticsMaker(int[] lottoArray, int userInputBonusNumber, int[] correctCount, int countTmp){
        if (countTmp == 3) {
            correctCount[0]++;
        }

        else if (countTmp == 4) {
            correctCount[1]++;
        }

        else if (countTmp == 5) {
            for (int i = 0; i < 6; i++){
                if (lottoArray[i] == userInputBonusNumber){
                    correctCount[2]--;
                    correctCount[3]++;
                }
            }
            correctCount[2]++;
        }

        else if (countTmp == 6) {
            correctCount[4]++;
        }
    }

    public static void winningStatisticPrinter(int[] correctCount){
        System.out.println("당첨 통계\n---");

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

        double yield = (double) grossIncome / (double) purchasedValue;

        System.out.print("총 수익률은 ");
        System.out.print(String.format("%.1f", yield));
        System.out.println("%입니다.");
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        int purchasedValue;
        String userInputLotto = "";
        String[] userInputLottoTmp;
        int[] userInputLottoNumber = new int[6];
        int userInputBonusNumber;

        System.out.println("구입금액을 입력해 주세요.");
        purchasedValue = scanner.nextInt();

        if (purchasedValue % 1000 != 0) {
            System.out.println("[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
            throw new IllegalArgumentException();
        }

        int lottoCount = purchasedValue / 1000;
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");


        int[][] lottoArray = new int[lottoCount][6];

        makeLottoNumber(lottoCount);

        System.out.println("당첨 번호를 입력해 주세요.");
        userInputLotto = scanner.nextLine();
        userInputLottoTmp = userInputLotto.split(",");
        for (int i = 0; i < userInputLottoTmp.length; i++) {
            userInputLottoNumber[i] = Integer.parseInt(userInputLottoTmp[i]);
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        userInputBonusNumber = scanner.nextInt();

        numberCompare(lottoCount, lottoArray, userInputLottoNumber, userInputBonusNumber, purchasedValue);
    }
}
