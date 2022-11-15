package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();

        try {
            User user = new User(userInput);

            Integer lottoQuantity = Lotto.calQuantityByPrice(Integer.parseInt(userInput));
            System.out.println(System.lineSeparator() + lottoQuantity + "개를 구매했습니다.");

            List<Lotto> lottos = new ArrayList<>();

            for(Integer i=0; i<lottoQuantity; i++) {
                Lotto lotto = new Lotto(Lotto.generateNumbers());
                lottos.add(lotto);
            }

            user.setLottos(lottos);

            user.printLottoNumbers();

            // TODO : 당첨 번호, 보너스 번호 입력 받기
            System.out.println(System.lineSeparator() + "당첨 번호를 입력해 주세요.");
            List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                    .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

            Prize prize = new Prize(winningNumbers);

            System.out.println(System.lineSeparator() + "보너스 번호를 입력해 주세요.");
            Integer bonusNumber = Integer.parseInt(Console.readLine());

            prize.setBonusNumber(bonusNumber);

            // TODO : 당첨자 확인, 발표
            List<PrizeWinner> prizeWinners = Arrays.asList(PrizeWinner.values());

            System.out.println(System.lineSeparator() + "당첨 통계");
            System.out.println("---");

            Institution.getInstance().confirmWinner(prizeWinners, user, prize);
            Institution.getInstance().announceWinnerResult(prizeWinners, user);

        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
