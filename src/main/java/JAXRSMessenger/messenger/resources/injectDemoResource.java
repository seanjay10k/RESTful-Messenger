package JAXRSMessenger.messenger.resources;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.UriInfo;

import JAXRSMessenger.messenger.beans.BeanMessageFilter;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/injectdemo")
public class injectDemoResource {


	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/annotation")
	public String getParamUsingAnnotation(@MatrixParam("param") String matrixParam,
										  @HeaderParam("authSessionId") String customHeader,
										  @CookieParam("name") String cookieValue) {
		//Note: if all three are not set, might get error
		//injectdemo/annotation;param=value ->String matrixParam="value";
		//injectdemo/annotation;param=value and set name=value pair in the header of submission ie authSessionId=8EFWF6EDF8 
		//INJECTDEMO/ANNOTATION;PARAM=VALUE AND set the header param and also if you have a cookie you can access value of that cookie
		return "test annotation param"+matrixParam+" "+customHeader+" "+cookieValue;
	}
	
	
	//What if you do not know the name of the headerparam or matrixparam or cookieparam 
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriinfo) {// UriInfo is like a library with awesome methods
	 //localhost:8080/messenger/webapi/injectdemo/context?start=3   ->
		//http://localhost:8080/messenger/webapi/injectdemo/context {start=[3]}
		return uriinfo.getAbsolutePath().toString()+" "+uriinfo.getQueryParameters().toString();
		
	}
	
	
	
	//if you dont know headerparam you are looking for ie cookie name you are looking for
	@GET
	@Path("contextheaders")
	public String getParamsUsingHeaders(@Context HttpHeaders headerinfo) {// HttpHeaders is like a library with awesome methods
	 //localhost:8080/messenger/webapi/injectdemo/contextheaders  ->
		//{name=$Version=0;name=invalidquantum, Cookie_1=$Version=0;Cookie_1=value}
		return headerinfo.getCookies().toString();
		
	}
	
	//You can use @BeanParam with a sepeare java bean with those @QueryParams declared.. compare MessageResourse get method with this.
	//BeanMessageFilter is a javabean under JAXRSMessenhger.messenger.beans
	@GET
	public String getQueryParamsUsingBeanParam(@BeanParam BeanMessageFilter filterBean) {
		//localhost:8080/messenger/webapi/injectdemo?start=20&size=10&year=2018  ->
			//year: 2018 size: 10 start: 20
		return "year: "+filterBean.getYear()+" size: "+ filterBean.getSize()+" start: "+filterBean.getStart();
	}
	
	
	
	
	
	
}

