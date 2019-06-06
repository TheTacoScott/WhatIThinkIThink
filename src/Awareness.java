public class Awareness {
  private Double sufferingCreatedAwareness;
  private Double optionalityAwareness;
  public Awareness(Double sufferingCreatedAwareness, Double optionalityAwareness) {
    assert sufferingCreatedAwareness >= 0;
    assert sufferingCreatedAwareness <= 1;
    this.sufferingCreatedAwareness = sufferingCreatedAwareness;

    assert optionalityAwareness >= 0;
    assert optionalityAwareness <= 1;
    this.optionalityAwareness = optionalityAwareness;
  }

  public Double getSufferingCreatedAwareness() {
    return sufferingCreatedAwareness;
  }

  public Double getOptionalityAwareness() {
    return optionalityAwareness;
  }
}
