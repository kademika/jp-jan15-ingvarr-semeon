package com.kademika.day10.reflection;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(JUnit4.class)
public class ClassReflectionTests {

    ClassReflection classReflection = new ClassReflection();
    List list1 = new ArrayList();
    List list2 = new ArrayList();
    Map map = new HashMap<String, Object>();

    @Before
    public void init() {
        list1.add("TestName");
        list1.add(1.0);
        list1.add(2015);
        list2.add("TestNick");
        list2.add(8);
        map.put("name", "DemoClass"); //private
        map.put("version", 1.0); //private
        map.put("prodactionYear", 2015); //private
        map.put("nickName", "DemoNick"); //public
        map.put("score", 7); //public
    }

    @Test
    public void initClassTest3Fields() throws InvocationTargetException, NoSuchMethodException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        Object inst = classReflection.initClass(DemoClass.class, list1);
        Assert.assertNotNull(inst);
    }

    @Test
    public void initClassTest2Fields() throws InvocationTargetException, NoSuchMethodException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        Object inst = classReflection.initClass(DemoClass.class, list2);
        Assert.assertNotNull(inst);
    }

    @Test
    public void setPrivatesTest() throws NoSuchFieldException, IllegalAccessException {
        classReflection.setPrivates(new DemoClass(), map);
        Object [] expected = map.values().toArray();
        Object [] actual = classReflection.getClass().getDeclaredFields();

//        Field[] fields = classReflection.getClass().getDeclaredFields();
//        for (int i = 0, j = 0; i < fields.length; i++, j++) {
//            actual[j] = fields[i].get(fields[i]);
//        }

        Assert.assertArrayEquals(expected, actual); //Why actual.length = 0 ?
    }
}
