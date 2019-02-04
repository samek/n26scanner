package si.root.n26scanner.Models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("com.asif.gsonpojogenerator")
public class Transaction implements Serializable {

	@SerializedName("amount")
	private double amount;

	@SerializedName("referenceText")
	private String referenceText;

	@SerializedName("partnerBic")
	private String partnerBic;

	@SerializedName("partnerName")
	private String partnerName;

	@SerializedName("type")
	private String type;

	@SerializedName("partnerIban")
	private String partnerIban;

	public void setAmount(double amount){
		this.amount = amount;
	}

	public double getAmount(){
		return amount;
	}

	public void setReferenceText(String referenceText){
		this.referenceText = referenceText;
	}

	public String getReferenceText(){
		return referenceText;
	}

	public void setPartnerBic(String partnerBic){
		this.partnerBic = partnerBic;
	}

	public String getPartnerBic(){
		return partnerBic;
	}

	public void setPartnerName(String partnerName){
		this.partnerName = partnerName;
	}

	public String getPartnerName(){
		return partnerName;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setPartnerIban(String partnerIban){
		this.partnerIban = partnerIban;
	}

	public String getPartnerIban(){
		return partnerIban;
	}

	@Override
 	public String toString(){
		return 
			"Transaction{" + 
			"amount = '" + amount + '\'' + 
			",referenceText = '" + referenceText + '\'' + 
			",partnerBic = '" + partnerBic + '\'' + 
			",partnerName = '" + partnerName + '\'' + 
			",type = '" + type + '\'' + 
			",partnerIban = '" + partnerIban + '\'' + 
			"}";
		}
}