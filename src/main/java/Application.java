import controller.LottoController;
import domain.Buyer;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.lottoStart();
    }
}
