package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
    public static int buyTicket(String money) {
        try {
            int intMoney = Integer.parseInt(money);
            if (intMoney < 1000) {
                throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상으로 입력해 주세요.");
            }
            if (intMoney % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해 주세요.");
            }
            return intMoney / 1000;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력해주세요.");
        }
    }

    public static List<Lotto> generateLottos(int nLotto) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < nLotto; i++) {
            List<Integer> pickedNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            tickets.add(new Lotto(pickedNumbers));
        }
        return tickets;
    }
    public static List<Integer> getWinningNumbers(String userInput) throws IllegalArgumentException {
        String[] splitedInputs = userInput.trim().split(",");
        List<Integer> winnings = new ArrayList<>();
        for (String s : splitedInputs) {
            try {
                winnings.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자 사이는 ,로 구분되어야 합니다.");
            }
        }
        lotteryValidationCheck(winnings);

        return winnings;
    }

    public static void lotteryValidationCheck(List<Integer> lotteryNumbers) {
        for (Integer chosen : lotteryNumbers) {
            if (chosen < 1 || chosen > 45) {
                throw new IllegalArgumentException("[ERROR] 숫자는 1 ~ 45 중 하나의 숫자여야 합니다." + chosen);
            }
        }
        if (lotteryNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자는 6개 이어야 합니다.");
        }
        Set<Integer> lotteryNumberSet = new HashSet<>(lotteryNumbers);
        if (lotteryNumberSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자가 중복되면 안됩니다.");
        }
    }
}
