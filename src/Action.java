import java.math.BigDecimal;

public class Action {
  private BigDecimal sufferingCreated;
  private BigDecimal optionality;


  public Action(BigDecimal sufferingCreated, BigDecimal optionality) {
//    assert sufferingCreated >= 0.0;
//    assert sufferingCreated <= 1.0;
    this.sufferingCreated = sufferingCreated;

//    assert optionality >= 0.0;
//    assert optionality <= 1.0;
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
