package lotto.system.converter;

import lotto.dto.WinningInfoDto;
import lotto.system.holder.ValidationHolder;
import lotto.vo.WinningInfo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningDtoToWinningConverter implements Converter {
    @Override
    public boolean supports(Object target, Class<?> to) {
        return target.getClass() == WinningInfoDto.class && to == WinningInfo.class;
    }

    @Override
    public Object convert(Object target) {
        ValidationHolder.validate(target, WinningInfo.class);
        WinningInfoDto winningInfoDto = (WinningInfoDto) target;

        List<Integer> winning = Arrays.stream(winningInfoDto.getWinningNumbers()
                        .replace(" ", "")
                        .split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int bonus = Integer.parseInt(winningInfoDto.getBonus());

        return new WinningInfo(winning, bonus);
    }
}
