class Range {
    private int startPoint;
    private int length;

    public Range(int startPoint, int length) {
        this.startPoint = startPoint;
        this.length = length;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public int getEndPoint() {
        return startPoint + length;
    }

    public int getLength() {
        return length;
    }

    // Gets the intersection of this range with another range. 
    // If there is no overlap, returns an empty range. 
    public Range intersect(Range other) {
        if(this.getStartPoint() > other.getEndPoint() || other.getStartPoint() > this.getEndPoint()) {
            return new Range(0, 0);
        } else {
            int intersectionStartPoint = Math.max(this.getStartPoint(), other.getStartPoint());
            int intersectionEndPoint = Math.min(this.getEndPoint(), other.getEndPoint());
            int lengthOfIntersection = intersectionEndPoint - intersectionStartPoint;
            return new Range(intersectionStartPoint, lengthOfIntersection);
        }
    }
}