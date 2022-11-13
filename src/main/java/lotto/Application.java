package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int lottoCount = getLottoCount(inputAmount());
        List<Lotto> lottos = getLottoList(lottoCount);

    }

    protected static int getLottoCount(String inputAmount) throws IllegalArgumentException {
        if(inputAmount.length() == 0)
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액을 입력하지 않았습니다.");
        int amount = Integer.parseInt(inputAmount);
        if(amount % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
        return amount / 1000;
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
}
