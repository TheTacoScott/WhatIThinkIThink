public class EthicalQuestion {

  public Float actionWrongness(Action action, Context context) {
    return action.sufferingCreated(context) * action.optionality(context);
  }

  public Float personBadness(Action action, Context context, Float wrongnessAwareness) {
    return actionWrongness(action,context) * wrongnessAwareness;
  }

}
