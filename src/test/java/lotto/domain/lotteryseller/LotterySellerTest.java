package lotto.domain.lotteryseller;

import lotto.dto.lotterystore.MoneyForPurchase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LotterySellerTest {
	private static LotterySeller lotterySeller;

	@BeforeAll static void initializeTest() {
		lotterySeller = LotterySeller.getLotterySeller();
	}

	@DisplayName("moneyDto를 제대로 받는고 세트를 제대로 생성하는지") @Test void 로또자동생성테스트1() {
		lotterySeller.receiveInformationAboutPurchase(new MoneyForPurchase("6000"));
		lotterySeller.sendGeneratedLotterySet();
		assertThat(lotterySeller.test.size()).isEqualTo(6);
		lotterySeller.test.forEach(System.out::println);
	}

	@DisplayName("moneyDto를 제대로 받는고 세트를 제대로 생성하는지") @Test void 로또자동생성테스트2() {
		lotterySeller.receiveInformationAboutPurchase(new MoneyForPurchase("40000"));
		lotterySeller.sendGeneratedLotterySet();
		assertThat(lotterySeller.test.size()).isEqualTo(40);
		lotterySeller.test.forEach(System.out::println);
	}

}
