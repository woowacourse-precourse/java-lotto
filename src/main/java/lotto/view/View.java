package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Prize;

public class View {

    public long inputMoney() {
        System.out.println("구입금액을 입력해 주세요");
        String input = Console.readLine();
        validateHasNumber(List.of(input));
        return Long.parseLong(input);
    }

    public void printBuyLotto(LottoDto lottoDto) {
        List<List<Integer>> lotteries = lottoDto.getLotteries();
        System.out.println(lotteries.size() + "개를 구매했습니다.");
        for (List<Integer> lottery : lotteries) {
            System.out.println(lottery);
        }
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요");
        String input = Console.readLine();
        List<String> winningNumbersInput = Arrays.stream(input.split(","))
                .collect(Collectors.toList());
        validateHasNumber(winningNumbersInput);
        return winningNumbersInput.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
        String input = Console.readLine();
        validateHasNumber(List.of(input));
        return Integer.parseInt(input);
    }

    public void printPrize(PrizeDto prizeDto) {
        Map<Prize, Long> prizeLongMap = prizeDto.groupByPrizes();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %s개\n", prizeLongMap.getOrDefault(Prize.THREE, 0L));
        System.out.printf("4개 일치 (50,000원) - %s개\n", prizeLongMap.getOrDefault(Prize.FOUR, 0L));
        System.out.printf("5개 일치 (1,500,000원) - %s개\n", prizeLongMap.getOrDefault(Prize.FIVE, 0L));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개\n", prizeLongMap.getOrDefault(Prize.FIVE_AND_BONUS, 0L));
        System.out.printf("6개 일치 (2,000,000,000원) - %s개\n", prizeLongMap.getOrDefault(Prize.SIX, 0L));
        System.out.printf("총 수익률은 %.1f%%입니다.\n", prizeDto.getYield());

    }
    private void validateHasNumber(List<String> list) {
        String regex = "[0-9]+";
        for (String number : list) {
            if (!number.matches(regex)) {
                throw new IllegalArgumentException("[ERROR] 정수만 입력해야 합니다.");
            }
        }
    }
}
