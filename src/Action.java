import java.math.BigDecimal;

public class Action {
  private BigDecimal sufferingCreated;
  private BigDecimal optionality;


  public Action(BigDecimal sufferingCreated, BigDecimal optionality) {
    assert sufferingCreated.compareTo(BigDecimal.ZERO) > 0;
    assert sufferingCreated.compareTo(BigDecimal.ONE) < 0;
    this.sufferingCreated = sufferingCreated;

    assert optionality.compareTo(BigDecimal.ZERO) > 0;
    assert optionality.compareTo(BigDecimal.ONE) < 0;
    this.optionality = optionality;
  }

  public BigDecimal getSufferingCreated() {
    return this.sufferingCreated;
  }

  public BigDecimal getOptionality() {
    return this.optionality;
  }

  @Override
  public String toString() {
    return "Suffering: " + this.getSufferingCreated() + " Optionality: " + this.getOptionality();
  }

}
