package lotto.domain;

import lotto.Exceptions;

public class Cash {
    public static String countPurchaseQuantity(String readLine){
        int count;
        Exceptions.excludeUnderThousand(readLine);
        count = Integer.parseInt(readLine) / 1000;
        return count + "개를 구매했습니다.";
    }
}
