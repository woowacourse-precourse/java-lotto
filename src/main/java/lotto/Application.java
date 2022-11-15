package lotto;


public class Application {
    public static void main(String[] args) {

        User user = new User();
        LottoMachine lottoMachine = new LottoMachine();
        Computer computer = new Computer();

        user.inputMoney();
        lottoMachine.inputWinningLotto();
        lottoMachine.inputBonusNumber();

        lottoMachine.issueLotto(user.getMoney());
        computer.computeWinnings(lottoMachine);

        lottoMachine.printIssuedLotto();
        computer.printWinnings();
        computer.printYield(user);

    }




}
