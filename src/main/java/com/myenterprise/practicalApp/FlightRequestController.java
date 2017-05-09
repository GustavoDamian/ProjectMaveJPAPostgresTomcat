package com.myenterprise.practicalApp;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.myenterprise.practicalApp.core.ApproveAplicattionService;
import com.myenterprise.practicalApp.entities.MfFlight;

/***
 * @author Gustavo Damian
 * @date 07/05/2017
 */

@ManagedBean
@ViewScoped
public class FlightRequestController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{approveAplicattionService}")
	private ApproveAplicattionService approveAplicattionservice;

	private MfFlight mfFlight;
	private Date dateTravelSelected;

	@PostConstruct
	public void init() {
		mfFlight = new MfFlight();
	}

	public void inserFlightCustomer() {
		approveAplicattionservice.inserFlightCustomer(mfFlight);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mfFlight.getFlightDestination(),
				" Record inserted");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		mfFlight = new MfFlight();
	}

	public MfFlight getMfFlight() {
		return mfFlight;
	}

	public void setMfFlight(MfFlight mfFlight) {
		this.mfFlight = mfFlight;
	}

	public Date getDateTravelSelected() {
		return dateTravelSelected;
	}

	public void setDateTravelSelected(Date dateTravelSelected) {
		this.dateTravelSelected = dateTravelSelected;
	}

	public ApproveAplicattionService getApproveAplicattionservice() {
		return approveAplicattionservice;
	}

	public void setApproveAplicattionservice(ApproveAplicattionService approveAplicattionservice) {
		this.approveAplicattionservice = approveAplicattionservice;
	}

}
