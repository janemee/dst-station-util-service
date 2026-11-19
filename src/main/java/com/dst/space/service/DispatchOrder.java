package com.dst.space.service;

import cn.hutool.core.collection.CollectionUtil;
import com.dst.station.bean.*;
import com.dst.station.service.SbyService;
import com.dst.steed.common.domain.response.PageDTO;
import com.dst.steed.common.domain.response.Response;
import com.dst.steed.common.util.DstJsonUtil;
import com.google.common.collect.Lists;
import sun.security.krb5.internal.PAData;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DispatchOrder {

    public static String env = "dev";
    public static String token = "i346e2de6db7d4d67b34e942a618d2f67";

    public static void main(String[] args) {
        DataPoolDataQuery query = new DataPoolDataQuery();
//        query.setDataPoolCode("WBGDC_0001");
//        query.setWorkOrderStatus(0);
        query.setBusinessOrderCode("1134087813072609280");
        query.setPageNum(1);
        query.setPageSize(300);
//        PageDTO<DataPoolDataDO> queryDataPoolDataByPage = queryDataPoolDataByPage(query);

//        System.out.println(queryWorkOrderDispatchUser(query));
       fixErrorData();

//        for (Object obj : queryDataPoolDataByPage.getList()) {
//            DataPoolDataDO dataPoolDataDO = DstJsonUtil.toObject(obj,DataPoolDataDO.class);
//            String businessOrderCode = dataPoolDataDO.getBusinessOrderCode();
//            // 更新工单池数据
//            WorkOrderSyncUpdateDTO workOrderSyncUpdateDTO = new WorkOrderSyncUpdateDTO();
//            workOrderSyncUpdateDTO.setBusinessOrderCode(businessOrderCode);
//            workOrderSyncUpdateDTO.setTimestamp(System.currentTimeMillis());
////            workOrderSyncUpdateDTO.setWorkOrderStatus(2);
////            workOrderSyncUpdateDTO.setBusinessOrderStatus("已完成");
//            Map<String, Object> businessMap = new HashMap<>();
//            businessMap.put("reminderNumber", "4");
//
//            workOrderSyncUpdateDTO.setOrderBusinessData(businessMap);
//            syncWorkOrderUpdateData(env, token, workOrderSyncUpdateDTO);
//        }

//            if (workOrderStatus.equals("0") && CollectionUtil.isNotEmpty(handleUserIds)){
//                // 更新工单池数据
//                WorkOrderSyncUpdateDTO workOrderSyncUpdateDTO = new WorkOrderSyncUpdateDTO();
//                workOrderSyncUpdateDTO.setBusinessOrderCode(businessOrderCode);
//                workOrderSyncUpdateDTO.setWorkOrderStatus(1);
//                workOrderSyncUpdateDTO.setTimestamp(System.currentTimeMillis());
//                Map<String,Object> businessMap = new HashMap<>();
//                businessMap.put("","");
//                workOrderSyncUpdateDTO.set
//                syncWorkOrderUpdateData(env, token, workOrderSyncUpdateDTO);
//            }
//        }
    }

    /**
     * 创建后同步派单中心
     *
     * @param env
     * @param token
     * @param params
     */
    public static void syncWorkOrderUpdateData(String env, String token, Object params) {
        SbyService.syncWorkOrderUpdateData(env, token, params);
    }

    public static void getWorkOrderSyncUpdateDTO() {
        String content = "GD1278041503595749376";
        String[] orderCodes = content.split("\n");
        for (String orderCode : orderCodes) {
            WorkOrderSyncUpdateDTO workOrderSyncUpdateDTO = new WorkOrderSyncUpdateDTO();
            workOrderSyncUpdateDTO.setBusinessOrderCode(orderCode);
            workOrderSyncUpdateDTO.setWorkOrderStatus(1);
            workOrderSyncUpdateDTO.setTimestamp(System.currentTimeMillis());
            syncWorkOrderUpdateData(env, token, workOrderSyncUpdateDTO);
        }
    }

    /**
     * 查询工单池数据
     *
     * @param query
     * @return
     */
    public static PageDTO<DataPoolDataDO> queryWorkOrderDispatchUser(DataPoolDataQuery query) {
        Response<PageDTO<DataPoolDataDO>> response = SbyService.queryWorkOrderDispatchUser(env, token, query);
        return response.getData();
    }

    /**
     * 创建后同步派单中心
     *
     * @param env
     * @param token
     * @param params
     */
    public static void manualExecuteDispatchStrategy(String env, String token, Object params) {
        SbyService.manualExecuteDispatchStrategy(env, token, params);
    }

    public static List<List<String>> getManualExecuteDispatchStrategyParams() {
        String content = "1084949625926295552\n" +
                "1084949625939300352\n" +
                "1084949626018992128\n" +
                "1084949626022764544\n" +
                "1084949626044104704\n" +
                "1084949626165563392\n" +
                "1084949626178375680\n" +
                "1084949626186342400\n" +
                "1084949626274844672\n" +
                "1084949626282811392\n" +
                "1084949626287374336\n" +
                "1084949626291621888\n" +
                "1084949626324754432\n" +
                "1084949626559635458\n" +
                "1084949626593558528\n" +
                "1084949656066932736\n" +
                "1084949656075145216\n" +
                "1084949656154644480\n" +
                "1084949656746041345\n" +
                "1084949686991536129\n" +
                "1084949745438793728\n" +
                "1084949745451569152\n" +
                "1084949806453334016\n" +
                "1084949807112208384\n" +
                "1084949837487411200\n" +
                "1086976815161753600\n" +
                "1087808156748718080\n" +
                "1088466650749812736\n" +
                "1088468098145034240\n" +
                "1089552715610931200\n" +
                "1090946975295946753\n" +
                "1092149771965730816\n" +
                "1092387573978341376\n" +
                "1092390902322565122\n" +
                "1092409115546390528\n" +
                "1121714195907514368\n" +
                "1123182587856326656\n" +
                "1126214136382304256\n" +
                "1126842479007797248\n" +
                "1128676484439117825\n" +
                "1130848778804404224\n" +
                "1130909462661730304\n" +
                "1131151740567166976\n" +
                "1131153557900836864\n" +
                "1131155344027951104\n" +
                "1131229349577629696\n" +
                "1131238259500027904\n" +
                "1131546367539421185\n" +
                "1131618846135951360\n" +
                "1131989971311403008\n" +
                "1132016956431699968\n" +
                "1132025694140317696\n" +
                "1132225065456377856\n" +
                "1132267932224724992\n" +
                "1132583555186331648\n" +
                "1132717241806700544\n" +
                "1133120700137218048\n" +
                "1133311959237955584\n" +
                "1133346772972290048\n" +
                "1133377398597304320\n" +
                "1133692702309302272\n" +
                "1134056937254109184\n" +
                "1134509028824879104\n" +
                "1134926331106332672\n" +
                "1135120499569410048\n" +
                "1135131287096692736\n" +
                "1135264633931993091\n" +
                "1135520218711625728\n" +
                "1136193731969556481\n" +
                "1136205577997336576\n" +
                "1136216730424872960\n" +
                "1136226575991476224\n" +
                "1136234431301951488\n" +
                "1136572941246537728\n" +
                "1136579973865881600\n" +
                "1136581714359435265\n" +
                "1136586755556327424\n" +
                "1136589094497062912\n" +
                "1136591594302554112\n" +
                "1136599691171078144\n" +
                "1136605576543113216\n" +
                "1136609426058387456\n" +
                "1136612548118089728\n" +
                "1136615081842610176\n" +
                "1136633971641294848\n" +
                "1136636705668997120\n" +
                "1136638897826177024\n" +
                "1136650879845408768\n" +
                "1136653831004000256\n" +
                "1136660719917633536\n" +
                "1136662504342167552\n" +
                "1136668483599343616\n" +
                "1136669053655748608\n" +
                "1136673634721021952\n" +
                "1136683777805918208\n" +
                "1136685822013218816\n" +
                "1136693169595432960\n" +
                "1136695564626903040\n" +
                "1136696448819273728\n" +
                "1136700443784941568\n" +
                "1136703549113245696\n" +
                "1136706894972620800\n" +
                "1136712514312376320\n" +
                "1136714547933093888\n" +
                "1136716625422663680\n" +
                "1136722675865260032\n" +
                "1136727127733080065\n" +
                "1136961725897252864\n" +
                "1136995453163937792\n" +
                "1136999963999944704\n" +
                "1137057438777876480\n" +
                "1137067070301224960\n" +
                "1137083404753911808\n" +
                "1137086130225233920\n" +
                "1137313316081319937\n" +
                "1137325294673805312\n" +
                "1137329148286607360\n" +
                "1137329403908464640\n" +
                "1137331163322683392\n" +
                "1137345750818394112\n" +
                "1137346801373945856\n" +
                "1137352449482899456\n" +
                "1137354487793008640\n" +
                "1137368619887968256\n" +
                "1137371451252576256\n" +
                "1137372578526302208\n" +
                "1137374193932967936\n" +
                "1137387720559640576\n" +
                "1137409016718303232\n" +
                "1137418096237223936\n" +
                "1137435330364084224\n" +
                "1137452681918554112\n" +
                "1137680760544989184\n" +
                "1137682281672089600\n" +
                "1137684556410920960\n" +
                "1137697949658726400\n" +
                "1137700120567255040\n" +
                "1137705726556381184\n" +
                "1137715227464908800\n" +
                "1137717296829337600\n" +
                "1137717879884038144\n" +
                "1137722628297539584\n" +
                "1137750661552807936\n" +
                "1137766732326539264\n" +
                "1137770960990117888\n" +
                "1137773780917325824\n" +
                "1137785117370564608\n" +
                "1137785130590543872\n" +
                "1137797270626451456\n" +
                "1137797399982981120\n" +
                "1137807258103136256\n" +
                "1137810060078563328\n" +
                "1138018165483249664\n" +
                "1138039444085022720\n" +
                "1138042434690883584\n" +
                "1138057232208445440\n" +
                "1138058595357245440\n" +
                "1138071197856337920\n" +
                "1138074479483822080\n" +
                "1138085841686052864\n" +
                "1138088262176948224\n" +
                "1138107383815639040\n" +
                "1138140731351318528\n" +
                "1138144077080510464\n" +
                "1138150034305007617\n" +
                "1138150814579462144\n" +
                "1138151282500210688\n" +
                "1138155010246918144\n" +
                "1138156496741810176\n" +
                "1138165100588601344\n" +
                "1138173643845091328\n" +
                "1138389338545537024\n" +
                "1138390152730779648\n" +
                "1138392833759416320\n" +
                "1138404762275946496\n" +
                "1138405131571830784\n" +
                "1138405380739121152\n" +
                "1138411777799000064\n" +
                "1138412380264472576\n" +
                "1138418790595903488\n" +
                "1138424675543687168\n" +
                "1138425024447025152\n" +
                "1138447629036064768\n" +
                "1138480078570790912\n" +
                "1138499083314696192\n" +
                "1138500509264650240\n" +
                "1138511680457809920\n" +
                "1138521202303836160\n" +
                "1138525585284407298\n" +
                "1138527595656724480\n" +
                "1138536011578032128\n" +
                "1138539648907821056\n" +
                "1138547221421703168\n" +
                "1138548135020339200\n" +
                "1138550223582871552\n" +
                "1138557310010474496";
        List<String> list = Arrays.asList(content.split("\n"));

        return Lists.partition(list, 1);
    }

    public static PageDTO<DataPoolDataDO> queryDataPoolDataByPage(DataPoolDataQuery query) {
        Response<PageDTO<DataPoolDataDO>> response = SbyService.queryDataPoolDataByPage(env, token, query);
        return response.getData();
    }

    public static void fixErrorData() {
        String content  = "order_id=1141436247799111680, fault_city=\"邯郸市\", fault_city_id=\"130400\";\n" +
                "order_id=GD1317089641031524352, fault_city=\"青岛市\", fault_city_id=\"370200\";\n" +
                "order_id=GD1317087575609434112, fault_city=\"西安市\", fault_city_id=\"610100\";\n" +
                "order_id=GD1317087065116368896, fault_city=\"西安市\", fault_city_id=\"610100\";\n" +
                "order_id=GD1317086662794534912, fault_city=\"北京市\", fault_city_id=\"110100\";\n" +
                "order_id=GD1317082921940934656, fault_city=\"成都市\", fault_city_id=\"510100\";\n" +
                "order_id=GD1317081976158937088, fault_city=\"青岛市\", fault_city_id=\"370200\";\n" +
                "order_id=GD1317080748494807040, fault_city=\"济南市\", fault_city_id=\"370100\";\n" +
                "order_id=GD1317080556185706496, fault_city=\"天津市\", fault_city_id=\"120100\";\n" +
                "order_id=GD1317080151460667392, fault_city=\"成都市\", fault_city_id=\"510100\";\n" +
                "order_id=GD1317079282048688128, fault_city=\"佳木斯市\", fault_city_id=\"230800\";\n" +
                "order_id=GD1317078840568832000, fault_city=\"大连市\", fault_city_id=\"210200\";\n" +
                "order_id=GD1317078091507818496, fault_city=\"重庆市\", fault_city_id=\"500100\";\n" +
                "order_id=GD1317077918522400768, fault_city=\"北京市\", fault_city_id=\"110100\";\n" +
                "order_id=GD1317076772281901056, fault_city=\"济宁市\", fault_city_id=\"370800\";\n" +
                "order_id=GD1317074923059535872, fault_city=\"青岛市\", fault_city_id=\"370200\";\n" +
                "order_id=GD1317074163743711232, fault_city=\"威海市\", fault_city_id=\"371000\";\n" +
                "order_id=GD1317073415643455488, fault_city=\"青岛市\", fault_city_id=\"370200\";\n" +
                "order_id=GD1317070323786833920, fault_city=\"湛江市\", fault_city_id=\"440800\";\n" +
                "order_id=GD1317069983511601152, fault_city=\"佛山市\", fault_city_id=\"440600\";\n" +
                "order_id=GD1317068886352846848, fault_city=\"成都市\", fault_city_id=\"510100\";\n" +
                "order_id=GD1317068792669003776, fault_city=\"沧州市\", fault_city_id=\"130900\";\n" +
                "order_id=GD1317068744274862080, fault_city=\"潍坊市\", fault_city_id=\"370700\";\n" +
                "order_id=GD1317067297822990336, fault_city=\"威海市\", fault_city_id=\"371000\";\n" +
                "order_id=GD1317095266574786560, fault_city=\"沧州市\", fault_city_id=\"130900\";\n" +
                "order_id=GD1313438679289159680, fault_city=\"五指山市\", fault_city_id=\"469001\";";

        List<String> list = Arrays.asList(content.split("\n"));
        for (String line : list) {
            String[] parts = line.split(",");
            String orderId = parts[0].split("=")[1];
            String faultCity = parts[1].split("=")[1];
            String faultCityId = parts[2].split("=")[1];
            DataPoolDataQuery query = new DataPoolDataQuery();
//        query.setDataPoolCode("WBGDC_0001");
//        query.setWorkOrderStatus(0);
            query.setBusinessOrderCode(orderId);
            query.setPageNum(1);
            query.setPageSize(300);
            PageDTO<DispatchErrorRecord> pageDTO=       queryDataPoolDataByError(query);
            if (pageDTO != null && pageDTO.getList() != null && pageDTO.getList().size() > 0) {
                DispatchErrorRecord record = pageDTO.getList().get(0);
                DataPoolRetryData recordData = DstJsonUtil.toObject(record.getOriginalData(), DataPoolRetryData.class);
//                recordData(); // 替换异常内容
               //替换异常内容
//                orgData = orgData.replace("fault_city\":\"" + faultCity + "\",", "fault_city\":\"" + faultCity + "\", fault_city_id\":\"" + faultCityId + "\"");
            }
            System.out.println("order_id=" + orderId + ", fault_city=" + faultCity + ", fault_city_id=" + faultCityId);
        }


    }


    /**
     * 查询异常数据
     * @param query
     * @return
     */
    public static PageDTO<DispatchErrorRecord> queryDataPoolDataByError(DataPoolDataQuery query) {
        Response<PageDTO<DispatchErrorRecord>> response = SbyService.queryDataPoolDataByError(env, token, query);
        return response.getData();
    }

}
