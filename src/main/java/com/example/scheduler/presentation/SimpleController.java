package com.example.scheduler.presentation;

import com.example.scheduler.job.JobParameter;
import com.example.scheduler.job.SimpleJob;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ユーザ用コントローラークラス
 */
@RestController
@RequestMapping("/")
public class SimpleController {

    private final Scheduler scheduler;

    @Autowired
    public SimpleController(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @GetMapping("/create")
    public ResponseEntity create() throws Exception {
        // パラメータ作成
        JobParameter jobParameter = new JobParameter("00001", "shigemax");

        // ジョブ生成及びパラメータ付与
        JobDetail job = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("sample_job").build();
        job.getJobDataMap().put("parameter", jobParameter);

        // トリガー設定（120秒後に発火）
        Date afterFiveSeconds = Date.from(LocalDateTime.now().plusSeconds(120)
                .atZone(ZoneId.systemDefault()).toInstant());
        Trigger trigger = TriggerBuilder.newTrigger()
                .startAt(afterFiveSeconds)
                .build();

        // ジョブ登録
        this.scheduler.scheduleJob(job, trigger);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/delete")
    public ResponseEntity delete() throws Exception {
        // ジョブ名で削除
        this.scheduler.deleteJob(new JobKey("sample_job"));
        return ResponseEntity.ok().build();
    }
}