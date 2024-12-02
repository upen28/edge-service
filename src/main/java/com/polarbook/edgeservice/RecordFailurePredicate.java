package com.polarbook.edgeservice;

import java.util.function.Predicate;

import org.springframework.cloud.gateway.filter.factory.SpringCloudCircuitBreakerFilterFactory.CircuitBreakerStatusCodeException;

public class RecordFailurePredicate implements Predicate<Throwable> {
	@Override
	public boolean test(Throwable throwable) {
		if (throwable instanceof CircuitBreakerStatusCodeException) {
			CircuitBreakerStatusCodeException exp = (CircuitBreakerStatusCodeException) throwable;
			if (exp.getStatusText().equalsIgnoreCase("NOT_FOUND") || exp.getStatusText().equalsIgnoreCase("500") || exp.getStatusText().equalsIgnoreCase("INTERNAL_SERVER_ERROR")) {
				return true;
			}
		}
		return false;
	}
}
