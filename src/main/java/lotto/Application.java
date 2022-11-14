package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static Guide guide = new Guide();
    private static Purchase purchase;
    private static WinNumber winNumber;
    private static BonusNumber bonusNumber;

    public static void main(String[] args) {
        guide.printPurchase();
        try {
            purchase = new Purchase(Console.readLine());
        } catch (Exception e) {
            return;
        }
        guide.printConfirmPurchase(purchase);

        MyLotto myLotto = new MyLotto(purchase);
        guide.printMyLotto(myLotto);

        guide.requestWinLottoNumber();
        try {
            winNumber = new WinNumber(Console.readLine());
        } catch (Exception e) {
            return;
        }

        guide.requestBonusNumber();
        try {
            bonusNumber = new BonusNumber(Console.readLine(), winNumber);
        } catch (Exception e) {
        }

        myLotto.checkEachLotto(winNumber, bonusNumber);
        myLotto.calculateProfit();
        guide.printMyLottoResult(myLotto);
        guide.printProfit(myLotto);
    }
}
