package util;

import java.util.List;

import dto.IssueLottoInfo;
import dto.Lotto;

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

}
