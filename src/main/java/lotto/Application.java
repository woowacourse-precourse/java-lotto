package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int lottoCount = getLottoCount(inputAmount());
        final List<Lotto> lottos = getLottoList(lottoCount);
        final WinningLotto winningLotto = getWinningLotto();
    }

    protected static int getLottoCount(String inputAmount) {
        if(inputAmount.length() == 0)
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액을 입력하지 않았습니다.");
        try {
            int amount = Integer.parseInt(inputAmount);
            if(amount % 1000 != 0)
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
            return amount / 1000;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 금액을 잘못 입력했습니다.");
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
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    protected static WinningLotto getWinningLotto() throws IllegalArgumentException {
        Lotto lotto = getWinningLottoNumber(inputLottoString());
        try {
            int bonus = Integer.parseInt(inputBonus());
            return new WinningLotto(lotto, bonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호로 숫자가 아닌 값을 입력했습니다.");
        }
    }

    protected static Lotto getWinningLottoNumber(String inputString) {
        List<String> str = Arrays.asList(inputString.split(","));
        List<Integer> number = str.stream().map(s -> Integer.parseInt(s))
                                    .collect(Collectors.toList());
        return new Lotto(number);
    }
    private static String inputLottoString() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    private static String inputBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
