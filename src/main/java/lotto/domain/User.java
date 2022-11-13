package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

	private final List<Lotto> lotties = new ArrayList<>();

	public List<Lotto> getLotties() {
		return lotties;
	}
}
