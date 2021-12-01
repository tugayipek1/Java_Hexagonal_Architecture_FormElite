package com.phexum.formelite.infralayer.common;

import com.phexum.formHandler.domain.common.scheduleUseCase.ScheduleUseCase;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@EnableAsync
@Component
@EnableScheduling
public class ScheduleService extends BaseController {

    @Scheduled(cron = "0 0 10 * * *")
    //@Scheduled(  cron = "*/10 * * * * *",zone="Europe/Istanbul")
    @Async
    public void triggerSchedule() {
        System.out.println("çalıştı");
        handle(new ScheduleUseCase());
    }
}
