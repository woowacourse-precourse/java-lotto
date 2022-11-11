package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.LottoConstant;

public class View {

    public int intputMoney() {
        System.out.println("구입금액을 입력해 주세요");
        int money = Integer.parseInt(Console.readLine());
        validateMoney(money);
        return money;
    }

    public void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력금액은 1000원 단위여야 합니다.");
        }
    }

    public void printBuyLotto(LottoDto lottoDto) {
        List<List<Integer>> lotteries = lottoDto.getLotteries();
        System.out.println(lotteries.size() + "개를 구매했습니다.");
        for (List<Integer> lottery : lotteries) {
            System.out.println(lottery);
        }
    }

    public List<Integer> inputWinningNumber() {
        String numbers = Console.readLine();
        List<Integer> winningNumber = Arrays.stream(numbers.split(","))
                .sorted()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validateWinningNumber(winningNumber);
        return winningNumber;
    }

    private void validateWinningNumber(List<Integer> winningNumber) {
        for (Integer integer : winningNumber) {
            if (integer > LottoConstant.MAX_LOTTO_NUMBER ||
                    integer < LottoConstant.LOW_LOTTO_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

}
