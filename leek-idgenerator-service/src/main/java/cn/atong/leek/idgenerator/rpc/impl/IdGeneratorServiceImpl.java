package cn.atong.leek.idgenerator.rpc.impl;

import cn.atong.leek.idgenerator.request.IdGeneratorRequest;
import cn.atong.leek.idgenerator.response.Result;
import cn.atong.leek.idgenerator.rpc.IdGeneratorService;

import java.util.List;

/**
 * @program: leek-idgenerator
 * @description: Id生成器 service
 * @author: atong
 * @create: 2021-10-26 17:23
 */
public class IdGeneratorServiceImpl implements IdGeneratorService {

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
        return null;
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
        return null;
    }
}
