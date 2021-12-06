package cn.atong.leek.idgenerator.rpc.impl;

import cn.atong.leek.idgenerator.constants.Constants;
import cn.atong.leek.idgenerator.request.IdGeneratorRequest;
import cn.atong.leek.idgenerator.response.Result;
import cn.atong.leek.idgenerator.rpc.IdGeneratorService;
import cn.atong.leek.idgenerator.service.SnowflakeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leek-idgenerator
 * @description: Id生成器 service
 * @author: atong
 * @create: 2021-10-26 17:23
 */
public class IdGeneratorServiceImpl implements IdGeneratorService {

    @Autowired
    private SnowflakeService snowflakeService;

    /**
     * @param request : IdGeneratorRequest
     * @return cn.atong.leek.idgenerator.response.Result<java.lang.Long>
     * @description 生成单个Id
     * @author atong
     * @date 2021/10/26 10:47
     * @version 1.0.0.1
     */
    @Override
    public Result<Long> generateId(IdGeneratorRequest request) {
        if (request.getBusinessType() == null){
            return Result.error("业务类型必传", 300);
        }
        Long id = snowflakeService.getId(String.valueOf(request.getBusinessType())).getId();
        return Result.success("success", id);
    }

    /**
     * @param request : IdGeneratorRequest
     * @return cn.atong.leek.idgenerator.response.Result<java.util.List < java.lang.Long>>
     * @description 批量生成Id
     * @author atong
     * @date 2021/10/26 10:48
     * @version 1.0.0.1
     */
    @Override
    public Result<List<Long>> batchGenerateId(IdGeneratorRequest request) {
        if (request.getBusinessType()==null){
            return Result.error("业务类型必传", 300);
        }
        if (request.getCount() == null || request.getCount() < Constants.MIN){
            request.setCount(Constants.MIN);
        }
        if (request.getCount()> Constants.MAX){
            return Result.error("发号器最多支持100", 2001);
        }
        try {
            //内部foreach 获取ID
            Integer count = request.getCount();
            String businessType = String.valueOf(request.getBusinessType());
            List<Long> ids=new ArrayList<>(count);
            for (int i=0;i<count;i++){
                Long id = snowflakeService.getId(businessType).getId();
                ids.add(id);
            }
            return Result.success("success", ids);
        }catch (Exception e){
            return Result.error("系统异常请稍后再试", 500);
        }
    }
}
