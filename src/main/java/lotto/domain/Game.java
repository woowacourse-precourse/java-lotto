package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final String notThousand = " 구입금액은 천원 단위여야합니다.";
    private static final String notNumber = " 구입금액은 숫자여야합니다.";
    private static final int unit = 1000;

    public void gameStart() {
        System.out.println(Resource.greetings);
        List<Lotto> lottoNumbers = showBoughtNumbers();
        WinningNumber winningNumber = makeWinningNumber();
        showResult(lottoNumbers, winningNumber);
        System.out.println(Resource.revenuePercentFront);
        System.out.println(Resource.revenuePercentBack);
    }

    private void showResult(List<Lotto> lottoNumbers, WinningNumber winningNumber) {
        JudgeMent judgeMent = new JudgeMent();
        judgeMent.setCorrectResult(lottoNumbers, winningNumber);
        System.out.println(judgeMent.getCorrectResult());
        System.out.println(Resource.resultOfWinning);
        System.out.println(Resource.countOfCorrectNumberFront);
        System.out.println(Resource.countOfCorrectNumberMiddle);
        System.out.println(Resource.countOfCorrectNumberBack);
    }

    private WinningNumber makeWinningNumber() {
        System.out.println(Resource.inputOfWinningNumber);
        String winNumber = Console.readLine();
        System.out.println(Resource.inputOfBonusNumber);
        String bonusNumber = Console.readLine();
        return new WinningNumber(winNumber, Integer.parseInt(bonusNumber));
    }

    private List<Lotto> showBoughtNumbers() {
        String purchase = Console.readLine();
        int lottoUnit = checkIfDivideWithThousand(purchase);
        System.out.println(lottoUnit + Resource.countOfBuying);
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoUnit; i++) {
            Lotto lotto = getLotto(lottoNumbers);
            System.out.println(lotto.getNumbers());
        }
        return lottoNumbers;
    }

    private Lotto getLotto(List<Lotto> lottos) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);
        lottos.add(lotto);
        return lotto;
    }

    public int checkIfDivideWithThousand(String purchase) {
        try {
            int purchaseBill = Integer.parseInt(purchase);
            if (purchaseBill % unit != 0) {
                throw new IllegalArgumentException(ErrorResource.errorStart + notThousand);
            }
            return purchaseBill / unit;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorResource.errorStart + notNumber);
        }
    }


}
