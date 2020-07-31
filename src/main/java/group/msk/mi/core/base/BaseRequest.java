package group.msk.mi.core.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author 吕衡
 * @Create 2020/7/31 - 17:11
 * @Desc 公共响应类请求类,
 */
public class BaseRequest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * TODO 子类重写即可,在WebBind中绑定,请求时校验参数,没弄懂其原理,后面用到再补充
     */
    public void checkParam() {
        logger.info("参数校验入口");
    }
}
