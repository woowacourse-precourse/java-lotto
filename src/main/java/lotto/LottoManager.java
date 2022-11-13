package lotto;

public class LottoManager {
    private InputManager inputManager;

    public LottoManager(){
        this.inputManager = new InputManager();
    }

    public void startLotto() {
        int amount = inputManager.getPurchasingAmount();
        int count = countBuyableLotto(amount);
    }

    public int countBuyableLotto(int amount) {
        int count;
        count = amount / 1000;
        
        return count;
    }
}
