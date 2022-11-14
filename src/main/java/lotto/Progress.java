package lotto;

public class Progress {
    public static void run() {
        BuyAmount buyAmount = new BuyAmount(UserInput.inputMoney());
        int buyLotto = buyAmount.buyLotto;  // 로또 구매 수량
        for(int i=0; i<buyLotto; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers();
            System.out.println(lottoNumbers.lottoNums);
        }

        WinningNumberToList winningNumberToList = new WinningNumberToList();
        winningNumberToList.setWinNumbers(UserInput.inputWinNumber()); // 당첨 번호 입력 후 리스트 저장

        int bonusNum = UserInput.inputBonusNumber();

        System.out.println(winningNumberToList.winNumbers);
    }
}
