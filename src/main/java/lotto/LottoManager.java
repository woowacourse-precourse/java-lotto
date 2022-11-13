package lotto;

public class LottoManager {
    private InputManager inputManager;

    public LottoManager(){
        this.inputManager = new InputManager();
    }

    public void startLotto() {
        int amount = inputManager.getPurchasingAmount();
    }
}
