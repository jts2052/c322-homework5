package edu.iu.habahram.coffeeorder;

import edu.iu.habahram.coffeeorder.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HouseBlendTests {
    Beverage houseBlend;
    @BeforeEach
    void setUp() {
        houseBlend = new HouseBlend();
    }

    @Test
    public void testWithMilk() {
        houseBlend = new Milk(houseBlend);
        assertEquals(2.05f, houseBlend.cost(), 0.01f);
        assertEquals("House Blend, Milk", houseBlend.getDescription());
    }

    @Test
    public void testWithMocha() {
        houseBlend = new Mocha(houseBlend);
        assertEquals(1.95f, houseBlend.cost(), 0.01f);
        assertEquals("House Blend, Mocha", houseBlend.getDescription());
    }

    @Test
    public void testWithSoy() {
        houseBlend = new Soy(houseBlend);
        assertEquals(1.92f, houseBlend.cost(), 0.01f);
        assertEquals("House Blend, Soy", houseBlend.getDescription());
    }

    @Test
    public void testWithWhip() {
        houseBlend = new Whip(houseBlend);
        assertEquals(1.90f, houseBlend.cost(), 0.01f);
        assertEquals("House Blend, Whip", houseBlend.getDescription());
    }
}
