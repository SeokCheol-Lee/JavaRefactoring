# Java Refactoring

### 리펙토링 목록

1. final 선언
    - 기존

        ```java
        
        	private ArrayList<TalentDonationProject> donationProjectList = new ArrayList<TalentDonationProject>();
        ```

    - 리펙토링

        ```java
        private final ArrayList<TalentDonationProject> donationProjectList = new ArrayList<TalentDonationProject>();
        
        ```

    - 이유
        - donationProject를 담고 있는 리스트로 외부에 의해 변경이 되면 안되므로 final 선언을 하여 불변성을 보장함
2. Optional 설정
    - 기존

    ```java
    public void donationProjectInsert(TalentDonationProject project){
    	
    		String projectName = project.getTalentDonationProjectName();
    		if(projectName != null && projectName.length() != 0) {
    			try {
    				
    				service.donationProjectInsert(project);
    				EndView.successMessage("새로운 프로젝트 등록 성공했습니다.");
    				
    			} catch (Exception e) {
    				FailView.failViewMessage(e.getMessage()); //실패인 경우 예외로 end user 서비스
    				e.printStackTrace();
    			}
    		}else {
    			FailView.failViewMessage("입력 부족, 재 확인 하세요~~");
    		}
    	}
    ```

    - 리펙토링

    ```java
    public void donationProjectInsert(TalentDonationProject project) throws Exception{		
    		Optional.ofNullable(project.getTalentDonationProjectName())
    				.orElseThrow(() -> new IllegalArgumentException("입력 부족, 재 확인 하세요~~"));
    		service.donationProjectInsert(project);
    		EndView.successMessage("새로운 프로젝트 등록 성공했습니다.");
    	}
    ```

    - 코드 간결성, Optional로 인한 nullException 해결
3. stream 사용
    - 기존

    ```java
    public void beneficiaryProjectUpdate(String projectName, Beneficiary people) {
    
    		for (TalentDonationProject project : donationProjectList) {
    
    			if (project != null && project.getTalentDonationProjectName().equals(projectName)) {
    
    				project.setProjectBeneficiary(people);
    
    				break;
    			}
    		}
    
    	}
    ```

    - 리펙토링

    ```java
    public void beneficiaryProjectUpdate(String projectName, Beneficiary people) {
    		donationProjectList.stream().filter(p -> !p.getTalentDonationProjectName().equals(projectName))
    			.forEach(p -> Optional.ofNullable(p)
    					.orElseThrow(() -> new IllegalArgumentException())
    					.setProjectBeneficiary(people));
    
    	}
    ```