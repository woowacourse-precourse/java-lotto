package lotto.dto.lotteryseller;

import java.util.List;

public class LottoSetsDto {
	private final List<List<Integer>> lottoSets;
	private final int lottoSetsSize;

	public LottoSetsDto(List<List<Integer>> lottoSets, int lottoSetsSize) {
		this.lottoSets = lottoSets;
		this.lottoSetsSize = lottoSetsSize;
	}

	public List<List<Integer>> getLottoSets() {
		return lottoSets;
	}

	public int getLottoSetsSize() {
		return lottoSetsSize;
	}
}
