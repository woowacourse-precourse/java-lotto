package lotto;

import java.util.List;

public class Check {
    static Output output = new Output();

    public static void numberCompare(int lottoCount, Lotto[] lottoArray, Lotto userInputLottoNumber, int userInputBonusNumber, int purchasedValue){
        int[] correctCount = new int[5];

        for(int i = 0; i < lottoCount; i++){
            int countTmp = 0;

            countTmp = countTmpCounter(lottoArray[i], userInputLottoNumber);

            winningStatisticsMaker(lottoArray[i], userInputBonusNumber, correctCount, countTmp);
        }
        output.winningStatisticPrinter(correctCount);
        output.yieldCalculation(correctCount, purchasedValue);
    }


    public static int countTmpCounter(Lotto lottoArray, Lotto userInputLottoNumber){
        int countTmp = 0;
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                if (lottoArray.getIthNumber(i) == userInputLottoNumber.getIthNumber(j)){
                    countTmp++;
                }
            }
        }

        return countTmp;
    }

    public static void winningStatisticsMaker(Lotto lottoArrayLine, int userInputBonusNumber, int[] correctCount, int countTmp){
        if(countTmp >= 3){
            correctCount[countTmp - 3]++;
        }

        if (countTmp == 5){
            for (int i = 0; i < 6; i++){
                if (lottoArrayLine.getIthNumber(i) == userInputBonusNumber){
                    correctCount[2]--;
                    correctCount[3]++;
                }
            }
        }
    }
}
