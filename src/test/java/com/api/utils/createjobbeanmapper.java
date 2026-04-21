package com.api.utils;

import java.util.ArrayList;
import java.util.List;

import com.api.dataproviderbean.createjobbean;
import com.pojo.createjobapipayload;
import com.pojo.customer;
import com.pojo.customer_address;
import com.pojo.customer_product;
import com.pojo.customerpojo;
import com.pojo.problems;

public class createjobbeanmapper {

	
	
	private createjobbeanmapper() {}
	// we will provide the bean and it will create the payload for createjobapi
	
	public static createjobapipayload createjobpayloadcreator(createjobbean bean) {
		int mst_service_location_id=Integer.parseInt(bean.getMst_service_location_id());
		int mst_platform_id=Integer.parseInt(bean.getMst_platform_id());
		int mst_warrenty_status_id=Integer.parseInt(bean.getMst_warrenty_status_id());
		int mst_oem_id=Integer.parseInt(bean.getMst_oem_id());
		int product_id=Integer.parseInt(bean.getCustomer_product__product_id());
		int model_id=Integer.parseInt(bean.getCustomer_product__mst_model_id());
		customerpojo customer=new customerpojo(bean.getCustomer__first_name(),bean.getCustomer__last_name(),bean.getCustomer__mobile_number(),bean.getCustomer__mobile_number_alt(),bean.getCustomer__email_id(),bean.getCustomer__email_id_alt());
		customer_address customer_address=new customer_address(bean.getCustomer_address__flat_number(),bean.getCustomer_address__apartment_name(),bean.getCustomer_address__street_name(),bean.getCustomer_address__landmark(),bean.getCustomer_address__area(),bean.getCustomer_address__pincode(),bean.getCustomer_address__country(),bean.getCustomer_address__state());
		customer_product customer_product=new customer_product(bean.getCustomer_product__dop(),bean.getCustomer_product__serial_number(),bean.getCustomer_product__imei1(),bean.getCustomer_product__imei2(),bean.getCustomer_product__popurl(),product_id ,model_id );
		
		
		 List<problems> problemslist=new ArrayList<problems>();
		 int Problems__id=Integer.parseInt(bean.getProblems__id());
		 problems problem=new problems(Problems__id, bean.getProblems__remark());
		problemslist.add(problem);
		createjobapipayload payload=new createjobapipayload(mst_service_location_id, mst_platform_id, mst_warrenty_status_id, mst_oem_id, customer, customer_address, customer_product, problemslist);
		return payload;
	}
	}