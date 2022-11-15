package lotto;

import java.util.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Player {
    private final int LOTTO_PRICE = 1000;
    private int PurchaseMoney;
    private int total_lotto;
    private Manager manager;
    private List<Integer> winning;
    private List<Lotto> lottos;
    private int Bonus;
    private int Profit;
    private String Error_message;
    public Player(Manager manager){
        this.manager = manager;
    }

    public void InputPurchaseMoney(){
        System.out.println(manager.INPUT_MONEY);
        String input = readLine();
        this.PurchaseMoney = manager.checkPurchaseMoney(input);
    }

    public void calculateTotalLotto(){
        this.total_lotto = this.PurchaseMoney / this.LOTTO_PRICE;
    }

    public void InputWinningNumber(){
        System.out.println("\n" + manager.INPUT_WINNING);
        winning = new ArrayList<>();
        String input = readLine();
        this.winning = manager.checkWinningNumber(input);
    }

    public void InputBonusNumber(){
        System.out.println("\n" + manager.INPUT_BONUS);
        String input = readLine();
        this.Bonus = manager.checkBonusNumber(input, this.winning);
    }

    public void PurChaseLotto(){
        lottos = new ArrayList<>();
        for(int i=0; i<total_lotto; i++){
            lottos.add(manager.makeLotto());
        }
    }

    public void LottoGamestart(){
        try{
            InputPurchaseMoney();
            calculateTotalLotto();
            PurChaseLotto();
            manager.PrintLotto(this.lottos);
            InputWinningNumber();
            InputBonusNumber();
            manager.PrintGameResult(this.lottos, this.winning, this.Bonus);
            Profit = manager.calculateTotalMoney(this.lottos, winning, Bonus);
            manager.PrintReturnRate(this.PurchaseMoney, this.Profit);
        }catch(IllegalArgumentException e){
            System.out.println(manager.getError_message());
        }
    }
}
