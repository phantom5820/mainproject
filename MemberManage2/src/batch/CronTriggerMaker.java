package batch;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class CronTriggerMaker {
	private String timer;//크론(Cron) 표현식
	private Class<? extends Job> job;
	
	
	public CronTriggerMaker(String timer, Class<? extends Job> job) {
		super();
		this.timer = timer;
		this.job = job;
	}

	public void createTrigger() {
		SchedulerFactory factory;
		Scheduler scheduler;
		
		//Job을 먼저 생성
		JobDetail jobDetail = JobBuilder.newJob(job).withIdentity(job.getName(),"group").build();
	
		//CronTrigger 생성
		CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger", "group").
				withSchedule(CronScheduleBuilder.cronSchedule(timer)).build();

		factory = new StdSchedulerFactory();
		try {
			scheduler = factory.getScheduler();
			scheduler.start();
			
			//JobDetail, CronTrigger를 스케줄러에 등록!!
			scheduler.scheduleJob(jobDetail,cronTrigger);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		CronTriggerMaker js = new CronTriggerMaker("* * * * * ?", IntervalJob.class);
		js.createTrigger();
	}
	/*
	 * 크론 표현식(* * * * * ?) : 초 분 시 일 월 요일 년도
	 * 초 : 0~59,	* , /
	 * 분 : 0~59,	* , /
	 * 시 : 1~23,	* , /
	 * 월 : 1~31,	* , / L W ?
	 * 요일 : 0~6 , SUN ~ Sat 	, * ? / L #
	 * 년도 : 비우거나 1970 ~ 2099 	, - *  /
	 * 
	 * 
	 * * : 모든 값
	 * ? : 특정한 값이 없음
	 * - : 범위 	SUN-SAT
	 *  /: 시작시간 /단위
	 *  ,: 특정 값일때만
	 *  
	 *  0/5 * * * * ? ---> 5초마다
	 *  0 0/5 * * * ? ---> 5분 마다
	 *  0 22 23 ? * * ---> 23시 22분 0초 마다 실행
	 *  http: www.cronmaker.com <---이 사이트에서 원하는 날짜를 선택후 위 ("* * * * * ?" 여기에 대입해주면 된다.
	 * 
	 */
}









