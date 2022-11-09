package lotto.service;


import lotto.domain.Money;

public class LottoService {

    Money money = new Money();

    public void insertMoney(int inputMoney){
        money.insertMoney(inputMoney);
    }
}
