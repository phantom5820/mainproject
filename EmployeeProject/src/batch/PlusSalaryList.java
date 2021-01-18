package batch;

import java.util.ArrayList;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dto.EmployeeDTO;
import dto.QnaDTO;
import service.EmployeeService;
import service.QnAService;

public class PlusSalaryList implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		ArrayList<EmployeeDTO> list = null;
		list = EmployeeService.getInstance().plusSalaryList();
		System.out.println(list.toString());
	}

}











