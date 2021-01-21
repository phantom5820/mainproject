package controller;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.FileDTO;
import model.ModelAndView;
import service.BoardService;

public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		//파일목록을 받아보자!
		ArrayList<FileDTO> list = BoardService.getInstance().selectFileList(bno);
		for (int i = 0; i < list.size(); i++) {
			File file = new File("c:\\fileupload\\"+list.get(i).getWriter()+"\\"+list.get(i).getFileName());
			
			// 파일이 있는지 없는지 체크(파일이 있으면 true가 나오고 없으면 false가 나온다!!)
			System.out.println(file.exists());
			// 경로가 잘 잡혔는지 확인하는 부분!!
			System.out.println(file.getAbsolutePath());
			file.delete();//현재 연결된 파일을 삭제 (delete()는 File 클래스 프로그램 안에있는 메서드이다!!)
		}
		//board comment 같은경우는 외래키로 잡혀있을때 sql문에서 캐스캐이딩 해버리면 해당 댓글까지 다 지우게 만들수 있다. 외래키를 안잡았다면 두번 삭제 하면 된다.
		//DB처리
		//board_file_list에 있는 파일 해당 게시글 목록 삭제
		if(list.size() > 0)//파일이 있을경우만 파일까지 삭제하는부분
			BoardService.getInstance().deleteFileList(bno);
		//board에서 해당 게시글 삭제 ()
			BoardService.getInstance().deleteList(bno);
		//삭제 완료하면 모델앤 뷰를 이용해서 mian.do페이지로 이동
		return new ModelAndView("main.do", true);
	}

}
