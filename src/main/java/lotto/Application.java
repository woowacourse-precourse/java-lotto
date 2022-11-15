package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoHandler lottoHandler = new LottoHandler();
            lottoHandler.sellLotto();
            lottoHandler.pickWinningNumber();
            lottoHandler.pickBonusNumber();
            lottoHandler.calculateResult();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
