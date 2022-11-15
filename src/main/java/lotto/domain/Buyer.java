package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Buyer {
	private static final int ZERO_COUNT = 0;

	private final List<Lotto> lottos;

	public Buyer(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public static Buyer buyLottos(int inputAmount) {
		List<Lotto> lottos = IntStream.range(ZERO_COUNT, inputAmount / ConstValue.LOTTO_PRICE)
			.mapToObj(i -> Lotto.generateLottoNumber())
			.collect(Collectors.toList());
		return new Buyer(lottos);
	}

	public int getLottosAmount() {
		return lottos.size() * ConstValue.LOTTO_PRICE;
	}

	public List<Lotto> getLotto() {
		return new ArrayList<>(lottos);
	}

}
