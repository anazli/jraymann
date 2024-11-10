package com.org.raymann.mathtools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vec2Test {
    private Vec2 v;

    @Test
    public void givenNullVectorWhenIsCreatedThenItIsZeroInitialized() {
        v = Vec2.create();
        assertEquals(v.x(), 0.f);
        assertEquals(v.y(), 0.f);
    }

    @Test
    public void givenNotNullVectorWhenCoordsAreSetThenTheyAreCorrect() {
        v = Vec2.create();
        v.setX(5.f);
        v.setY(6.f);
        assertEquals(v.x(), 5.f);
        assertEquals(v.y(), 6.f);
        v.setAll(-13.f);
        assertEquals(v.x(), -13.f);
        assertEquals(v.y(), -13.f);
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
        assertEquals(v.x(), 5.f);
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
        assertEquals(v.get(0), 5.f);
    }

    @Test
    public void givenNotNullVectorWhenLengthIsReturnedThenItIsCorrect() {
        v = Vec2.create();
        assertEquals(v.length(), 0.f);
        v.setAll(1.f);
        assertEquals(v.length(), (float) Math.sqrt(2.f));
        v.setAll(3.f);
        assertEquals(v.length(), (float)Math.sqrt(18.f));
        v.setAll(5.f);
        assertEquals(v.length(), (float)Math.sqrt(50.f));
    }

    @Test
    public void givenNotNullVectorWhenMultipliedWithFloatThenItIsCorrect() {
        v = Vec2.create(1.f, 0.f);
        Vec2 u = v.times(5.f);
        assertEquals(u.x(), 5.f);
        assertEquals(u.y(), 0.f);
    }

    @Test
    public void givenNotNullVectorWhenNormalVecIsReturnedThenItIsCorrect() {
        v = Vec2.create(4.53f, 93.5f);
        Vec2 u = v.normalVector();
        assertEquals(u.length(), 1.f);
    }

    @Test
    public void givenTwoVectorsWhenAddedThenResultIsCorrect() {
        v = Vec2.create(1.45f, -10.55f);
        Vec2 u = Vec2.create(-55.2f, 40.48f);
        Vec2 w = v.plus(u);
        assertEquals(w.x(), -53.75f);
        assertEquals(w.y(), 29.93f);

    }

    @Test
    public void givenTwoVectorsWhenSubtractedThenResultIsCorrect() {
        v = Vec2.create();
        Vec2 u = Vec2.create(5.f, -45.f);
        Vec2 w = v.minus(u);
        assertEquals(w.x(), -5.f);
        assertEquals(w.y(), 45.f);
    }

    @Test
    public void givenTwoVectorsWhenMultipliedThenResultIsCorrect() {
        v = Vec2.create(3.f, -5.f);
        Vec2 u = Vec2.create(6.f, -3.f);
        Vec2 w = v.times(u);
        assertEquals(w.x(), 18.f);
        assertEquals(w.y(), 15.f);
    }

    @Test
    public void givenTwoVectorsWhenDotProductIsReturnedThenResultIsCorrect() {
        v = Vec2.create(3.f, 3.f);
        Vec2 u = Vec2.create(3.f, 3.f);
        assertEquals(v.dot(u), 18.f);
        v.setX(-1.f);
        v.setY(5.f);
        u.setX(-3.f);
        u.setY(3.f);
        assertEquals(v.dot(u), 18.f);
    }

    @Test
    public void givenTwoVectorsWhenComparedThenResultIsCorrect() {
        v = Vec2.create(4.43f, 43.f);
        Vec2 u = Vec2.create(4.43f, 43.f);
        assertTrue(v.equals(u));
    }
}