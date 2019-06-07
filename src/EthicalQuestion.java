public class EthicalQuestion {

  public static Double getActionBadness(Action action) {
    return action.getSufferingCreated();
  }

  public static Double getActionWrongness(Action action) {
    return getActionBadness(action) * action.getOptionality();
  }

  public static Double getBehaviorBadness(Action action, Double actionFrequency) {
    return getActionWrongness(action) * actionFrequency;
  }

  public static Double getBehaviorWrongness(Action action, Double actionFrequency, Awareness awareness) {
    return getBehaviorBadness(action, actionFrequency) * awareness.getOptionalityAwareness() * awareness.getSufferingCreatedAwareness();
  }


  public static void main(String[] args) {

    for (double suffering = 0.0; suffering <= 1.0; suffering += 0.1) {
      if (suffering == 0.0) { continue; }
      for (double optionality = 0.0; optionality <= 1.0; optionality += 0.1) {
        if (optionality == 0.0) { continue; }
        for (double sufferingAwareness = 0.0; sufferingAwareness <= 1.0; sufferingAwareness += 0.1) {
          for (double optionalityAwareness = 0.0; optionalityAwareness <= 1.0; optionalityAwareness += 0.1) {
            for (double frequency = 0.0; frequency <= 1.0; frequency += 0.1) {

              Action testAction = new Action(suffering, optionality);
              Awareness testAwareness = new Awareness(sufferingAwareness, optionalityAwareness);

//              assert getActionBadness(testAction) > 0;
//              assert getActionWrongness(testAction) == 1.0;
//              assert getBehaviorBadness(testAction, frequency) == 0;

            }
          }
        }
      }
    }
  }
}


