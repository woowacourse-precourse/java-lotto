package lotto.system.converter;

import lotto.system.holder.ValidationHolder;
import lotto.vo.LottoBuyingInfo;

public class StringToLottoBuyingInfoConverter implements Converter {
	@Override
	public boolean supports(Object target, Class<?> to) {
		return target.getClass() == String.class && to == LottoBuyingInfo.class;
	}

	@Override
	public Object convert(Object target) {
		ValidationHolder.validate(target, LottoBuyingInfo.class);
		int money = Integer.parseInt(removeCommaFrom((String) target));
		ValidationHolder.validate(money, LottoBuyingInfo.class);
		return new LottoBuyingInfo(money, money / 1000);
	}

	private static String removeCommaFrom(String target) {
		return target.replaceAll(",", "");
	}
}
