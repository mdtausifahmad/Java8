package behaviorParameterization.thirdattempt.predicateImpl;

import behaviorParameterization.modal.Apple;
import behaviorParameterization.thirdattempt.predicate.ApplePredicate;

public class AppleColorPredicate implements ApplePredicate {
		public boolean test(Apple apple){
			return "green".equals(apple.getColor());
		}
	}
