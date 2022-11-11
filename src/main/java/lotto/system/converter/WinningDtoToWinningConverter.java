package lotto.system.converter;

import lotto.dto.WinningDto;
import lotto.system.holder.ValidationHolder;
import lotto.vo.Winning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningDtoToWinningConverter implements Converter {
    @Override
    public boolean supports(Object target, Class<?> to) {
        return target.getClass() == WinningDto.class && to == Winning.class;
    }

    @Override
    public Object convert(Object target) {
        ValidationHolder.validate(target, Winning.class);
        WinningDto winningDto = (WinningDto) target;

        List<Integer> winning = Arrays.stream(winningDto.getWinning()
                        .replace(" ", "")
                        .split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int bonus = Integer.parseInt(winningDto.getBonus());

        return new Winning(winning, bonus);
    }
}
