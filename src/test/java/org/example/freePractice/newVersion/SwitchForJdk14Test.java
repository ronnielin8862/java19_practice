package org.example.freePractice.newVersion;

import org.junit.jupiter.api.Test;

class SwitchForJdk14Test {

    @Test
    void switchJdk14() {
        SwitchForJdk14 switchForJdk14 = new SwitchForJdk14();
        switchForJdk14.trySwitch();
        System.out.println("==========");
        switchForJdk14.newSwitchAndTextBlock(11);
        System.out.println("==========");
        switchForJdk14.newSwitchAndYield(14);
        switchForJdk14.newSwitchAndYield(10);
        switchForJdk14.newSwitchAndYield(13);

    }

}