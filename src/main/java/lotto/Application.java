package lotto;

public class Application {
    public static void main(String[] args) {
        LottoKiosk lottoKiosk = new LottoKiosk();
        WinningNumberMaker winningNumberMaker = new WinningNumberMaker();
        try{
            lottoKiosk.insertMoney();
            lottoKiosk.sellLotto();
            winningNumberMaker.make();
            winningNumberMaker.makeBonusNumber();
            LottoChecker lottoChecker = new LottoChecker(winningNumberMaker.showWinningNumbers(),
                    winningNumberMaker.showBonusNumber());
            lottoChecker.insertLottos(lottoKiosk.showAllLotto());
            lottoChecker.saveAllResult();
            lottoChecker.printEachPrizeWinCount();
            lottoChecker.printProfitRate();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
