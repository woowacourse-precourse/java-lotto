package lotto.view;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
import lotto.dto.input.ReadBonusNumberDto;
import lotto.dto.input.ReadPlayerPurchaseAmountDto;
import lotto.dto.input.ReadWinningLottoDto;
import lotto.dto.output.PrintLottoDto;
import lotto.dto.output.PrintLottoResultDto;
import lotto.view.exception.NotFoundViewException;

public class IOViewResolver {

    private final Map<Class<?>, Consumer<Object>> outputViewMappings = new HashMap<>();
    private final Map<Class<?>, Supplier<Object>> inputViewMappings = new HashMap<>();

    public IOViewResolver(InputView inputView, OutputView outputView) {
        initInputViewMappings(inputView);
        initOutputViewMappings(outputView);
    }

    private void initInputViewMappings(InputView inputView) {
        inputViewMappings.put(ReadBonusNumberDto.class, inputView::readBonusNumber);
        inputViewMappings.put(ReadPlayerPurchaseAmountDto.class, inputView::readPlayerPurchaseAmount);
        inputViewMappings.put(ReadWinningLottoDto.class, inputView::readWinningLotto);
    }

    private void initOutputViewMappings(final OutputView outputView) {
        outputViewMappings.put(PrintLottoDto.class, dto -> outputView.printLotto((PrintLottoDto) dto));
        outputViewMappings.put(PrintLottoResultDto.class, dto -> outputView
                .printLottoResult((PrintLottoResultDto) dto));
    }

    public <T> T inputViewResolve(final Class<T> type) {
        try {
            return type.cast(inputViewMappings.get(type).get());
        } catch (NullPointerException e) {
            throw new NotFoundViewException();
        }
    }

    public void outputViewResolve(final Object dto) {
        try {
            outputViewMappings.get(dto.getClass()).accept(dto);
        } catch (NullPointerException e) {
            throw new NotFoundViewException();
        }
    }
}
