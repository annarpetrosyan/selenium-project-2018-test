package helper;

import org.openqa.selenium.support.ui.LoadableComponent;

public abstract class LoadableComponents extends BasePage {

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        System.out.println("Stex gri confitiony ");
    }
}
