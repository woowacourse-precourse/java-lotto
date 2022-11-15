package lotto;

import java.util.List;

public class Progress {
    public static void run() {
        int money = 0;
        try {
            money = UserInput.inputMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        BuyAmount buyAmount = new BuyAmount(money);
        int buyLotto = buyAmount.buyLotto;  // 로또 구매 수량

        System.out.println(buyLotto + "개를 구매했습니다.");

        LottoNumbers lottoNumbers = new LottoNumbers(buyLotto);

        WinningNumberToList winningNumberToList = new WinningNumberToList();
        winningNumberToList.setWinNumbers(UserInput.inputWinNumber());
        new Lotto(winningNumberToList.winNumbers);

        int bonusNum = UserInput.inputBonusNumber();
        bonusErrorCheck(bonusNum, winningNumberToList.winNumbers);

        System.out.println("당첨 통계");
        System.out.println("---");

        LottoCheck lottoCheck = new LottoCheck(lottoNumbers.lottoNums, winningNumberToList.winNumbers, bonusNum);

        System.out.printf("총 수익률은 %.1f%%입니다.", 100 * lottoCheck.totalPrice / (float) money);

    }

    private static void bonusErrorCheck(int bonus, List<Integer> winNumbers) {
        if (bonus < 1 || bonus > 45)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 부터 45 사이입니다.");
        if (winNumbers.contains(bonus))
            throw new IllegalArgumentException("[ERROR] 이미 당첨번호에 존재합니다.");
    }
}


