package lotto;

public class Service {

    private static String money;
    private static String winNumbers;
    private static String bonusNumber;
    private static Customer customer;
    private static LottoInfo lottoInfo;

    private static void readInput() {
        try {
            money = UserInterface.readMoney();
            customer = new Customer(Utils.convertStringToInt(money));
            customer.purchaseLotto();
            UserInterface.printLottoNumbers(customer.getLottoNumbers());
            winNumbers = UserInterface.readWinNumbers();
            Lotto win = new Lotto(Utils.convertStringToIntList(winNumbers));
            bonusNumber = UserInterface.readBonusNumber();
            lottoInfo = new LottoInfo(win, Utils.convertStringToInt(bonusNumber));
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public static void start() {
        readInput();
        System.out.println(lottoInfo.compare(customer.getLottoNumbers().get(0)).getRank() + "등");

    }
}
