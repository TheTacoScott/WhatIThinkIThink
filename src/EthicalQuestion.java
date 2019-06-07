import java.math.BigDecimal;
import java.math.MathContext;

public class EthicalQuestion {
  private static MathContext mc = MathContext.DECIMAL64;
  public static BigDecimal getActionBadness(Action action) {
    return action.getSufferingCreated();
  }

  public static BigDecimal getActionWrongness(Action action) {

    return getActionBadness(action)
            .multiply(action.getOptionality(),mc);
  }

  public static BigDecimal getBehaviorBadness(Action action, BigDecimal actionFrequency) {
    return getActionWrongness(action)
            .multiply(actionFrequency,mc);
  }

  public static BigDecimal getBehaviorWrongness(Action action, BigDecimal actionFrequency, Awareness awareness) {
    return getBehaviorBadness(action, actionFrequency)
            .multiply(awareness.getOptionalityAwareness(),mc)
            .multiply(awareness.getSufferingCreatedAwareness(),mc);
  }


  public static void main(String[] args) {
    BigDecimal increment = new BigDecimal(0.1D, mc);

    for (BigDecimal suffering = new BigDecimal(0D, mc); suffering.compareTo(BigDecimal.ONE) <= 0; suffering = suffering.add(increment)) {
      for (BigDecimal optionality = new BigDecimal(0D, mc); optionality.compareTo(BigDecimal.ONE) <= 0; optionality = optionality.add(increment)) {
        for (BigDecimal sufferingAwareness = new BigDecimal(0D, mc); sufferingAwareness.compareTo(BigDecimal.ONE) <= 0; sufferingAwareness = sufferingAwareness.add(increment)) {
          for (BigDecimal optionalityAwareness = new BigDecimal(0D, mc); optionalityAwareness.compareTo(BigDecimal.ONE) <= 0; optionalityAwareness = optionalityAwareness.add(increment)) {
            for (BigDecimal frequency = new BigDecimal(0D, mc); frequency.compareTo(BigDecimal.ONE) <= 0; frequency = frequency.add(increment)) {

              Action testAction = new Action(suffering, optionality);
              Awareness testAwareness = new Awareness(sufferingAwareness, optionalityAwareness);

              BigDecimal actionBadness = getActionBadness(testAction);
              BigDecimal actionWrongness = getActionWrongness(testAction);
              BigDecimal behaviorBadness = getBehaviorBadness(testAction,frequency);
              BigDecimal behaviorWrongness = getBehaviorWrongness(testAction,frequency,testAwareness);

              System.out.println(testAction + " -> " + testAwareness + " -> Freq: " + frequency);
              System.out.println("\t    actionBadness: " + actionBadness);
              System.out.println("\t  actionWrongness: " + actionWrongness);
              System.out.println("\t  behaviorBadness: " + behaviorBadness);
              System.out.println("\tbehaviorWrongness: " + behaviorWrongness);
              System.out.print("");
            }
          }
        }
      }
    }
  }
}


