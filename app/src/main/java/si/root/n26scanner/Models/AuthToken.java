package si.root.n26scanner.Models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("com.asif.gsonpojogenerator")
public class AuthToken implements Serializable {

	@SerializedName("access_token")
	private String accessToken;

	@SerializedName("refresh_token")
	private String refreshToken;

	@SerializedName("host_url")
	private String hostUrl;

	@SerializedName("error_description")
	private String errorDescription;

	@SerializedName("scope")
	private String scope;

	@SerializedName("token_type")
	private String tokenType;

	@SerializedName("error")
	private String error;

	@SerializedName("expires_in")
	private int expiresIn;

	public void setAccessToken(String accessToken){
		this.accessToken = accessToken;
	}

	public String getAccessToken(){
		return accessToken;
	}

	public void setRefreshToken(String refreshToken){
		this.refreshToken = refreshToken;
	}

	public String getRefreshToken(){
		return refreshToken;
	}

	public void setHostUrl(String hostUrl){
		this.hostUrl = hostUrl;
	}

	public String getHostUrl(){
		return hostUrl;
	}

	public void setErrorDescription(String errorDescription){
		this.errorDescription = errorDescription;
	}

	public String getErrorDescription(){
		return errorDescription;
	}

	public void setScope(String scope){
		this.scope = scope;
	}

	public String getScope(){
		return scope;
	}

	public void setTokenType(String tokenType){
		this.tokenType = tokenType;
	}

	public String getTokenType(){
		return tokenType;
	}

	public void setError(String error){
		this.error = error;
	}

	public String getError(){
		return error;
	}

	public void setExpiresIn(int expiresIn){
		this.expiresIn = expiresIn;
	}

	public int getExpiresIn(){
		return expiresIn;
	}

	@Override
 	public String toString(){
		return 
			"AuthToken{" + 
			"access_token = '" + accessToken + '\'' + 
			",refresh_token = '" + refreshToken + '\'' + 
			",host_url = '" + hostUrl + '\'' + 
			",error_description = '" + errorDescription + '\'' + 
			",scope = '" + scope + '\'' + 
			",token_type = '" + tokenType + '\'' + 
			",error = '" + error + '\'' + 
			",expires_in = '" + expiresIn + '\'' + 
			"}";
		}
}