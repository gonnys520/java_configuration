package org.gonnys.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
public class SampleTask {

	//601p에 자세한 설명있음.
	@Scheduled(cron="0 0 * * * *")
	public void doJob() {
		
		log.warn("====================");
		log.warn("====================");
		log.warn("====================");
		log.warn("====================");
		log.warn("End");
	}
}
