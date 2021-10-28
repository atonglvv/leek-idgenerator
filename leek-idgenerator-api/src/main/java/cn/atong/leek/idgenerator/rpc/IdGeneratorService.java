package cn.atong.leek.idgenerator.rpc;

import cn.atong.leek.idgenerator.request.IdGeneratorRequest;
import cn.atong.leek.idgenerator.response.Result;

import java.util.List;

/**
 * @program: leek-idgenerator
 * @description: Id生成器 service
 * @author: atong
 * @create: 2021-04-13 16:16
 */
public interface IdGeneratorService {

    /**
     * @description 生成单个Id
     * @param request: IdGeneratorRequest
     * @return cn.atong.leek.idgenerator.response.Result<java.lang.Long>
     * @author atong
     * @date 2021/10/26 10:47
     * @version 1.0.0.1
     */
    Result<Long> generateId(IdGeneratorRequest request);

    /**
     * @description 批量生成Id
     * @param request: IdGeneratorRequest
     * @return cn.atong.leek.idgenerator.response.Result<java.util.List<java.lang.Long>>
     * @author atong
     * @date 2021/10/26 10:48
     * @version 1.0.0.1
     */
    Result<List<Long>> batchGenerateId(IdGeneratorRequest request);

}
