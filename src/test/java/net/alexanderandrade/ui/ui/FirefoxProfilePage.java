/*
AlexanderAndrade.Net CONFIDENTIAL

Copyright (c) 2024. All Rights Reserved.

NOTICE: The source code contained or described herein and all documents
related to the source code ("Material") are owned by Alexander Andrade
or its companies, suppliers or licensors.

Dissemination of this information or reproduction of this material
is strictly forbidden unless prior written permission is obtained
from Alexander Andrade.
*/
package net.alexanderandrade.ui.ui;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("about:profiles")
public class FirefoxProfilePage extends PageObject {

    private FirefoxProfilePage() {
        super();
    }

    public static final Target REMOVE_BUTTON =
            Target.the("radio button {0}").locatedBy("//button[@text='Remove']");
}
