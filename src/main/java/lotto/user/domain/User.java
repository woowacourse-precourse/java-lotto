package lotto.user.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.Constant;

public class User {
    private int inputMoney;
    private int purchaseAmount;
    private int ticketAmount; // 롯도 장수
    private List<List<Integer>> lottos;


    public User() {
        this.inputMoney = Constant.INIT_ZERO;
        this.ticketAmount = Constant.INIT_ZERO;
        this.purchaseAmount = Constant.INIT_ZERO;
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