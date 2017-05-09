package com.myenterprise.practicalApp;

import java.io.Serializable;
import java.util.List;

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
public class ApproveAplicationController implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<MfFlight> mfFlights;
	@ManagedProperty("#{approveAplicattionService}")
	private ApproveAplicattionService approveAplicattionService;
	private List<MfFlight> selectedCars;
	private MfFlight selectedMfFlight;

	@PostConstruct
	public void init() {
		System.out.println("PostConstruct");
		mfFlights = approveAplicattionService.getFlightCustomer();
	}

	public void updateMfFlightCustomer() {
		approveAplicattionService.updateFlightCustomer(selectedMfFlight);
		mfFlights = approveAplicattionService.getFlightCustomer();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, selectedMfFlight.getFlightDestination(),
				" Record update to Reserved");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public List<MfFlight> getMfFlights() {
		return mfFlights;
	}

	public void setMfFlights(List<MfFlight> mfFlights) {
		this.mfFlights = mfFlights;
	}

	public MfFlight getSelectedMfFlight() {
		return selectedMfFlight;
	}

	public void setSelectedMfFlight(MfFlight selectedMfFlight) {
		this.selectedMfFlight = selectedMfFlight;
	}

	public List<MfFlight> getSelectedCars() {
		return selectedCars;
	}

	public void setSelectedCars(List<MfFlight> selectedCars) {
		this.selectedCars = selectedCars;
	}

	public ApproveAplicattionService getApproveAplicattionService() {
		return approveAplicattionService;
	}

	public void setApproveAplicattionService(ApproveAplicattionService approveAplicattionService) {
		this.approveAplicattionService = approveAplicattionService;
	}

}
