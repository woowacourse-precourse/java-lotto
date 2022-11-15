package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            User user = new User();
            user.enterPrice();
            user.printLottoEA();
            user.createLotto();
            user.enterWinningNumbers();

            Lotto lotto = new Lotto(user.getUserNumbers());
            user.enterBonusNumber();

            LotteryMachine machine = new LotteryMachine(user, lotto);
            machine.countWinningNumber();
            machine.showStatistics();
            machine.calculateRate();
        } catch (Exception e){
            System.out.println("[ERROR]" + e.getMessage());
        }
    }
}
