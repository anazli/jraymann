package com.org.raymann.mathtools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Matrix4DTest {
    private Matrix4D m;
    private static final float eps = Constants.EPSILON;

    @Test
    public void givenNullMatrixWhenItIsCreatedThenIsZeroInit() {
        Float f = 0.f;
        m = Matrix4D.create(Vec4.create(), Vec4.create(), Vec4.create(), Vec4.create());
        assertEquals(m.get(0, 0), f);
        assertEquals(m.get(0, 1), f);
        assertEquals(m.get(0, 2), f);
        assertEquals(m.get(1, 0), f);
        assertEquals(m.get(1, 1), f);
        assertEquals(m.get(1, 2), f);
        assertEquals(m.get(2, 0), f);
        assertEquals(m.get(2, 1), f);
        assertEquals(m.get(2, 2), f);
        assertEquals(m.get(3, 0), f);
        assertEquals(m.get(3, 1), f);
        assertEquals(m.get(3, 2), f);
    }

    @Test
    public void givenNullMatrixWhenIndexIsWrongThenItThrows() {
        Float f = 5.f;
        m = Matrix4D.create();
        IndexOutOfBoundsException exc1 = assertThrows(IndexOutOfBoundsException.class,
                () -> {m.set(-1, 0, f);});
        assertEquals(IndexOutOfBoundsException.class, exc1.getClass());
        IndexOutOfBoundsException exc2 = assertThrows(IndexOutOfBoundsException.class,
                () -> {m.set(4, 0, f);});
        assertEquals(IndexOutOfBoundsException.class, exc2.getClass());
        IndexOutOfBoundsException exc3 = assertThrows(IndexOutOfBoundsException.class,
                () -> {m.set(0, 4, f);});
        assertEquals(IndexOutOfBoundsException.class, exc3.getClass());
    }

    @Test
    public void givenNotNullMatrixWhenElementsAreSetThenAreReturnedCorrectly() {
        float f = 5.f;
        m = Matrix4D.create();
        m.set(0, 2, f);
        m.set(2, 0, f);
        m.set(2, 2, f);
        m.set(3, 3, f);
        m.set(3, 0, f);
        assertEquals(f, m.get(0, 2), f);
        assertEquals(f, m.get(2, 0), f);
        assertEquals(f, m.get(2, 2), f);
        assertEquals(f, m.get(3, 3), f);
        assertEquals(f, m.get(3, 0), f);
        assertEquals(0.f, m.get(0, 0));
    }

    @Test
    public void givenTwoMatricesWhenAddedThenResultIsCorrect() {
        m = Matrix4D.create(Vec4.create(1.36f, 1.28f, 1.f, 0.f),
                            Vec4.create(1.5f, 0.f, -1.f, -2.f),
                            Vec4.create(6.3f, 0.5f, 0.8f, -6.f),
                            Vec4.create(0.5f, 3.38f, -2.f, 5.f));

        Matrix4D mr = Matrix4D.create(Vec4.create(9.f, -5.8f, 0.f, 0.f),
                                      Vec4.create(-6.5f, 5.3f, -1.5f, -2.5f),
                                      Vec4.create(-5.f, 0.4f, 90.f, 3.5f),
                                      Vec4.create(5.f, 0.4f, 0.5f, 3.5f));

        Matrix4D ms = m.plus(mr);

        assertEquals(10.36f, ms.get(0,0), eps);
        assertEquals(-4.52f, ms.get(0,1), eps);
        assertEquals(1.f, ms.get(0,2), eps);
        assertEquals(0.f, ms.get(0,3), eps);

        assertEquals(-5.f, ms.get(1,0), eps);
        assertEquals(5.3f, ms.get(1,1), eps);
        assertEquals(-2.5f, ms.get(1,2), eps);
        assertEquals(-4.5f, ms.get(1,3), eps);

        assertEquals(1.3f, ms.get(2,0), eps);
        assertEquals(0.9f, ms.get(2,1), eps);
        assertEquals(90.8f, ms.get(2,2), eps);
        assertEquals(-2.5f, ms.get(2,3), eps);

        assertEquals(5.5f, ms.get(3,0), eps);
        assertEquals(3.78f, ms.get(3,1), eps);
        assertEquals(-1.5f, ms.get(3,2), eps);
        assertEquals(8.5f, ms.get(3,3), eps);
    }

    @Test
    public void givenTwoMatricesWhenMultipliedThenResultIsCorrect() {
        m = Matrix4D.create(Vec4.create(1.36f, 1.28f, 0.85f, -1.f),
                Vec4.create(1.5f, 0.f, -6.58f, 0.f),
                Vec4.create(4.5f, 0.f, -3.f, 0.f),
                Vec4.create(5.8f, -3.4f, 0.f, -1.f));

        Matrix4D mr = Matrix4D.create(Vec4.create(9.f, -5.8f, -4.5f, -1.1f),
                                      Vec4.create(-6.5f, 5.3f, 20.f, 2.2f),
                                      Vec4.create(8.6f, 33.f, -5.f, -4.f),
                                      Vec4.create(0.f, -5.f, 8.f, -3.f));

        Matrix4D ms = m.times(mr);

        assertEquals(11.23f, ms.get(0,0), eps);
        assertEquals(31.946f, ms.get(0,1), eps);
        assertEquals(7.23f, ms.get(0,2), eps);
        assertEquals(0.92f, ms.get(0,3), eps);

        assertEquals(-43.088f, ms.get(1,0), eps);
        assertEquals(-225.84f, ms.get(1,1), eps);
        assertEquals(26.15f, ms.get(1,2), eps);
        assertEquals(24.67f, ms.get(1,3), eps);

        assertEquals(14.7f, ms.get(2,0), eps);
        assertEquals(-125.1f, ms.get(2,1), eps);
        assertEquals(-5.25f, ms.get(2,2), eps);
        assertEquals(7.05f, ms.get(2,3), eps);

        assertEquals(74.3f, ms.get(3,0), eps);
        assertEquals(-46.66f, ms.get(3,1), eps);
        assertEquals(-102.1f, ms.get(3,2), eps);
        assertEquals(-10.86f, ms.get(3,3), eps);
    }

    @Test
    public void givenNotNullMatrixWhenTransposeIsReturnedThenItIsCorrect() {
        m = Matrix4D.create(Vec4.create(1.36f, 1.28f, 0.85f, -1.f),
                            Vec4.create(1.5f, 0.f, -6.58f, -5.f),
                            Vec4.create(4.5f, 0.f, -3.f, 0.f),
                            Vec4.create(3.f, 4.f, 5.f, 6.f));

        Matrix4D mt = m.transpose();

        assertEquals(1.36f, mt.get(0,0));
        assertEquals(1.5f, mt.get(0,1));
        assertEquals(4.5f, mt.get(0,2));
        assertEquals(3.f, mt.get(0,3));

        assertEquals(1.28f, mt.get(1,0));
        assertEquals(0.f, mt.get(1,1));
        assertEquals(0.f, mt.get(1,2));
        assertEquals(4.f, mt.get(1,3));

        assertEquals(0.85f, mt.get(2,0));
        assertEquals(-6.58f, mt.get(2,1));
        assertEquals(-3.f, mt.get(2,2));
        assertEquals(5.f, mt.get(2,3));

        assertEquals(-1.f, mt.get(3,0));
        assertEquals(-5.f, mt.get(3,1));
        assertEquals(0.f, mt.get(3,2));
        assertEquals(6.f, mt.get(3,3));
    }

    @Test
    public void givenNotNullMatrixWhenInvertedThenItIsCorrect() {
        m = Matrix4D.create(Vec4.create(1.36f, 1.28f, 0.85f, -7.f),
                            Vec4.create(1.5f, 0.f, -6.58f, 1.f),
                            Vec4.create(4.5f, 0.f, -3.f, 10.f),
                            Vec4.create(0.f, 1.f, 6.68f, -9.f));

        Matrix4D mt = m.inverse();

        assertEquals(-0.5764461f, mt.get(0,0), eps);
        assertEquals(0.5823574f, mt.get(0,1), eps);
        assertEquals( 0.202317f, mt.get(0,2), eps);
        assertEquals(0.73785f, mt.get(0,3), eps);

        assertEquals(2.71820f, mt.get(1,0), eps);
        assertEquals(-2.112317f, mt.get(1,1), eps);
        assertEquals(-0.11739f, mt.get(1,2), eps);
        assertEquals(-2.47929f, mt.get(1,3), eps);

        assertEquals(-0.09638f, mt.get(2,0), eps);
        assertEquals(-0.061866f, mt.get(2,1), eps);
        assertEquals(0.04975f, mt.get(2,2), eps);
        assertEquals(0.12336f, mt.get(2,3), eps);

        assertEquals(0.23048f, mt.get(3,0), eps);
        assertEquals(-0.28062f, mt.get(3,1), eps);
        assertEquals(0.023882f, mt.get(3,2), eps);
        assertEquals(-0.295022f, mt.get(3,3), eps);
    }

    @Test
    public void givenTranslationMatrixWhenIsAppliedToVectorThenReturnedVectorIsCorrect() {
        Vec3 v3 = Vec3.create(-3.0f, 4.0f, 5.0f);
        Matrix4D m = Matrix4D.translation(v3);
        Vec4 v4 = Vec4.create(v3);
        v4 = m.times(v4);
        assertEquals(v3.x(), v4.x());
        assertEquals(v3.y(), v4.y());
        assertEquals(v3.z(), v4.z());
        assertEquals(0.f, v4.w());
    }

    @Test
    public void givenScalingMatrixWhenItIsAppliedToVectorThenReturnedVectorIsCorrect() {
        Vec3 v3 = Vec3.create(-4.0f, 6.0f, 8.0f);
        Matrix4D m = Matrix4D.scale(2.f, 3.f, 4.f);
        Vec4 v4 = Vec4.create(v3);
        v4 = m.times(v4);

        assertEquals(-8.f, v4.x());
        assertEquals(18.f, v4.y());
        assertEquals(32.f, v4.z());
    }

    @Test
    public void givenScalingMatrixWhenInverseIsAppliedToVectorThenReturnedVectorIsCorrect() {
        Vec3 v3 = Vec3.create(-4.0f, 6.0f, 8.0f);
        Matrix4D m = Matrix4D.scale(2.f, 3.f, 4.f);
        Vec4 v4 = Vec4.create(v3);
        m = m.inverse();
        v4 = m.times(v4);

        assertEquals(-2.f, v4.x());
        assertEquals(2.f, v4.y());
        assertEquals(2.f, v4.z());
    }

    @Test
    public void givenXRotationMatrixWhenItIsAppliedToVectorThenReturnedVectorIsCorrect() {
        Matrix4D m = Matrix4D.rotationOverX(Constants.PI/4.f);
        Vec4 v4 = Vec4.create(0.f, 1.f, 0.f, 0.f);
        v4 = m.times(v4);
        assertEquals(0.f, v4.x());
        assertEquals((float)Math.sqrt(2.f)/2.f, v4.y());
        assertEquals((float)Math.sqrt(2.f)/2.f, v4.z());
    }

    @Test
    public void givenYRotationMatrixWhenItIsAppliedToVectorThenReturnedVectorIsCorrect() {
        Matrix4D m = Matrix4D.rotationOverY(Constants.PI/4.f);
        Vec4 v4 = Vec4.create(0.f, 0.f, 1.f, 0.f);
        v4 = m.times(v4);
        assertEquals((float)Math.sqrt(2.f)/2.f, v4.x());
        assertEquals(0.f, v4.y());
        assertEquals((float)Math.sqrt(2.f)/2.f, v4.z());
    }

    @Test
    public void givenZRotationMatrixWhenItIsAppliedToVectorThenReturnedVectorIsCorrect() {
        Matrix4D m = Matrix4D.rotationOverZ(Constants.PI/4.f);
        Vec4 v4 = Vec4.create(0.f, 1.f, 0.f, 0.f);
        v4 = m.times(v4);
        assertEquals(-(float)Math.sqrt(2.f)/2.f, v4.x());
        assertEquals((float)Math.sqrt(2.f)/2.f, v4.y());
        assertEquals(0.f, v4.z());
    }

    @Test
    public void givenTransformationMatricesWhenChainingIsAppliedToVectorThenReturnedVectorIsCorrect() {
        Vec4 v4 = Vec4.create(1.f, 0.f, 1.f, 1.f);
        Matrix4D rotationOverX = Matrix4D.rotationOverX(Constants.PI / 2.f);
        Matrix4D scale = Matrix4D.scale(5.f, 5.f, 5.f);
        Matrix4D translation = Matrix4D.translation(10.f, 5.f, 7.f);
        Matrix4D m = Matrix4D.chainedTransformationMatrix(rotationOverX, scale, translation);
        v4 = m.times(v4);

        assertEquals(15.f, v4.x());
        assertEquals(0.f, v4.y());
        assertEquals(7.f, v4.z());
        assertEquals(1.f, v4.w());
    }
}