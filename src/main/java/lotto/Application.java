package lotto;

import java.util.List;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

    	int payment = User.getPayment();
    	int purchaseQuantity = payment / Constant.PAYMENT_UNIT.value;

    	List<List<Integer>> myLottos = getMyLottos(purchaseQuantity);
    	System.out.println(myLottos);
    }
    
    public static List<List<Integer>> getMyLottos(int purchaseQuantity) {
    	
    	List<List<Integer>> myLottos = new ArrayList<List<Integer>>(purchaseQuantity);
    	
    	for (int count = 0; count < purchaseQuantity; count++) {
    		
    		myLottos.add(Lotto.newLotto().getNumbers());
    	}
    	
    	return myLottos;
    }
}