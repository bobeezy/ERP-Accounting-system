package com.accounting.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.accounting.models.Payabless;
import com.acounting.dao.PayablesDAO;
import com.google.gson.Gson;

@Path(value= "/payablesController")
public class PayablesRest {

	PayablesDAO payments=new PayablesDAO();
	
	@Path(value= "/savingPayments")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response SaveChartInJson(Payabless paymentss ){
		
		payments.savePayables(paymentss);

		return Response.status(Status.CREATED).build();

	}
	
	@Path(value="/getAllPayables")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray viewPayables() throws JSONException
	{
		List<Payabless> paysList=(List<Payabless>) payments.viewPayments();
		
		JSONArray jsonArray= new JSONArray();
		
		for(int i=0; i<paysList.size(); i++)
		{
			JSONObject pay= new JSONObject();
			pay.put("folioNumber", paysList.get(i).getFolioNumber());
			pay.put("payableType", paysList.get(i).getPayableType());
			pay.put("transactionDate", paysList.get(i).getTransactionDate());
			pay.put("amount", paysList.get(i).getAmount());
			pay.put("charts", paysList.get(i).getChart().getChartDescription());
			pay.put("employees", paysList.get(i).getEmployee().getName());
			
			jsonArray.put(pay);
		}
		return jsonArray;
		
	}
	@GET
	@Path("/getPayable/{folioNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getChartDescription(@PathParam("folioNumber") Long folioNumber) throws JSONException {
		
		Payabless payable =(Payabless)payments.getPayable(folioNumber);
		
		JSONObject pay= new JSONObject();
		pay.put("folioNumber", payable.getFolioNumber());
		pay.put("payableType", payable.getPayableType());
		pay.put("transactionDate", payable.getTransactionDate());
		pay.put("amount", payable.getAmount());
		pay.put("employees", payable.getEmployee().getName());
		pay.put("charts", payable.getChart().getChartDescription());
		return pay.toString();
	}
	
	@PUT
	@Path("updatePayables")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updatePayables(Payabless payabless)
	{
		payments.updatePayables(payabless);
		String str=new Gson().toJson(payabless);
		
		return str;
	}
}
