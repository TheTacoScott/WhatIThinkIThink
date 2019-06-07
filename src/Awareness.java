import java.math.BigDecimal;

public class Awareness {
  private BigDecimal sufferingCreatedAwareness;
  private BigDecimal optionalityAwareness;
  public Awareness(BigDecimal sufferingCreatedAwareness, BigDecimal optionalityAwareness) {
    assert sufferingCreatedAwareness.compareTo(BigDecimal.ZERO) >= 0;
    assert sufferingCreatedAwareness.compareTo(BigDecimal.ONE) <= 1;
    this.sufferingCreatedAwareness = sufferingCreatedAwareness;

//    assert optionalityAwareness >= 0;
//    assert optionalityAwareness <= 1;
    this.optionalityAwareness = optionalityAwareness;
  }

  public BigDecimal getSufferingCreatedAwareness() {
    return sufferingCreatedAwareness;
  }

  public BigDecimal getOptionalityAwareness() {
    return optionalityAwareness;
  }

  @Override
  public String toString() {
    return "SufferingAwareness: " + this.getSufferingCreatedAwareness() + " OptionalityAwareness: " + this.getOptionalityAwareness();
  }
}
