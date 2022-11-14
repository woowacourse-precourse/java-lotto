package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private static final String INPUT_PRICE = "구입금액을 입력해주세요";
    private static final String BUY_COUNT = "개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private int lottoCount;

    public void play() {

        Integer inputPrice = getInputPrice();
        List<Lotto> lottos = getLottos(inputPrice);
        List<Integer> winNumbers = getWinNumbers();

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

    private static List<Integer> getWinNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        String input = Console.readLine();
        String[] winInput = input.split(",");
        List<Integer> winNumbers = Arrays.stream(winInput).mapToInt(s -> Integer.parseInt(s)).boxed().collect(Collectors.toList());

        if (winNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개여야 합니다.");
        }
        if (winNumbers.size() != winNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 중복되지 않아야 합니다.");
        }
        if (winNumbers.stream().anyMatch(i -> i > 45 || i < 1)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1이상 45이하여야 합니다.");
        }
        return winNumbers;
    }

}
