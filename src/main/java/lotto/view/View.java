package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constant.LottoConstant;
import lotto.type.Prize;

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

    public void printPrize(PrizeDto prizeDto) {
        Map<Prize, Long> prizeLongMap = prizeDto.groupByPrizes();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %s개\n",prizeLongMap.get(Prize.THREE));
        System.out.printf("4개 일치 (50,000원) - %s개\n",prizeLongMap.get(Prize.FOUR));
        System.out.printf("5개 일치 (1,500,000원) - %s개\n",prizeLongMap.get(Prize.FIVE));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개\n",prizeLongMap.get(Prize.FIVE_AND_BONUS));
        System.out.printf("6개 일치 (2,000,000,000원) - %s개\n",prizeLongMap.get(Prize.SIX));
        System.out.printf("총 수익률은 %.1f%%입니다.\n",prizeDto.getYield());

    }

}
