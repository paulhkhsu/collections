package com.directv.tvapps.ws.rest.response;

import java.util.Date;

import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

//@XmlRootElement(name = "tvapps")
@XmlAccessorType(XmlAccessType.NONE)

public class ResponseRoot extends ResponseBase {
	@XmlAttribute
	private String link = "test";
	@XmlAttribute
	private String status = "success";
	@XmlAttribute
	private String errorCode = "0";
	@XmlAttribute
	private String errorText = "";
	@XmlAttribute
	private Date timestamp = new Date();

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	public void setLink(UriInfo uriInfo) {
		this.link = uriInfo.getAbsolutePath().toString();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorText() {
		return errorText;
	}

	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

}
