package com.dst.space.service;

import com.dst.station.bean.QualityWorkOrderOutParam;
import com.dst.station.bean.SpaceWorkOrderDO;
import com.dst.station.service.SbyService;
import com.dst.steed.common.util.DstJsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 质检工单 历史数据需要初始化，质检信息和异常描述
 */
public class SpaceZJGDINITTest {
    public static final String evn = "dev";
    //    public static final String token = "ia407d7b995e2441ab9ebf5e46f15fa24";
    public static final String token = "i65fd2319de3b41d8b80797611972c547";
    private static final Logger log = LoggerFactory.getLogger(SpaceZJGDINITTest.class);

    public static void main(String[] args) {
        //质检工单创建参数
        QualityWorkOrderOutParam param = new QualityWorkOrderOutParam();
        param.setVinCode("VEHP1785326298521");
        param.setType("3");
        param.setQType("1");
        param.setStationId(35);
        param.setPlateNumber("京A12345");
        param.setRelationOrderCode("1234567890");
        param.setRelationOrderType("1");
        String json = "{\n" +
                "    \"orderTypeId\": \"1939897836110807041\",\n" +
                "    \"data\": {\n" +
                "        \"brandAttrValueName\": \"江淮牌\",\n" +
                "        \"categoryAttrValueName\": null,\n" +
                "        \"cityName\": \"深圳市\",\n" +
                "        \"qualityResult\": null,\n" +
                "        \"leixing\": \"2\",\n" +
                "        \"maintenanceStatus\": null,\n" +
                "        \"maintenanceTime\": null,\n" +
                "        \"modelAttrValueName\": \"帅铃i6\",\n" +
                "        \"orderCode\": null,\n" +
                "        \"plateNumber\": \"京Q10407\",\n" +
                "        \"plateNumberValue\": \"京Q10407\",\n" +
                "        \"regionCode\": \"东南大区\",\n" +
                "        \"regionName\": \"东南大区\",\n" +
                "        \"relationBackOrderCode\": \"1111111111\",\n" +
                "        \"relationDeliveryOrderCode\": \"S20260421-0008\",\n" +
                "        \"relationMaintenanceOrderCode\": null,\n" +
                "        \"relationOrderCode\": \"ZBGD00691789731147544\",\n" +
                "        \"relationOrderType\": \"整备\",\n" +
                "        \"remark\": null,\n" +
                "        \"serveCityCode\": \"440300\",\n" +
                "        \"specialInspection\": \"非专项质检\",\n" +
                "        \"stationCode\": \"S1807180001\",\n" +
                "        \"stationId\": \"35\",\n" +
                "        \"stationName\": \"深圳市顺丰万基场站\",\n" +
                "        \"type\": \"2\",\n" +
                "        \"vin\": \"LHB14T3E10413GR10407\",\n" +
                "        \"vinCode\": \"LHB14T3E10413GR10407\",\n" +
                "        \"relationSubTable\":\"m_djclzb_m\"\n" +
                "    }\n" +
                "}";


        SpaceWorkOrderDO spaceWorkOrderDO = DstJsonUtil.toObject(json, SpaceWorkOrderDO.class);

        for (int i = 0; i < 200; i++){
            SbyService.submitWorkorder(evn, token, spaceWorkOrderDO);
        }

    }

}
