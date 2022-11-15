package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    public static void lottoGame() {
        final int lottoCount = getLottoCount(inputAmount());
        final List<Lotto> lottos = getLottoList(lottoCount);
        printLottoList(lottos);
        final WinningLotto winningLotto = getWinningLotto();
        WinningResult lottoResult = new WinningResult(winningLotto);
        lottoResult.calcRank(lottos);
        printWinningResult(lottoResult, lottoCount * 1000);
    }

    protected static int getLottoCount(String inputAmount) {
        if(inputAmount.length() == 0)
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액을 입력하지 않았습니다.");
        try {
            int amount = Integer.parseInt(inputAmount);
            if(amount % 1000 != 0)
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
            return amount / 1000;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
    }

    private static String inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    protected static List getLottoList(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>(lottoCount);
        for(int i=0; i<lottoCount; i++) {
            lottos.add(getLotto());
        }
        return lottos;
    }

    private static Lotto getLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        numbers.sort(Comparator.naturalOrder());
        return new Lotto(numbers);
    }

    private static void printLottoList(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }

    protected static WinningLotto getWinningLotto() throws IllegalArgumentException {
        List<Integer> numbers = getWinningLottoNumber(inputWinningLotto());
        try {
            int bonus = Integer.parseInt(inputWinningBonus());
            return new WinningLotto(numbers, bonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호로 숫자가 아닌 값을 입력했습니다.");
        }
    }

    protected static List<Integer> getWinningLottoNumber(String inputString) {
        List<String> str = Arrays.asList(inputString.split(","));
        List<Integer> numbers = str.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        return numbers;
    }
    private static String inputWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    private static String inputWinningBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    private static void printWinningResult(WinningResult lottoResult, int cost) {
        int reward = lottoResult.calcReward();
        double rewardRate = Math.round((float) reward / cost * 1000) / 10.0;
        System.out.println("당첨 통계\n---");
        System.out.println(lottoResult.getResult());
        System.out.println("총 수익률은 "+ rewardRate + "%입니다.");
    }
}
