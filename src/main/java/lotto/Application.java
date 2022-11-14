package lotto;

import camp.nextstep.edu.missionutils.*;
import java.util.List;
import java.util.ArrayList;
import java.text.NumberFormat;

public class Application {
    private static String[] resultString = { "6개 일치", "5개 일치, 보너스 볼 일치", "5개 일치", "4개 일치", "3개 일치" };
    private static Integer[] prizeMoney = { 2000000000, 30000000, 1500000, 50000, 5000 };

    public static void main(String[] args) {
        List<Lotto> lottoList;

        try {
            lottoList = buyLotteries(getLottoBuyCount());
            startLottery(lottoList);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private static Integer getLottoBuyCount() {
        Integer money;

        System.out.println("구입금액을 입력해 주세요.");
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }

        if (money % 1000 > 0)
            throw new IllegalArgumentException("1000으로 나누어지는 값을 입력해야 합니다.");

        return money / 1000;
    }

    private static Lotto buyLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return new Lotto(numbers);
    }

    private static List<Lotto> buyLotteries(Integer count) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int num = 0;num < count;num++)
            lottoList.add(buyLotto());

        printLotteries(lottoList);

        return lottoList;
    }

    private static void printLotteries(List<Lotto> lottoList) {
        System.out.println("\n" + lottoList.size() + "개를 구매했습니다.");

        for (Lotto lotto: lottoList)
            lotto.printNumbers();
    }

    private static Lotto getWinningNumbers() {
        System.out.println("\n" + "당첨 번호를 입력해 주세요.");
        return new Lotto(Console.readLine());
    }

    private static Integer getBonusNumber() {
        Integer bonusNumber;

        System.out.println("\n" + "보너스 번호를 입력해 주세요.");
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }

        if (bonusNumber < 1 || bonusNumber > 45)
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        return bonusNumber;
    }

    private static void startLottery(List<Lotto> lottoList) {
        Integer[] result;
        Lotto winningNumbers = getWinningNumbers();
        Integer bonusNumber = getBonusNumber();

        if (winningNumbers.contains(bonusNumber))
            throw new IllegalArgumentException("중복되지 않는 숫자를 입력해야 합니다.");

        result = getResult(lottoList, winningNumbers, bonusNumber);
        printResult(result);
        printRate(result, lottoList.size());
    }

    private static Integer[] getResult(List<Lotto> lottoList, Lotto winningNumbers, Integer bonusNumber) {
        Integer[] result = { 0, 0, 0, 0, 0, 0 };

        for (Lotto lotto: lottoList) {
            Prize prize = lotto.getResult(winningNumbers, bonusNumber);
            result[prize.ordinal()]++;
        }

        return result;
    }

    private static void printResult(Integer[] result) {
        NumberFormat nf = NumberFormat.getIntegerInstance();

        System.out.println("\n" + "당첨 통계");
        System.out.println("---");

        for (int i = 4; i >= 0; i--)
            System.out.println(resultString[i] + " (" + nf.format(prizeMoney[i]) + "원) - " + result[i] + "개");
    }

    private static void printRate(Integer[] result, Integer lotteryCount) {
        int earn = 0;

        for (int i = 4; i >= 0; i--)
            earn += prizeMoney[i] * result[i];

        System.out.println("총 수익률은 " + Math.round(earn / (lotteryCount * 1000.0) * 100 * 10) / 10.0 + "%입니다.");
    }
}
