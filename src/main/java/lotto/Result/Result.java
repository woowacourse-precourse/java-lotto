package lotto.Result;

import lotto.Lotto;
import lotto.printer.Printer;

import java.util.List;

public class Result {
    static int[] count = new int[5];
    static Integer totalMoney = 0;

    public static void checkResult(List<Lotto> lottoNumbers, Lotto winNumber, Integer bonusNumber) {
        Printer.printResultMessage();
        calculateResult(lottoNumbers, winNumber, bonusNumber);
        callPrinter(count, lottoNumbers.size()*1000);
    }

    private static void callPrinter(int[] count, Integer money) {
       for(int i = 0; i < count.length; i++){
          Printer.printResult(Prize.values()[i].getMessage(), count[i]);
       }
        Printer.printEarningRate((float)totalMoney/(float)money*100);
    }


    private static void calculateResult(List<Lotto> lottoNumbers, Lotto winNumber, Integer bonusNumber) {
        int result = 0;

        for (Lotto lotto : lottoNumbers) {
            result = compareNumber(lotto, winNumber, bonusNumber);
            if (result == Prize.FIFTH.getCount()) {
                count[0] += 1;
                totalMoney += Prize.FIFTH.getPrize();
            }
            if (result == Prize.FOURTH.getCount()) {
                count[1] += 1;
                totalMoney += Prize.FOURTH.getPrize();
            }
            if (result == Prize.THIRD.getCount()) {
                count[2] += 1;
                totalMoney += Prize.THIRD.getPrize();
            }
            if (result == Prize.SECOND.getCount()) {
                count[3] += 1;
                totalMoney += Prize.FOURTH.getPrize();
            }
            if (result == Prize.FIRST.getCount()) {
                count[4] += 1;
                totalMoney += Prize.FIRST.getPrize();
            }
        }
    }

    private static int compareNumber(Lotto lottoNumber, Lotto winNumber, int bonusNumber) {
        int count = 0;
        for (Integer number : lottoNumber.getNumbers()) {
            if (winNumber.getNumbers().contains(number)) {
                count += 10;
            }
        }
        if (count == 50 && lottoNumber.getNumbers().contains(bonusNumber)) {
            count += 1;
        }
        return count;
    }
}
