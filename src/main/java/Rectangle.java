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

    // Get the intersection of this rectangle and the given rectangle
    public Rectangle intersect(Rectangle other) {
        if(doesNotIntersect(other)) {
            return null;
        }

        int intLeftX = Math.max(this.getLeftX(), other.getLeftX());
        int intRightX = Math.min(this.getRightX(), other.getRightX());
        int intWidth = intRightX - intLeftX;

        int intBottomY = Math.max(this.getBottomY(), other.getBottomY());
        int intTopY = Math.min(this.getTopY(), other.getTopY());
        int intHeight = intTopY - intBottomY;

        return new Rectangle(intLeftX, intBottomY, intWidth, intHeight);
    }

    private boolean doesNotIntersect(Rectangle other) {
        return this.getRightX() < other.getLeftX() 
            || other.getRightX() < this.getLeftX()
            || this.getBottomY() > other.getTopY()
            || other.getBottomY() > other.getTopY();
    }
}