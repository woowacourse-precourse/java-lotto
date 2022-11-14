package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final String INPUT_PRICE = "구입금액을 입력해주세요";
    private static final String BUY_COUNT = "개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private int lottoCount;

    public void play() {

        Integer inputPrice = getInputPrice();
        List<Lotto> lottos = getLottos(inputPrice);

    }

    private static Integer getInputPrice() {
        System.out.println(INPUT_PRICE);
        String input = Console.readLine();
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
        Integer inputPrice = Integer.parseInt(input);
        if (inputPrice < 1000) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상이어야 합니다.");
        }
        if (inputPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000으로 나누어 떨어져야 합니다.");
        }
        return inputPrice;
    }


    private List<Lotto> getLottos(Integer inputPrice) {
        StringBuilder sb = new StringBuilder();
        lottoCount = inputPrice / 1000;
        sb.append(lottoCount).append(BUY_COUNT);
        System.out.println(sb);

        List<Lotto> lottos = issueLottos(lottoCount);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        return lottos;
    }

    private List<Lotto> issueLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Lotto.issueLotto()));
        }
        return lottos;
    }

}
