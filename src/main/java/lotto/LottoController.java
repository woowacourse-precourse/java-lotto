package lotto;

import static lotto.global.Constant.MAX_LOTTO_SIZE;

import java.util.ArrayList;
import java.util.List;
import lotto.global.Message;
import lotto.util.RandomNumberGenerator;

public class LottoController {

    private LottoInput lottoInput = new LottoInput();
    private int[] lottoResult = new int[MAX_LOTTO_SIZE + 2];
    private int[] lottoReward = new int[]{0, 0, 0, 5000, 50000, 1500000, 2000000000, 30000000};

    public Integer getUserLottoCount() {
        UserInput userInput = new UserInput();

        Message.GAME_INPUT.print();
        Integer userMoney = userInput.getUserInput();
        return userMoney / 1000;
    }

    public List<Lotto> issueLotto(Integer lottoCount) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        List<Lotto> issuedLotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = randomNumberGenerator.generateRandomNumber();
            Lotto lotto = new Lotto(lottoNumbers);
            issuedLotto.add(lotto);
        }

        return issuedLotto;
    }

    public void showIssueResult(List<Lotto> issuedLotto) {
        System.out.print("\n" + issuedLotto.size());
        Message.GAME_ISSUE.print();
        issuedLotto.stream().forEach(lotto -> lotto.print());
        System.out.println();
    }

    public Lotto getLottoInput() {
        Message.LOTTO_INPUT.print();
        List<Integer> lottoNumbers = lottoInput.getLottoInput();
        Lotto lotto = new Lotto(lottoNumbers);
        System.out.println();
        return lotto;
    }

    public Integer getBonusInput() {
        Message.BONUS_INPUT.print();
        Integer bonus = lottoInput.getBonusInput();
        System.out.println();
        return bonus;
    }

    public void computeResult(List<Lotto> issuedLotto, Lotto lotto, Integer bonus) {
        for (int i = 0; i < issuedLotto.size(); i++) {
            int idx = issuedLotto.get(i).countEqual(lotto);
            if (idx == 5 && issuedLotto.get(i).checkBonus(bonus)) {
                idx += 2;
            }

            lottoResult[idx]++;
        }
    }

    public void printResult() {
        System.out.println("당첨 통계\n" + "---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", lottoResult[3]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", lottoResult[4]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", lottoResult[5]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", lottoResult[7]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lottoResult[6]);
    }

    public void printYield(Integer lottoCount) {
        double yield = 0;
        for (int i = 0; i < MAX_LOTTO_SIZE + 2; i++) {
            yield += lottoResult[i] * lottoReward[i];
        }
        yield = Math.round(yield) / 10.0;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield / lottoCount);
    }
}
