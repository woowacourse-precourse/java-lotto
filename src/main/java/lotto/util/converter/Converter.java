package lotto.util.converter;

import lotto.util.Validator;

import java.util.List;

@FunctionalInterface
public interface Converter<SRC, DEST> {

    default DEST convert(SRC input, List<Validator<SRC>> validators) {
        validators.forEach(v -> v.validate(input));
        return operate(input);
    }

    DEST operate(SRC input);
}
