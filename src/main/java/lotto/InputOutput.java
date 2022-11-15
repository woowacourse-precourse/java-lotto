package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class InputOutput {
    private final int lotteryPrice;

    private InputOutput(int lotteryPrice) {
        this.lotteryPrice = lotteryPrice;
    }

    private static class InputOutputHelper {
        private static final InputOutput INSTANCE = new InputOutput(Application.LOTTERY_PRICE);
    }

    public static InputOutput getInstance() {
        return InputOutputHelper.INSTANCE;
    }

    public int getMoney() {
        int money;

        try {
            System.out.println("구입금액을 입력해 주세요.");
            money = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자이어야 합니다.");
        }

        validateMoney(money);

        return money;
    }

    private void validateMoney(int money) {
        if (money % lotteryPrice != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 " + lotteryPrice + "단위 이어야 합니다.");
        }

        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 " + lotteryPrice + "이상만 가능합니다.");
        }
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public List<Integer> getWinningNums() {
        List<Integer> winningNums;
        String[] nums = getSplittedStr();

        try {
            winningNums = Arrays.stream(nums)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자이어야 합니다.");
        }
        validateWinningNums(winningNums);
        winningNums.sort(Comparator.naturalOrder());
        return winningNums;
    }

    private String[] getSplittedStr() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] splittedStr = Console.readLine().split(",");

        if (splittedStr.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개이어야 합니다.");
        }

        return splittedStr;
    }

    private void validateWinningNums(List<Integer> winningNums) {
        winningNums.forEach(integer -> {
            if (integer < 1 || 45 < integer) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45사이의 숫자여야 합니다.");
            }
        });

        Set<Integer> uniqueWinningNums = new TreeSet<>(winningNums);

        if (uniqueWinningNums.size() != winningNums.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되는 숫자가 있어서는 안됩니다.");
        }
    }

    public int getBonusNum() {
        int bonusNum;
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            bonusNum = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자이어야 합니다.");
        }

        return bonusNum;
    }

    public void validateBonusNum(int bonusNum, List<Integer> winningNums) {
        if (winningNums.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복이 있어선 안됩니다.");
        }

        if (bonusNum < 1 || 45 < bonusNum) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45사이의 숫자여야 합니다.");
        }
    }

}
