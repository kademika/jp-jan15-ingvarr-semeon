package com.kademika.day10.junit;

import static org.junit.Assert.*; //This static import allows do not write: Assert.<testMethod>
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CatTests {

    private Cat cat;

    @Before //Thanks to this annotation the method init() will be launched 3 times
    public void init() {
        cat = new Cat();
    }

    @Test
    public void checkCatNameDefaultValue() {
        assertNull("Default name of cat should be null", cat.getName());
    }

    @Test
    public void checkCatWeigthDefaultValue() {
        assertTrue("Default weigth of cat should be 0.0", cat.getWeigth() == 0.0);
    }

    @Test
    public void checkCatIsHungryDefaultValue() {
        assertTrue("Cat should be hungry by default", cat.isHungry());
    }
}
