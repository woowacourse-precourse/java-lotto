package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoMachine lottoMachine = new LottoMachine();
            LottoContainer lottoContainer = lottoMachine.buy();
            lottoContainer.printLottos();

            lottoMachine.setWinningNumbers();
            lottoContainer.matchAll(lottoMachine.getNormalNumbers(), lottoMachine.getBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
