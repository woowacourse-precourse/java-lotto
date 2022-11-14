package lotto.view;

import java.text.DecimalFormat;

public class WinningStatisticsView {

	public static void printStatistics(int[] rankArray) {
		StringBuilder sb = new StringBuilder();
		sb.append("3개 일치 (5,000원) - ").append(rankArray[4]).append("개").append('\n');
		sb.append("4개 일치 (50,000원) - ").append(rankArray[3]).append("개").append('\n');
		sb.append("5개 일치 (1,500,000원) - ").append(rankArray[2]).append("개").append('\n');
		sb.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(rankArray[1]).append("개").append('\n');
		sb.append("6개 일치 (2,000,000,000원) - ").append(rankArray[0]).append("개");
		System.out.println(sb);
	}

	public static void printYield(double yield) {
		DecimalFormat doubleFormatter = new DecimalFormat("#,###.0");
		System.out.println("총 수익률은 " + doubleFormatter.format(yield) + "%입니다.");
	}

}
