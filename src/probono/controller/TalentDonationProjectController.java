package probono.controller;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import probono.model.dto.Beneficiary;
import probono.model.dto.Donator;
import probono.model.dto.TalentDonationProject;
import probono.service.TalentDonationProjectService;
import probono.view.EndView;
import probono.view.FailView;

public class TalentDonationProjectController {
	// singleton design pattern
	/* 객체 생성 수 제약ㄱ
	*
	* 단 하나의 객체를 다른 외부 클래스에 받아서 사용 가능하게는 함
	* - 공유 개념, 보유하고 있는 멤버 변수나 메소드 외부 호출 가능하게 하기 위한
	* - 주의 사항
	* 	- 외부에서 해당 객체를 삭제, 수정 금지
	* 	- 해당 객체를 보유하고 참조하는 변수값 수정 금지 : private 변수
	* 	- 생성자 외부 호출 호출 : private 생성자
	* 	- 객체를 공유한다는 건 객체의 주소값 공유 : public
	* - 변수명 : instance / 메소드명 : getInstance()
	* - jpa 기술문서등에 createInstance()...
	* */

	private static TalentDonationProjectController instance = new TalentDonationProjectController();
	private static TalentDonationProjectService service = TalentDonationProjectService.getInstance();

	private TalentDonationProjectController() {}

	public static TalentDonationProjectController getInstance() {
		return instance;
	}
  
	
	/**
	 * 모든 Project 검색
	 * 
	 * @return 모든 Project
	 */
	public void getDonationProjectsList() {
		EndView.projectListView(service.getDonationProjectsList());	
	}


	/**
	 * Project 이름으로 검색 - 객체된 Project 반환하기
	 * 
	 * @param projectName 프로젝트 이름
	 * @return TalentDonationProject 검색된 프로젝트
	 */
	public void getDonationProject(String projectName) {
		EndView.projectView(service.getDonationProject(projectName));
	}

	
	/**
	 * 브라우저의 입력잧(form) 입력없이 데이터 전송 - "" 문자열 객체, 길이는 0
	 * 미존재하는 요청 = server에선 null
	 *
	 * 새로운 Project 추가
	 * 
	 * @param project 저장하고자 하는 새로운 프로젝트
	 */
	public void donationProjectInsert(TalentDonationProject project) throws Exception{		
		Optional.ofNullable(project.getTalentDonationProjectName())
				.orElseThrow(() -> new IllegalArgumentException("입력 부족, 재 확인 하세요~~"));
		service.donationProjectInsert(project);
		EndView.successMessage("새로운 프로젝트 등록 성공했습니다.");
	}

	/**
	 * Project의 기부자 수정 - 프로젝트 명으로 검색해서 해당 프로젝트의 기부자 수정
	 * 
	 * @param projectName 프로젝트 이름
	 * @param people      기부자
	 */
	public void donationProjectUpdate(String projectName, Donator people) {
		
		try {
			service.donationProjectUpdate(projectName, people);
		} catch (Exception e) {
			FailView.failViewMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Project의 수혜자 수정 - 프로젝트 명으로 검색해서 해당 프로젝트의 수혜자 수정
	 * 
	 * @param projectName 프로젝트 이름
	 * @param people      수혜자
	 */
	public void beneficiaryProjectUpdate(String projectName, Beneficiary people) {
		service.beneficiaryProjectUpdate(projectName, people);
	}

	/**
	 * Project 삭제 - 프로젝트 명으로 해당 프로젝트 삭제
	 * 
	 * @param projectName 삭제하고자 하는 프로젝트 이름
	 */
	public void donationProjectDelete(String projectName) {
		service.donationProjectDelete(projectName);
	}

}
