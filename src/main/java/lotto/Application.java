package lotto;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        Service service = new Service();

        try{
            view.lottoStartMsg();
            int moneyInput = service.getMoneyInput();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
