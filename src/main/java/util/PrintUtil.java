package util;

import java.text.DecimalFormat;
import java.util.List;

import dto.CriteriaWinning;
import dto.IssueLottoInfo;
import dto.Lotto;
import dto.LottoGameInfo;

public class PrintUtil {

	public static void printPurchaseResult(long l) {

		System.out.println(l/1000+"개를 구매했습니다.");
	}

	public static void printIssueLotto(List<IssueLottoInfo> issueLottos) {
		
		for(IssueLottoInfo  lottoInfo : issueLottos) {
			Lotto lotto = lottoInfo.getIssueLottoNumber();
			System.out.println(lotto.getNumbers());
		}
	}

	public static void printResult(LottoGameInfo lottoGameInfo) {
		
		System.out.println("당첨 통계");
		System.out.println("---");
		
		
		DecimalFormat decFormat = new DecimalFormat("###,###");

		List<Integer> result = lottoGameInfo.getResult();
		for (int i = result.size()-1; i >= 0 ; i--) {
			CriteriaWinning winInfo = CriteriaWinning.valueOf("R"+(i+1));
			System.out.print(winInfo.getCriteria()+"개 일치");
			if(winInfo.isBonus()) {
				System.out.print(", 보너스 볼 일치");
			}
			
			System.out.print(" (");
			String str = decFormat.format(winInfo.getPrizeMoney());
			System.out.print(str);
			System.out.print("원)");
			System.out.print(" - ");
			System.out.print(result.get(i));
			System.out.print("개");
			System.out.println();
			
		}
		
	}

	public static void printProfitRate(LottoGameInfo lottoGameInfo) {
		List<Integer> result = lottoGameInfo.getResult();
		long totalRevenue = 0;
		for (int i = 0; i < result.size(); i++) {
			CriteriaWinning winInfo = CriteriaWinning.valueOf("R"+(i+1));
			totalRevenue += winInfo.getPrizeMoney() * result.get(i);
		}
		float profitRate =  lottoGameInfo.getInputPrice()/totalRevenue;
		System.out.println("총 수익률은 "+	String.format("%.1f", profitRate)+"%입니다.");
	
	}

}
