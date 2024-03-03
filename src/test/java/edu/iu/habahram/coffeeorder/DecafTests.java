package edu.iu.habahram.coffeeorder;

import edu.iu.habahram.coffeeorder.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DecafTests {
    Beverage decaf;
    @BeforeEach
    void setUp() {
        decaf = new Decaf();
    }

    @Test
    public void testWithMilk() {
        decaf = new Milk(decaf);
        assertEquals(1.68f, decaf.cost(), 0.01f);
        assertEquals("Decaf, Milk", decaf.getDescription());
    }

    @Test
    public void testWithMocha() {
        decaf = new Mocha(decaf);
        assertEquals(1.58f, decaf.cost(), 0.01f);
        assertEquals("Decaf, Mocha", decaf.getDescription());
    }

    @Test
    public void testWithSoy() {
        decaf = new Soy(decaf);
        assertEquals(1.55f, decaf.cost(), 0.01f);
        assertEquals("Decaf, Soy", decaf.getDescription());
    }

    @Test
    public void testWithWhip() {
        decaf = new Whip(decaf);
        assertEquals(1.53f, decaf.cost(), 0.01f);
        assertEquals("Decaf, Whip", decaf.getDescription());
    }
}
