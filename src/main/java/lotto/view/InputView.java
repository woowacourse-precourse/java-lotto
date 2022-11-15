package lotto.view;

public class InputView {
    private static InputView instance = new InputView();

    private InputView(){}

    public void printInputMoney(){
        System.out.println(InputMessage.MONEY.message());
    }

    public static InputView getInstance(){
        return instance;
    }
}
