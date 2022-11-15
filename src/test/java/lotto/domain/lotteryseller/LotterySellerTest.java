package lotto.domain.lotteryseller;

import lotto.controller.LotteryRequestController;
import lotto.domain.lotterystore.LotteryStoreUi;
import lotto.dto.lotterystore.MoneyDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LotterySellerTest {
	private static LotterySeller lotterySeller;
	private static LotteryRequestController lotteryRequestController;
	private static LotteryStoreUi lotteryStoreUi;

	@BeforeAll public static void initiation() {
		lotterySeller = new LotterySeller();
		lotteryRequestController = new LotteryRequestController();
		lotteryStoreUi = new LotteryStoreUi();
	}

	@DisplayName("moneyDto를 제대로 받는고 세트를 제대로 생성하는지") @Test void 로또자동생성테스트1() {
		lotterySeller.receiveMoney(new MoneyDto("6000"));
		lotterySeller.sendGeneratedLotterySets(lotteryRequestController);
		lotteryRequestController.sendLottoSetsToLotteryStoreUi(lotteryStoreUi);

		lotteryStoreUi.printMessageForLottoSets();

	}

	@DisplayName("moneyDto를 제대로 받는고 세트를 제대로 생성하는지") @Test void 로또자동생성테스트2() {
		lotterySeller.receiveMoney(new MoneyDto("40000"));
		lotterySeller.sendGeneratedLotterySets(lotteryRequestController);
		lotteryRequestController.sendLottoSetsToLotteryStoreUi(lotteryStoreUi);

		lotteryStoreUi.printMessageForLottoSets();
	}

}
