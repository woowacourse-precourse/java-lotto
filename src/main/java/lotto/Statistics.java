package lotto;

import java.util.List;

public class Statistics {
	
	private int firstPlaceCount = 0;
	private int secondPlaceCount = 0;
	private int thirdPlaceCount = 0;
	private int fourthPlaceCount = 0;
	private int fifthPlaceCount = 0;
	
	private int totalPrize = 0;
	private double rateOfReturn = 0;
	
	public Statistics(List<List<Integer>> numbers, List<Integer> winningNumbers, int money, int bonus) {
		for (List<Integer> list : numbers) {
			rankCount(list, winningNumbers, bonus);
		}
		
		setTotalPrize();
		setRateOfReturn(totalPrize, money);
	}
	
	private void rankCount(List<Integer> numbers, List<Integer> winningNumbers, int bonus) {
		int count = 0;
		
		for (int number : numbers) {
			if (winningNumbers.contains(number)) {
				count++;
			}
		}
		
		rankCount(winningNumbers, count, bonus);
	}
	
	private void rankCount(List<Integer> winningNumbers, int count, int bonus) {
		if (count == 3) { fifthPlaceCount++; return; }
		
		if (count == 4) { fourthPlaceCount++; return; }
		
		if (count == 5) {
			if (winningNumbers.contains(bonus)) {
				secondPlaceCount++; return;
			}
			
			thirdPlaceCount++; return;
		}
		
		if (count == 6) { firstPlaceCount++; return; }
	}
	
	
	private void setTotalPrize() {
		int result = 0;
		
		result += Winnings.FIRST_PLACE.getPrize() * firstPlaceCount;
		result += Winnings.SECOND_PLACE.getPrize() * secondPlaceCount;
		result += Winnings.THIRD_PLACE.getPrize() * thirdPlaceCount;
		result += Winnings.FOURTH_PLACE.getPrize() * fourthPlaceCount;
		result += Winnings.FIFTH_PLACE.getPrize() * fifthPlaceCount;
		
		totalPrize = result;
	}
	
	private void setRateOfReturn(int totalPrize, int money) {
		double result = 0;
		
		if (totalPrize == 0) {
			rateOfReturn = 0;
			return;
		}
		
		result = (double) totalPrize / (double) money * 100;
		rateOfReturn = Math.round(result * 10) / 10.0;
	}
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("당첨 통계\n");
		builder.append("---\n");
		builder.append("3개 일치 (5,000원) - " + fifthPlaceCount + "개\n");
		builder.append("4개 일치 (50,000원) - " + fourthPlaceCount + "개\n");
		builder.append("5개 일치 (1,500,000원) - " + thirdPlaceCount + "개\n");
		builder.append("5개 일치, 보너스 볼 일치 (30,000,000원) - " + secondPlaceCount + "개\n");
		builder.append("6개 일치 (2,000,000,000원) - " + firstPlaceCount + "개\n");
		builder.append("총 수익률은 " + rateOfReturn + "%입니다.");
		
		return builder.toString();
	}
}
