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

        List<Integer> winningNumbers = convertStringToIntegerList(winningInfoDto);
        int bonus = convertStringToInteger(winningInfoDto);

        return new WinningInfo(winningNumbers, bonus);
    }

    private static int convertStringToInteger(WinningInfoDto winningInfoDto) {
        return Integer.parseInt(winningInfoDto.getBonus());
    }

    private static List<Integer> convertStringToIntegerList(WinningInfoDto winningInfoDto) {
        return Arrays.stream(winningInfoDto.getWinningNumbers()
                        .replace(" ", "")
                        .split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
