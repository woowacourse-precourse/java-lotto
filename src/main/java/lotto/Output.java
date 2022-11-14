package lotto;

import java.util.Arrays;

public class Output {

    public void wrongNumberException() {
        System.out.println("[ERROR] 로또 구입 금액은 숫자로 이루어지고 1000원으로 나누어 떨어져야 합니다.");
    }

    public void lottoNumberPrinter(int[] lottoArray){
        System.out.print("[");
        for(int j = 0; j < lottoArray.length - 1; j++){
            System.out.print(lottoArray[j] + ", ");
        }
        System.out.println(lottoArray[5] + "]");
    }

    public void winningStatisticPrinter(int[] correctCount){
        System.out.println("\n당첨 통계\n---");
        Arrays.asList(CorrectCountEnum.values()).forEach(correctIterator ->
                System.out.println(correctIterator.getStr() +" - "+ correctCount[correctIterator.ordinal()]+ "개")
        );
    }

    public void yieldCalculation(int[] correctCount, int purchasedValue){
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
}
