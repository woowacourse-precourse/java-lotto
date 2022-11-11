package lotto.system.converter;

import lotto.system.holder.ValidationHolder;
import lotto.vo.LottoAmount;

public class StringToLottoAmountConverter implements Converter {
	@Override
	public boolean supports(Object target, Class<?> to) {
		return target.getClass() == String.class && to == LottoAmount.class;
	}

	@Override
	public Object convert(Object target) {
		ValidationHolder.validate(target, LottoAmount.class);
		target = ((String)target).replaceAll(",", "");
		return new LottoAmount(Integer.parseInt((String)target) / 1000);
	}
}
