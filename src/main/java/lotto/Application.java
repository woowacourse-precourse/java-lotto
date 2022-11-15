package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.controller.LottoController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int budget = getNumber();
        int round = createRound(budget);

        System.out.println(String.format("%d개를 구매했습니다.",round));
        List<List<Integer>> games = createGames(round);

        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = getNumber();

        System.out.println("당첨 통계\n ---");
        LottoController lottoController = new LottoController(games,input,bonusNumber);
        lottoController.printTotalYield(budget);
    }

    private static int getNumber() {
        try{
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e){
            System.out.println("[ERROR] 입력값은 항상 숫자여야만합니다.");
            throw new NoSuchElementException("[ERROR] 입력값은 항상 숫자여야만합니다.");
        }
    }

    private static int createRound(int budget){
        if(budget % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 입력금액은 1000원 단위여야만 합니다.");
        }
        return budget / 1000;
    }

    private static List<List<Integer>> createGames(int round) {
        List<List<Integer>> games = new ArrayList<>();
        while(games.size() < round){
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            numbers.sort(Comparator.naturalOrder());
            System.out.println(numbers.toString());
            games.add(numbers);
        }
        return games;
    }
}
