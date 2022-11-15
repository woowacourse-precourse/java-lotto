package lotto;

import java.util.Map;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
    	try {
	    	Answer answer = new Answer();
	    	User user = new User();
	    	
	        System.out.println("구입금액을 입력해 주세요.");
	        String cost = Console.readLine();
	        int count = user.getPurchaseCount(cost);
	        
	        for(int i=0;i<count;i++) {
	            user.addLotto();
	        }
	        System.out.println("당첨 번호를 입력해 주세요.");
	        String answerNumbers = Console.readLine();
	        answer.setNumbers(answerNumbers);
	        
	        System.out.println("보너스 번호를 입력해 주세요.");
	        String answerBonus = Console.readLine();
	        answer.setBonus(answerBonus);
	        
	        answer.evaluate(user);
	        
	        printStatistic(user);
	        
    	}catch(IllegalArgumentException e) {
    		System.out.print("[ERROR] " + e.getMessage());
    	}
    }

	private static void printStatistic(User user) {
		Map<Rank, Integer> rankCount = user.getRankCount();
		
		System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %s개\n", rankCount.get(Rank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %s개\n", rankCount.get(Rank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %s개\n", rankCount.get(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개\n", rankCount.get(Rank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %s개\n", rankCount.get(Rank.FIRST));
        System.out.printf("총 수익률은 %s%%입니다.", user.getProfitRate());
	}
}
