package lotto.user.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int inputMoney;
    private int purchaseAmount;
    private int ticketAmount; // 롯도 장수
    private List<List<Integer>> lottos;

    public User(int inputMoney) {
        this.inputMoney = inputMoney;
        this.ticketAmount = inputMoney;
        this.purchaseAmount = inputMoney;
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
    public void setTicketAmount(int amount)
    {
        this.ticketAmount = amount ;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getTicketAmount(){
        return ticketAmount;
    }

}