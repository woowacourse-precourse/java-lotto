package lotto.system.converter;

import lotto.system.holder.ValidationHolder;
import lotto.vo.LottoBuyingInfo;

public class StringToLottoAmountConverter implements Converter {
	@Override
	public boolean supports(Object target, Class<?> to) {
		return target.getClass() == String.class && to == LottoBuyingInfo.class;
	}

	@Override
	public Object convert(Object target) {
		ValidationHolder.validate(target, LottoBuyingInfo.class);
		String targetCommaRemoved = ((String) target).replaceAll(",", "");
		int money = Integer.parseInt(targetCommaRemoved);
		return new LottoBuyingInfo(money, money / 1000);
	}
}
