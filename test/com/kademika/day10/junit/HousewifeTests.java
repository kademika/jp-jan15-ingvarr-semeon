package com.kademika.day10.junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class HousewifeTests {

    private Cat[] cats;
    private Housewife housewife;

    @Before //Thanks to this annotation the method init() will be launched 3 times
    public void init() {
        housewife = new Housewife();
        cats = new Cat[2];

        cats[0] = new Cat();
        cats[0].setName("Bobby");
        cats[1] = new Cat();
        cats[1].setName("Tommy");
    }

    @Test
    public void testFeed() {
        housewife.feed(cats);
        for (Cat cat : cats) {
            Assert.assertFalse(cat.isHungry());
        }
    }

    @Test(expected = CatNotHungryException.class) //Passing a parameter into annotation
    public void testCatNotHungryException() {
        cats[1].setName("Tommy2");
        cats[1].setHungry(false);

        housewife.feed(cats);
        for (Cat cat : cats) {
            Assert.assertFalse(cat.isHungry());
        }
    }
}
