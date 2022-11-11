package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class AutomaticLottery {
    public int getLottoPieces(String amount) {
        validateInputType(amount);
        validateAmount(amount);
        int money = Integer.parseInt(amount);
        return money / 1000;
    }

    public List<List<Integer>> buyLotteries(String amount) {
        int lottoPieces = getLottoPieces(amount);
        List<List<Integer>> lotteries = new ArrayList<>();

        System.out.println(lottoPieces + "개를 구매했습니다.");

        for (int seq = 0; seq < lottoPieces; seq++) {
            lotteries.add(sortLotteriesNumber(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return lotteries;
    }

    public void printLotteries(List<List<Integer>> lotteries) {
        for (List<Integer> lottery : lotteries) {
            System.out.println(lottery);
        }
    }

    private List<Integer> sortLotteriesNumber(List<Integer> lottery) {
        return lottery.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    private void validateInputType(String amount) {
        if (amount.equals("")) {
            System.out.println("[ERROR] 공백을 입력할 수 없습니다 금액을 입력해 주세요.");
            throw new IllegalArgumentException();
        }
        for (int seq = 0; seq < amount.length(); seq++) {
            validateCharacter(amount.charAt(seq));
        }
    }

    private void validateCharacter(char inputSequence) {
        if (47 >= inputSequence || 58 <= inputSequence) {
            System.out.println("[ERROR] 금액은 숫자로만 입력할 수 있습니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateAmount(String amount) {
        int money = Integer.parseInt(amount);
        if (money % 1000 != 0) {
            System.out.println("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

}