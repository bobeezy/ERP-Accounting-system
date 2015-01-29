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

import com.accounting.models.Receivables;
import com.acounting.dao.ReceivablesDAO;
import com.google.gson.Gson;

@Path(value="/receivablesController")
public class ReceivablesRest {
	
	ReceivablesDAO receive=new ReceivablesDAO();
	
	@Path(value="/savingReceivebles")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response SaveChartInJson(Receivables receivable ){
		
		receive.saveReceivables(receivable);
		
	    return Response.status(Status.CREATED).build();
	
	}
	
	@Path(value="/getAllReceivables")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray viewReceivables() throws JSONException
	{
		List<Receivables> receivessList=(List<Receivables>) receive.viewReceivables();
		
		JSONArray jsonArray= new JSONArray();
		
		for(int i=0; i<receivessList.size(); i++)
		{
			JSONObject receives= new JSONObject();
			receives.put("folioNumber", receivessList.get(i).getFolioNumber());
			receives.put("receivableType", receivessList.get(i).getReceivableType());
			receives.put("transactionDate", receivessList.get(i).getTransactionDate());
			receives.put("amount", receivessList.get(i).getAmount());
			receives.put("employees", receivessList.get(i).getEmployee().getName());
			receives.put("charts", receivessList.get(i).getChart().getChartDescription());
			
			jsonArray.put(receives);
		}
		return jsonArray;
		
	}
	
	@GET
	@Path("/getReceivable/{folioNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getChartDescription(@PathParam("folioNumber") Long folioNumber) throws JSONException {
		
		Receivables recievable =(Receivables)receive.getReceivables(folioNumber);
		JSONObject receives= new JSONObject();
		receives.put("folioNumber", recievable.getFolioNumber());
		receives.put("receivableType",recievable.getReceivableType());
		receives.put("transactionDate", recievable.getTransactionDate());
		receives.put("amount", recievable.getAmount());
		receives.put("employees", recievable.getEmployee().getName());
		receives.put("charts", recievable.getChart().getChartDescription());
		return receives.toString();
	}
	
	@PUT
	@Path("updateReceivable")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateReceivable(Receivables receivables)
	{
		receive.updateRecievables(receivables);
		String str=new Gson().toJson(receivables);
		return str;
	}
	
	
}
