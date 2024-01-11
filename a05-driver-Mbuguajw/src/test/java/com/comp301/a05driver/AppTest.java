package com.comp301.a05driver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        Vehicle v = new VehicleImpl("make", "model", "789", new PositionImpl(1, 1));
        Driver a = new DriverImpl("a", "A", 123, v);
        Vehicle w = new VehicleImpl("make", "model", "789", new PositionImpl(2, 2));
        Driver b = new DriverImpl("b", "B", 123, w);
        Vehicle x = new VehicleImpl("make", "model", "789", new PositionImpl(3, 3));
        Driver c = new DriverImpl("c", "C", 123, x);
        Vehicle y = new VehicleImpl("make", "model", "789", new PositionImpl(4, 4));
        Driver d = new DriverImpl("d", "D", 123, y);
        ArrayList<Driver> iterator = new ArrayList();
        iterator.add(a);
        iterator.add(b);
        iterator.add(c);
        iterator.add(d);

        Iterable<Driver> yes = iterator;

        ExpandingProximityIterator test = new ExpandingProximityIterator(yes, new PositionImpl(0, 0), 1);
        System.out.println(test.next());
        System.out.println(test.next());
        System.out.println(test.next());
        System.out.println(test.next());

        assertFalse( test.hasNext() );
    }
}
