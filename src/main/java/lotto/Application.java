package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numbergenerator = new NumberGenerator();
        List<ArrayList<Integer>> lottonumbersall = new ArrayList<ArrayList<Integer>>();
        lottonumbersall = numbergenerator.createRandomLotto(lottocount);
    }
    
    public static void askTotalPrice() {
    	System.out.println("구입금액을 입력해 주세요.");
    	String stringprice;
    	stringprice = Console.readLine();
    	int price = Integer.parseInt(stringprice);
    }
    
    public static int askNumbers() {
    	int lottocount = 0;
    	return lottocount;
    }
    
    public void lottoValidateNumber() {
    	
    }
    
    public void askBonusNumber() {
    	
    }
}
