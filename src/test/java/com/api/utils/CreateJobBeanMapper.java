package com.api.utils;

import java.util.ArrayList;
import java.util.List;

import com.api.pojo.CreateJobPayload;
import com.api.pojo.Customer;
import com.api.pojo.CustomerAddress;
import com.api.pojo.CustomerProduct;
import com.api.pojo.Problem;
import com.dataprovider.api.bean.CreateJobBean;

public class CreateJobBeanMapper {
	public CreateJobBeanMapper() {

	}

	public static CreateJobPayload mapper(CreateJobBean createBean) {
		int mstServiceLocationID = Integer.parseInt(createBean.getMst_service_location_id());
		int mstPlatformID = Integer.parseInt(createBean.getMst_platform_id());
		int mstOemID = Integer.parseInt(createBean.getMst_oem_id());
		int mstWarrentyStatusID = Integer.parseInt(createBean.getMst_warrenty_status_id());

		Customer customer = new Customer(createBean.getCustomer__first_name(), createBean.getCustomer__last_name(),
				createBean.getCustomer__mobile_number(), createBean.getCustomer__mobile_number_alt(),
				createBean.getCustomer__email_id(), createBean.getCustomer__email_id_alt());

		CustomerAddress customerAddress = new CustomerAddress(createBean.getCustomer_address__flat_number(),
				createBean.getCustomer_address__apartment_name(), createBean.getCustomer_address__street_name(),
				createBean.getCustomer_address__landmark(), createBean.getCustomer_address__area(),
				createBean.getCustomer_address__pincode(), createBean.getCustomer_address__country(),
				createBean.getCustomer_address__state());

		int productId = Integer.parseInt(createBean.getCustomer_product__product_id());
		int modelID = Integer.parseInt(createBean.getCustomer_product__mst_model_id());
		CustomerProduct customerProduct = new CustomerProduct(createBean.getCustomer_product__doop(),
				createBean.getCustomer_product__serial_number(), createBean.getCustomer_product__imei1(),
				createBean.getCustomer_product__imei2(), createBean.getCustomer_product__popurl(), productId, modelID);
		List<Problem> problemList = new ArrayList<Problem>();
		int problemId = Integer.parseInt(createBean.getProblems__id());
		Problem problem = new Problem(problemId, createBean.getProblems__remark());

		CreateJobPayload payload = new CreateJobPayload(mstServiceLocationID, mstPlatformID, mstWarrentyStatusID,
				mstOemID, customer, customerAddress, customerProduct, problemList);
		return payload;
	}

}
