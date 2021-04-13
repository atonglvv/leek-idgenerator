package cn.atong.leek.idgenerator.service;

import cn.atong.leek.idgenerator.request.IdGeneratorRequest;
import cn.atong.leek.idgenerator.response.Result;

/**
 * @program: leek-idgenerator
 * @description: Id生成器 service
 * @author: atong
 * @create: 2021-04-13 16:16
 */
public interface IdGeneratorService {

    Result<Long> generateId(IdGeneratorRequest request);

}
