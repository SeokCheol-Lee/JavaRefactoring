/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  TalentDonationProject.java
 * DESC  :  진행중인 프로젝트 정보(Data)
 * 
 * @author  
 * @version 1.0         
*/
package probono.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter 
public class TalentDonationProject {
    
	/** 프로젝트 고유 이름 : PK- 프로젝트 구분 데이터 */
	private String talentDonationProjectName; 

	/** 기부자 : 사번, 이름, 이메일, 기부자 정보 */
	private Donator projectDonator;  
		
	/** 수혜자 */
	private Beneficiary projectBeneficiary;

	/** 재능 기부 타입 */
	private TalentDonationType talentDonationType;

	/** 프로젝트 시작일 */
	private String startDate;

	/** 프로젝트 종료일 */
	private String endDate;

	/** 진행되는 project의 상세 내용 */
	private String talentDonationProjectDetail;

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("프로젝트명 : ");
		builder.append(talentDonationProjectName);
		builder.append(", 기부자 : ");
		builder.append(projectDonator);
		builder.append(", 수혜자 : ");
		builder.append(projectBeneficiary);
		builder.append(", 진행되는 기부 타입 : ");
		builder.append(talentDonationType);
		builder.append(", 기부 시작일 : ");
		builder.append(startDate);
		builder.append(", 기부 종료일 : ");
		builder.append(endDate);
		builder.append(", 기부 상세 내용 : ");
		builder.append(talentDonationProjectDetail);
		return builder.toString();
	}
}