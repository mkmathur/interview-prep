public class Rectangle {
    // coordinates of bottom left corner
    private int leftX;
    private int bottomY;

    // dimensions
    private int width;
    private int height;

    public Rectangle(int leftX, int bottomY, int width, int height) {
        this.leftX = leftX;
        this.bottomY = bottomY;
        this.width  = width;
        this.height = height;
    }

    public int getLeftX() {
        return leftX;
    }

    public int getRightX() {
        return leftX + width;
    }

    public int getBottomY() {
        return bottomY;
    }

    public int getTopY() {
        return bottomY + height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String toString() {
        return String.format("(%s, %s), %s, %s", leftX, bottomY, width, height);
    }

    public Range getXRange() {
        return new Range(leftX, width);
    }

    public Range getYRange() {
        return new Range(bottomY, height);
    }

    // Get the intersection of this rectangle and the given rectangle
    public Rectangle intersect(Rectangle other) {
        Range xOverlap = this.getXRange().intersect(other.getXRange());
        Range yOverlap = this.getYRange().intersect(other.getYRange());

        if(xOverlap.getLength() == 0 || yOverlap.getLength() == 0) {
            return new Rectangle(0, 0, 0, 0);
        }

        return new Rectangle(
            xOverlap.getStartPoint(), 
            yOverlap.getStartPoint(),
            xOverlap.getLength(), 
            yOverlap.getLength());
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(1, 1, 2, 2);
        Rectangle r2 = new Rectangle(3, 0, 2, 3);
        Rectangle intersection = r1.intersect(r2);
        System.out.println(intersection);
    }
}