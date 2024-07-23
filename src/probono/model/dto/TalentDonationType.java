/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  TalentDonationType.java
 * DESC  :  재능기부 종류(Data)
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
@Getter  
@Setter
public class TalentDonationType {
	/** 재능 기부 타입(종류) */
	private String donationType; 
	
	/** 재능 기부 활동 영역 */
	private String activityArea;
	
	/** 재능 기부 활동 예시 */
	private String activityDetails;
 
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("기부 타입 : ");
		builder.append(donationType);
		builder.append(", 기부 활동 영역 : ");
		builder.append(activityArea);
		builder.append(", 기부 활동 예시 : ");
		builder.append(activityDetails);
		return builder.toString();
	}
}
