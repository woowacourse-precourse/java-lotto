package lotto;

public class Service {

    private static String money;
    private static String winNumbers;
    private static String bonusNumber;
    private static Customer customer;

    public static void start() {
        money = UserInterface.readMoney();
        customer = new Customer(Utils.convertStringToInt(money));
        customer.purchaseLotto();
        UserInterface.printLottoNumbers(customer.getLottoNumbers());
    }
}
