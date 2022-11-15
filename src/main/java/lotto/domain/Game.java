package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public static final String notThousand =" 구입금액은 천원 단위여야합니다.";
    public static final String notNumber =" 구입금액은 숫자여야합니다.";
    public static final int unit = 1000;

    public int checkIfDivideWithThousand(String purchase){
        try{
            int purchaseBill = Integer.parseInt(purchase);
            if(purchaseBill%unit !=0){
                throw new IllegalArgumentException(ErrorResource.errorStart+notThousand);
            }
            return purchaseBill/unit;
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorResource.errorStart+notNumber);
        }
    }

}
