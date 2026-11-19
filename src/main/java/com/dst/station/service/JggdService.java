package com.dst.station.service;

import cn.hutool.core.collection.CollectionUtil;
import com.dst.station.bean.*;
import com.dst.station.common.VehicleAttrConst;
import com.dst.steed.common.domain.response.Response;
import com.dst.steed.common.domain.user.SSOUser;
import com.dst.steed.common.util.DstJsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class JggdService {
    /**
     * 技改工单-更新车属性
     *
     * @return 响应
     */
    public static Response<?> updateCarAttribute(String evn, String token, String orderCode) {
        //查询技改工单
        TechnicalModificationWorkOrderVO transformationOrder = SbyService.getTechnicalTransformationOrder(evn, token, orderCode);
        if (transformationOrder == null) {
            return Response.error("工单不存在");
        }
        CarAttrChangeMessage message = new CarAttrChangeMessage();
        message.setBusCode("LYJG20250429");
        message.setVinCodes(transformationOrder.getVinCode());
        //获取需要更新的车属性
        Map<String, String> attrData = getNeedUpdateCarAttr(transformationOrder);
        //技改验收 尾板品牌
        attrData.putAll(getTailBoardBrand(evn, token, orderCode));
        //加装
        if (VehicleAttrConst.TECH_CHANGE_TYPE_INSTALL.equals(transformationOrder.getRefitType())) {
            if (!attrData.isEmpty()) {
                message.setAttrData(attrData);
            }
        }
        //拆除
        if (VehicleAttrConst.TECH_CHANGE_TYPE_TEAR_DOWN.equals(transformationOrder.getRefitType())) {
            if (!attrData.isEmpty()) {
                Map<String, String> attrDataMap = new HashMap<>();
                Map<String, Object> delAttrKeyAndValues = new HashMap<>();
                for (String key : attrData.keySet()) {
                    if (VehicleAttrConst.A_TECHMOD_CARGO_BOX.equals(key)) {
                        delAttrKeyAndValues.put(key, Arrays.asList(attrData.get(key).split(",")));
                    } else if (VehicleAttrConst.A_TECHMOD_ADD_EQUIPMENT.equals(key)) {
                        delAttrKeyAndValues.put(key, Arrays.asList(attrData.get(key).split(",")));
                    } else if (VehicleAttrConst.A_OPT_CAR_TERMINAL.equals(key)) {
                        delAttrKeyAndValues.put(key, Arrays.asList(attrData.get(key).split(",")));
                    } else {
                        attrDataMap.put(key, attrData.get(key));
                    }
                }
                //更新
                message.setAttrData(attrDataMap);
                //剔除
                message.setDelAttrKeyAndValues(delAttrKeyAndValues);
            }
        }
        if (CollectionUtil.isNotEmpty(attrData)) {
            message.setOperatorId("0205363439694716");
            message.setOperatorName("吴杰");
            message.setRemark("技改工单-更新车辆属性");
            //调用车辆修改属性mq
            return SbyService.updateVehicleAttrByMq(evn, token, message);
        }
        return Response.error("无需要更新的车辆属性");
    }

    /**
     * 获取需要修改车辆属性
     */
    public static Map<String, String> getNeedUpdateCarAttr(TechnicalModificationWorkOrderVO transformationOrder) {
        Map<String, String> attrData = new HashMap<>();
        //车身颜色
        if (StringUtils.isNotBlank(transformationOrder.getCarColor())) {
            attrData.put(VehicleAttrConst.A_CAR_COLOR, transformationOrder.getCarColor());
        }
        //尾板状态
        if (StringUtils.isNotBlank(transformationOrder.getTailBoardStatus())) {
            attrData.put(VehicleAttrConst.AK_A_CAR_ENDURANCE, transformationOrder.getTailBoardStatus());
        }
        //尾板品牌
        if (StringUtils.isNotBlank(transformationOrder.getTailBoardBrand())) {
            attrData.put(VehicleAttrConst.A_TAIL_BOARD_BRAND, transformationOrder.getTailBoardBrand());
        }
        //尾板护栏
        if (StringUtils.isNotBlank(transformationOrder.getTailBoardBarrier())) {
            attrData.put(VehicleAttrConst.A_OPT_TAILBOARD_GUARDRAIL, transformationOrder.getTailBoardBarrier());
        }
        //冷机制热模块
        if (StringUtils.isNotBlank(transformationOrder.getColdMechanismHeatModule())) {
            attrData.put(VehicleAttrConst.A_OPT_CHILLER_HEAT_MODULE, transformationOrder.getColdMechanismHeatModule());
        }
        //温感主机
        if (StringUtils.isNotBlank(transformationOrder.getHeatDetectionControlPanel())) {
            attrData.put(VehicleAttrConst.A_OPT_HEAT_DETECTION_CONTROL_PANEL, transformationOrder.getHeatDetectionControlPanel());
        }
        //厢体技改
        if (StringUtils.isNotBlank(transformationOrder.getTailBoardRefit())) {
            attrData.put(VehicleAttrConst.A_TECHMOD_CARGO_BOX, transformationOrder.getTailBoardRefit());
        }
        //加装设备
        if (StringUtils.isNotBlank(transformationOrder.getAddEquipment())) {
            attrData.put(VehicleAttrConst.A_TECHMOD_ADD_EQUIPMENT, transformationOrder.getAddEquipment());
        }
        //智能车载终端装备
        if (StringUtils.isNotBlank(transformationOrder.getIntelligentCarEquipment())) {
            attrData.put(VehicleAttrConst.A_OPT_CAR_TERMINAL, transformationOrder.getIntelligentCarEquipment());
        }
        //温感传感器品牌
        if (StringUtils.isNotBlank(transformationOrder.getTempSensorBrand())) {
            attrData.put(VehicleAttrConst.A_TECHMOD_TEMP_SENSOR_BRAND, transformationOrder.getTempSensorBrand());
        }
        //温感探头数量
        if (StringUtils.isNotBlank(transformationOrder.getTempSensorNumber())) {
            attrData.put(VehicleAttrConst.A_TECHMOD_TEMP_SENSORS, transformationOrder.getTempSensorNumber());
        }
        //冷藏风道长度
        if (StringUtils.isNotBlank(transformationOrder.getTckAirDuctLength())) {
            attrData.put(VehicleAttrConst.A_TECHMOD_COLD_AIR_DUCT_ASSEMBLY, transformationOrder.getTckAirDuctLength());
        }
        //冷藏门帘位置
        if (StringUtils.isNotBlank(transformationOrder.getRefrigerationCurtainPosition())) {
            attrData.put(VehicleAttrConst.A_TECHMOD_COLD_DOOR_CURTAIN, transformationOrder.getRefrigerationCurtainPosition());
        }
        //冷箱分温板数量
        if (StringUtils.isNotBlank(transformationOrder.getColdBoxSeparationTemperatureBoardNumber())) {
            attrData.put(VehicleAttrConst.A_TECHMOD_INSULATION_PANEL, transformationOrder.getColdBoxSeparationTemperatureBoardNumber());
        }
        //侧板挡风槽
        if (StringUtils.isNotBlank(transformationOrder.getSidePanelDoorSlot())) {
            attrData.put(VehicleAttrConst.A_TECHMOD_SIDE_PANEL_AIR_DUCT, transformationOrder.getSidePanelDoorSlot());
        }
        //门磁探头数量
        if (StringUtils.isNotBlank(transformationOrder.getDoorMagnetSensorNumber())) {
            attrData.put(VehicleAttrConst.A_OPT_DOOR_MAGNETIC_SENSORS, transformationOrder.getDoorMagnetSensorNumber());
        }
        //蒸发器
        if (StringUtils.isNotBlank(transformationOrder.getEvaporator())) {
            attrData.put(VehicleAttrConst.A_TECHMOD_EVAPORATOR, transformationOrder.getEvaporator());
        }
        //医药冷藏箱风罩
        if (StringUtils.isNotBlank(transformationOrder.getMedicineColdBoxDownstreamWindShield())) {
            attrData.put(VehicleAttrConst.A_TECHMOD_AIR_DEFLECTOR_HOOD, transformationOrder.getMedicineColdBoxDownstreamWindShield());
        }
        //货厢撑杆数量
        if (StringUtils.isNotBlank(transformationOrder.getCargoRodNumber())) {
            attrData.put(VehicleAttrConst.A_TECHMOD_CARGO_BOX_SUPPORT_ROD, transformationOrder.getCargoRodNumber());
        }
        //铝地台
        if (StringUtils.isNotBlank(transformationOrder.getAluminaPlatform())) {
            attrData.put(VehicleAttrConst.A_TECHMOD_ALUMINUM_PLATFORM, transformationOrder.getAluminaPlatform());
        }
        return attrData;
    }

    /**
     * 技改工单-技改验收，尾板更新
     */
    public static Response<?> updateTailBoard(String evn, String token, String orderCode) {
        SSOUser ssoUser = DstJsonUtil.toObject("{\"id\":1320,\"username\":\"wujie\",\"realname\":\"吴杰\",\"jobNumber\":\"001643\",\"ddUserId\":\"0205363439694716\",\"nickname\":null,\"phone\":\"15558029260\",\"email\":\"wujie@dstcar.com\",\"sex\":null,\"ctime\":1589444796740,\"token\":\"ied6f9c0fe5cf4c09b69772db6bf22249\",\"weakPwdFlag\":false}", SSOUser.class);
        //查询技改工单
        TechnicalModificationWorkOrderVO transformationOrder = SbyService.getTechnicalTransformationOrder(evn, token, orderCode);
        if (transformationOrder == null) {
            log.info("技改工单不存在");
            return Response.error("技改工单不存在");
        }

        if (StringUtils.isBlank(transformationOrder.getRefitItem())) {
            log.info("技改项为空");
            return Response.error("技改项为空");
        }
        //不包含 尾板技改 字符
        if (!transformationOrder.getRefitItem().contains("尾板技改")) {
            log.info("技改项不包含 尾板技改 项");
            return Response.error("技改项不包含 尾板技改 项");
        }


        //获取技改验收
        TechnicalModificationWorkOrderSubVO acceptanceData = SbyService.getTechnicalTransformationOrderSub(evn, token, orderCode);
        if (Objects.isNull(acceptanceData)) {
            log.info("获取技改验收项结果为空");
            return Response.error("获取技改验收项结果为空");
        }
        //如果sku为空，则直接返回
        if (StringUtils.isBlank(acceptanceData.getTailBoardSku()) &&
                VehicleAttrConst.TECH_CHANGE_TYPE_INSTALL.equals(transformationOrder.getRefitType())) {
            log.info("技改验收，尾板sku为空，不处理");
            return Response.error("技改验收，尾板sku为空，不处理");
        }
        //根据车架号查询运营城市
        VehicleVO vehicleVO = SbyService.queryVehicleInfo(evn, token, transformationOrder.getVinCode());
        if (Objects.isNull(vehicleVO)) {
            log.info("根据车架号查询运营城市结果为空");
            return Response.error("根据车架号查询运营城市结果为空");
        }
        TailBoardDTO tailBoard = new TailBoardDTO();
        tailBoard.setTailBoardCode(acceptanceData.getTailBoardCode());
        tailBoard.setSkuCode(acceptanceData.getTailBoardSku());
        tailBoard.setBindVinCode(transformationOrder.getVinCode());
        tailBoard.setServeCityCode(vehicleVO.getVehicleOperating().getServeCityCode());

        BatchSaveTailBoardParam tailBoardParam = new BatchSaveTailBoardParam();
        tailBoardParam.setSsoUser(ssoUser);
        tailBoardParam.setTailBoards(Collections.singletonList(tailBoard));
        //安装
        if (VehicleAttrConst.TECH_CHANGE_TYPE_INSTALL.equals(transformationOrder.getRefitType())) {
            return SbyService.batchSaveTailBoard(tailBoardParam,token,evn);
        }
        //拆除
        if (VehicleAttrConst.TECH_CHANGE_TYPE_TEAR_DOWN.equals(transformationOrder.getRefitType())) {
            return SbyService.batchRemoveTailBoard(tailBoardParam,token,evn);
        }
        return Response.error("尾板技改项异常");
    }

    /**
     * 技改工单-获取尾板品牌
     *
     * @param orderCode 工单编号
     * @return 尾板品牌
     */
    public static Map<String, String> getTailBoardBrand(String evn, String token, String orderCode) {
        HashMap<String, String> tailBoardBrand = new HashMap<>();
        //获取技改验收
        TechnicalModificationWorkOrderSubVO acceptanceData = SbyService.getTechnicalTransformationOrderSub(evn, token, orderCode);
        if (Objects.isNull(acceptanceData)) {
            log.info("获取技改验收失败：{}", orderCode);
            return tailBoardBrand;
        }
        if (StringUtils.isNotBlank(acceptanceData.getTailBoardBrand())) {
            tailBoardBrand.put(VehicleAttrConst.A_TAIL_BOARD_BRAND, acceptanceData.getTailBoardBrand());
        }
        return tailBoardBrand;
    }

    /**
     * 同步技改属性，尾板数据同步到主数据
     *
     * @param param 工单参数
     * @return 响应
     */
    public Response<?> syncVehicleAttr(TechnicalModificationWorkOrderParam param) {
        if (param == null || CollectionUtil.isEmpty(param.getOrderCodeList()) || StringUtils.isBlank(param.getToken())) {
            return Response.error("参数为空");
        }
        List<String> orderList = param.getOrderCodeList();
        List<String> data = new ArrayList<>();
        //去重
        orderList = orderList.stream().distinct().collect(Collectors.toList());
        for (String orderCode : orderList) {
            try {
                //技改工单，更新车辆属性
                Response<?> response = updateCarAttribute(param.getEnv(), param.getToken(), orderCode);
                //尾板数据同步到主数据
                Response<?> response1 = updateTailBoard(param.getEnv(), param.getToken(), orderCode);
                data.add("工单编码：【" + orderCode + "】,执行成功，车辆属性同步结果：【" + DstJsonUtil.toString(response) + "】,尾板数据同步结果：【" + DstJsonUtil.toString(response1) + "】");
            } catch (Exception e) {
                log.error("同步车辆属性失败：{}", e.getMessage(), e);
                data.add("工单编码：【" + orderCode + "】,执行失败，失败原因：" + e.getMessage());
            }
        }
        return Response.succeed(data);
    }
// 辽ADZ7644

}
