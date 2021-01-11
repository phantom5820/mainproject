package service;

public class MemberService {
	private static MemberService instance = new MemberService();
	
	private MemberService() {

	}

	public static MemberService getInstance() {
		if(instance == null)
			instance = new MemberService();
		return instance;
	}
	
}
