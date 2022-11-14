package lotto;

public class View {
    public View(){
        Controller controller = new Controller();

        controller.cashInput();
        System.out.println(controller.showBuy());
        controller.printUserLotto();
        System.out.println("당첨 번호를 입력해 주세요.");
        controller.winningNumInput();
        System.out.println("보너스 번호를 입력해 주세요.");
        controller.bonusNumInput();
        controller.checking();
        System.out.println(controller.winningTable());
        System.out.println(controller.percent());
    }
}
