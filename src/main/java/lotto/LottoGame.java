package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    private static String amount;
    private static String[] basket;
    private static List<Integer> winNumber;
    private static int bonusBall;
    private static List<List<Integer>> randomLottoNumbers;

    public LottoGame() {
        amount = "";
        basket = new String[6];
        winNumber = new ArrayList<>();
        bonusBall = 0;
        randomLottoNumbers = new ArrayList<>();
    }

    public void startGame() {
        try {
            buyLotto();
            createNumbers();
            compareLottoNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void buyLotto() {
        payMoney();
        createLotto(amount);
        for (List<Integer> randomLottoNumber : randomLottoNumbers) {
            System.out.println(randomLottoNumber); // 함수화 시키자
        }
    }
    
    private void payMoney() {
        Message.printMoneyMessage();
        amount = Console.readLine();
        PurchaseException.validatePurchaseAmount(amount);
        int lottoCount = Integer.parseInt(amount) / 1000;
        Message.printPurchaseMessage(lottoCount);
    }
    
    private void createLotto(String amount) {
        LottoRandomNumbers lottoRandomNumbers = new LottoRandomNumbers(amount);
        randomLottoNumbers = lottoRandomNumbers.getNumbers();
    }

    private void createNumbers() {
        createWinNumber();
        createBonusNumber();
    }

    private void createWinNumber() {
        Message.printWinNumber();
        basket = Console.readLine().split(",");
        for (int i = 0; i < basket.length; i++) {
            winNumber.add(Integer.parseInt(basket[i]));
        }
        Lotto lotto = new Lotto(winNumber);
    }

    private void createBonusNumber() {
        Message.printBonusNumber();
        bonusBall = Integer.parseInt(Console.readLine());
        Lotto lotto = new Lotto(winNumber);
        lotto.validateBonusNumber(winNumber, bonusBall);
    }

    private void compareLottoNumber() {
        LottoNumberCheck lottoNumberCheck = new LottoNumberCheck();
        lottoNumberCheck.compareWinNumberWithMyLotto(randomLottoNumbers, winNumber, bonusBall);
        lottoNumberCheck.comparePrizeMoneyWithMyPrizeLotto();
    }
}
