package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        int pay = inputPay();
        int lottoCount = pay/1_000;
        System.out.println(lottoCount + "개를 구매했습니다.");

        List<List<Integer>> lottoNumbers = pickLottoNumbers(lottoCount);

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winNumbers = inputWinNumbers(Console.readLine());
        Lotto lotto = new Lotto(winNumbers);
        int bonusNum = lotto.inputBonusNumber();
        int result = getPrizeResult(lottoNumbers, winNumbers, bonusNum);
        printOutResult(result, pay);

    }

    public static int inputPay() {
        System.out.println("구입금액을 입력해 주세요.");
        return checkPay(Console.readLine());
    }

    public static int checkPay(String str) {
//        if (!str.matches("^[0-9]*$")) {
//            throw new IllegalArgumentException("[ERROR] 안된대용");
//        }
        int pay = 0;
        try {
            pay = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입 금액은 숫자만 입력하실 수 있습니다.");
            throw new NoSuchElementException("[ERROR] 구입 금액은 숫자만 입력하실 수 있습니다.");
        }
        if (pay % 1_000 != 0) {
            System.out.println("[ERROR] 구입 금액은 1,000원 단위로 이루어져야 합니다.");
            throw new IllegalArgumentException();
        }
        return pay;
    }

    public static List<List<Integer>> pickLottoNumbers(int count) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = new ArrayList<>(Collections.unmodifiableList(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            numbers.sort(Comparator.naturalOrder());
            System.out.println(numbers);
            lottoNumbers.add(numbers);
        }
        return lottoNumbers;
    }

    public static List<Integer> inputWinNumbers(String str) {
        List<Integer> winNumbers;
        try {
            winNumbers = Arrays.stream(str.split(",")).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 당첨 번호는 숫자만 입력하실 수 있습니다.");
            throw new IllegalArgumentException();
        }
        return winNumbers;
    }

    public static int getPrizeResult(List<List<Integer>> lottoNumbers, List<Integer> winNumbers, int bonusNum) {
        int result = 0;
        for (List<Integer> num : lottoNumbers) {
            int correctCount = 0;

            correctCount = findCorrectNum(num, winNumbers, bonusNum, correctCount);
            Rank rank = Rank.getRank(correctCount);
            result += rank.getPrize();

            if (correctCount == 0 || correctCount > 2 && correctCount < 8)
                rank.rankCounting(rank);
        }
        return result;
    }

    public static int findCorrectNum(List<Integer> num, List<Integer> winNumbers, int bonusNum, int correctCount) {
        for (int i : num) {
            if (winNumbers.contains(i))
                correctCount++;
            if (correctCount == 5 && num.contains(bonusNum))
                correctCount += 2;
        }
        return correctCount;
    }

    public static void printOutResult(int result, int pay) {
        double profit = Math.round(((double) result/(double) pay) * 10000);
        BigDecimal profitPercent = new BigDecimal(String.valueOf(Double.parseDouble(String.valueOf(profit/100))));
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + Rank.fifth.getWinCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + Rank.fourth.getWinCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + Rank.third.getWinCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Rank.second.getWinCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Rank.first.getWinCount() + "개");
        System.out.println("총 수익률은 " + profitPercent.toPlainString() + "%입니다.");
    }

}
