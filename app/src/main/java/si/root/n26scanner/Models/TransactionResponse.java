package si.root.n26scanner.Models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("com.asif.gsonpojogenerator")
public class TransactionResponse implements Serializable {

	@SerializedName("partnerEmail")
	private Object partnerEmail;

	@SerializedName("n26Iban")
	private String n26Iban;

	@SerializedName("userSmartCategory")
	private Object userSmartCategory;

	@SerializedName("type")
	private String type;

	@SerializedName("sepaPurposeCode")
	private Object sepaPurposeCode;

	@SerializedName("approved")
	private long approved;

	@SerializedName("userCertified")
	private Object userCertified;

	@SerializedName("transferWiseTransfer")
	private boolean transferWiseTransfer;

	@SerializedName("id")
	private String id;

	@SerializedName("bankTransaction")
	private boolean bankTransaction;

	@SerializedName("bankBalanceImpact")
	private Object bankBalanceImpact;

	@SerializedName("created")
	private long created;

	@SerializedName("recurring")
	private boolean recurring;

	@SerializedName("dataClass")
	private String dataClass;

	@SerializedName("failed")
	private Object failed;

	@SerializedName("transactionId")
	private Object transactionId;

	@SerializedName("accountId")
	private String accountId;

	@SerializedName("partnerBic")
	private String partnerBic;

	@SerializedName("additionalArgumentForFeeBooking")
	private Object additionalArgumentForFeeBooking;

	@SerializedName("updated")
	private long updated;

	@SerializedName("userCancelled")
	private Object userCancelled;

	@SerializedName("processorTransaction")
	private boolean processorTransaction;

	@SerializedName("initiated")
	private long initiated;

	@SerializedName("partnerBcn")
	private String partnerBcn;

	@SerializedName("partnerAccountIsSepa")
	private boolean partnerAccountIsSepa;

	@SerializedName("recipientIBAN")
	private String recipientIBAN;

	@SerializedName("partnerPhone")
	private Object partnerPhone;

	@SerializedName("description")
	private Object description;

	@SerializedName("availableBalanceImpact")
	private Object availableBalanceImpact;

	@SerializedName("senderIBAN")
	private String senderIBAN;

	@SerializedName("title")
	private Object title;

	@SerializedName("confirmed")
	private long confirmed;

	@SerializedName("hasBalanceImpact")
	private boolean hasBalanceImpact;

	@SerializedName("partnerBankName")
	private Object partnerBankName;

	@SerializedName("userAccepted")
	private long userAccepted;

	@SerializedName("userCancellable")
	private boolean userCancellable;

	@SerializedName("amount")
	private double amount;

	@SerializedName("debitTransferWithInvalidAmount")
	private boolean debitTransferWithInvalidAmount;

	@SerializedName("partnerName")
	private String partnerName;

	@SerializedName("visibleTS")
	private long visibleTS;

	@SerializedName("oldAmount")
	private Object oldAmount;

	@SerializedName("deduplicationId")
	private Object deduplicationId;

	@SerializedName("referenceToOriginalOperation")
	private Object referenceToOriginalOperation;

	@SerializedName("bankTransferTypeText")
	private Object bankTransferTypeText;

	@SerializedName("message")
	private String message;

	@SerializedName("userId")
	private String userId;

	@SerializedName("linkId")
	private String linkId;

	@SerializedName("uniqueTransactionId")
	private Object uniqueTransactionId;

	@SerializedName("discriminatorValue")
	private String discriminatorValue;

	@SerializedName("referenceText")
	private String referenceText;

	@SerializedName("descriminatorString")
	private String descriminatorString;

	@SerializedName("newAmount")
	private Object newAmount;

	@SerializedName("currencyCode")
	private String currencyCode;

	@SerializedName("partnerIban")
	private String partnerIban;

	@SerializedName("partnerAccountBan")
	private String partnerAccountBan;

	public void setPartnerEmail(Object partnerEmail){
		this.partnerEmail = partnerEmail;
	}

	public Object getPartnerEmail(){
		return partnerEmail;
	}

	public void setN26Iban(String n26Iban){
		this.n26Iban = n26Iban;
	}

	public String getN26Iban(){
		return n26Iban;
	}

	public void setUserSmartCategory(Object userSmartCategory){
		this.userSmartCategory = userSmartCategory;
	}

	public Object getUserSmartCategory(){
		return userSmartCategory;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setSepaPurposeCode(Object sepaPurposeCode){
		this.sepaPurposeCode = sepaPurposeCode;
	}

	public Object getSepaPurposeCode(){
		return sepaPurposeCode;
	}

	public void setApproved(long approved){
		this.approved = approved;
	}

	public long getApproved(){
		return approved;
	}

	public void setUserCertified(Object userCertified){
		this.userCertified = userCertified;
	}

	public Object getUserCertified(){
		return userCertified;
	}

	public void setTransferWiseTransfer(boolean transferWiseTransfer){
		this.transferWiseTransfer = transferWiseTransfer;
	}

	public boolean isTransferWiseTransfer(){
		return transferWiseTransfer;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setBankTransaction(boolean bankTransaction){
		this.bankTransaction = bankTransaction;
	}

	public boolean isBankTransaction(){
		return bankTransaction;
	}

	public void setBankBalanceImpact(Object bankBalanceImpact){
		this.bankBalanceImpact = bankBalanceImpact;
	}

	public Object getBankBalanceImpact(){
		return bankBalanceImpact;
	}

	public void setCreated(long created){
		this.created = created;
	}

	public long getCreated(){
		return created;
	}

	public void setRecurring(boolean recurring){
		this.recurring = recurring;
	}

	public boolean isRecurring(){
		return recurring;
	}

	public void setDataClass(String dataClass){
		this.dataClass = dataClass;
	}

	public String getDataClass(){
		return dataClass;
	}

	public void setFailed(Object failed){
		this.failed = failed;
	}

	public Object getFailed(){
		return failed;
	}

	public void setTransactionId(Object transactionId){
		this.transactionId = transactionId;
	}

	public Object getTransactionId(){
		return transactionId;
	}

	public void setAccountId(String accountId){
		this.accountId = accountId;
	}

	public String getAccountId(){
		return accountId;
	}

	public void setPartnerBic(String partnerBic){
		this.partnerBic = partnerBic;
	}

	public String getPartnerBic(){
		return partnerBic;
	}

	public void setAdditionalArgumentForFeeBooking(Object additionalArgumentForFeeBooking){
		this.additionalArgumentForFeeBooking = additionalArgumentForFeeBooking;
	}

	public Object getAdditionalArgumentForFeeBooking(){
		return additionalArgumentForFeeBooking;
	}

	public void setUpdated(long updated){
		this.updated = updated;
	}

	public long getUpdated(){
		return updated;
	}

	public void setUserCancelled(Object userCancelled){
		this.userCancelled = userCancelled;
	}

	public Object getUserCancelled(){
		return userCancelled;
	}

	public void setProcessorTransaction(boolean processorTransaction){
		this.processorTransaction = processorTransaction;
	}

	public boolean isProcessorTransaction(){
		return processorTransaction;
	}

	public void setInitiated(long initiated){
		this.initiated = initiated;
	}

	public long getInitiated(){
		return initiated;
	}

	public void setPartnerBcn(String partnerBcn){
		this.partnerBcn = partnerBcn;
	}

	public String getPartnerBcn(){
		return partnerBcn;
	}

	public void setPartnerAccountIsSepa(boolean partnerAccountIsSepa){
		this.partnerAccountIsSepa = partnerAccountIsSepa;
	}

	public boolean isPartnerAccountIsSepa(){
		return partnerAccountIsSepa;
	}

	public void setRecipientIBAN(String recipientIBAN){
		this.recipientIBAN = recipientIBAN;
	}

	public String getRecipientIBAN(){
		return recipientIBAN;
	}

	public void setPartnerPhone(Object partnerPhone){
		this.partnerPhone = partnerPhone;
	}

	public Object getPartnerPhone(){
		return partnerPhone;
	}

	public void setDescription(Object description){
		this.description = description;
	}

	public Object getDescription(){
		return description;
	}

	public void setAvailableBalanceImpact(Object availableBalanceImpact){
		this.availableBalanceImpact = availableBalanceImpact;
	}

	public Object getAvailableBalanceImpact(){
		return availableBalanceImpact;
	}

	public void setSenderIBAN(String senderIBAN){
		this.senderIBAN = senderIBAN;
	}

	public String getSenderIBAN(){
		return senderIBAN;
	}

	public void setTitle(Object title){
		this.title = title;
	}

	public Object getTitle(){
		return title;
	}

	public void setConfirmed(long confirmed){
		this.confirmed = confirmed;
	}

	public long getConfirmed(){
		return confirmed;
	}

	public void setHasBalanceImpact(boolean hasBalanceImpact){
		this.hasBalanceImpact = hasBalanceImpact;
	}

	public boolean isHasBalanceImpact(){
		return hasBalanceImpact;
	}

	public void setPartnerBankName(Object partnerBankName){
		this.partnerBankName = partnerBankName;
	}

	public Object getPartnerBankName(){
		return partnerBankName;
	}

	public void setUserAccepted(long userAccepted){
		this.userAccepted = userAccepted;
	}

	public long getUserAccepted(){
		return userAccepted;
	}

	public void setUserCancellable(boolean userCancellable){
		this.userCancellable = userCancellable;
	}

	public boolean isUserCancellable(){
		return userCancellable;
	}

	public void setAmount(double amount){
		this.amount = amount;
	}

	public double getAmount(){
		return amount;
	}

	public void setDebitTransferWithInvalidAmount(boolean debitTransferWithInvalidAmount){
		this.debitTransferWithInvalidAmount = debitTransferWithInvalidAmount;
	}

	public boolean isDebitTransferWithInvalidAmount(){
		return debitTransferWithInvalidAmount;
	}

	public void setPartnerName(String partnerName){
		this.partnerName = partnerName;
	}

	public String getPartnerName(){
		return partnerName;
	}

	public void setVisibleTS(long visibleTS){
		this.visibleTS = visibleTS;
	}

	public long getVisibleTS(){
		return visibleTS;
	}

	public void setOldAmount(Object oldAmount){
		this.oldAmount = oldAmount;
	}

	public Object getOldAmount(){
		return oldAmount;
	}

	public void setDeduplicationId(Object deduplicationId){
		this.deduplicationId = deduplicationId;
	}

	public Object getDeduplicationId(){
		return deduplicationId;
	}

	public void setReferenceToOriginalOperation(Object referenceToOriginalOperation){
		this.referenceToOriginalOperation = referenceToOriginalOperation;
	}

	public Object getReferenceToOriginalOperation(){
		return referenceToOriginalOperation;
	}

	public void setBankTransferTypeText(Object bankTransferTypeText){
		this.bankTransferTypeText = bankTransferTypeText;
	}

	public Object getBankTransferTypeText(){
		return bankTransferTypeText;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setLinkId(String linkId){
		this.linkId = linkId;
	}

	public String getLinkId(){
		return linkId;
	}

	public void setUniqueTransactionId(Object uniqueTransactionId){
		this.uniqueTransactionId = uniqueTransactionId;
	}

	public Object getUniqueTransactionId(){
		return uniqueTransactionId;
	}

	public void setDiscriminatorValue(String discriminatorValue){
		this.discriminatorValue = discriminatorValue;
	}

	public String getDiscriminatorValue(){
		return discriminatorValue;
	}

	public void setReferenceText(String referenceText){
		this.referenceText = referenceText;
	}

	public String getReferenceText(){
		return referenceText;
	}

	public void setDescriminatorString(String descriminatorString){
		this.descriminatorString = descriminatorString;
	}

	public String getDescriminatorString(){
		return descriminatorString;
	}

	public void setNewAmount(Object newAmount){
		this.newAmount = newAmount;
	}

	public Object getNewAmount(){
		return newAmount;
	}

	public void setCurrencyCode(String currencyCode){
		this.currencyCode = currencyCode;
	}

	public String getCurrencyCode(){
		return currencyCode;
	}

	public void setPartnerIban(String partnerIban){
		this.partnerIban = partnerIban;
	}

	public String getPartnerIban(){
		return partnerIban;
	}

	public void setPartnerAccountBan(String partnerAccountBan){
		this.partnerAccountBan = partnerAccountBan;
	}

	public String getPartnerAccountBan(){
		return partnerAccountBan;
	}

	@Override
 	public String toString(){
		return 
			"TransactionResponse{" + 
			"partnerEmail = '" + partnerEmail + '\'' + 
			",n26Iban = '" + n26Iban + '\'' + 
			",userSmartCategory = '" + userSmartCategory + '\'' + 
			",type = '" + type + '\'' + 
			",sepaPurposeCode = '" + sepaPurposeCode + '\'' + 
			",approved = '" + approved + '\'' + 
			",userCertified = '" + userCertified + '\'' + 
			",transferWiseTransfer = '" + transferWiseTransfer + '\'' + 
			",id = '" + id + '\'' + 
			",bankTransaction = '" + bankTransaction + '\'' + 
			",bankBalanceImpact = '" + bankBalanceImpact + '\'' + 
			",created = '" + created + '\'' + 
			",recurring = '" + recurring + '\'' + 
			",dataClass = '" + dataClass + '\'' + 
			",failed = '" + failed + '\'' + 
			",transactionId = '" + transactionId + '\'' + 
			",accountId = '" + accountId + '\'' + 
			",partnerBic = '" + partnerBic + '\'' + 
			",additionalArgumentForFeeBooking = '" + additionalArgumentForFeeBooking + '\'' + 
			",updated = '" + updated + '\'' + 
			",userCancelled = '" + userCancelled + '\'' + 
			",processorTransaction = '" + processorTransaction + '\'' + 
			",initiated = '" + initiated + '\'' + 
			",partnerBcn = '" + partnerBcn + '\'' + 
			",partnerAccountIsSepa = '" + partnerAccountIsSepa + '\'' + 
			",recipientIBAN = '" + recipientIBAN + '\'' + 
			",partnerPhone = '" + partnerPhone + '\'' + 
			",description = '" + description + '\'' + 
			",availableBalanceImpact = '" + availableBalanceImpact + '\'' + 
			",senderIBAN = '" + senderIBAN + '\'' + 
			",title = '" + title + '\'' + 
			",confirmed = '" + confirmed + '\'' + 
			",hasBalanceImpact = '" + hasBalanceImpact + '\'' + 
			",partnerBankName = '" + partnerBankName + '\'' + 
			",userAccepted = '" + userAccepted + '\'' + 
			",userCancellable = '" + userCancellable + '\'' + 
			",amount = '" + amount + '\'' + 
			",debitTransferWithInvalidAmount = '" + debitTransferWithInvalidAmount + '\'' + 
			",partnerName = '" + partnerName + '\'' + 
			",visibleTS = '" + visibleTS + '\'' + 
			",oldAmount = '" + oldAmount + '\'' + 
			",deduplicationId = '" + deduplicationId + '\'' + 
			",referenceToOriginalOperation = '" + referenceToOriginalOperation + '\'' + 
			",bankTransferTypeText = '" + bankTransferTypeText + '\'' + 
			",message = '" + message + '\'' + 
			",userId = '" + userId + '\'' + 
			",linkId = '" + linkId + '\'' + 
			",uniqueTransactionId = '" + uniqueTransactionId + '\'' + 
			",discriminatorValue = '" + discriminatorValue + '\'' + 
			",referenceText = '" + referenceText + '\'' + 
			",descriminatorString = '" + descriminatorString + '\'' + 
			",newAmount = '" + newAmount + '\'' + 
			",currencyCode = '" + currencyCode + '\'' + 
			",partnerIban = '" + partnerIban + '\'' + 
			",partnerAccountBan = '" + partnerAccountBan + '\'' + 
			"}";
		}
}