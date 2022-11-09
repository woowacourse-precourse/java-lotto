package lotto.system;

import java.util.List;

import lotto.system.holder.ConverterHolder;
import lotto.system.holder.ValidationHolder;

public class LottoApplication {
	public void run() {
		doSetting();
		doAfter();
	}

	private void doSetting() {
		initializeValidators();
	}

	private void initializeValidators() {
		ValidationHolder.initializeValidators(List.of());
		ConverterHolder.initializeConverters(List.of());
	}

	private void doAfter() {

	}
}
