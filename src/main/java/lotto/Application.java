package lotto;


import lotto.view.DefaultView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ApplicationContext context = ApplicationContext.getContext();
        DefaultView view = context.getView();

        view.render();
    }
}
