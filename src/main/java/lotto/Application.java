package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numbergenerator = new NumberGenerator();
        List<ArrayList<Integer>> lottonumbersall = new ArrayList<ArrayList<Integer>>();
        lottonumbersall = numbergenerator.createRandomLotto(lottocount);
    }
    
    public static void askTotalPrice() {
    
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
