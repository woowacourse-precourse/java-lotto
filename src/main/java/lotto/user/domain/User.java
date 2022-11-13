package lotto.user.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int inputMoney;
    private int purchaseAmount;
    private int ticketAmount; // 롯도 장수
    private List<List<Integer>> lottos;
    private static final int INIT_NUMBER = 0;

    public User() {
        this.inputMoney = INIT_NUMBER;
        this.ticketAmount = INIT_NUMBER;
        this.purchaseAmount = INIT_NUMBER;
        this.lottos = new ArrayList<>();
    }

    public void setLottos(List<Integer> lottoNumbers) {
        lottos.add(lottoNumbers);
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }

    public int getInputMoney() {
        return inputMoney;
    }

    public void setpurchaseAmount(int amount) {
        this.purchaseAmount = amount;
    }

    public void setTicketAmount(int amount) {
        this.ticketAmount = amount;
    }

    public void setInputMoney(int money) {
        this.inputMoney = money;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

}