package si.root.n26scanner.Models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("com.asif.gsonpojogenerator")
public class TransferRequest implements Serializable {

	@SerializedName("pin")
	private String pin;

	@SerializedName("transaction")
	private Transaction transaction;

	public void setPin(String pin){
		this.pin = pin;
	}

	public String getPin(){
		return pin;
	}

	public void setTransaction(Transaction transaction){
		this.transaction = transaction;
	}

	public Transaction getTransaction(){
		return transaction;
	}

	@Override
 	public String toString(){
		return 
			"TransferRequest{" + 
			"pin = '" + pin + '\'' + 
			",transaction = '" + transaction + '\'' + 
			"}";
		}
}