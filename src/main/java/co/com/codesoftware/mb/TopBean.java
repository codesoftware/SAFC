package co.com.codesoftware.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import co.com.codesoftware.logic.SearchTopLogic;
import co.com.codesoftware.servicio.usuario.ClienteEntity;

@ManagedBean
@ViewScoped
public class TopBean implements Serializable{
	private UIData usersDataTable;
	private List<ClienteEntity> clientes;
	private List<ClienteEntity> clientesFilter;
	private ClienteEntity cliente;
	

	public UIData getUsersDataTable() {
		return usersDataTable;
	}

	public void setUsersDataTable(UIData usersDataTable) {
		this.usersDataTable = usersDataTable;
	}

	@PostConstruct
	public void init() {
		clientes = new ArrayList<>();
		SearchTopLogic logic = new SearchTopLogic();
		clientes = logic.searchClient();

	}
	
	public void getClient(){
		final String idUserSelected = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idClient");
		Long id = Long.parseLong(idUserSelected);
		SearchTopLogic logic = new SearchTopLogic();
		//cliente = logic.getLogicClient(id);
	}
	
	public void edit(ActionEvent event){
		System.out.println("User selected " + ((ClienteEntity) usersDataTable.getRowData()));
	}
	
	public void addClient(ActionEvent actionEvent){
		SearchTopLogic logic = new SearchTopLogic();
		if(logic.getLogicAddClient(this.cliente)!=null){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserto Correctamente", "OK");
	        FacesContext.getCurrentInstance().addMessage(null, message);	
		}else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No Inserto Correctamente", "Error");
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	

}
