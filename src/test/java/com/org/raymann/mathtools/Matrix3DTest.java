package com.org.raymann.mathtools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Matrix3DTest {
    private Matrix3D m;
    private static final float eps = Constants.EPSILON;

    @Test
    public void givenNullMatrixWhenItIsCreatedThenIsZeroInit() {
        Float f = 0.f;
        m = Matrix3D.create(Vector3D.create(), Vector3D.create(), Vector3D.create());
        assertEquals(m.get(0, 0), f);
        assertEquals(m.get(0, 1), f);
        assertEquals(m.get(0, 2), f);
        assertEquals(m.get(1, 0), f);
        assertEquals(m.get(1, 1), f);
        assertEquals(m.get(1, 2), f);
        assertEquals(m.get(2, 0), f);
        assertEquals(m.get(2, 1), f);
        assertEquals(m.get(2, 2), f);
    }

    @Test
    public void givenNullMatrixWhenIndexIsWrongThenItThrows() {
        Float f = 5.f;
        m = Matrix3D.create();
        IndexOutOfBoundsException exc1 = assertThrows(IndexOutOfBoundsException.class,
                () -> {m.set(-1, 0, f);});
        assertEquals(IndexOutOfBoundsException.class, exc1.getClass());
        IndexOutOfBoundsException exc2 = assertThrows(IndexOutOfBoundsException.class,
                () -> {m.set(3, 0, f);});
        assertEquals(IndexOutOfBoundsException.class, exc2.getClass());
        IndexOutOfBoundsException exc3 = assertThrows(IndexOutOfBoundsException.class,
                () -> {m.set(0, 3, f);});
        assertEquals(IndexOutOfBoundsException.class, exc3.getClass());
    }

    @Test
    public void givenNotNullMatrixWhenElementsAreSetThenAreReturnedCorrectly() {
        float f = 5.f;
        m = Matrix3D.create();
        m.set(0, 2, f);
        m.set(2, 0, f);
        m.set(2, 2, f);
        assertEquals(f, m.get(0, 2), f);
        assertEquals(f, m.get(2, 0), f);
        assertEquals(f, m.get(2, 2), f);
        assertEquals(0.f, m.get(0, 0));
    }

    @Test
    public void givenTwoMatricesWhenAddedThenResultIsCorrect() {
        m = Matrix3D.create(Vector3D.create(1.36f, 1.28f, 1.f),
                            Vector3D.create(1.5f, 0.f, -1.f),
                            Vector3D.create(6.3f, 0.5f, 0.8f));

        Matrix3D mr = Matrix3D.create(Vector3D.create(9.f, -5.8f, 0.f),
                                      Vector3D.create(-6.5f, 5.3f, -1.5f),
                                      Vector3D.create(-5.f, 0.4f, 90.f));

        Matrix3D ms = m.plus(mr);

        assertEquals(10.36f, ms.get(0,0), eps);
        assertEquals(-4.52f, ms.get(0,1), eps);
        assertEquals(1.f, ms.get(0,2), eps);

        assertEquals(-5.f, ms.get(1,0), eps);
        assertEquals(5.3f, ms.get(1,1), eps);
        assertEquals(-2.5f, ms.get(1,2), eps);

        assertEquals(1.3f, ms.get(2,0), eps);
        assertEquals(0.9f, ms.get(2,1), eps);
        assertEquals(90.8f, ms.get(2,2), eps);
    }

    @Test
    public void givenTwoMatricesWhenMultipliedThenResultIsCorrect() {
        m = Matrix3D.create(Vector3D.create(1.36f, 1.28f, 0.85f),
                Vector3D.create(1.5f, 0.f, -6.58f),
                Vector3D.create(4.5f, 0.f, -3.f));

        Matrix3D mr = Matrix3D.create(Vector3D.create(9.f, -5.8f, -4.5f),
                Vector3D.create(-6.5f, 5.3f, 20.f),
                Vector3D.create(8.6f, 33.f, -5.f));

        Matrix3D ms = m.times(mr);

        assertEquals(11.23f, ms.get(0,0), eps);
        assertEquals(26.946f, ms.get(0,1), eps);
        assertEquals(15.23f, ms.get(0,2), eps);

        assertEquals(-43.088f, ms.get(1,0), eps);
        assertEquals(-225.84f, ms.get(1,1), eps);
        assertEquals(26.15f, ms.get(1,2), eps);

        assertEquals(14.7f, ms.get(2,0), eps);
        assertEquals(-125.1f, ms.get(2,1), eps);
        assertEquals(-5.25f, ms.get(2,2), eps);
    }

    @Test
    public void givenNotNullMatrixWhenTransposeIsReturnedThenItIsCorrect() {
        m = Matrix3D.create(Vector3D.create(1.36f, 1.28f, 0.85f),
                Vector3D.create(1.5f, 0.f, -6.58f),
                Vector3D.create(4.5f, 0.f, -3.f));

        Matrix3D mt = m.transpose();

        assertEquals(1.36f, mt.get(0,0));
        assertEquals(1.5f, mt.get(0,1));
        assertEquals(4.5f, mt.get(0,2));

        assertEquals(1.28f, mt.get(1,0));
        assertEquals(0.f, mt.get(1,1));
        assertEquals(0.f, mt.get(1,2));

        assertEquals(0.85f, mt.get(2,0));
        assertEquals(-6.58f, mt.get(2,1));
        assertEquals(-3.f, mt.get(2,2));
    }
}