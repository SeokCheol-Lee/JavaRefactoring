/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  Beneficiary.java
 * DESC  :  수혜자 정보(Data)
 * 
 * @author  김혜경
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
public class Beneficiary {
	/** 수혜자 번호 : pk*/
	private int no;

	/** 수혜자 이름 */
	private String name;  

	/** 수혜자 연락처 */
	private String contactInformation;

	/** 혜택받길 희망하는 기부 타입 */
	private String requestType;


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("수혜자 번호 : ");
		builder.append(no);
		builder.append(", 수혜자 이름 : ");
		builder.append(name);
		builder.append(", 수혜자 연락처 : ");
		builder.append(contactInformation);
		builder.append(", 수혜자가 희망하는 기부 내용 : ");
		builder.append(requestType);
		return builder.toString();
	}
}