package com.org.raymann.mathtools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Matrix2DTest {
    private Matrix2D m;

    @Test
    public void givenNullMatrixWhenItIsCreatedThenIsZeroInit() {
        Float f = 0.f;
        m = Matrix2D.create(Vec2.create(), Vec2.create());
        assertEquals(f, m.get(0, 0));
        assertEquals(f, m.get(0, 1));
        assertEquals(f, m.get(1, 0));
        assertEquals(f, m.get(1, 1));
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
        assertEquals(f, m.get(0, 1));
        assertEquals(f, m.get(1, 0));
    }

    @Test
    public void givenTwoMatricesWhenAddedThenResultIsCorrect() {
        Float f1 = 3.14f;
        Float f2 = -9.45f;
        m = Matrix2D.create();
        Matrix2D mr = Matrix2D.create(Vec2.create(f1, f2), Vec2.create(f2, f1));
        Matrix2D ms = m.plus(mr);
        assertEquals(f1, ms.get( 0,0));
        assertEquals(f2, ms.get( 0,1));
        assertEquals(f2, ms.get( 1,0));
        assertEquals(f1, ms.get( 1,1));
    }

    @Test
    public void givenTwoMatricesWhenSubtractedThenResultIsCorrect() {
        Float f1 = 3.14f;
        Float f2 = -9.45f;
        m = Matrix2D.create();
        Matrix2D mr = Matrix2D.create(Vec2.create(f1, f2), Vec2.create(f2, f1));
        Matrix2D ms = m.minus(mr);
        assertEquals(-f1, ms.get(0,0));
        assertEquals(-f2, ms.get(0,1));
        assertEquals(-f2, ms.get(1,0));
        assertEquals(-f1, ms.get(1,1));
    }

    @Test
    public void givenNotNullMatrixWhenDeterminantIsCalculatedTheItIsCorrect() {
        m = Matrix2D.create(Vec2.create(5.36f, 2.28f), Vec2.create(-1.5f, 85.f));
        assertEquals(459.02002f, m.determinant(), Constants.EPSILON);

    }

    @Test
    public void givenTwoMatricesWhenMultipliedThenResultIsCorrect() {
        m = Matrix2D.create(Vec2.create(1.36f, 1.28f), Vec2.create(1.5f, 0.f));
        Matrix2D mr = Matrix2D.create(Vec2.create(9.f, -5.8f), Vec2.create(-6.5f, 5.3f));
        Matrix2D mp = m.times(mr);
        float f1 = 3.92f;
        float f2 = -1.104f;
        float f3 = 13.5f;
        float f4 = -8.7f;
        assertEquals(f1, mp.get(0,0), Constants.EPSILON);
        assertEquals(f2, mp.get(0,1), Constants.EPSILON);
        assertEquals(f3, mp.get(1,0), Constants.EPSILON);
        assertEquals(f4,mp.get(1,1), Constants.EPSILON);
    }
}