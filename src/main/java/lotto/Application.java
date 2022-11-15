package lotto;


import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ApplicationContext context = ApplicationContext.getContext();
        View view = context.getView();

        view.render();
    }
}
