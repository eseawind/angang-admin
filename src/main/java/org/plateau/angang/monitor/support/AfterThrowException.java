package org.plateau.angang.monitor.support;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class AfterThrowException {

	@AfterThrowing("org.plateau.angang.monitor.support.SystemMonitorAspect.tracePublicOperation()")
	public void doMonitor() {
		System.out.println("－－－－－－－－－监控成功－－－－－－－－－");
	}

}