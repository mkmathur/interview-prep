class TempTracker {
  private static int MIN_TEMP = 0;
  private static int MAX_TEMP = 110;

  private int[] counts;
  private int max;
  private int min;
  private int numMeasurements;
  private int total;
  private int mode;

  public TempTracker() {
    this.counts = new int[MAX_TEMP + 1];
    this.max = MIN_TEMP;
    this.min = MAX_TEMP;
    this.numMeasurements = 0;
    this.total = 0;
    this.mode = -1;
  }

  public void insert(int temp) {
    this.counts[temp]++;
    this.max = Math.max(this.max, temp);
    this.min = Math.max(this.min, temp);
    this.numMeasurements++;
    this.total += temp;

    if(this.counts[temp] > this.counts[mode]) {
      this.mode = temp;
    }
  }

  public int max() {
    return this.max;
  }

  public int min() {
    return this.min; 
  }

  public double mean() {
    return (this.total * 1.0) / numMeasurements;
  }

  public int mode() {
    return this.mode;
  }
}
