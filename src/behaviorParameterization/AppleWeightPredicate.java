package behaviorParameterization;

import behaviorParameterization.modal.Apple;

public class AppleWeightPredicate implements ApplePredicate{
		public boolean test(Apple apple){
			return apple.getWeight() > 150; 
		}
	}
