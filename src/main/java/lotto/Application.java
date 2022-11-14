package lotto;

public class Application {
    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager();
        try{
            lottoManager.inputAmount();
            lottoManager.showAllLottos();
            lottoManager.inputWinningNumbers();
            lottoManager.inputBonusNumber();
            lottoManager.checkContain();
            lottoManager.compare();
            lottoManager.calcYield();
            lottoManager.printResult();
        } catch(IllegalArgumentException e) {
            System.out.println(LottoManager.error);
        }
    }
}
