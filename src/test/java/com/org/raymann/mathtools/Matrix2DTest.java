package com.org.raymann.mathtools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Matrix2DTest {
    private Matrix2D m;

    @Test
    public void givenNullMatrixWhenItIsCreatedThenIsZeroInit() {
        Float f = 0.f;
        m = Matrix2D.create(Vec2.create(), Vec2.create());
        assertEquals(m.get(0, 0), f);
        assertEquals(m.get(0, 1), f);
        assertEquals(m.get(1, 0), f);
        assertEquals(m.get(1, 1), f);
    }

    @Test
    public void givenNullMatrixWhenIndexIsWrongThenItThrows() {
        Float f = 5.f;
        m = Matrix2D.create();
        IndexOutOfBoundsException exc1 = assertThrows(IndexOutOfBoundsException.class,
                () -> {m.set(-1, 0, f);});
        assertEquals(IndexOutOfBoundsException.class, exc1.getClass());
        IndexOutOfBoundsException exc2 = assertThrows(IndexOutOfBoundsException.class,
                () -> {m.set(2, 0, f);});
        assertEquals(IndexOutOfBoundsException.class, exc2.getClass());
        IndexOutOfBoundsException exc3 = assertThrows(IndexOutOfBoundsException.class,
                () -> {m.set(0, 2, f);});
        assertEquals(IndexOutOfBoundsException.class, exc3.getClass());
    }

    @Test
    public void givenNotNullMatrixWhenElementsAreSetThenAreReturnedCorrectly() {
        Float f = 5.f;
        m = Matrix2D.create();
        m.set(0, 1, f);
        m.set(1, 0, f);
        assertEquals(m.get(0, 1), f);
        assertEquals(m.get(1, 0), f);
    }

    @Test
    public void givenTwoMatricesWhenAddedThenResultIsCorrect() {
        Float f1 = 3.14f;
        Float f2 = -9.45f;
        m = Matrix2D.create();
        Matrix2D mr = Matrix2D.create(Vec2.create(f1, f2), Vec2.create(f2, f1));
        Matrix2D ms = m.plus(mr);
        assertEquals(ms.get(0,0), f1);
        assertEquals(ms.get(0,1), f2);
        assertEquals(ms.get(1,0), f2);
        assertEquals(ms.get(1,1), f1);
    }

    @Test
    public void givenTwoMatricesWhenSubtractedThenResultIsCorrect() {
        Float f1 = 3.14f;
        Float f2 = -9.45f;
        m = Matrix2D.create();
        Matrix2D mr = Matrix2D.create(Vec2.create(f1, f2), Vec2.create(f2, f1));
        Matrix2D ms = m.minus(mr);
        assertEquals(ms.get(0,0), -f1);
        assertEquals(ms.get(0,1), -f2);
        assertEquals(ms.get(1,0), -f2);
        assertEquals(ms.get(1,1), -f1);
    }

    @Test
    public void givenTwoMatricesWhenMultipliedThenResultIsCorrect() {
        m = Matrix2D.create(Vec2.create(1.36f, 1.28f), Vec2.create(1.5f, 0.f));
        Matrix2D mr = Matrix2D.create(Vec2.create(9.f, -5.8f), Vec2.create(-6.5f, 5.3f));
        Matrix2D mp = m.times(mr);
        Float f1 = 3.92f;
        Float f2 = -1.104f;
        Float f3 = 13.5f;
        Float f4 = -8.7f;
        assertTrue(Math.abs(mp.get(0,0) - f1) < Constants.EPSILON);
        assertTrue(Math.abs(mp.get(0,1) - f2) < Constants.EPSILON);
        assertTrue(Math.abs(mp.get(1,0) - f3) < Constants.EPSILON);
        assertTrue(Math.abs(mp.get(1,1) - f4) < Constants.EPSILON);
    }
}