package lotto;

import lotto.enums.StatEnum;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
    public static boolean validBonus(List<Integer> tempLottoNumbers) {
        if (tempLottoNumbers.contains(Counter.BONUS)) {
            return true;
        }
        return false;
    }

    public static int correctCount(List<Integer> tempLottoNumbers) {
        int count = 0;
        List<Integer> winningNumbers = LottoMachine.winningLotto.getNumbers(); //당첨 로또 번호

        for (int numberIdx = 0; numberIdx < StatEnum.LOTTO_NUMBER.getNumber(); numberIdx++) {
            if (winningNumbers.contains(tempLottoNumbers.get(numberIdx))) {
                count++;
            }
        }
        return count;
    }

    public static void recordStat() {
        int count = 0;
        int element;

        for (int listIdx = 0; listIdx < Counter.getLottoList().size(); listIdx++) {
            List<Integer> tempLottoNumbers = Counter.getLottoList().get(listIdx).getNumbers(); //해당 lotto 클래스의 numbers
            count = correctCount(tempLottoNumbers);

            if (count == StatEnum.THREE_CORRECT.getNumber()) {
                element = Counter.record.get(StatEnum.THREE_CORRECT_INDEX.getNumber());
                Counter.record.set(StatEnum.THREE_CORRECT_INDEX.getNumber(), ++element);
            }
            else if (count == StatEnum.FOUR_CORRECT.getNumber()) {
                element = Counter.record.get(StatEnum.FOUR_CORRECT_INDEX.getNumber());
                Counter.record.set(StatEnum.FOUR_CORRECT_INDEX.getNumber(), ++element);
            }
            else if (count == StatEnum.FIVE_CORRECT.getNumber() && !validBonus(tempLottoNumbers)) { //보너스x
                element = Counter.record.get(StatEnum.FIVE_CORRECT_INDEX.getNumber());
                Counter.record.set(StatEnum.FIVE_CORRECT_INDEX.getNumber(), ++element);
            }
            else if (count == StatEnum.FIVE_CORRECT.getNumber() && validBonus(tempLottoNumbers)) { //보너스o
                element = Counter.record.get(StatEnum.FIVE_BONUS_CORRECT_INDEX.getNumber());
                Counter.record.set(StatEnum.FIVE_BONUS_CORRECT_INDEX.getNumber(), ++element);
            }
            else if (count == StatEnum.SIX_CORRECT.getNumber()) {
                element = Counter.record.get(StatEnum.SIX_CORRECT_INDEX.getNumber());
                Counter.record.set(StatEnum.SIX_CORRECT_INDEX.getNumber(), ++element);
            }
        }
    }

    public static void printStat() {
        System.out.println(StatEnum.INFO.getMessage());
        System.out.println(StatEnum.THREE_INFO.getMessage() + Counter.record.get(0) + StatEnum.UNIT.getMessage());
        System.out.println(StatEnum.FOUR_INFO.getMessage() + Counter.record.get(1) + StatEnum.UNIT.getMessage());
        System.out.println(StatEnum.FIVE_INFO.getMessage() + Counter.record.get(2) + StatEnum.UNIT.getMessage());
        System.out.println(StatEnum.FIVE_BONUS_INFO.getMessage() + Counter.record.get(3) + StatEnum.UNIT.getMessage());
        System.out.println(StatEnum.SIX_INFO.getMessage() + Counter.record.get(4) + StatEnum.UNIT.getMessage());
    }

    public static void printYield() {
        double earnMoney = 0;
        List<Integer> money = new ArrayList<>(List.of(5000, 50000, 1500000, 30000000, 2000000000));

        for (int idx = 0; idx < money.size(); idx++) {
            earnMoney += (money.get(idx) * Counter.record.get(idx));
        }

        double pay = Double.parseDouble(Counter.payMoney);
        double yield = earnMoney/pay * 100.0;

        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "%입니다.");
    }

    public static void print() {
        recordStat();
        printStat();
        printYield();
    }
}
