package com.org.raymann.mathtools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vec2Test {
    private Vec2 v;

    @Test
    public void givenNullVectorWhenIsCreatedThenItIsZeroInitialized() {
        v = Vec2.create();
        assertEquals(0.f, v.x());
        assertEquals(0.f, v.y());
    }

    @Test
    public void givenNotNullVectorWhenCoordsAreSetThenTheyAreCorrect() {
        v = Vec2.create();
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
        v = Vec2.create();
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
        v = Vec2.create();
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
        v = Vec2.create();
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
        v = Vec2.create(1.f, 0.f);
        Vec2 u = v.times(5.f);
        assertEquals(5.f, u.x());
        assertEquals(0.f, u.y());
    }

    @Test
    public void givenNotNullVectorWhenNormalVecIsReturnedThenItIsCorrect() {
        v = Vec2.create(4.53f, 93.5f);
        Vec2 u = v.normalVector();
        assertEquals(1.f, u.length());
    }

    @Test
    public void givenTwoVectorsWhenAddedThenResultIsCorrect() {
        v = Vec2.create(1.45f, -10.55f);
        Vec2 u = Vec2.create(-55.2f, 40.48f);
        Vec2 w = v.plus(u);
        assertEquals(-53.75f, w.x());
        assertEquals(29.93f, w.y());

    }

    @Test
    public void givenTwoVectorsWhenSubtractedThenResultIsCorrect() {
        v = Vec2.create();
        Vec2 u = Vec2.create(5.f, -45.f);
        Vec2 w = v.minus(u);
        assertEquals(-5.f, w.x());
        assertEquals(45.f, w.y());
    }

    @Test
    public void givenTwoVectorsWhenMultipliedThenResultIsCorrect() {
        v = Vec2.create(3.f, -5.f);
        Vec2 u = Vec2.create(6.f, -3.f);
        Vec2 w = v.times(u);
        assertEquals(18.f, w.x());
        assertEquals(15.f, w.y());
    }

    @Test
    public void givenTwoVectorsWhenDotProductIsReturnedThenResultIsCorrect() {
        v = Vec2.create(3.f, 3.f);
        Vec2 u = Vec2.create(3.f, 3.f);
        assertEquals(18.f, v.dot(u));
        v.setX(-1.f);
        v.setY(5.f);
        u.setX(-3.f);
        u.setY(3.f);
        assertEquals(18.f, v.dot(u));
    }

    @Test
    public void givenTwoVectorsWhenComparedThenResultIsCorrect() {
        v = Vec2.create(4.43f, 43.f);
        Vec2 u = Vec2.create(4.43f, 43.f);
        assertTrue(v.equals(u));
    }
}