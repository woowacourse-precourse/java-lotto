package lotto;

public class LottoAmount {
    Input input;

    public LottoAmount(){
        input = new Input();
    }

    public int caculInputMoney(int money){
         money = input.inputMoney();
         return money / 1000;
    }
}
