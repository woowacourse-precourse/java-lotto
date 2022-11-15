package lotto;

public class LottoService {

    private static String money;
    private static String winNumbers;
    private static String bonusNumber;
    private static Customer customer;
    private static WinningInfo winningInfo;

    private static void processMoney() {
        money = UserInterface.readMoney();
        customer = new Customer(Utils.convertStringToInt(money));
    }

    private static void processLotto() {
        customer.purchaseLotto();
        UserInterface.printLottoNumbers(customer.getLottoNumbers());
    }

    private static void processWinningNumbers() {
        winNumbers = UserInterface.readWinNumbers();
        Lotto win = new Lotto(Utils.convertStringToIntList(winNumbers));
        bonusNumber = UserInterface.readBonusNumber();
        winningInfo = new WinningInfo(win, Utils.convertStringToInt(bonusNumber));
    }

    private static void readInput() {
        processMoney();
        processLotto();
        processWinningNumbers();
    }

    private static void confirmWinning() {
        customer.checkWinning(winningInfo);
    }

    public static void start() {
        try {
            readInput();
            confirmWinning();
            UserInterface.printResult(customer);
            UserInterface.printRate(customer);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
