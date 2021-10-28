package cn.atong.leek.idgenerator.service;

import cn.atong.leek.idgenerator.exception.InitException;
import com.sankuai.inf.leaf.IDGen;
import com.sankuai.inf.leaf.common.Result;
import com.sankuai.inf.leaf.common.ZeroIDGen;
import com.sankuai.inf.leaf.snowflake.SnowflakeIDGenImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @program: leek-idgenerator
 * @description: 雪花算法Service
 * @author: atong
 * @create: 2021-10-28 11:07
 */
@Service("snowflakeService")
public class SnowflakeService {
    private Logger logger = LoggerFactory.getLogger(SnowflakeService.class);

    @Value("${leaf.snowflake.enable}")
    private String snowflakeEnable;

    @Value("${leaf.snowflake.zk.address}")
    private String zkAddress;

    @Value("${leaf.snowflake.zk.port}")
    private Integer port;

    private IDGen idGen;

    @PostConstruct
    public void snowflake() throws InitException {
        boolean flag = Boolean.parseBoolean(snowflakeEnable);
        if (flag) {
            idGen = new SnowflakeIDGenImpl(zkAddress, port);
            if(idGen.init()) {
                logger.info("snowflake service init successfully");
            } else {
                throw new InitException("snowflake service init fail");
            }
        } else {
            idGen = new ZeroIDGen();
            logger.info("zero id gen service init successfully");
        }
    }

    public Result getId(String key) {
        return idGen.get(key);
    }
}
