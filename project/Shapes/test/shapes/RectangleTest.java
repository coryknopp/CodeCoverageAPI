package shapes;

import org.junit.Test;
import static org.junit.Assert.*;

import static shapes.Rectangle.Type;
import static shapes.Rectangle.Type.*;

public class RectangleTest{


  @Test
  public void test1(){
    assertEquals(Rectangle.classify(10,10,10,10), SQUARE);
  }

  @Test
  public void test2(){
    assertEquals(Rectangle.classify(0,3,5,7), INVALID);
  }

  @Test
  public void test3(){
    assertEquals(Rectangle.classify(1,3,5,7), INVALID);
  }

  @Test
  public void test4(){
    assertEquals(Rectangle.classify(2,2,4,4), RECTANGLE);
  }

}
