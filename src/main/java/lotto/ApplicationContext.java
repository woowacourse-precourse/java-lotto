package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoGameService;
import lotto.view.DefaultView;

public class ApplicationContext {

    private static ApplicationContext context;

    private final LottoGameService service;
    private final LottoController controller;
    private final DefaultView view;

    public static ApplicationContext getContext() {
        if (context == null) {
            context = new ApplicationContext();
        }

        return context;
    }

    private ApplicationContext() {
        this.service = new LottoGameService();
        this.controller = new LottoController(this.service);
        this.view = new DefaultView(this.controller);
    }

    public LottoController getController() {
        return controller;
    }

    public LottoGameService getService() {
        return service;
    }

    public DefaultView getView() {
        return view;
    }
}
