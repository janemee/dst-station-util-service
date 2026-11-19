(function() {
	// 获取HTTP任务返回的数据
	var responseData = $.workorderResponse;
	// 检查响应是否成功
	if (!responseData || responseData.code !== '00000000') {
		return {
			status: 'error',
			message: responseData ? responseData.msg: '未知错误',
			data: null
		};
	}
	// 初始化组装结果数组
	var assembledResults = [];
	// 获取工单列表数据
	var workorderList = responseData.data && responseData.data.list ? responseData.data.list: [];
	// 遍历工单列表进行数据组装
	workorderList.forEach(function(order) {
		// 组装处理人信息
		var handlePersonCodes = [];
		var handleUserNames = [];
		if (order.handlerNames) {
			handleUserNames = order.handlerNames.split(',');
		}
		if (order.handlerIds) {
			handlePersonCodes = order.handlerIds.split(',');
		}
		// 根据processState计算workOrderStatus
		var workOrderStatus = null;
		if (order.processState !== undefined && order.processState !== null) {
			if (order.processState == '1' || order.processState == '2') {
				workOrderStatus = 1;
			} else if (order.processState == '3') {
				workOrderStatus = 2;
			} else if (order.processState == '4') {
				workOrderStatus = 3;
			}
		}
		// 创建businessParams对象并进行字段转换
		var businessParams = {
			orderCode: order.orderCode,
			ywgdmc : order.fYwgdmc ,
			txbq: order.fTxbq ,
			plateNumber: order.fPlateNumber ,
			vinCode: order.fVincode ,
			jlizwxq893383: order.fJlizwxq893383 ,
			car_brand_id: order.fCarBrandId ,
			car_type_id: order.fCartypeid ,
			car_type: order.fBwvjfqm713641 ,
			operator_name: order.fCompanyName ,
			operator_code: order.fOrgCompanyCode ,
			isExternalCar: order.fIsExternalCar ,
			customer_name: order.fCustomerName ,
			customer_id: order.fCustomerId ,
			customer_class: order.fCustomerClassName ,
			car_order_code: order.fQrydmnd772044 ,
			submitter: order.fSubmitter ,
			submitter_tel: order.fSubmitterTel ,
			fault_city: order.fFailureCity ,
			fault_city_code: order.fFailureCityCode ,
			fault_address: order.fFaultAddress ,
			failure_types: order.fFaulttypearrLabels || order.fFaulttype ,
			failure_type_ids: order.fFaulttypearrValue || order.fFaulttypevalues ,
			fault_description: order.fFaultDescription ,
			repair_station_id: order.fStoreId ,
			repair_station_name: order.fStoreName ,
			store_address: order.fStoreAddress ,
			book_service: order.fYyfwLabel ,
			reservation_arrival_time: order.fReservationArrivalTime ,
			repair_progress_name: order.fRepairStatusTxt ,
			is_reminder_name: order.fCustomerReminder
		};

		//创建组装对象
		var assembledItem = {
			typeCode: 'WBYYD037',

			// 工单类型编码
			businessOrderCode: order.orderCode || order.fOrdercode || '',
			// 业务工单编码
			businessOrderStatus: order.businessState || '',
			// 业务工单状态
			handlePersonCodes: Java.to(handlePersonCodes, 'java.lang.String[]'),
			// 处理人SPACE
			handleUserNames: Java.to(handleUserNames, 'java.lang.String[]'),
			// 处理人名称
			workOrderStatus: workOrderStatus,
			// 根据processState映射的工单状态
			businessParams: businessParams,
			 // 业务参数对象
			extendParams: order
			};
			assembledResults.push(assembledItem);
		}); // 返回组装结果
		return {
			limit: responseData.data.pageSize,
			totalNum: responseData.data.totalCount,
			totalPage: responseData.data.totalPage,
			list: Java.to(assembledResults, 'java.util.Map[]')
		};
	})();