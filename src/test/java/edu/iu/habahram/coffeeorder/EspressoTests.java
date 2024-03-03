package edu.iu.habahram.coffeeorder;

import edu.iu.habahram.coffeeorder.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EspressoTests {
    Beverage espresso;
    @BeforeEach
    void setUp() {
        espresso = new Espresso();
    }

    @Test
    public void testWithMilk() {
        espresso = new Milk(espresso);
        assertEquals(1.74f, espresso.cost(), 0.01f);
        assertEquals("Espresso, Milk", espresso.getDescription());
    }

    @Test
    public void testWithMocha() {
        espresso = new Mocha(espresso);
        assertEquals(1.64f, espresso.cost(), 0.01f);
        assertEquals("Espresso, Mocha", espresso.getDescription());
    }

    @Test
    public void testWithSoy() {
        espresso = new Soy(espresso);
        assertEquals(1.61f, espresso.cost(), 0.01f);
        assertEquals("Espresso, Soy", espresso.getDescription());
    }

    @Test
    public void testWithWhip() {
        espresso = new Whip(espresso);
        assertEquals(1.59f, espresso.cost(), 0.01f);
        assertEquals("Espresso, Whip", espresso.getDescription());
    }
}
