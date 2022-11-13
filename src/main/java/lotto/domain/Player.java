package lotto.domain;

public class Player {

    public int howManyLotto(int money){
        if(money%1000!=0){
            throw new IllegalArgumentException("[ERROR] 돈은 1000원 단위로 떨어져야 합니다.");
        }
        return money/1000;
    }


}
