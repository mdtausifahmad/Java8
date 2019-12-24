package behaviorParameterization;

import behaviorParameterization.modal.Apple;

public class AppleColorPredicate implements ApplePredicate{
		public boolean test(Apple apple){
			return "green".equals(apple.getColor());
		}
	}
