package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto{
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> lottoNumbers, Integer bonusNumber) {
	super(lottoNumbers);
	this.bonusNumber = bonusNumber;
    }
}
