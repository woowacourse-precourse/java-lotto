package lotto;

public class Application {
    public static void main(String[] args) {
        
    	LottoGameController lottoGameController =  new LottoGameController();
		lottoGameController.inputPurchaseAmount();
		lottoGameController.issueLotto();
		lottoGameController.printIssueLotto();
		lottoGameController.inputWinningNumber();
		lottoGameController.inputBonusNumber();
		lottoGameController.calculateResult();
    	
    }
}
