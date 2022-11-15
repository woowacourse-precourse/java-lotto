package lotto;

import java.util.HashMap;
import java.util.List;

public class Calculator {
    private static HashMap<Integer,Integer> prizeBuckets=Util.setPrizeBuckets();
    private static HashMap<Integer,Integer> prizeInfo= Util.setPrizeInfo();;
    private static final List<Integer> scoreOrder=List.of(3,4,5,-1,6);;
    private static final List<String> moneyOrder=List.of("5,000","50,000","1,500,000","","2,000,000,000");;


}
