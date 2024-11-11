package com.org.raymann.mathtools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2DTest {
    private Vector2D v;

    @Test
    public void givenNullVectorWhenIsCreatedThenItIsZeroInitialized() {
        v = Vector2D.create();
        assertEquals(0.f, v.x());
        assertEquals(0.f, v.y());
    }

    @Test
    public void givenNotNullVectorWhenCoordsAreSetThenTheyAreCorrect() {
        v = Vector2D.create();
        v.setX(5.f);
        v.setY(6.f);
        assertEquals(5.f, v.x());
        assertEquals(6.f, v.y());
        v.setAll(-13.f);
        assertEquals(-13.f, v.x());
        assertEquals(-13.f, v.y());
    }

    @Test
    public void givenNotNullVectorWhenIndexIsProvidedThenValueIsSetCorrectly() {
        v = Vector2D.create();
        IndexOutOfBoundsException exc1 = assertThrows(IndexOutOfBoundsException.class,
                () -> {v.set(-1, 5.f);});
        assertEquals(IndexOutOfBoundsException.class, exc1.getClass());
        IndexOutOfBoundsException exc2 = assertThrows(IndexOutOfBoundsException.class,
                () -> {v.set(2, 5.f);});
        assertEquals(IndexOutOfBoundsException.class, exc2.getClass());
        v.set(0, 5.f);
        assertEquals(5.f, v.x());
    }

    @Test
    public void givenNotNullVectorWhenIndexIsProvidedThenValueIsReturnedCorrectly() {
        v = Vector2D.create();
        IndexOutOfBoundsException exc1 = assertThrows(IndexOutOfBoundsException.class,
                () -> {v.set(-1, 5.f);});
        assertEquals(IndexOutOfBoundsException.class, exc1.getClass());
        IndexOutOfBoundsException exc2 = assertThrows(IndexOutOfBoundsException.class,
                () -> {v.set(2, 5.f);});
        assertEquals(IndexOutOfBoundsException.class, exc2.getClass());
        v.setX(5.f);
        assertEquals(5.f, v.get(0));
    }

    @Test
    public void givenNotNullVectorWhenLengthIsReturnedThenItIsCorrect() {
        v = Vector2D.create();
        assertEquals(0.f, v.length());
        v.setAll(1.f);
        assertEquals((float) Math.sqrt(2.f), v.length());
        v.setAll(3.f);
        assertEquals((float)Math.sqrt(18.f), v.length());
        v.setAll(5.f);
        assertEquals((float)Math.sqrt(50.f), v.length());
    }

    @Test
    public void givenNotNullVectorWhenMultipliedWithFloatThenItIsCorrect() {
        v = Vector2D.create(1.f, 0.f);
        Vector2D u = v.times(5.f);
        assertEquals(5.f, u.x());
        assertEquals(0.f, u.y());
    }

    @Test
    public void givenNotNullVectorWhenNormalVecIsReturnedThenItIsCorrect() {
        v = Vector2D.create(4.53f, 93.5f);
        Vector2D u = v.normalVector();
        assertEquals(1.f, u.length());
    }

    @Test
    public void givenTwoVectorsWhenAddedThenResultIsCorrect() {
        v = Vector2D.create(1.45f, -10.55f);
        Vector2D u = Vector2D.create(-55.2f, 40.48f);
        Vector2D w = v.plus(u);
        assertEquals(-53.75f, w.x());
        assertEquals(29.93f, w.y());

    }

    @Test
    public void givenTwoVectorsWhenSubtractedThenResultIsCorrect() {
        v = Vector2D.create();
        Vector2D u = Vector2D.create(5.f, -45.f);
        Vector2D w = v.minus(u);
        assertEquals(-5.f, w.x());
        assertEquals(45.f, w.y());
    }

    @Test
    public void givenTwoVectorsWhenMultipliedThenResultIsCorrect() {
        v = Vector2D.create(3.f, -5.f);
        Vector2D u = Vector2D.create(6.f, -3.f);
        Vector2D w = v.times(u);
        assertEquals(18.f, w.x());
        assertEquals(15.f, w.y());
    }

    @Test
    public void givenTwoVectorsWhenDotProductIsReturnedThenResultIsCorrect() {
        v = Vector2D.create(3.f, 3.f);
        Vector2D u = Vector2D.create(3.f, 3.f);
        assertEquals(18.f, v.dot(u));
        v.setX(-1.f);
        v.setY(5.f);
        u.setX(-3.f);
        u.setY(3.f);
        assertEquals(18.f, v.dot(u));
    }

    @Test
    public void givenTwoVectorsWhenComparedThenResultIsCorrect() {
        v = Vector2D.create(4.43f, 43.f);
        Vector2D u = Vector2D.create(4.43f, 43.f);
        assertTrue(v.equals(u));
    }
}