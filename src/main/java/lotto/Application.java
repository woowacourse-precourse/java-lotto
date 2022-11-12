package lotto;

public class Application {
    public static void main(String[] args) {
        System system = new System();
        system.purchaseLottoTable();
        system.notifySumOfResult(system.compareWinningLottoNumbers());
    }
}
