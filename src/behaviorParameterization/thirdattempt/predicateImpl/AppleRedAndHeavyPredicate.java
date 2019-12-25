package behaviorParameterization.thirdattempt.predicateImpl;

import behaviorParameterization.modal.Apple;
import behaviorParameterization.thirdattempt.predicate.ApplePredicate;

public class AppleRedAndHeavyPredicate implements ApplePredicate {
		public boolean test(Apple apple){
			return "red".equals(apple.getColor()) 
					&& apple.getWeight() > 150; 
		}
	}
