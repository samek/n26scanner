package si.root.n26scanner.Models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("com.asif.gsonpojogenerator")
public class Me implements Serializable {

	@SerializedName("lastName")
	private String lastName;

	@SerializedName("mobilePhoneNumber")
	private String mobilePhoneNumber;

	@SerializedName("gender")
	private String gender;

	@SerializedName("kycLastName")
	private String kycLastName;

	@SerializedName("title")
	private String title;

	@SerializedName("birthDate")
	private long birthDate;

	@SerializedName("idNowToken")
	private Object idNowToken;

	@SerializedName("firstName")
	private String firstName;

	@SerializedName("transferWiseTermsAccepted")
	private boolean transferWiseTermsAccepted;

	@SerializedName("nationality")
	private String nationality;

	@SerializedName("kycFirstName")
	private String kycFirstName;

	@SerializedName("id")
	private String id;

	@SerializedName("shadowUserId")
	private String shadowUserId;

	@SerializedName("signupCompleted")
	private boolean signupCompleted;

	@SerializedName("email")
	private String email;

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber){
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public String getMobilePhoneNumber(){
		return mobilePhoneNumber;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setKycLastName(String kycLastName){
		this.kycLastName = kycLastName;
	}

	public String getKycLastName(){
		return kycLastName;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setBirthDate(long birthDate){
		this.birthDate = birthDate;
	}

	public long getBirthDate(){
		return birthDate;
	}

	public void setIdNowToken(Object idNowToken){
		this.idNowToken = idNowToken;
	}

	public Object getIdNowToken(){
		return idNowToken;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setTransferWiseTermsAccepted(boolean transferWiseTermsAccepted){
		this.transferWiseTermsAccepted = transferWiseTermsAccepted;
	}

	public boolean isTransferWiseTermsAccepted(){
		return transferWiseTermsAccepted;
	}

	public void setNationality(String nationality){
		this.nationality = nationality;
	}

	public String getNationality(){
		return nationality;
	}

	public void setKycFirstName(String kycFirstName){
		this.kycFirstName = kycFirstName;
	}

	public String getKycFirstName(){
		return kycFirstName;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setShadowUserId(String shadowUserId){
		this.shadowUserId = shadowUserId;
	}

	public String getShadowUserId(){
		return shadowUserId;
	}

	public void setSignupCompleted(boolean signupCompleted){
		this.signupCompleted = signupCompleted;
	}

	public boolean isSignupCompleted(){
		return signupCompleted;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"Me{" + 
			"lastName = '" + lastName + '\'' + 
			",mobilePhoneNumber = '" + mobilePhoneNumber + '\'' + 
			",gender = '" + gender + '\'' + 
			",kycLastName = '" + kycLastName + '\'' + 
			",title = '" + title + '\'' + 
			",birthDate = '" + birthDate + '\'' + 
			",idNowToken = '" + idNowToken + '\'' + 
			",firstName = '" + firstName + '\'' + 
			",transferWiseTermsAccepted = '" + transferWiseTermsAccepted + '\'' + 
			",nationality = '" + nationality + '\'' + 
			",kycFirstName = '" + kycFirstName + '\'' + 
			",id = '" + id + '\'' + 
			",shadowUserId = '" + shadowUserId + '\'' + 
			",signupCompleted = '" + signupCompleted + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}