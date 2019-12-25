package behaviorParameterization.thirdattempt.predicateImpl;

import behaviorParameterization.modal.Apple;
import behaviorParameterization.thirdattempt.predicate.ApplePredicate;

public class AppleWeightPredicate implements ApplePredicate {
		public boolean test(Apple apple){
			return apple.getWeight() > 150; 
		}
	}
