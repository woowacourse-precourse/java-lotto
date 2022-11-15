package lotto.domain;
import lotto.domain.Lotto;

import java.util.List;

public class Purchase {

    private Purchase(int numberOfGame){
        for(int i=0;i<numberOfGame;i++){
            Lotto.generateRandomLotto(); // 여기서 하나 만들고
        }
    }
    public static Purchase getInstance(int numberOfGame){
        return new Purchase(numberOfGame);
    }
}
