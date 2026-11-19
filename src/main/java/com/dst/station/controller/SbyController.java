package com.dst.station.controller;

import com.dst.space.bean.SpaceSyncParam;
import com.dst.space.service.SpaceService;
import com.dst.steed.common.domain.response.Response;
import com.dst.steed.common.util.DstJsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dst.station.bean.TechnicalModificationWorkOrderParam;
import com.dst.station.service.JggdService;

/**
 * 场站技改工单-同步技改属性
 */
@Slf4j
@RestController
@RequestMapping("/station")
public class SbyController {

    @Autowired
    private JggdService sbyService;

    @Autowired
    private SpaceService spaceService;


    /**
     * 技改工单，更新车辆属性
     */
    @PostMapping("/syncVehicleAttr")
    public Response<?> syncVehicleAttr(@RequestBody TechnicalModificationWorkOrderParam param) {
        log.info("【交车工单】技改工单，更新车辆属性param:{}", DstJsonUtil.toString(param));
        return sbyService.syncVehicleAttr(param);
    }

    /**
     * 思倍云工单同步工单池
     */
    @PostMapping( "/spaceSyncWordOrder")
    public Response<?> spaceSyncWordOrder(@RequestBody SpaceSyncParam param) {
        log.info("【思倍云工单同步工单池】开始同步数据,param:{}", DstJsonUtil.toString(param));
        return spaceService.syncSpace(param);
    }

}
