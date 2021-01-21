package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelAndView;

public class ImageLoadController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String writer = request.getParameter("writer");
		String file = request.getParameter("file");
		String type = file.substring(file.lastIndexOf(".")+1);//다음 위치부터이니까 +1을 꼭 해줘야한다.
		response.setContentType("image/"+type);
		
		//파일 경로 잡아주기 부분!!
		File path = new File("c:\\fileupload"+writer+"\\"+file);
		try {
			FileInputStream fis = new FileInputStream(path);
			ServletOutputStream sos = response.getOutputStream();
			
			
			byte[] buffer = new byte[1024*1024];
			while(true) {
				int size = fis.read(buffer);
				if(size == -1) break;
				sos.write(buffer,0,size);
				sos.flush();
			}
			sos.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
