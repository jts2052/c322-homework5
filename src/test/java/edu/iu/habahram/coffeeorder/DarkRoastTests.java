package edu.iu.habahram.coffeeorder;

import edu.iu.habahram.coffeeorder.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DarkRoastTests {
    Beverage darkRoast;
    @BeforeEach
    void setUp() {
        darkRoast = new DarkRoast();
    }

    @Test
    public void testWithMilk() {
        darkRoast = new Milk(darkRoast);
        assertEquals(2.39f, darkRoast.cost(), 0.01f);
        assertEquals("Dark Roast, Milk", darkRoast.getDescription());
    }

    @Test
    public void testWithMocha() {
        darkRoast = new Mocha(darkRoast);
        assertEquals(2.29f, darkRoast.cost(), 0.01f);
        assertEquals("Dark Roast, Mocha", darkRoast.getDescription());
    }

    @Test
    public void testWithSoy() {
        darkRoast = new Soy(darkRoast);
        assertEquals(2.26f, darkRoast.cost(), 0.01f);
        assertEquals("Dark Roast, Soy", darkRoast.getDescription());
    }

    @Test
    public void testWithWhip() {
        darkRoast = new Whip(darkRoast);
        assertEquals(2.24f, darkRoast.cost(), 0.01f);
        assertEquals("Dark Roast, Whip", darkRoast.getDescription());
    }
}
