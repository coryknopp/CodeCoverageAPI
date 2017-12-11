package shapes;

/**
 * An implementation that classifies triangles.
 */
public class Rectangle {

    /**
     * This enum gives the type of the Rectangle
     */
    public static enum Type {
        INVALID, RECTANGLE, SQUARE
    };

    /**
     * This static method does the actual classification of a triangle, given the lengths
     * of its three sides.
     */
    public static Type classify(int left, int right, int top, int bottom) {
        if (isSquare(left, right, top, bottom))
            return Type.SQUARE;
        else if(isRectangle(left, right, top, bottom))
            return Type.RECTANGLE;
        else
            return Type.INVALID;
    }

    public static boolean isRectangle(int left, int right, int top, int bottom) {
        if(left == right) {
            if(top == bottom) {
                if(top != left)
                    return true;
                else
                    return false;
            }
            else
                return false;
        }
        else
            return false;
    }

    public static boolean isSquare(int left, int right, int top, int bottom) {
        if(left == right) {
            if(top == bottom) {
                if(top == left)
                    return true;
                else
                    return false;
            }
            else
                return false;
        }
        else
            return false;
    }


}
