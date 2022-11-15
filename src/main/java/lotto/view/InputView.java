package lotto.view;

public class InputView {
    private static final InputView instance = new InputView();

    private InputView(){}

    public void printInputMoney(){
        System.out.println(InputMessage.MONEY.message());
    }

    public void printInputLotto(){
        System.out.println(InputMessage.LOTTO.message());
    }

    public void printInputBonus(){
        System.out.println(InputMessage.BONUS.message());
    }

    public static InputView getInstance(){
        return instance;
    }
}
