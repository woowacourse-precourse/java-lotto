package lotto;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        Service service = new Service();

        view.lottoStartMsg();
        int moneyInput = service.getMoneyInput();
    }
}
