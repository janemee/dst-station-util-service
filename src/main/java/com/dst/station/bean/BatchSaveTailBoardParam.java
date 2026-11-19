package com.dst.station.bean;

import com.dst.steed.common.domain.user.SSOUser;
import lombok.Data;

import java.util.List;

/**
 * 批量保存尾板参数
 *
 * @author: jzm
 * @date: 2025/12/22
 * @description: 批量保存尾板参数
 */
@Data
public class BatchSaveTailBoardParam {
    /**
     * 尾板信息
     */
    private List<TailBoardDTO> tailBoards;

    /**
     * 用户信息
     */
    private SSOUser ssoUser;
}
