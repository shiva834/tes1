package com.coms360.batch;

import java.io.Serializable;

public class CustomerBusinessEvent implements Serializable 
{
	public CustomerBusinessEvent(String eventId, String eventType, String eventStatus, String sourceSystem,
			String businessNatureCode, String amwayPartyId, String aBONumber, String channel, String localeId,
			String marketCode, String eCommTypeCd, String eventLogDate, String communicationDate, String businessKeys,
			String internalId, String content) {
		super();
		this.eventId = eventId;
		this.eventType = eventType;
		this.eventStatus = eventStatus;
		this.sourceSystem = sourceSystem;
		this.businessNatureCode = businessNatureCode;
		this.amwayPartyId = amwayPartyId;
		this.aBONumber = aBONumber;
		this.channel = channel;
		this.localeId = localeId;
		this.marketCode = marketCode;
		this.eCommTypeCd = eCommTypeCd;
		this.eventLogDate = eventLogDate;
		this.communicationDate = communicationDate;
		this.businessKeys = businessKeys;
		this.internalId = internalId;
		this.content = content;
	}
	public CustomerBusinessEvent() {
		// TODO Auto-generated constructor stub
	}
	String eventId;
	String eventType;
	String eventStatus;
	String sourceSystem;
	String businessNatureCode;
	String amwayPartyId;
	String aBONumber;
	String channel;
	String localeId;
	String marketCode;
	String eCommTypeCd;
	String eventLogDate;
	String communicationDate;
	String businessKeys;
	String internalId;
	String content;
	
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getEventStatus() {
		return eventStatus;
	}
	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}
	public String getSourceSystem() {
		return sourceSystem;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	public String getBusinessNatureCode() {
		return businessNatureCode;
	}
	public void setBusinessNatureCode(String businessNatureCode) {
		this.businessNatureCode = businessNatureCode;
	}
	public String getAmwayPartyId() {
		return amwayPartyId;
	}
	public void setAmwayPartyId(String amwayPartyId) {
		this.amwayPartyId = amwayPartyId;
	}
	public String getaBONumber() {
		return aBONumber;
	}
	public void setaBONumber(String aBONumber) {
		this.aBONumber = aBONumber;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getLocaleId() {
		return localeId;
	}
	public void setLocaleId(String localeId) {
		this.localeId = localeId;
	}
	public String getMarketCode() {
		return marketCode;
	}
	public void setMarketCode(String marketCode) {
		this.marketCode = marketCode;
	}
	public String geteCommTypeCd() {
		return eCommTypeCd;
	}
	public void seteCommTypeCd(String eCommTypeCd) {
		this.eCommTypeCd = eCommTypeCd;
	}
	public String getEventLogDate() {
		return eventLogDate;
	}
	public void setEventLogDate(String eventLogDate) {
		this.eventLogDate = eventLogDate;
	}
	public String getCommunicationDate() {
		return communicationDate;
	}
	public void setCommunicationDate(String communicationDate) {
		this.communicationDate = communicationDate;
	}
	public String getBusinessKeys() {
		return businessKeys;
	}
	public void setBusinessKeys(String businessKeys) {
		this.businessKeys = businessKeys;
	}
	public String getInternalId() {
		return internalId;
	}
	public void setInternalId(String internalId) {
		this.internalId = internalId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}	
}