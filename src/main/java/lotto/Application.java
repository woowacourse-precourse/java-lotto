package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine().replaceAll(" ", "");

        try {
            validatePriceInput(input);
        } catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] 잘못된 입력값입니다.");
            return;
        }
        long investment = Integer.parseInt(input);

        user.buyLotto(investment);
        List<Lotto> lottos = user.getLottos();
        System.out.println(lottos.size() + "개를 구매했습니다.");

        lottos.forEach(lotto -> {
            System.out.println(lotto.toString());
        });
        System.out.println("당첨 번호를 입력해 주세요.");
        String input2 = Console.readLine().replaceAll(" ", "");

        try {
            validateWinningInput(input2);
        } catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] 6개의 당첨숫자를 콤마(,)를 이용해 숫자를 분리해주세요 )");
        }

        List<Integer> answer = Arrays.stream(input2.split(",")).map(Integer::parseInt).collect(Collectors.toList());


        System.out.println("보너스 번호를 입력해 주세요.");
        String input3 = Console.readLine().replaceAll(" ", "");

        try {
            validateBonusInput(input3);
        } catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] 1부터 45사이의 숫자를 입력해주세요.");
        }

        int bonus = Integer.parseInt(input3);

        System.out.println("당첨 통계");
        System.out.println("---");

        List<Integer> history = user.getWinningHistory(answer, bonus);
        Place[] places = Place.values();

        System.out.println(3 + "개 일치 " + "(" + places[5].getPrizeMoney() + "원) - " + history.get(5) + "개");
        System.out.println(4 + "개 일치 " + "(" + places[4].getPrizeMoney() + "원) - " + history.get(4) + "개");
        System.out.println(5 + "개 일치 " + "(" + places[3].getPrizeMoney() + "원) - " + history.get(3) + "개");
        System.out.println(5 + "개 일치, 보너스 볼 일치 " + "(" + places[2].getPrizeMoney() + "원) - " + history.get(2) + "개");
        System.out.println(6 + "개 일치 " + "(" + places[1].getPrizeMoney() + "원) - " + history.get(1) + "개");


        System.out.println("총 수익률은 " + user.getYield(history, investment) + "%입니다.");
    }

    private static void validateBonusInput(String input3) {
        if (!input3.matches("^[0-9]+$")) throw new IllegalArgumentException();
    }

    private static void validateWinningInput(String input2) {
        if (input2.split(",").length < 6) throw new IllegalArgumentException();
    }

    private static void validatePriceInput(String input) {
        if (!input.matches("^[0-9]+$")) throw new IllegalArgumentException();
    }
}
