/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  Donator.java
 * DESC  :  기부자 정보(Data)
 * 
 * @author  김혜경
 * @version 1.0
*/
package probono.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter  
@ToString  
public class Donator {
	/** 기부자 사번 */
	private int empno;
	
	/** 기부자 이름 */  
	private String ename;
	
	/** 기부자 이메일 */
	private String email;
	
	/** 기부자 재능 */
	private String talent;

	@Override  //재정의 표현 생략도 가능
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("기부를 희망하는 사원번호 : ");
		builder.append(empno);
		builder.append(", 사원명 : ");
		builder.append(ename);
		builder.append(", 이메일 주소 : ");
		builder.append(email);
		builder.append(", 재능 : ");
		builder.append(talent);
		return builder.toString();  //String으로 반환 메소드 호출
	}
	
	
}



