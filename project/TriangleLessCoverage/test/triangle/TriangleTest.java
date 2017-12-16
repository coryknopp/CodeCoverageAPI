package triangle;

import org.junit.Test;
import static org.junit.Assert.*;

import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

/**
 * Test class for the Triangle implementation.
 */
public class TriangleTest {
    //
    // @Test
    // public void test1() {
    //     assertEquals(Triangle.classify(10, 10, 10), EQUILATERAL);
    // }
    //
    // @Test
    // public void test2() {
    //     assertEquals(Triangle.classify(1, 1, 0), INVALID);
    // }
    //
    // @Test
    // public void test3() {
    //     assertEquals(Triangle.classify(5, 4, 3), SCALENE);
    // }
    //
    // @Test
    // public void test4() {
    //     assertEquals(Triangle.classify(1, 100, 100), ISOSCELES);
    // }
    //
    // @Test
    // public void test5() {
    //     assertEquals(Triangle.classify(0, 0, 0), INVALID);
    // }
    //
    // @Test
    // public void test6() {
    //     assertEquals(Triangle.classify(-1, -1, -1), INVALID);
    // }
    //
    // @Test
    // public void test7() {
    //     assertEquals(Triangle.classify(1, -1, -1), INVALID);
    // }
    //
    // @Test
    // public void test8() {
    //     assertEquals(Triangle.classify(1, 1, -1), INVALID);
    // }
    //
    // @Test
    // public void test9() {
    //     assertEquals(Triangle.classify(10, 10, 100), INVALID);
    // }
    //
    // @Test
    // public void test10() {
    //     assertEquals(Triangle.classify(1, 9, 14), INVALID);
    // }
    //
    // @Test
    // public void test11() {
    //     assertEquals(Triangle.classify(50, 9, 14), INVALID);
    // }
    //
    // @Test
    // public void test12() {
    //     assertEquals(Triangle.classify(1, 2, 3), INVALID);
    // }
    //
    // @Test
    // public void test13() {
    //     Triangle t = new Triangle();
    //     Type tri = Type.EQUILATERAL;
    // }
    //
    // @Test
    // public void test14() {
    //     assertEquals(Triangle.classify(3, 2, 3), ISOSCELES);
    // }
    //
    // @Test
    // public void test15() {
    //     assertEquals(Triangle.classify(2, 3, 3), ISOSCELES);
    // }
    //
    // @Test
    // public void test16() {
    //     assertEquals(Triangle.classify(4, 3, 6), SCALENE);
    // }
    //
    // @Test
    // public void test17() {
    //     assertEquals(Triangle.classify(2, 2, 3), ISOSCELES);
    // }
    //
    // @Test
    // public void test18() {
    //     assertEquals(Triangle.classify(100, 1, 100), ISOSCELES);
    // }
    //
    // @Test
    // public void test19() {
    //     assertEquals(Triangle.classify(100, 100, 1), ISOSCELES);
    // }
    //
    // @Test
    // public void test20() {
    //     assertEquals(Triangle.classify(1, 10000, 100), INVALID);
    // }
    //
    // @Test
    // public void test21() {
    //     assertEquals(Triangle.classify(-1, 1, 1), INVALID);
    // }
    //
    // @Test
    // public void test22() {
    //     assertEquals(Triangle.classify(1, -1, 1), INVALID);
    // }
    //
    // @Test
    // public void test23() {
    //     assertEquals(Triangle.classify(1, 100, 100), ISOSCELES);
    // }
    //
    // @Test
    // public void test211() {
    //     assertEquals(Triangle.classify(10, 10, 10), EQUILATERAL);
    // }
    //
    // @Test
    // public void test212() {
    //     assertEquals(Triangle.classify(1, 100, 100), ISOSCELES);
    // }
    //
    // @Test
    // public void test213() {
    //     assertEquals(Triangle.classify(1, 10000, 100), INVALID);
    // }
    //
    // @Test
    // public void test214() {
    //     assertEquals(Triangle.classify(-10, 10, 10), INVALID);
    // }
    //
    // @Test
    // public void test215() {
    //     assertEquals(Triangle.classify(-10, 10, 10), INVALID);
    // }
    //
    // @Test
    // public void test216() {
    //     assertEquals(Triangle.classify(10, -10, 10), INVALID);
    // }
    //
    // @Test
    // public void test217() {
    //     assertEquals(Triangle.classify(10, 10, -10), INVALID);
    // }
    //
    // @Test
    // public void test218() {
    //     assertEquals(Triangle.classify(10, 10, 100), INVALID);
    // }
    //
    // @Test
    // public void test219() {
    //     assertEquals(Triangle.classify(10, 100, 10), INVALID);
    // }
    //
    // @Test
    // public void test110() {
    //     assertEquals(Triangle.classify(100, 10, 10), INVALID);
    // }
    //
    // @Test
    // public void test111() {
    //     assertEquals(Triangle.classify(11, 12, 13), SCALENE);
    // }
    //
    // @Test
    // public void test112() {
    //     assertEquals(Triangle.classify(12, 11, 13), SCALENE);
    // }
    //
    // @Test
    // public void test113() {
    //     assertEquals(Triangle.classify(13, 11, 12), SCALENE);
    // }
    //
    // @Test
    // public void test114() {
    //     assertEquals(Triangle.classify(13, 12, 11), SCALENE);
    // }
    //
    // @Test
    // public void test115() {
    //     assertEquals(Triangle.classify(11, 13, 12), SCALENE);
    // }
    //
    // @Test
    // public void test117() {
    //     assertEquals(Triangle.classify(10, 10, 100), INVALID);
    // }
    //
    // @Test
    // public void test118() {
    //     assertEquals(Triangle.classify(1, 9, 14), INVALID);
    // }
    //
    // @Test
    // public void test119() {
    //     assertEquals(Triangle.classify(50, 9, 14), INVALID);
    // }
    //
    // @Test
    // public void test120() {
    //     assertEquals(Triangle.classify(1, 2, 3), INVALID);
    // }
    // @Test
    // public void test121() {
    //     assertEquals(Triangle.classify(0, 0, 0), INVALID);
    // }
    //
    // @Test
    // public void test122() {
    //     assertEquals(Triangle.classify(-1, -1, -1), INVALID);
    // }
    //
    // @Test
    // public void test123() {
    //     assertEquals(Triangle.classify(1, -1, -1), INVALID);
    // }
    // @Test
    // public void test124() {
    //     assertEquals(Triangle.classify(1, 1, 0), INVALID);
    // }

    // @Test
    // public void test116() {
    //     Triangle t = new Triangle();
    //     Type t0 = Type.EQUILATERAL;
    //     Type t1 = Type.INVALID;
    //     Type t2 = Type.SCALENE;
    //     Type t3 = Type.ISOSCELES;
    //     assertEquals(t0, EQUILATERAL);
    //     assertEquals(t1, INVALID);
    //     assertEquals(t2, SCALENE);
    //     assertEquals(t3, ISOSCELES);
    // }

    @Test
    public void testEquilateral() {
        Type actual = Triangle.classify(10, 10, 10);
        Type expected = EQUILATERAL;
        assertEquals(actual, expected);
    }

    // @Test
    // public void testScalene() {
    //     Type actual = Triangle.classify(4, 3, 6);
    //     Type expected = SCALENE;
    //     assertEquals(actual, expected);
    // }

    @Test
    public void testIsoceles() {
        Type actual = Triangle.classify(2, 2, 3);
        Type expected = ISOSCELES;
        assertEquals(actual, expected);
        Type actual2 = Triangle.classify(3, 2, 3);
        Type expected2 = ISOSCELES;
        assertEquals(actual2, expected2);
        Type actual3 = Triangle.classify(2, 3, 3);
        Type expected3 = ISOSCELES;
        assertEquals(actual3, expected3);
    }

    // @Test
    // public void testInvalid() {
    //     Type actual = Triangle.classify(0, 10, 10);
    //     Type expected = INVALID;
    //     assertEquals(actual, expected);
    //     Type actual2 = Triangle.classify(1, 2, 3);
    //     Type expected2 = INVALID;
    //     assertEquals(actual2, expected2);
    //     Type actual3 = Triangle.classify(2, 2, 7);
    //     Type expected3 = INVALID;
    //     assertEquals(actual3, expected3);
    // }

//     @Test
//     public void test300() {
//         assertEquals(Triangle.classify(1, 0, 1), INVALID);
//     }
//
//     @Test
//     public void test301() {
//         assertEquals(Triangle.classify(4, 2, 5), SCALENE);
//     }
//
//     @Test
//     public void testM70() {
//         assertEquals(Triangle.classify(20, 40, 15), INVALID);
//     }
//
//     @Test
//     public void testM63() {
//         assertEquals(Triangle.classify(20, 40, 60), INVALID);
//     }
//
//     @Test
//     public void testM73() {
//         assertEquals(Triangle.classify(15, 75, 60), INVALID);
//     }
//
//     @Test
//     public void testM84() {
//         assertEquals(Triangle.classify(20, 9, 11), INVALID);
//     }
//
//     @Test
//     public void testM105() {
//         assertEquals(Triangle.classify(4, 4, 9), INVALID);
//     }
//
//     @Test
//     public void testM109() {
//         assertEquals(Triangle.classify(2, 2, 4), INVALID);
//     }
//
//     @Test
//     public void testM122() {
//         assertEquals(Triangle.classify(4, 9, 4), INVALID);
//     }
//
//     @Test
//     public void testM126() {
//         assertEquals(Triangle.classify(2, 4, 2), INVALID);
//     }
//
//     @Test
//     public void testM139() {
//         assertEquals(Triangle.classify(9, 4, 4), INVALID);
//     }
//
//     @Test
//     public void testM143() {
//         assertEquals(Triangle.classify(4, 2, 2), INVALID);
//     }
//
//     @Test
//     public void testM87() {
//         assertEquals(Triangle.classify(20, 30, 10), INVALID);
//     }
}
