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
		String targetCommaRemoved = ((String) target).replaceAll(",", "");
		int money = Integer.parseInt(targetCommaRemoved);
		return new LottoAmount(money, money / 1000);
	}
}
