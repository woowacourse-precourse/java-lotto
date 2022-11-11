package lotto;

public class Controller {
    private final Model model = new Model();
    private final View view = new View();
    public Controller() {
    }

    /**
     * input money value by user and serve to Model.setUserMoney
     */
    public void inputUserMoney() {
        String money = view.inputMoney();
        this.model.setUserMoney(money);
    }
}
