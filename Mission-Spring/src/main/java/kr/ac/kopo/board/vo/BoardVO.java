package kr.ac.kopo.board.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;


public class BoardVO {


	private int no;
	@Length(min = 2, max = 100, message = "제목에 2글자 이상을 입력해주세요.")
//	@NotEmpty(message = "필수항목입니다") 위 @Length에서 걸러지므로 얘는 필요 없다
	private String title;
	@Pattern(regexp = "^[A-Za-z0-9]*$", message="첫글자는 특수기호를 사용할 수 없습니다.")
	//"^[A-Za-z0-9]*$ 시작은 무조건 대문자" --- 더 많은 규칙은 '자바 정규표현식' 검색하여 공부
	@NotEmpty(message = "필수항목입니다")
	private String writer;
	@NotEmpty(message = "필수항목입니다")
	private String content;
	private int viewCnt;
	private String regDate;
	
	   
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", viewCnt="
				+ viewCnt + ", regDate=" + regDate + "]";
	}
	
	
}
