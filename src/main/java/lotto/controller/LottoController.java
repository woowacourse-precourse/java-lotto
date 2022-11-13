package lotto.controller;

import static lotto.domain.LottoRankStatus.*;
import static lotto.restrict.RestrictConstants.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoRankStatus;
import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.filter.UserInputFilter;
import lotto.service.LottoService;
import lotto.service.UserInterfaceService;
import lotto.service.UserService;

public class LottoController {

	private static final UserService userService = new UserService();
	private static final LottoService lottoService = new LottoService();
	private static final UserInterfaceService userInterfaceService = new UserInterfaceService();
	private static final UserInputFilter filter = new UserInputFilter();

	public void startLottoBusinessService() {
		try {
			User user = new User();
			long amount = sellLottoToUser(user);
			WinningLotto winningLotto = makeWinningLotto();
			List<Integer> totalResult = makeTotalResult(user, winningLotto);
			float revenueRate = calculateRevenueRate(amount, totalResult);

			userInterfaceService.outputTotalResult(revenueRate, totalResult);
		} catch (Exception e) {
			userInterfaceService.outputError(e);
			throw e;
		}
	}

	private Long sellLottoToUser(User user) {
		String userInputAmount = userInterfaceService.inputUserPurchaseAmount();
		Long amount = filter.changeStringToLong(userInputAmount);
		Integer lottoQuantity = userService.getLottoQuantity(amount);

		userInterfaceService.outputPurchaseCompletion(lottoQuantity);
		for (int makeLottoCount = 0; makeLottoCount < lottoQuantity; makeLottoCount++) {
			Lotto lotto = lottoService.makeLotto();

			user.addLotto(lotto);
			userInterfaceService.outputLottoNumbers(lotto.getNumbers());
		}
		return amount;
	}

	private WinningLotto makeWinningLotto() {
		String userInputWinningNumber = userInterfaceService.inputUserWinningNumber();
		List<Integer> numbers = filter.splitStringToDelimiter(userInputWinningNumber, LIMIT_SIZE);
		Lotto winningLotto = new Lotto(numbers);
		String userInputBonusNumber = userInterfaceService.inputUserBonusNumber();
		List<Integer> bonusNumbers = filter.splitStringToDelimiter(userInputBonusNumber, BONUS_QUANTITY);
		return new WinningLotto(winningLotto, bonusNumbers);
	}

	private List<Integer> makeTotalResult(User user, WinningLotto winningLotto) {
		List<Lotto> lotties = user.getLotties();
		List<LottoRankStatus> result = new ArrayList<>();

		for (Lotto lotto : lotties) {
			LottoRankStatus lottoRankStatus = lottoService.determineLottoRankStatus(lotto, winningLotto);

			result.add(lottoRankStatus);
		}
		return calculateRankCount(result);
	}

	private List<Integer> calculateRankCount(List<LottoRankStatus> result){
		List<Integer> totalResult = new ArrayList<>();
		totalResult.add(Collections.frequency(result, FIFTH_RANK));
		totalResult.add(Collections.frequency(result, FOURTH_RANK));
		totalResult.add(Collections.frequency(result, THIRD_RANK));
		totalResult.add(Collections.frequency(result, SECOND_RANK));
		totalResult.add(Collections.frequency(result, FIRST_RANK));
		return totalResult;
	}

	private float calculateRevenueRate(long amount, List<Integer> totalResult) {
		long totalCompensation = calculateTotalCompensation(totalResult);

		return (float) totalCompensation * 100 / amount;
	}

	private long calculateTotalCompensation(List<Integer> totalResult) {
		long totalCompensation = 0L;

		totalCompensation += (long) FIFTH_RANK_COMPENSATION * totalResult.get(0);
		totalCompensation += (long) FOURTH_RANK_COMPENSATION * totalResult.get(1);
		totalCompensation += (long) THIRD_RANK_COMPENSATION * totalResult.get(2);
		totalCompensation += (long) SECOND_RANK_COMPENSATION * totalResult.get(3);
		totalCompensation += (long) FIRST_RANK_COMPENSATION * totalResult.get(4);
		return totalCompensation;
	}
}
