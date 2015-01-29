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

import com.accounting.models.Clerk;
import com.accounting.models.Employees;
import com.accounting.models.Manager;
import com.acounting.dao.EmployeeDAO;
import com.google.gson.Gson;


@Path("/employeesController")
public class EmployeeRest {

	EmployeeDAO employeeDao= new EmployeeDAO();

	@POST
	@Path(value="/savingClerk")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveClerkEmployee(Clerk employees){

		employeeDao.saveEmployee(employees);

		return Response.status(Status.CREATED).build();	
	}

	@POST
	@Path(value="/savingManager")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveManagerEmployee(Manager employees){

		employeeDao.saveEmployee(employees);

		return Response.status(Status.CREATED).build();	
	}

	@Path(value="/getAllEmployees")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray viewEmployees() throws JSONException
	{
		List<Employees> employeesList=(List<Employees>) employeeDao.viewAllEmployee();
		JSONArray jsonArray= new JSONArray();

		for(int i=0; i<employeesList.size(); i++)
		{
			JSONObject employees= new JSONObject();
			employees.put("employeeId", employeesList.get(i).getEmployeeId());
			employees.put("name", employeesList.get(i).getName());
			employees.put("surname", employeesList.get(i).getSurname());
			employees.put("telephone", employeesList.get(i).getTelephone());
			employees.put("address", employeesList.get(i).getAddress());

			jsonArray.put(employees);
		}
		return jsonArray;
	}
	
	@GET
	@Path("/getEmpById/{employeeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getEmployeeById(@PathParam("employeeId") Long employeeId) throws JSONException {
		
		Employees emps =(Employees) employeeDao.getEmployee(employeeId);
		
		JSONObject employees= new JSONObject();
		employees.put("employeeId", emps.getEmployeeId());
		employees.put("name", emps.getName());
		employees.put("surname", emps.getSurname());
		employees.put("telephone", emps.getTelephone());
		employees.put("address", emps.getAddress());
		
		return employees.toString();
	}
	
	@PUT
	@Path(value="/UpdateEmployee")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateEmployee(Employees employee){
		
		employeeDao.updateEmployees(employee);
		String str=new Gson().toJson(employee);

		return str;
		
	}
}
