package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class LottoApplication {
    private final String patten = "^[0-9]*$";

    private RandomLotto randomLottos;
    private RandomLottoGenerator randomLottoGenerator;
    private WinningLotto winningLotto;

    private List<Lotto> randomNumbers;
    private int bonusNumber;

    public void run() {
        // 구매 금액 입력
        int money = inputMoney();

        // 랜덤 로또 생성
        randomLottoGenerator = new RandomLottoGenerator();
        randomLottos = new RandomLotto(randomLottoGenerator);
        randomNumbers = randomLottos.makeRandomLottos(money);
        randomNumbers.forEach(random -> random.printNumbers());

        // 로또 당첨번호(당첨번호 입력, 보너스번호 입력)
        winningLotto = new WinningLotto(inputAndGetLotto(), inputBonusNumber());

        // 총 상금
        int sum = 0;
        sum = getSum(sum);

        // 결과 출력
        printResult();

        // 수익률 출력
        printYield((double) money, (double) sum);
    }

    private int inputMoney() {
        System.out.println(Message.MONEY_INPUT);
        String input = Console.readLine();
        if (!(Pattern.matches(patten, input))) {
            throw new IllegalArgumentException(Message.NOT_NUMBER_ERROR);
        }

        int money = Integer.parseInt(input);

        return money;
    }

    private Lotto inputAndGetLotto() {
        System.out.println(Message.WINNING_NUMBER_INPUT);
        List<Integer> inputWinningLotto = new ArrayList<>();
        String[] split = Console.readLine().split(",");

        for (int idx = 0; idx < split.length; idx++) {
            winningNumberValidate(inputWinningLotto, split, idx);
            inputWinningLotto.add(Integer.parseInt(split[idx]));
        }

        Lotto inputLotto = new Lotto(inputWinningLotto);

        return inputLotto;
    }

    private void winningNumberValidate(List<Integer> inputWinningLotto, String[] split, int idx) {
        if (!(Pattern.matches(patten, split[idx]))) {
            throw new IllegalArgumentException(Message.NOT_NUMBER_OR_NOT_COMMA_ERROR);
        }

        if (inputWinningLotto.contains(Integer.parseInt(split[idx]))) {
            throw new IllegalArgumentException(Message.DUPLICATE_NUMBER_ERROR);
        }
    }

    private int inputBonusNumber() {
        System.out.println(Message.BONUS_NUMBER_INPUT);
        String inputBonusNumber = Console.readLine();
        if (!(Pattern.matches(patten, inputBonusNumber))) {
            throw new IllegalArgumentException(Message.NOT_NUMBER_ERROR);
        }
        bonusNumber = Integer.parseInt(inputBonusNumber);

        return bonusNumber;
    }

    private int getSum(int sum) {
        for (Lotto lotto : randomNumbers) {
            int cnt = winningLotto.matchCount(lotto);
            winningLotto.matchCount(lotto);

            if (isSmallerThanCount(cnt)) continue;

            /**
             * FIRST, SECOND, THIRD, FOURTH, FIFTH
             */
            LottoReward rank = getLottoRank(lotto, cnt);
            // 해당 rank 의 숫자를 더해준다
            plusCount(rank);
            // 해당 rank 의 상금을 더해준다
            sum += rank.getReward();
        }

        return sum;
    }

    private boolean isSmallerThanCount(int cnt) {
        return cnt < 3;
    }

    private LottoReward getLottoRank(Lotto lotto, int cnt) {
        LottoReward rank = LottoReward.getRank(cnt, isContainsBonusNumber(lotto, cnt));
        return rank;
    }

    private boolean isContainsBonusNumber(Lotto lotto, int cnt) {
        boolean containsBonusNumber = false;
        if (isCountFive(cnt)) {
            if (winningLotto.isContainsBonusNumber(lotto, bonusNumber)) {
                containsBonusNumber = true;
            }
        }
        return containsBonusNumber;
    }

    private boolean isCountFive(int cnt) {
        return cnt == 5;
    }

    private void plusCount(LottoReward rank) {
        rank.plusCount();
    }

    private void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoReward lottoReward : LottoReward.values()) {
            if (isRankSecond(lottoReward)) {
                System.out.println(String.format(Message.BONUS_BALL_RESULT_MESSAGE,
                        lottoReward.getMatchingNumbers(), lottoReward.getReward(), lottoReward.getCount()));
                continue;
            }
            System.out.println(String.format(Message.RESULT_MESSAGE,
                    lottoReward.getMatchingNumbers(), lottoReward.getReward(), lottoReward.getCount()));
        }
    }

    private boolean isRankSecond(LottoReward lottoReward) {
        return lottoReward == LottoReward.SECOND;
    }

    private void printYield(double money, double sum) {
        double yield = sum / money * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "%입니다.");
    }
}
