package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Rank.*;

public class User {

    private int userMoney = 0;
    private int numOfLotto = 0;
    private List<Lotto> lottos = new ArrayList<>();

    public User(String userMoney) {
        checkInputMoneyIsValid(userMoney);
        this.userMoney =  Integer.parseInt(userMoney);
        setNumOfLotto();
    }

    public void checkInputMoneyIsValid(String money){
        isNumeric(money);
        isDivided(money);
    }

    private void isNumeric(String money) {
        try {
            if (!(money != null && money.matches("[-+]?\\d*\\.?\\d+"))) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 금액 입력이 잘못되었습니다.");
        }
    }
    private void isDivided(String inputMoney) {
        int money = Integer.parseInt(inputMoney);
        if(money%UNIT.value() != 0){
            System.out.println("[ERROR] 금액은 1000원 단위로 나뉘어 떨어져야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void makeLottos(){
        if(numOfLotto != 0){
            for(int i=0; i<numOfLotto; i++){
                addLotto(new NumberGenerator().makeNumber());
            }
        }
    }

    public void addLotto(List<Integer> lottoNumber){
        lottos.add(new Lotto(lottoNumber));
    }

    public void setNumOfLotto(){
        if(userMoney != 0){
            numOfLotto = userMoney/(int)UNIT.value();
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getUserMoney() {
        return userMoney;
    }

    public int getNumOfLotto() {
        return numOfLotto;
    }
}
