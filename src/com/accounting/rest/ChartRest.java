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

import com.accounting.models.ChartOfAccounts;
import com.accounting.models.MoneyIn;
import com.accounting.models.MoneyOut;
import com.acounting.dao.ChartDAO;
import com.google.gson.Gson;


@Path(value = "/chartController")
public class ChartRest {

	
	ChartDAO charts = new ChartDAO();

	@POST
	@Path(value = "/savingMoneyIn")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response SaveMoneyIn(MoneyIn moneyIn) {

		charts.saveChart(moneyIn);
		return Response.status(Status.CREATED).build();

	}
	

	@POST
	@Path(value = "/savingMoneyOut")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response SaveMoneyOut(MoneyOut moneyOut) {

		charts.saveChart(moneyOut);		

		return Response.status(Status.CREATED).build();

	}

	@Path("/getAllCharts")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray viewCharts() throws JSONException {

		List<ChartOfAccounts> chartList = (List<ChartOfAccounts>) charts
				.viewCharts();

		JSONArray jsonArray = new JSONArray();

		for (int i = 0; i < chartList.size(); i++) {
			JSONObject chart = new JSONObject();
			chart.put("chartId", chartList.get(i).getChartId());
			chart.put("chartNumber", chartList.get(i)
					.getChartNumber());
			chart.put("chartDescription", chartList.get(i)
					.getChartDescription());

			jsonArray.put(chart);
		}
		return jsonArray;
	}
	@GET
	@Path("/getChartAcc/{chartId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getChartDescription(@PathParam("chartId") Long chartId) throws JSONException {
		
		ChartOfAccounts chatAccount =(ChartOfAccounts) charts.getCharts(chartId);
		
			JSONObject chart = new JSONObject();
			chart.put("chartId", chatAccount.getChartId());
			chart.put("chartNumber", chatAccount
					.getChartNumber());
			chart.put("chartDescription", chatAccount
					.getChartDescription());	
		return chart.toString();
	}

	@PUT
	@Path("updateChartsOfAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateCharts(ChartOfAccounts chartOfAccounts)
	{
		
		charts.updateChart(chartOfAccounts);
		String str= new Gson().toJson(chartOfAccounts);
		
		return str;
	}

	
}
