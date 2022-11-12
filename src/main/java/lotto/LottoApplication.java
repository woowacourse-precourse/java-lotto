package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    private RandomLotto randomLottos;
    private RandomLottoGenerator randomLottoGenerator;
    private WinningLotto winningLotto;

    private List<Lotto> randomNumbers;
    private int bonusNumber;

    public void run() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        randomLottoGenerator = new RandomLottoGenerator();
        randomLottos = new RandomLotto(randomLottoGenerator);
        randomNumbers = randomLottos.makeRandomLottos(money);
        randomNumbers.forEach(random -> random.printNumbers());

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> inputWinningLotto = new ArrayList<>();
        String[] split = Console.readLine().split(",");

        for (int idx = 0; idx < split.length; idx++) {
            if (inputWinningLotto.contains(Integer.parseInt(split[idx]))) {
                throw new IllegalArgumentException("[ERROR] 로또 번호가 중복됩니다.");
            }
            inputWinningLotto.add(Integer.parseInt(split[idx]));
        }
        Lotto inputLotto = new Lotto(inputWinningLotto);

        // 보너스 숫자
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());
        winningLotto = new WinningLotto(inputLotto, bonusNumber);

        int sum = 0;
        for (Lotto lotto : randomNumbers) {
            int cnt = winningLotto.matchCount(lotto);
            winningLotto.matchCount(lotto);

            if (cnt < 3) continue;

            boolean containsBonusNumber = false;
            if (cnt == 5) {
                if (winningLotto.isContainsBonusNumber(lotto, bonusNumber)) {
                    containsBonusNumber = true;
                }
            }

            /**
             * FIRST, SECOND, THIRD, FOURTH, FIFTH
             */
            LottoReward rank = LottoReward.getRank(cnt, containsBonusNumber);
            // 해당 rank 의 숫자를 더해준다
            rank.plusCount();
            // 해당 rank 의 상금을 더해준다
            sum += rank.getReward();
        }

        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoReward lottoReward : LottoReward.values()) {
            if (lottoReward == LottoReward.SECOND) {
                System.out.println(String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개",
                        lottoReward.getMatchingNumbers(), lottoReward.getReward(), lottoReward.getCount()));
                continue;
            }
            System.out.println(String.format("%d개 일치 (%,d원) - %d개",
                    lottoReward.getMatchingNumbers(), lottoReward.getReward(), lottoReward.getCount()));
        }

        double yield = (double) sum / (double) money * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "%입니다.");
    }
}
