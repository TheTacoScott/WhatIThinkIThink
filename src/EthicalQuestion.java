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

  public static void test(boolean condition,String group, String name) {
    if (!condition) {
      System.out.println(group + " validate " + name);
      System.exit(1);
    }
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

              System.out.println(testAction + " " + testAwareness + " Frequency: " + frequency);
              System.out.println("\t    actionBadness: " + actionBadness);
              System.out.println("\t  actionWrongness: " + actionWrongness);
              System.out.println("\t  behaviorBadness: " + behaviorBadness);
              System.out.println("\tbehaviorWrongness: " + behaviorWrongness);

              String conditionGroup = "Zero suffering";
              if (testAction.getSufferingCreated().compareTo(BigDecimal.ZERO) == 0) {
                test(actionBadness.compareTo(BigDecimal.ZERO) == 0,conditionGroup, "actionBadness == 0");
                test(actionWrongness.compareTo(BigDecimal.ZERO) == 0,conditionGroup,"actionWrongness == 0");
                test(behaviorBadness.compareTo(BigDecimal.ZERO) == 0,conditionGroup,"behaviorBadness == 0");
                test(behaviorWrongness.compareTo(BigDecimal.ZERO) == 0,conditionGroup,"behaviorWrongness == 0");
                continue;
              }

              conditionGroup = "Some suffering, Zero frequency";
              if (frequency.compareTo(BigDecimal.ZERO) == 0) {
                test(behaviorBadness.compareTo(BigDecimal.ZERO) == 0,conditionGroup,"behaviorBadness == 0");
                test(behaviorWrongness.compareTo(BigDecimal.ZERO) == 0,conditionGroup,"behaviorWrongness == 0");
                continue;
              }

              conditionGroup = "Some suffering/frequency. Zero optionality)";
              if (testAction.getOptionality().compareTo(BigDecimal.ZERO) == 0) {
                test(actionWrongness.compareTo(BigDecimal.ZERO) == 0,conditionGroup,"actionWrongness == 0");
                continue;
              }

              conditionGroup = "Some suffering/frequency/optionality. Zero awareness)";
              if (testAwareness.getSufferingCreatedAwareness().compareTo(BigDecimal.ZERO) == 0 || testAwareness.getOptionalityAwareness().compareTo(BigDecimal.ZERO) == 0) {
                test(behaviorWrongness.compareTo(BigDecimal.ZERO) == 0,conditionGroup,"actionWrongness == 0");
                continue;
              }

              conditionGroup = "Some suffering/frequency/optionality/awareness)";
              test(actionBadness.compareTo(BigDecimal.ZERO) > 0,conditionGroup,"actionBadness > 0");
              test(actionWrongness.compareTo(BigDecimal.ZERO) > 0,conditionGroup,"actionWrongness > 0");
              test(behaviorBadness.compareTo(BigDecimal.ZERO) > 0,conditionGroup,"behaviorBadness > 0");
              test(behaviorWrongness.compareTo(BigDecimal.ZERO) > 0,conditionGroup,"behaviorWrongness > 0");

              System.out.println();
            }
          }
        }
      }
    }
  }
}


