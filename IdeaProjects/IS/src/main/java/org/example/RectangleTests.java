package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleTests {

    @Test
    public void testCalculateRectangleArea() {
        assertEquals(12.0, Rectangle.calculateRectangleArea(3, 4));
    }

    @Test
    public void testCalculateRectangleAreaWithInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rectangle.calculateRectangleArea(-3, 4);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Rectangle.calculateRectangleArea(3, -4);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Rectangle.calculateRectangleArea(0, 4);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Rectangle.calculateRectangleArea(3, 0);
        });
    }
}