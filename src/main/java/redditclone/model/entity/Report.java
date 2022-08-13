package redditclone.model.entity;

import java.time.LocalDate;

public class Report {

	private Long report_id;
	private ReportReason reason;
	private LocalDate time_stamp;
	private User reporting_user;
	private boolean accepted;
	
	
}

