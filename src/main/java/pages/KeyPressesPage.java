package pages;

import helper.BasePage;

/**
 * Created by anna.r.petrosyan on 1/22/2018.
 */
public class KeyPressesPage extends BasePage {


    public KeyPressesPage(){
        get(getUrl());
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/key_presses" ;
    }

    public void pressOnKey(String keyName) {
    }
}
