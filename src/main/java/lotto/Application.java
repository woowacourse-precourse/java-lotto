package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int lottoCount = getLottoCount(Console.readLine());
            System.out.println();

            System.out.println(lottoCount + "개를 구매했습니다.");

            Set<Lotto> lotteries = new HashSet<>();
            for (int i = 0; i < lottoCount; i++) {
                lotteries.add(new Lotto(getRandomUniqueNumbers()));
            }

            for (Lotto lottery : lotteries) {
                System.out.println(lottery.getLottoNumbers().toString());
            }
            System.out.println();

            System.out.println("당첨 번호를 입력해 주세요.");
            Lotto winningLotto = getWinningLotto(Console.readLine());
            System.out.println();

            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = getBonusNumber(Console.readLine());
            System.out.println();

            validateWinningLottoAndBonusNumber(winningLotto, bonusNumber);

            LottoComparator lottoComparator = new LottoComparator(lotteries, winningLotto,
                bonusNumber);
            List<Integer> calculateResult = lottoComparator.getCalculateResult();

            System.out.println("당첨 통계");
            System.out.println("---");
            System.out.println(
                "3개 일치 (" + WinningAmount.FIFTH_PLACE.getAmountToDecimalFormatString() + "원) - "
                    + calculateResult.get(4) + "개");
            System.out.println(
                "4개 일치 (" + WinningAmount.FOURTH_PLACE.getAmountToDecimalFormatString() + "원) - "
                    + calculateResult.get(3) + "개");
            System.out.println(
                "5개 일치 (" + WinningAmount.THIRD_PLACE.getAmountToDecimalFormatString() + "원) - "
                    + calculateResult.get(2) + "개");
            System.out.println(
                "5개 일치, 보너스 볼 일치 (" + WinningAmount.SECOND_PLACE.getAmountToDecimalFormatString()
                    + "원) - " + calculateResult.get(1) + "개");
            System.out.println(
                "6개 일치 (" + WinningAmount.FIRST_PLACE.getAmountToDecimalFormatString() + "원) - "
                    + calculateResult.get(0) + "개");

            double yield = getYield(lottoCount, calculateResult);
            DecimalFormat decFormat = new DecimalFormat("###,###.#");

            System.out.println("총 수익률은 " + decFormat.format(yield) + "%입니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getLottoCount(String string) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액이 숫자 형식 또는 정수가 아닙니다.");
        }
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액이 양수가 아닙니다.");
        }
        if (number % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액이 1,000원으로 나누어떨어지지 않습니다.");
        }
        return number / 1000;
    }

    public static List<Integer> getRandomUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static Lotto getWinningLotto(String string) throws IllegalArgumentException {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String splitString : string.split(",")) {
            winningNumbers.add(getWinningNumber(splitString));
        }
        return new Lotto(winningNumbers);
    }

    private static int getWinningNumber(String string) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 숫자 형식이 아닙니다.");
        }
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 1부터 45 사이의 수가 아닙니다.");
        }
        return number;
    }

    public static int getBonusNumber(String string) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 숫자 형식이 아닙니다.");
        }
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 1부터 45 사이의 수가 아닙니다.");
        }
        return number;
    }

    public static void validateWinningLottoAndBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.getLottoNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 로또 번호와 보너스 번호 중복이 있습니다.");
        }
    }

    public static double getYield(int lottoCount, List<Integer> calculateResult) {
        int purchaseAmount = lottoCount * 1000;
        int sumOfWinningAmount = getSumOfWinningAmount(calculateResult);
        return 100 + ((double) (sumOfWinningAmount - purchaseAmount) * 100 / purchaseAmount);
    }

    private static int getSumOfWinningAmount(List<Integer> calculateResult) {
        return WinningAmount.FIRST_PLACE.getAmount() * calculateResult.get(0)
            + WinningAmount.SECOND_PLACE.getAmount() * calculateResult.get(1)
            + WinningAmount.THIRD_PLACE.getAmount() * calculateResult.get(2)
            + WinningAmount.FOURTH_PLACE.getAmount() * calculateResult.get(3)
            + WinningAmount.FIFTH_PLACE.getAmount() * calculateResult.get(4);
    }
}
