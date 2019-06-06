public class Action {
  private Double sufferingCreated;
  private Double optionality;


  public Action(Double sufferingCreated, Double optionality) {
    assert sufferingCreated > 0;
    assert sufferingCreated <= 1;
    this.sufferingCreated = sufferingCreated;

    assert optionality > 0;
    assert optionality <= 1;
    this.optionality = optionality;


  }

  public Double getSufferingCreated() {
    return this.sufferingCreated;
  }

  public Double getOptionality() {
    return this.optionality;
  }
}
