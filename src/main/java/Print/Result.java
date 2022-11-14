package Print;

import java.util.List;

import lotto.Lotto;

public class Result {
	private static final int[] result_price = {5000, 50000, 1500000, 30000000, 2000000000};
	private static final String[] result_print = {"3개 일치 (5,000원)", "4개 일치 (50,000원)", "5개 일치 (1,500,000원)", "5개 일치, 보너스 볼 일치 (30,000,000원)", "6개 일치 (2,000,000,000원)"};
	public static void print(List<Lotto> arr, List<Integer> win_number, int bonus_number, int n) {
		Message.WINNING_STATES.print();
    	
    	int[] result_count = print_result(arr, win_number, bonus_number);
    	
    	double profit = 0;
    	for(int i = 0; i < result_print.length; i++) {
    		System.out.println(result_print[i] + " - " + result_count[i] + "개");
    		profit += result_count[i] * result_price[i];
    	}
    	
    	profit = profit / (n * 1000) * 100;
    	
    	Message.PROFIT.print_profit(profit);
	}
	
	private static int[] print_result(List<Lotto> arr, List<Integer> win_number, int bonus_number) {
		int[] result_count = new int[result_print.length];
    	for(int i = 0; i < arr.size(); i++) {
    		int count = result(arr.get(i).getnumber(), win_number);
    		
    		if(count < 3 || count > 6) {
    			continue;
    		}
    		
    		if(count == 6 || (count == 5 && check_bonus_number(arr.get(i).getnumber(), bonus_number))) {
    			result_count[count - 2]++;
    			continue;
    		}
    		result_count[count - 3]++;
    	}
    	return result_count;
	}
	
	public static int result(List<Integer> arr, List<Integer> win_number) {
    	int number_count = 0;
    	for(int i = 0; i < win_number.size(); i++) {
			if(arr.contains(win_number.get(i))) {
				number_count++;
			}
		}
    	
    	return number_count;
    }
    
    public static boolean check_bonus_number(List<Integer> arr, int bonus_number) {
    	return arr.contains(bonus_number);
    }
}
