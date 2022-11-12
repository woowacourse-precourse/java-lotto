package lotto;

import java.util.List;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

    	int payment = User.getPayment();
    	int purchaseQuantity = payment / Constant.PAYMENT_UNIT.value;

    	List<List<Integer>> myLottos = getMyLottos(purchaseQuantity);
    	
    	List<Integer> winningNumbers = User.getWinningNumbers();
    	System.out.println(winningNumbers);
    }
    
    public static List<List<Integer>> getMyLottos(int purchaseQuantity) {
    	
    	System.out.println("\n" + purchaseQuantity + "개를 구매했습니다.");
    	
    	List<List<Integer>> myLottos = new ArrayList<List<Integer>>(purchaseQuantity);
    	
    	for (int count = 0; count < purchaseQuantity; count++) {
    		
    		List<Integer> lotto = Lotto.newLotto().getNumbers();
    		System.out.println(lotto);
    		myLottos.add(lotto);
    	}
    	
    	return myLottos;
    }
}