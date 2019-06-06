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
    return getBehaviorBadness(action,actionFrequency) * awareness.getOptionalityAwareness() * awareness.getSufferingCreatedAwareness();
  }


  public static void main(String[] args) {
    Action maxSufferingMaxOptionality = new Action(1.0,1.0);
    assert getActionBadness(maxSufferingMaxOptionality) == 1.0;
    assert getActionWrongness(maxSufferingMaxOptionality) == 1.0;
    assert getBehaviorBadness(maxSufferingMaxOptionality,0.0) == 0;
    assert getBehaviorBadness(maxSufferingMaxOptionality,1.0) == 1.0;

    Action minSufferingMinOptionality = new Action(0.0,0.0);
    assert getActionBadness(minSufferingMinOptionality) == 0.0;
    assert getActionWrongness(minSufferingMinOptionality) == 0.0;
    assert getBehaviorBadness(minSufferingMinOptionality,0.0) == 0.0;
    assert getBehaviorBadness(minSufferingMinOptionality,1.0) == 0.0;

    Action maxSufferingMinOptionality = new Action(1.0,0.0);
    assert getActionBadness(maxSufferingMinOptionality) == 1.0;
    assert getActionWrongness(maxSufferingMinOptionality) == 0.0;
    assert getBehaviorBadness(maxSufferingMinOptionality,0.0) == 0.0;
    assert getBehaviorBadness(maxSufferingMinOptionality,1.0) == 0.0;

    Action minSufferingMaxOptionality = new Action(0.0,1.0);
    assert getActionBadness(minSufferingMaxOptionality) == 0.0;
    assert getActionWrongness(minSufferingMaxOptionality) == 0.0;
    assert getBehaviorBadness(minSufferingMaxOptionality,0.0) == 0.0;
    assert getBehaviorBadness(minSufferingMaxOptionality,1.0) == 0.0;


    Awareness maxAwareness = new Awareness(1.0,1.0);
    assert getBehaviorWrongness(maxSufferingMaxOptionality,0.0,maxAwareness) == 0.0;
    assert getBehaviorWrongness(maxSufferingMaxOptionality,1.0,maxAwareness) == 1.0;
    assert getBehaviorWrongness(minSufferingMinOptionality,0.0,maxAwareness) == 0.0;
    assert getBehaviorWrongness(minSufferingMinOptionality,1.0,maxAwareness) == 0.0;
    assert getBehaviorWrongness(maxSufferingMinOptionality,0.0,maxAwareness) == 0.0;
    assert getBehaviorWrongness(maxSufferingMinOptionality,1.0,maxAwareness) == 0.0;
    assert getBehaviorWrongness(minSufferingMaxOptionality,0.0,maxAwareness) == 0.0;
    assert getBehaviorWrongness(minSufferingMaxOptionality,1.0,maxAwareness) == 0.0;


    Awareness minAwareness = new Awareness(0.0,0.0);
    assert getBehaviorWrongness(maxSufferingMaxOptionality,0.0,minAwareness) == 0.0;
    assert getBehaviorWrongness(maxSufferingMaxOptionality,1.0,minAwareness) == 0.0;
    assert getBehaviorWrongness(minSufferingMinOptionality,0.0,minAwareness) == 0.0;
    assert getBehaviorWrongness(minSufferingMinOptionality,1.0,minAwareness) == 0.0;
    assert getBehaviorWrongness(maxSufferingMinOptionality,0.0,minAwareness) == 0.0;
    assert getBehaviorWrongness(maxSufferingMinOptionality,1.0,minAwareness) == 0.0;
    assert getBehaviorWrongness(minSufferingMaxOptionality,0.0,minAwareness) == 0.0;
    assert getBehaviorWrongness(minSufferingMaxOptionality,1.0,minAwareness) == 0.0;

    Awareness maxSufferingAwarenessMinOptionalityAwareness = new Awareness(1.0,0.0);
    assert getBehaviorWrongness(maxSufferingMaxOptionality,0.0,maxSufferingAwarenessMinOptionalityAwareness) == 0.0;
    assert getBehaviorWrongness(maxSufferingMaxOptionality,1.0,maxSufferingAwarenessMinOptionalityAwareness) == 0.0;
    assert getBehaviorWrongness(minSufferingMinOptionality,0.0,maxSufferingAwarenessMinOptionalityAwareness) == 0.0;
    assert getBehaviorWrongness(minSufferingMinOptionality,1.0,maxSufferingAwarenessMinOptionalityAwareness) == 0.0;
    assert getBehaviorWrongness(maxSufferingMinOptionality,0.0,maxSufferingAwarenessMinOptionalityAwareness) == 0.0;
    assert getBehaviorWrongness(maxSufferingMinOptionality,1.0,maxSufferingAwarenessMinOptionalityAwareness) == 0.0;
    assert getBehaviorWrongness(minSufferingMaxOptionality,0.0,maxSufferingAwarenessMinOptionalityAwareness) == 0.0;
    assert getBehaviorWrongness(minSufferingMaxOptionality,1.0,maxSufferingAwarenessMinOptionalityAwareness) == 0.0;

    Awareness minSufferingAwarenessMaxOptionalityAwareness = new Awareness(0.0,1.0);
    assert getBehaviorWrongness(maxSufferingMaxOptionality,0.0,minSufferingAwarenessMaxOptionalityAwareness) == 0.0;
    assert getBehaviorWrongness(maxSufferingMaxOptionality,1.0,minSufferingAwarenessMaxOptionalityAwareness) == 0.0;
    assert getBehaviorWrongness(minSufferingMinOptionality,0.0,minSufferingAwarenessMaxOptionalityAwareness) == 0.0;
    assert getBehaviorWrongness(minSufferingMinOptionality,1.0,minSufferingAwarenessMaxOptionalityAwareness) == 0.0;
    assert getBehaviorWrongness(maxSufferingMinOptionality,0.0,minSufferingAwarenessMaxOptionalityAwareness) == 0.0;
    assert getBehaviorWrongness(maxSufferingMinOptionality,1.0,minSufferingAwarenessMaxOptionalityAwareness) == 0.0;
    assert getBehaviorWrongness(minSufferingMaxOptionality,0.0,minSufferingAwarenessMaxOptionalityAwareness) == 0.0;
    assert getBehaviorWrongness(minSufferingMaxOptionality,1.0,minSufferingAwarenessMaxOptionalityAwareness) == 0.0;

  }
}


