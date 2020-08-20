package kr.co.mlec.file;

import java.io.File;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/file")
@Controller
public class UploadController {

	@Autowired
	ServletContext servletContext;
	  
	@RequestMapping(value="/upload.do", method=RequestMethod.POST)
	public ModelAndView fileUpload(MultipartHttpServletRequest mRequest) throws Exception {
		
		// ����Ǵ� �����ø����̼��� ���� ��� ��������
		String uploadDir = servletContext.getRealPath("/upload/"); // ���� �����Ǵ� ������ ��θ� �� �� �ִ�...?
		System.out.println(uploadDir);

		ModelAndView mav = new ModelAndView("file/uploadResult"); //~.jsp�� ����

		String id = mRequest.getParameter("id");
		System.out.println("id : " + id);
		
		Iterator<String> iter = mRequest.getFileNames();
		while(iter.hasNext()) {
			
			String formFileName = iter.next();
			// ������ ������ �������� �ʾƵ� ��ü ������
			MultipartFile mFile = mRequest.getFile(formFileName);
			
			// ���� ���ϸ�
			String oriFileName = mFile.getOriginalFilename();
			System.out.println("���� ���ϸ� : " + oriFileName);
			
			if(oriFileName != null && !oriFileName.equals("")) {
			
				// Ȯ���� ó��
				String ext = "";
				// ���ʿ� �ִ� . �� ��ġ 
				int index = oriFileName.lastIndexOf(".");
				if (index != -1) {
					// ���ϸ��� Ȯ���ڸ�(.����)�� ����
					ext = oriFileName.substring(index);
				}
				
				// ���� ������
				long fileSize = mFile.getSize();
				System.out.println("���� ������ : " + fileSize);
				
				// ������ ���ϸ� �����	
				String saveFileName = "mlec-" + UUID.randomUUID().toString() + ext;
				System.out.println("������ ���ϸ� : " + saveFileName);
			
				// �ӽ������ ������ ���ϴ� ��ο� ����
				mFile.transferTo(new File(uploadDir + saveFileName));
			} 
		} 
		return mav;
	}
	/*
	@RequestMapping("/uploadForm.do")
	public String upload() {
		
		return "file/fileUploadForm";
	}
	*/
}
