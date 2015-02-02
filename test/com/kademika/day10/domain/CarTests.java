package com.kademika.day10.domain;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CarTests {

    private KIASportage kiaSportage;
    private NissanQashqai nissanQashqai;
    private Porshe911 porshe911;

    @Before
    public void init() {
        kiaSportage = new KIASportage();
        nissanQashqai = new NissanQashqai();

        porshe911 = new Porshe911();
        porshe911.enableSportMode();
    }

    @Test
    public void checkKIASportageIs4WDModeEnabled() {
        assertFalse("For SUV 4WD Mode should be disabled by default", kiaSportage.getIs4WDModeEnabled());
    }

    @Test
    public void checkNissanQashqaiIs4WDModeEnabled() {
        assertFalse("For SUV 4WD Mode should be disabled by default", nissanQashqai.getIs4WDModeEnabled());
    }

    @Test
    public void checkPorshe911IsSportModeEnabled() {
        assertTrue("For Sports car Sport Mode should be enabled by default", porshe911.getIsSportModeEnabled());
    }


}
