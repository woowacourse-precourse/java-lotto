package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public static final String notThousand =" 구입금액은 천원 단위여야합니다.";

    public void checkIfDivideWithThousand(int purchase){
        if(purchase%1000 !=0){
            throw new IllegalArgumentException(ErrorResource.errorStart+notThousand);
        }
    }

}
