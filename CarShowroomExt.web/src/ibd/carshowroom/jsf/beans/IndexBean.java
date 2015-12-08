package ibd.carshowroom.jsf.beans;

import ibd.carshowroom.jsf.beans.ejb.ContextProviderBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "indexBean")
public class IndexBean {

	@EJB
	private ContextProviderBean contextProviderBean;
	
	private String username;
	
	public String getUsername() {
		if(username == null) {
			username = contextProviderBean.getSessionContext().getCallerPrincipal().getName();
		}
		return username;
	}
}
