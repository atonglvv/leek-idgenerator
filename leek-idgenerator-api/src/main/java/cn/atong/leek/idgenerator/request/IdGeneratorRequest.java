package cn.atong.leek.idgenerator.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: leek-idgenerator
 * @description: Request
 * @author: atong
 * @create: 2021-04-13 16:08
 */
@Data
public class IdGeneratorRequest implements Serializable {

    /** 业务类型 */
    private Integer businessType;
    /** 每次请求生成id数, 默认是1 */
    private Integer count = 1;
}
