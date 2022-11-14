package lotto;

import java.util.List;

public class Progress {
    public static void run() {
        int money = UserInput.inputMoney();
        BuyAmount buyAmount = new BuyAmount(money);
        int buyLotto = buyAmount.buyLotto;  // 로또 구매 수량

        System.out.println(buyLotto + "개를 구매했습니다.");

        LottoNumbers lottoNumbers = new LottoNumbers(buyLotto);

        WinningNumberToList winningNumberToList = new WinningNumberToList();
        winningNumberToList.setWinNumbers(UserInput.inputWinNumber()); // 당첨 번호 입력 후 리스트 저장
        new Lotto(winningNumberToList.winNumbers);

        int bonusNum = UserInput.inputBonusNumber();

        System.out.println("당첨 통계");
        System.out.println("---");

        LottoCheck lottoCheck = new LottoCheck(lottoNumbers.lottoNums, winningNumberToList.winNumbers, bonusNum);

        System.out.printf("총 수익률은 %.1f%%입니다.", 100 * lottoCheck.totalPrice / (float) money);

    }
}


