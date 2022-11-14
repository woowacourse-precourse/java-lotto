package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.InfoEnum;
import lotto.enums.StatEnum;

import java.util.*;

public class Application {
    private static List<Lotto> lottoList = new ArrayList<>(); //전체 로또 담을 리스트

    public static int BONUS;
    public static Lotto winningLotto;
    public static List<Integer> record = new ArrayList<>(List.of(0, 0, 0, 0, 0)); //로또 통계 기록용 리스트
    public static String payMoney;
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static int buyLotto() {
        System.out.println(InfoEnum.MONEY.getMessage());
        payMoney = Console.readLine();

        int lottoNumber = 0;

        try {
            lottoNumber = Integer.parseInt(payMoney) / 1000;
        }
        catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE);
        }

        return lottoNumber;
    }

    public static List<Integer> makeRandom() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);

        return numbers;
    }

    public static void printLotto(int lottoNumber) {
        System.out.println("\n" + lottoNumber + InfoEnum.BUY_NUMBER.getMessage());

        for (int cnt = 0; cnt < lottoNumber; cnt++) {
            Lotto lotto = new Lotto(makeRandom());
            lottoList.add(lotto); //로또 리스트에 담기
            lotto.printNumbers(); //로또 번호 출력
        }
    }

    public static void exception(String numbers) {
        try {
            if (!numbers.contains(",")) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Integer> winningNumber() {
        System.out.println("\n" + InfoEnum.WINNING_NUMBER.getMessage());
        String numbers = Console.readLine();

        exception(numbers);

        List<Integer> winningNumbersList = new ArrayList<>(); //당첨 번호 담긴 리스트
        StringTokenizer st = new StringTokenizer(numbers, ",");

        while(st.hasMoreTokens()) {
            int element = Integer.parseInt(st.nextToken());
            winningNumbersList.add(element);
        }

        return winningNumbersList;
    }

    public static void bonusNumber() {
        System.out.println("\n" + InfoEnum.BONUS_NUMBER.getMessage());
        String tempBonus = Console.readLine();
        BONUS = Integer.parseInt(tempBonus);
    }

    public static boolean validBonus(List<Integer> tempLottoNumbers) {
        if (tempLottoNumbers.contains(BONUS)) {
            return true;
        }
        return false;
    }

    public static int correctCount(List<Integer> tempLottoNumbers) {
        int count = 0;
        List<Integer> winningNumbers = winningLotto.getNumbers(); //당첨 로또 번호

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

        for (int listIdx = 0; listIdx < lottoList.size(); listIdx++) {
            List<Integer> tempLottoNumbers = lottoList.get(listIdx).getNumbers(); //해당 lotto 클래스의 numbers
            count = correctCount(tempLottoNumbers);

            if (count == StatEnum.THREE_CORRECT.getNumber()) {
                element = record.get(StatEnum.THREE_CORRECT_INDEX.getNumber());
                record.set(StatEnum.THREE_CORRECT_INDEX.getNumber(), ++element);
            }
            else if (count == StatEnum.FOUR_CORRECT.getNumber()) {
                element = record.get(StatEnum.FOUR_CORRECT_INDEX.getNumber());
                record.set(StatEnum.FOUR_CORRECT_INDEX.getNumber(), ++element);
            }
            else if (count == StatEnum.FIVE_CORRECT.getNumber() && !validBonus(tempLottoNumbers)) { //보너스x
                element = record.get(StatEnum.FIVE_CORRECT_INDEX.getNumber());
                record.set(StatEnum.FIVE_CORRECT_INDEX.getNumber(), ++element);
            }
            else if (count == StatEnum.FIVE_CORRECT.getNumber() && validBonus(tempLottoNumbers)) { //보너스o
                element = record.get(StatEnum.FIVE_BONUS_CORRECT_INDEX.getNumber());
                record.set(StatEnum.FIVE_BONUS_CORRECT_INDEX.getNumber(), ++element);
            }
            else if (count == StatEnum.SIX_CORRECT.getNumber()) {
                element = record.get(StatEnum.SIX_CORRECT_INDEX.getNumber());
                record.set(StatEnum.SIX_CORRECT_INDEX.getNumber(), ++element);
            }
        }
    }

    public static void printStat() {
        System.out.println(StatEnum.INFO.getMessage());
        System.out.println(StatEnum.THREE_INFO.getMessage() + record.get(0) + StatEnum.UNIT.getMessage());
        System.out.println(StatEnum.FOUR_INFO.getMessage() + record.get(1) + StatEnum.UNIT.getMessage());
        System.out.println(StatEnum.FIVE_INFO.getMessage() + record.get(2) + StatEnum.UNIT.getMessage());
        System.out.println(StatEnum.FIVE_BONUS_INFO.getMessage() + record.get(3) + StatEnum.UNIT.getMessage());
        System.out.println(StatEnum.SIX_INFO.getMessage() + record.get(4) + StatEnum.UNIT.getMessage());
    }

    public static void printYield() {
        double earnMoney = 0;

        List<Integer> money = new ArrayList<>(List.of(5000, 50000, 1500000, 30000000, 2000000000));

        for (int idx = 0; idx < money.size(); idx++) {
            earnMoney += (money.get(idx) * record.get(idx));
        }
        double pay = Double.parseDouble(payMoney);
        double yield = earnMoney/pay * 100.0;

        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "%입니다.");
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int lottoNumber = buyLotto();
        printLotto(lottoNumber);
        winningLotto = new Lotto(winningNumber()); //당첨 로또
        bonusNumber();
        recordStat();
        printStat();
        printYield();
    }
}
