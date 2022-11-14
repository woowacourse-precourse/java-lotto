package Main;

import java.util.List;

import Print.Result;
import User.User;
import lotto.BuyLotto;
import lotto.Lotto;

public class Application {
    public static void main(String[] args) {
        //BuyLotto butlotto = new BuyLotto();
    	
    	User user = new User();
    	
    	int n = user.input_money();
    	
    	if(n == 0) {
    		return;
    	}
    	
		List<Lotto> arr = BuyLotto.print(n);
    	
    	List<Integer> win_number = user.winning_number();
    	
    	if(win_number.size() == 0) {
    		return;
    	}
    	
    	int bonus_number = user.winning_number_bonus();
    	
		Result.print(arr, win_number, bonus_number, n);
    }
}
